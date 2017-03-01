/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.AnswerDao;
import com.bbsBlog.dao.QuestionDao;
import com.bbsBlog.entity.Answer;
import com.bbsBlog.entity.ForumPost;
import com.bbsBlog.entity.Question;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 * 
 * @date 2014骞�鏈�8鏃�
 * 
 */
@Repository("questionDao")
public class QuestionDaoImpl extends HibernateDaoSupport implements QuestionDao {

	@Resource
	private AnswerDao answerDao;

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	/*
	 * 锛堥潪 Javadoc锛�
	 * 
	 * @see
	 * com.bbsBlog.dao.QuestionDao#saveQuestion(com.bbsBlog.entity.Question)
	 */
	public void saveQuestion(Question question) {

		this.getHibernateTemplate().save(question);

	}

	/*
	 * 锛堥潪 Javadoc锛�
	 * 
	 * @see
	 * com.bbsBlog.dao.QuestionDao#updateQuestion(com.bbsBlog.entity.Question)
	 */
	public void updateQuestion(Question question) {

		this.getHibernateTemplate().update(question);

	}

	/*
	 * 锛堥潪 Javadoc锛�
	 * 
	 * @see com.bbsBlog.dao.QuestionDao#deleteQuestion(long)
	 */
	public void deleteQuestion(long id) {

		this.getHibernateTemplate().delete(
				this.getHibernateTemplate().get(Question.class, id));

	}

	/*
	 * 锛堥潪 Javadoc锛�
	 * 
	 * @see com.bbsBlog.dao.QuestionDao#listQuestion()
	 */
	@SuppressWarnings("unchecked")
	public List<Question> listQuestion() {

		return this.getHibernateTemplate().find(
				"from Question q order by q.qTime desc");

	}

	@SuppressWarnings("unchecked")
	public List<Question> listQuestionByBoard(long board_id) {
		List<Question> allQuestion = this.getHibernateTemplate().find(
				"from Question q where q.board.id=" + board_id
						+ " order by q.qTime desc");
		List<Question> listQuestion = new ArrayList<Question>();
		for (int i = 0; i < allQuestion.size(); i++) {
			List<Answer> listAnswer = this.answerDao.findAnswer(allQuestion
					.get(i).getId());
			if (listAnswer.size() > 0)
				listQuestion.add(allQuestion.get(i));
		}

		if (listQuestion.size() < 10)
			listQuestion = allQuestion;

		return listQuestion;

	}

	@SuppressWarnings("unchecked")
	public List<Question> findQuestionByUser(long userId) {

		return this.getHibernateTemplate().find(
				"from Question where userInfo.id=" + userId);

	}

	public Question findQuestion(long id) {
		return this.getHibernateTemplate().get(Question.class, id);
	}

