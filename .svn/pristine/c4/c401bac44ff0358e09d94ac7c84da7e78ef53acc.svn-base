/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.FriendDao;
import com.bbsBlog.entity.Friend;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("friendDao")
public class FriendDaoImpl implements FriendDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.FriendDao#saveFriend(com.bbsBlog.entity.Friend)
	 */
	@Override
	public void saveFriend(Friend friend) {
		this.hibernateTemplate.save(friend);
		// TODO 自动生成的方法存根

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.FriendDao#updateFriend(com.bbsBlog.entity.Friend)
	 */
	@Override
	public void updateFriend(Friend friend) {
		this.hibernateTemplate.update(friend);
		// TODO 自动生成的方法存根

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.FriendDao#deleteFriend(long)
	 */
	@Override
	public void deleteFriend(long id) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.delete(this.hibernateTemplate.get(Friend.class, id));

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.FriendDao#listFriend()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Friend> listFriendByMsater(long id) {
		// TODO 自动生成的方法存根
		return this.hibernateTemplate.find("from Friend f where f.userInfo1.id="+id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Friend> IsFriend(long userInfo2_id,long userInfo1_id) {
		// TODO 自动生成的方法存根
		return this.hibernateTemplate.find("from Friend f where f.userInfo1.id="+userInfo1_id+" and f.userInfo2.id="+userInfo2_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Friend> listFriendById(long id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Friend f where f.userInfo2.id='"+id+"'");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int countFans(long user_id ) {
		// TODO 自动生成的方法存根
		return Integer.parseInt(this.hibernateTemplate.find("select count(*) from Friend f where f.userInfo1="+user_id).listIterator().next().toString());
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Friend> listMineById(long id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Friend f where f.userInfo1.id='"+id+"'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isFriend(long user1, long user2) {
		// TODO Auto-generated method stub
		List<Friend> list = this.hibernateTemplate.find("from Friend f where f.userInfo2.id="+user1+" and f.userInfo1.id="+user2);
		
		if(list.size() > 0){
			return true;
		}else
			return false;
		
	}

}
