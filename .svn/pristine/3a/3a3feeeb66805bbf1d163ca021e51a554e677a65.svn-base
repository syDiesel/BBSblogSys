/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.FavoriteDao;
import com.bbsBlog.entity.Favorite;
import com.bbsBlog.service.FavoriteService;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService {

	@Resource
	private FavoriteDao favoriteDao;

	/**
	 * @return favoriteDao
	 */
	public FavoriteDao getFavoriteDao() {
		return favoriteDao;
	}

	/**
	 * @param favoriteDao
	 *            要设置的 favoriteDao
	 */
	public void setFavoriteDao(FavoriteDao favoriteDao) {
		this.favoriteDao = favoriteDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.FavoriteService#saveFavorite(com.bbsBlog.entity.Favorite
	 * )
	 */
	@Override
	public void saveFavorite(Favorite favorite) {
		// TODO 自动生成的方法存根
		this.favoriteDao.saveFavorite(favorite);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.FavoriteService#updateFavorite(com.bbsBlog.entity
	 * .Favorite)
	 */
	@Override
	public void updateFavorite(Favorite favorite) {
		// TODO 自动生成的方法存根
		this.favoriteDao.updateFavorite(favorite);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.FavoriteService#deleteFavorite(long)
	 */
	@Override
	public void deleteFavorite(long id) {
		// TODO 自动生成的方法存根
		this.favoriteDao.deleteFavorite(id);
	}


	/* （非 Javadoc）
	 * @see com.bbsBlog.service.FavoriteService#listFavorite(int, int)
	 * @param offset
	 * @param pageSize
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月30日
	 *
	 */
	@Override
	public PageModel listFavorite(int offset, int pageSize,long loginUser) {
		// TODO 自动生成的方法存根
		return this.favoriteDao.listFavorite(offset, pageSize,loginUser);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.FavoriteService#listFavoriteBySql(java.lang.String)
	 * @param sql
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月30日
	 *
	 */
	@Override
	public List<Favorite> listFavoriteBySql(String sql) {
		// TODO 自动生成的方法存根
		return this.favoriteDao.listFavoriteBySql(sql);
	}

}
