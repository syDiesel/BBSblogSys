/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.LabelDao;
import com.bbsBlog.entity.Label;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("labelDao")
public class LabelDaoImpl extends HibernateDaoSupport implements LabelDao {

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.LabelDao#saveLabel(com.bbsBlog.entity.Label)
	 */
	public void saveLabel(Label label) {
		// TODO 自动生成的方法存根

		this.getHibernateTemplate().save(label);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.LabelDao#updateLabel(com.bbsBlog.entity.Label)
	 */
	public void updateLabel(Label label) {
		// TODO 自动生成的方法存根

		this.getHibernateTemplate().update(label);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.LabelDao#deleteLabel(long)
	 */
	public void deleteLabel(long id) {
		// TODO 自动生成的方法存根

		this.getHibernateTemplate().delete(
				this.getHibernateTemplate().get(Label.class, id));

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.LabelDao#listLabel()
	 */
	@SuppressWarnings("unchecked")
	public List<Label> listLabel() {
		// TODO 自动生成的方法存根

		return this.getHibernateTemplate()
				.find("from Label order by board asc");

	}

	public Label listLabelById(long id) {
		return this.getHibernateTemplate().get(Label.class, id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.LabelDao#listLabelByBoard(long)
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月20日
	 */
	public List<Label> listLabelByBoard(long id) {
		// TODO 自动生成的方法存根

		return this.getHibernateTemplate().find(
				"from Label where board = '" + id + "'");
	}

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public List<Label> listLabelByBoard(long board_id) { return
	 * this
	 * .getHibernateTemplate().find("from Label l where l.board.id="+board_id);
	 * }
	 */

	public PageModel listLabel(int offset, int pageSize) {
		// TODO 自动生成的方法存根

		// 得到总记录数
		String queryCountHql = "select count(*) from Label";
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();

		String hql = "from Label order by board asc";
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
	public List<Label> listLabelBySql(String sql ){
		return this.getHibernateTemplate().find(sql);
	}

}
