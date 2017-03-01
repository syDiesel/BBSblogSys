/**
 * 
 */
package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.Favorite;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月26日
 *
 */
public interface FavoriteDao {

	public void saveFavorite(Favorite favorite);

	public void updateFavorite(Favorite favorite);

	public void deleteFavorite(long id);

	public PageModel listFavorite(int offset,int pageSize,long loginUser);
	
	public List<Favorite> listFavoriteBySql(String sql);

}
