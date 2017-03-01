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

import com.bbsBlog.dao.FavoriteDao;
import com.bbsBlog.entity.Favorite;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("favoriteDao")
public class FavoriteDaoImpl extends HibernateDaoSupport implements FavoriteDao {

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.dao.FavoriteDao#saveFavorite(com.bbsBlog.entity.Favorite)
	 */
	@Override
	public void saveFavorite(Favorite favorite) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().save(favorite);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.dao.FavoriteDao#updateFavorite(com.bbsBlog.entity.Favorite)
	 */
	@Override
	public void updateFavorite(Favorite favorite) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().update(favorite);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.FavoriteDao#deleteFavorite(long)
	 */
	@Override
	public void deleteFavorite(long id) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().delete(
				this.getHibernateTemplate().get(Favorite.class, id));
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.FavoriteDao#listFavorite()
	 */
	@Override
	public PageModel listFavorite(int offset, int pageSize, long loginUser) {
		String queryCountHql = "select count(*) from Favorite where userInfo.id='"
				+ loginUser + "'";
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();

		String hql = "from Favorite where userInfo.id='" + loginUser
				+ "' order by time desc";
		List datas = this.getSession().createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize).list();

		// 得到结果集
		PageModel pm = new PageModel();
		pm.setTotal(total);
		pm.setDatas(datas);
		pm.setOffset(offset);

		return pm;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.FavoriteDao#listFavoriteBySql(java.lang.String)
	 * 
	 * @param sql
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月30日
	 */
	@Override
	public List<Favorite> listFavoriteBySql(String sql) {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().find(sql);
	}

}
