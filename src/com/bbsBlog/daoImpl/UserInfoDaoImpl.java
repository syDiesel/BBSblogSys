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

import com.bbsBlog.dao.UserInfoDao;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("userInfoDao")
public class UserInfoDaoImpl extends HibernateDaoSupport  implements UserInfoDao {


	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}


	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.dao.UserInfoDao#saveUserInfo(com.bbsBlog.entity.UserInfo)
	 */
	@Override
	public void saveUserInfo(UserInfo userInfo) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate() .save(userInfo);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.dao.UserInfoDao#updateUserInfo(com.bbsBlog.entity.UserInfo)
	 */
	@Override
	public void updateUserInfo(UserInfo userInfo) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate() .update(userInfo);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.UserInfoDao#deleteUserInfo(long)
	 */
	@Override
	public void deleteUserInfo(long id) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate() .delete(this.getHibernateTemplate() .get(
				UserInfo.class, id));

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.UserInfoDao#listUserInfo()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> listUserInfo() {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate() .find("from UserInfo");
	}

	@Override
	public UserInfo findById(long id) {
		return this.getHibernateTemplate() .get(UserInfo.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkExistsByName(UserInfo uuser) {

		List<UserInfo> listuser = getHibernateTemplate() 
				.find("from UserInfo  where userName = '" + uuser.getUserName()
						+ "'");
		if (listuser.size() > 0)
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getPasswordByName(UserInfo uuser) {
		List<UserInfo> users = getHibernateTemplate() 
				.find("from UserInfo where userName = '" + uuser.getUserName()
						+ "'");
		return users.get(0).getPassword();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> findUserByName(String name) {
		return getHibernateTemplate() .find("from UserInfo  where userName = '"
				+ name + "'");

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate() .find("from UserInfo where e_mail='"
				+ email + "'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> findUserNotSay() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate() .find("from UserInfo u where u.isSay<>'0'");
	}

	@Override
	public boolean checkExistByNickName(String nickName) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<UserInfo> listuser = getHibernateTemplate() 
				.find("from UserInfo u  where u.nickName = '" + nickName + "'");
		if (listuser.size() > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean checkExistByEmail(UserInfo userInfo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<UserInfo> listuser = getHibernateTemplate() 
				.find("from UserInfo  where e_mail = '" + userInfo.getE_mail()
						+ "'");
		if (listuser.size() > 0)
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkExistUserByName(String name, String password) {
		// TODO Auto-generated method stub
		List<UserInfo> list = this.getHibernateTemplate() 
				.find("from UserInfo  where userName = '" + name
						+ "'and password= '" + password + "'");
		if (list.size() > 0)
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkExistUserByEmail(String email, String password) {
		// TODO Auto-generated method stub
		List<UserInfo> list = this.getHibernateTemplate() 
				.find("from UserInfo  where e_mail = '" + email
						+ "'and password= '" + password + "'");
		if (list.size() > 0)
			return true;
		else
			return false;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.UserInfoDao#findUserByNickName(java.lang.String)
	 * 
	 * @param nickName
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月10日
	 */
	@Override
	public List<UserInfo> findUserByNickName(String nickName) {
		// TODO 自动生成的方法存根
		return getHibernateTemplate() .find("from UserInfo  where nickName = '"
				+ nickName + "'");
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.dao.UserInfoDao#findUserByLastLoginTime(java.lang.String)
	 * 
	 * @param lastLoginTime
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月25日
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> findUserByLastLoginTime(String lastLoginTime,
			String year) {
		// TODO 自动生成的方法存根
		List<UserInfo> list = new ArrayList<UserInfo>();
		List<UserInfo> list1 = getHibernateTemplate() 
				.find("from UserInfo  where lastLogin_date like '"
						+ lastLoginTime + "%'");
		List<UserInfo> list2 = getHibernateTemplate() 
				.find("from UserInfo  where lastLogin_date like '" + year
						+ "%'");

		list.addAll(list1);
		list.addAll(list2);

		return list;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> listUserByLingdan() {
		// TODO 自动生成的方法存根
		List<UserInfo> listUser=this.getHibernateTemplate() .find("from UserInfo u where cast(u.lingdan as long)>0 order by cast(u.lingdan as long) desc");
		
			return listUser;

		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> listUserByRegister() {
		// TODO 自动生成的方法存根
		
	List<UserInfo> listUser=this.getHibernateTemplate() .find("from UserInfo u order by u.registerDate desc");
	if(listUser.size()>7)
		{
			return listUser.subList(0,7);
		}else{
			return listUser;
		}
		
	}
	
	
	
	
	
	@Override
	public List<UserInfo> listUserByBoardWealth(long board_id){
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate() .find("select u.id from UserInfo u,WealthBoard w where w.userInfo.id=u.id and w.board.id="+board_id+" order by cast(w.wealthQuantity as long) desc");
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> listNewUserInfo() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate() .find("from UserInfo order by registerDate desc");
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.UserInfoDao#listUserByRole(int, int)
	 * @param offset
	 * @param pageSize
	 * @return
	 *
	 * @author Robust
	 * @date 2014年10月9日
	 *
	 */
	@Override
	public PageModel listUserByRole(int offset, int pageSize) {
		// TODO 自动生成的方法存根

		// 得到总记录数
		String queryCountHql = "select count(*) from UserInfo";
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();

		/*String hql = "from Blog order by blogUp+0 asc";*/
		String hql = "from UserInfo where userName <> 'admin' order by role.id+0 asc";
		List datas = this.getSession().createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize).list();

		// 得到结果集
		PageModel pm = new PageModel();
		pm.setTotal(total);
		pm.setDatas(datas);
		pm.setOffset(offset);

		return pm;
	}


	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.UserInfoDao#listUserBySql(java.lang.String)
	 * @param sql
	 * @return
	 *
	 * @author Robust
	 * @date 2014年10月9日
	 *
	 */
	@Override
	public List<UserInfo> listUserBySql(String sql) {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().find(sql);
	}

}
