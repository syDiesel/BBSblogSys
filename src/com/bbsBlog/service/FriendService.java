/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.Friend;

/**
 * @author Robust
 *
 * @date 2014年7月29日
 *
 */
public interface FriendService {
	
	public void saveFriend(Friend friend);

	public void updateFriend(Friend friend);

	public void deleteFriend(long id);

	public List<Friend> listFriendByMsater(long userInfo1_id);
	
	public List<Friend> IsFriend(long userInfo1_id,long userInfo2_id);
	
	public List<Friend> listFriendById(long id);
	
	public int countFans(long user_id );
	
	public List<Friend> listMineById(long id);
	
	public boolean isFriend(long user1, long user2);
}
