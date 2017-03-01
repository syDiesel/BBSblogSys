/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
public interface UserInfoService {
	
	public void saveUserInfo(UserInfo userInfo);

	public void updateUserInfo(UserInfo userInfo);

	public void deleteUserInfo(long id);

	public List<UserInfo> listUserInfo();
	
	public List<UserInfo> listNewUserInfo();
	
	public UserInfo findById(long id);
	
	public String register(UserInfo user);
	
	public String login(UserInfo user);
	
	public List<UserInfo> findUserByName(String name);
	
	public List<UserInfo> findUserNotSay();
	
	public void updateLastLogByName(String name,String date);
	
	public void updateJinzhuan(String name,String jinzhuan);
	
	public void updateLingdan(String name,String lingdan);
	
	public void updateYangmu(String name,String yangmu);
	
	public void updateXianhua(String name,String xianhua);
	
	public void updateUserLevel(String name,String userLevel);
	
	public void updateIsSay(String name,String isSay);
	
	public void updateRole(String name,long Role_id);
	
	public void updatePassword(String name,String password);
	
	public List<UserInfo> findUserByEmail(String email);
	
	public boolean checkExistByNickName(String nickName);
	
	//通过名字查找密码是否正确 2014.9.4   by swh  登录验证
	public boolean checkExistUserByName(String name,String password);
	
	//通过email查找密码是否正确 2014.9.4   by swh		登录验证
	public boolean checkExistUserByEmail(String email,String password);
	
	public List<UserInfo> findUserByNickName(String nickName);

	public List<UserInfo> findUserByLastLoginTime(String lastLoginTime,String year);
	
    public List<UserInfo> listUserByLingdan();
	
	public List<UserInfo> listUserByRegister();
	
	public List listUserByBoardWealth(long board_id);
	
	public PageModel listUserByRole(int offset, int pageSize);
	
	public  List<UserInfo> listUserBySql(String sql);
}