	// ----------------------------------排序--------------------------------------
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> listQuestionByKey(String keyword, String lab, String sub, String con) {
		// TODO Auto-generated method stub
		List<Question> list = new ArrayList<Question>();
		List<Question> list1 = new ArrayList<Question>();
		List<Question> list2 = new ArrayList<Question>();
		List<Question> list3 = new ArrayList<Question>();
		List<Question> list4 = new ArrayList<Question>();
		List<Question> list5 = new ArrayList<Question>();

		if(lab.equals("1")){
			list4 = this.getHibernateTemplate().find(
					"from Question where keywordA = '" + keyword + "'");
			list5 = this.getHibernateTemplate().find(
					"from Question where (keywordB = '" + keyword + "' or "
							+ "keywordC = '" + keyword + "') and (keywordA <> '"
							+ keyword + "' " + "or keywordA is null)");
        	if(sub.equals("1")&&con.equals("1")){
        		list1 = this.getHibernateTemplate().find(
        				"from Question where qSubject like '%" + keyword + "%' and "
        						+ "qContent like '%" + keyword
        						+ "%' and (keywordA <> '" + keyword
        						+ "' or keywordA is null) and (keywordB <> '" + keyword
        						+ "' or keywordB is null) and (keywordC <> '" + keyword
        						+ "' or keywordC is null)");
        		list2 = this.getHibernateTemplate().find(
        				"from Question where qSubject like '%" + keyword + "%' and "
        						+ "qContent not like '%" + keyword
        						+ "%' and (keywordA <> '" + keyword
        						+ "' or keywordA is null) and (keywordB <> '" + keyword
        						+ "' or keywordB is null) and (keywordC <> '" + keyword
        						+ "' or keywordC is null)");
        		list3 = this.getHibernateTemplate().find(
        				"from Question where qSubject not like '%" + keyword
        						+ "%' and " + "qContent like '%" + keyword
        						+ "%' and (keywordA <> '" + keyword
        						+ "' or keywordA is null) and (keywordB <> '" + keyword
        						+ "' or keywordB is null) and (keywordC <> '" + keyword
        						+ "' or keywordC is null)");
        	}else if(sub.equals("1")&&!con.equals("1")){
        		list2 = this.getHibernateTemplate().find(
        				"from Question where qSubject like '%" + keyword + "%' and "
        						+ "(keywordA <> '" + keyword
        						+ "' or keywordA is null) and (keywordB <> '" + keyword
        						+ "' or keywordB is null) and (keywordC <> '" + keyword
        						+ "' or keywordC is null)");
        	}else if(!sub.equals("1")&&con.equals("1")){
        		list3 = this.getHibernateTemplate().find(
        				"from Question where qContent like '%" + keyword
        						+ "%' and (keywordA <> '" + keyword
        						+ "' or keywordA is null) and (keywordB <> '" + keyword
        						+ "' or keywordB is null) and (keywordC <> '" + keyword
        						+ "' or keywordC is null)");
        	}
        	
        }else{
        	
        	if(sub.equals("1")&&con.equals("1")){
        		list1 = this.getHibernateTemplate().find(
        				"from Question where qSubject like '%" + keyword + "%' and "
        						+ "qContent like '%" + keyword + "%'");
        		list2 = this.getHibernateTemplate().find(
        				"from Question where qSubject like '%" + keyword + "%' and "
        						+ "qContent not like '%" + keyword + "%'");
        		list3 = this.getHibernateTemplate().find(
        				"from Question where qSubject not like '%" + keyword
        						+ "%' and " + "qContent like '%" + keyword + "%'");
        	}else if(sub.equals("1")&&!con.equals("1")){
        		list2 = this.getHibernateTemplate().find(
        				"from Question where qSubject like '%" + keyword + "%'");
        	}else if(!sub.equals("1")&&con.equals("1")){
        		list3 = this.getHibernateTemplate().find(
        				"from Question where qContent like '%" + keyword + "%'");
        	}
        }
		
		list.addAll(list4);
		list.addAll(list5);
		list.addAll(list1);
		list.addAll(list2);
		list.addAll(list3);

		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> listQuestionByTime(String keyword,String lab, String sub, String con) {
		// TODO Auto-generated method stub
		List<Question> list = new ArrayList<Question>();
		if(lab.equals("1")){
			if(sub.equals("1")&&con.equals("1")){
				list = this.getHibernateTemplate().find(
						"from Question where qSubject like '%" + keyword + "%' or "
								+ "qContent like '%" + keyword + "%' or keywordA = '"
								+ keyword + "' or keywordC = '" + keyword
								+ "' or keywordB = '" + keyword + "' "
								+ "order by qTime desc");
				
			}else if(sub.equals("1")&&!con.equals("1")){
				list = this.getHibernateTemplate().find(
						"from Question where qSubject like '%" + keyword + "%' or "
								+ "keywordA = '"
								+ keyword + "' or keywordC = '" + keyword
								+ "' or keywordB = '" + keyword + "' "
								+ "order by qTime desc");
				
			}else if(!sub.equals("1")&&con.equals("1")){
				list = this.getHibernateTemplate().find(
						"from Question where qContent like '%" + keyword + "%' or keywordA = '"
								+ keyword + "' or keywordC = '" + keyword
								+ "' or keywordB = '" + keyword + "' "
								+ "order by qTime desc");
				
			}	
		}else{
			if(sub.equals("1")&&con.equals("1")){
				list = this.getHibernateTemplate().find(
						"from Question where qSubject like '%" + keyword + "%' or "
								+ "qContent like '%" + keyword + "%' order by qTime desc");
				
			}else if(sub.equals("1")&&!con.equals("1")){
				list = this.getHibernateTemplate().find(
						"from Question where qSubject like '%" + keyword + "%' order by qTime desc");
				
			}else if(!sub.equals("1")&&con.equals("1")){
				list = this.getHibernateTemplate().find(
						"from Question where qContent like '%" + keyword + "%' order by qTime desc");
				
			}
		}
		
		return list;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> listQuestionByTime() {

		return this.getHibernateTemplate().find(
				"from Question order by q_time desc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findQuestionPageByTime(int firstResult, int MaxResult) {

		return this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession()
				.createQuery("from Question order by q_time desc")
				.setFirstResult(firstResult).setMaxResults(MaxResult).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findQuestionPageByHot(int firstResult, int MaxResult) {

		return this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery("from Question")
				.setFirstResult(firstResult).setMaxResults(MaxResult).list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public PageModel listQuestion(int offset, int pageSize, long questionId) {
		// TODO Auto-generated method stub
		// 得到总记录数
		String queryCountHql = "select count(*) from Question where userInfo.id='"
				+ questionId + "'";
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();

		String hql = "from Question where userInfo.id='" + questionId
				+ "' order by qTime desc";
		List datas = this.getSession().createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize).list();
		// 得到结果集
		PageModel pm = new PageModel();
		pm.setTotal(total);
		pm.setDatas(datas);
		pm.setOffset(offset);

		return pm;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findQuestionByBoard(long board_id) {
		return this.getHibernateTemplate().find(
				"from Question where boa_id=" + board_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> listQuestionBySql(String sql) {
		// TODO Auto-generated method stub
		List<Question> listQuestion = this.getHibernateTemplate().find(sql);
		return listQuestion;
	}

	@Override
	public PageModel listQuestionBySQL(int offset, int pageSize,
			String queryCountHql, String hql) {
		// TODO Auto-generated method stub

		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();

		List datas = this.getSession().createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize).list();

		// 得到结果集
		PageModel pm = new PageModel();
		pm.setTotal(total);
		pm.setDatas(datas);
		pm.setOffset(offset);

		return pm;
	}

	@Override
	public int listCount(String queryCountHql) {
		// TODO Auto-generated method stub
		// 得到总记录数

		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();
		return total;
	}

}