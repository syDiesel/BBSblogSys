package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.util.PageModel;

public interface UserInfoDao {

	public void saveUserInfo(UserInfo userInfo);

	public void updateUserInfo(UserInfo userInfo);

	public void deleteUserInfo(long id);

	public List<UserInfo> listUserInfo();
	
	public List<UserInfo> listNewUserInfo();
	
	public UserInfo findById(long id);
	
	public boolean checkExistsByName(UserInfo uuser);
	
	public String getPasswordByName(UserInfo uuser);
	
	public List<UserInfo> findUserByName(String name);
	
	public List<UserInfo> findUserByEmail(String email);
	
	public List<UserInfo> findUserNotSay();
	
	public boolean checkExistByEmail(UserInfo userInfo);
	
	public boolean checkExistByNickName(String nickName);

	//通过名字查找密码是否正确 2014.9.4   by swh  登录验证
	public boolean checkExistUserByName(String name,String password);
	
	//通过email查找密码是否正确 2014.9.4   by swh		登录验证
	public boolean checkExistUserByEmail(String email,String password);
	
	//通过昵称发送私信
	public List<UserInfo> findUserByNickName(String nickName);
	
	//通过最后登录时间，过滤僵尸用户
	public List<UserInfo> findUserByLastLoginTime(String lastLoginTime,String year);
	
	public List<UserInfo> listUserByLingdan();
	
	public List<UserInfo> listUserByRegister();
	
	public List<UserInfo> listUserByBoardWealth(long board_id);
	
	public PageModel listUserByRole(int offset,int pageSize);
	
	public  List<UserInfo> listUserBySql(String sql);
	
}
