/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.FriendDao;
import com.bbsBlog.entity.Friend;
import com.bbsBlog.service.FriendService;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("friendService")
public class FriendServiceImpl implements FriendService {

	@Resource
	private FriendDao friendDao;

	/**
	 * @return friendDao
	 */
	public FriendDao getFriendDao() {
		return friendDao;
	}

	/**
	 * @param friendDao
	 *            要设置的 friendDao
	 */
	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.FriendService#saveFriend(com.bbsBlog.entity.Friend)
	 */
	@Override
	public void saveFriend(Friend friend) {
		// TODO 自动生成的方法存根
		this.friendDao.saveFriend(friend);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.FriendService#updateFriend(com.bbsBlog.entity.Friend)
	 */
	@Override
	public void updateFriend(Friend friend) {
		// TODO 自动生成的方法存根
		this.friendDao.updateFriend(friend);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.FriendService#deleteFriend(long)
	 */
	@Override
	public void deleteFriend(long id) {
		// TODO 自动生成的方法存根
		this.friendDao.deleteFriend(id);

	}
	@Override
	public int countFans(long user_id ){
		return this.friendDao.countFans(user_id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.FriendService#listFriend()
	 */
	@Override
	public List<Friend> listFriendByMsater(long userInfo1_id) {
		// TODO 自动生成的方法存根
		return this.friendDao.listFriendByMsater(userInfo1_id);
	}
	
	@Override
	public List<Friend> IsFriend(long userInfo1_id,long userInfo2_id) {
		// TODO 自动生成的方法存根
		return this.friendDao.IsFriend(userInfo1_id, userInfo2_id);
	}

	@Override
	public List<Friend> listFriendById(long id) {
		// TODO Auto-generated method stub
		return this.friendDao.listFriendById(id);
	}

	@Override
	public List<Friend> listMineById(long id) {
		// TODO Auto-generated method stub
		return this.friendDao.listMineById(id);
	}

	@Override
	public boolean isFriend(long user1, long user2) {
		// TODO Auto-generated method stub
		return this.friendDao.isFriend(user1,user2);
	}

}
