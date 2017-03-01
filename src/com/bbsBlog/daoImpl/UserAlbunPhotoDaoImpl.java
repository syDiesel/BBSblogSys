/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.UserAlbumPhotoDao;
import com.bbsBlog.entity.UserAlbumPhoto;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("userAlbumPhotoDao")
public class UserAlbunPhotoDaoImpl extends HibernateDaoSupport implements UserAlbumPhotoDao {
	
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}
	
	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.UserAlbumPhotoDao#saveUserAlbumPhoto(com.bbsBlog.entity.UserAlbumPhoto)
	 */
	@Override
	public void saveUserAlbumPhoto(UserAlbumPhoto uap) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().save(uap);

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.UserAlbumPhotoDao#updateUserAlbumPhoto(com.bbsBlog.entity.UserAlbumPhoto)
	 */
	@Override
	public void updateUserAlbumPhoto(UserAlbumPhoto uap) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().update(uap);

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.UserAlbumPhotoDao#delete(long)
	 */
	@Override
	public void delete(long id) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(UserAlbumPhoto.class,id));

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.UserAlbumPhotoDao#listUserAlbumPhoto()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbumPhoto> listUserAlbumPhoto() {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().find("from UserAlbumPhoto");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbumPhoto> findByUserAlbumId(long id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from UserAlbumPhoto u where u.userAlbum.id='"+id+"'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbumPhoto> findByPhotoId(long id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from UserAlbumPhoto where id='"+id+"'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbumPhoto> listZzzm() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from UserAlbumPhoto u where u.zzzm = '1' and u.root = '0'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbumPhoto> listZzzmByRoot(String id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from UserAlbumPhoto u where u.root = '"+id+"'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbumPhoto> listZzzmByAlbumAndRoot(long id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from UserAlbumPhoto u where u.userAlbum.id = '"+id+"' and u.root='0'");
	}

	@Override
	public PageModel listPhotoByAlbum(int offset, int pageSize, long albumId) {
		// TODO Auto-generated method stub
		String queryCountHql="select count(*) from UserAlbumPhoto where userAlbum.id='"+albumId+"'";
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();
		
		String hql = "from UserAlbumPhoto where userAlbum.id='" + albumId
				+ "' order by photoTime desc";
		List datas = this.getSession().createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize).list();
		
		PageModel pm = new PageModel();
		pm.setTotal(total);
		pm.setDatas(datas);
		pm.setOffset(offset);

		return pm;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbumPhoto> listByAlbumNameAndRoot(String albumName,long id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from UserAlbumPhoto u where u.userAlbum.albumName = '"+albumName+"' and u.zzzm='4' " +
				"and u.root ='0' and u.userAlbum.userInfo.id='"+id+"'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbumPhoto> listBySql(String sql) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(sql);
	}

}
