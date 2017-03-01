/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.RoleDao;
import com.bbsBlog.dao.UserInfoDao;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.UserInfoService;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月31日
 *
 */
@Service("userInfo")
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoDao userInfoDao;
	
	@Resource
	private RoleDao roleDao;


	/**
	 * @return userInfoDao
	 */
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	/**
	 * @param userInfoDao
	 *            要设置的 userInfoDao
	 */
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.UserInfoService#saveUserInfo(com.bbsBlog.entity.UserInfo
	 * )
	 * 
	 * @param userInfo
	 * 
	 * @author Robust
	 * 
	 * @date 2014年7月31日
	 */
	@Override
	public void saveUserInfo(UserInfo userInfo) {
		// TODO 自动生成的方法存根
		this.userInfoDao.saveUserInfo(userInfo);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.UserInfoService#updateUserInfo(com.bbsBlog.entity
	 * .UserInfo)
	 * 
	 * @param userInfo
	 * 
	 * @author Robust
	 * 
	 * @date 2014年7月31日
	 */
	@Override
	public void updateUserInfo(UserInfo userInfo) {
		// TODO 自动生成的方法存根
		this.userInfoDao.updateUserInfo(userInfo);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.UserInfoService#deleteUserInfo(long)
	 * 
	 * @param id
	 * 
	 * @author Robust
	 * 
	 * @date 2014年7月31日
	 */
	@Override
	public void deleteUserInfo(long id) {
		// TODO 自动生成的方法存根
		this.userInfoDao.deleteUserInfo(id);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.UserInfoService#listUserInfo()
	 * 
	 * @param
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年7月31日
	 */
	@Override
	public List<UserInfo> listUserInfo() {
		// TODO 自动生成的方法存根
		return this.userInfoDao.listUserInfo();
	}
	
	@Override
	public List<UserInfo> findUserNotSay(){
		// TODO 自动生成的方法存根
		return this.userInfoDao.findUserNotSay();
	}
	
	public UserInfo findById(long id){
		return this.userInfoDao.findById(id);
	}
	
	@Override
	public String register(UserInfo user) {
		if (user.getUserName().equals("") || user.getPassword().equals("") || user.getE_mail().equals("")) {
			return "registererror";
		} else {
			if (!userInfoDao.checkExistsByName(user)) {
				userInfoDao.saveUserInfo(user);
				return "success";
			} else
				return "error";
		}
	}
	@Override
	public String login(UserInfo user) {
		if (user.getUserName().equals("") || user.getPassword().equals("")) {
			return "error";
		} else {
			if (!userInfoDao.checkExistsByName(user)&&!userInfoDao.checkExistByEmail(user)) {
				return "error";
			} else if (userInfoDao.checkExistsByName(user)
					&& user.getPassword().equals(userInfoDao.getPasswordByName(user)))
				return "success";
			else if(userInfoDao.checkExistByEmail(user)&& user.getPassword().equals(userInfoDao.getPasswordByName(user)))
				return "success";
			else
				return "error";
		}
	}
	@Override
	public List<UserInfo> findUserByName(String name){
		return userInfoDao.findUserByName(name);
		
	}
	@Override
	public void updateLastLogByName(String name,String date){
		List<UserInfo> user=userInfoDao.findUserByName(name);
		UserInfo userInfo=user.get(0);
		userInfo.setLastLogin_date(date);
		this.userInfoDao.updateUserInfo(userInfo);
	}
	
	@Override
	public void updatePassword(String name,String password){
		List<UserInfo> user=userInfoDao.findUserByName(name);
		UserInfo userInfo=user.get(0);
		userInfo.setPassword(password);
		this.userInfoDao.updateUserInfo(userInfo);
	}
	
	@Override
	public void updateJinzhuan(String name,String jinzhuan){
		List<UserInfo> user=userInfoDao.findUserByName(name);
		UserInfo userInfo=user.get(0);
		userInfo.setJinzhuan(jinzhuan);
		this.userInfoDao.updateUserInfo(userInfo);
	}
	
	
	@Override
	public void updateYangmu(String name,String yangmu){
		List<UserInfo> user=userInfoDao.findUserByName(name);
		UserInfo userInfo=user.get(0);
		userInfo.setYangmu(yangmu);
		this.userInfoDao.updateUserInfo(userInfo);
	}
	
	@Override
	public void updateXianhua(String name,String xianhua){
		List<UserInfo> user=userInfoDao.findUserByName(name);
		UserInfo userInfo=user.get(0);
		userInfo.setXianhua(xianhua);
		this.userInfoDao.updateUserInfo(userInfo);
	}
	
	@Override
	public void updateLingdan(String name,String lingdan){
		List<UserInfo> user=userInfoDao.findUserByName(name);
		UserInfo userInfo=user.get(0);
		userInfo.setLingdan(lingdan);
		this.userInfoDao.updateUserInfo(userInfo);
	}
	
	@Override
	public void updateUserLevel(String name,String userLevel){
		List<UserInfo> user=userInfoDao.findUserByName(name);
		UserInfo userInfo=user.get(0);
		userInfo.setUserLevel(userLevel);
		this.userInfoDao.updateUserInfo(userInfo);
	}
	
	@Override
	public void updateIsSay(String name,String isSay){
		List<UserInfo> user=userInfoDao.findUserByName(name);
		UserInfo userInfo=user.get(0);
		userInfo.setIsSay(isSay);
		this.userInfoDao.updateUserInfo(userInfo);
	}
	
	@Override
	public void updateRole(String name,long role_id){
		List<UserInfo> user=userInfoDao.findUserByName(name);
		UserInfo userInfo=user.get(0);
		userInfo.setRole(this.roleDao.listRoleById(role_id));
		this.userInfoDao.updateUserInfo(userInfo);
	}

	@Override
	public List<UserInfo> findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userInfoDao.findUserByEmail(email);
	}

	@Override
	public boolean checkExistUserByName(String name, String password) {
		// TODO Auto-generated method stub
		return this.userInfoDao.checkExistUserByName(name, password);
	}

	@Override
	public boolean checkExistUserByEmail(String email, String password) {
		// TODO Auto-generated method stub
		return this.userInfoDao.checkExistUserByEmail(email, password);
	}
	
	
	@Override
	public boolean checkExistByNickName(String nickName){
		// TODO Auto-generated method stub
		return this.userInfoDao.checkExistByNickName(nickName);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.UserInfoService#findUserByNickName(java.lang.String)
	 * @param nickName
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月10日
	 *
	 */
	@Override
	public List<UserInfo> findUserByNickName(String nickName) {
		// TODO 自动生成的方法存根
		return this.userInfoDao.findUserByNickName(nickName);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.UserInfoService#findUserByLastLoginTime(java.lang.String)
	 * @param lastLoginTime
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月25日
	 *
	 */
	@Override
	public List<UserInfo> findUserByLastLoginTime(String lastLoginTime,String year) {
		// TODO 自动生成的方法存根
		return this.userInfoDao.findUserByLastLoginTime(lastLoginTime,year);
	}
	
	@Override
	public List<UserInfo> listUserByLingdan(){
		// TODO 自动生成的方法存根
		return this.userInfoDao.listUserByLingdan();
	}
	
	@Override
	public List<UserInfo> listUserByRegister() {
		// TODO 自动生成的方法存根
		return this.userInfoDao.listUserByRegister();
	}
	
	
	@Override
	public List listUserByBoardWealth(long board_id) {
		// TODO 自动生成的方法存根
		return this.userInfoDao.listUserByBoardWealth(board_id);
	}

	@Override
	public List<UserInfo> listNewUserInfo() {
		// TODO Auto-generated method stub
		return this.userInfoDao.listNewUserInfo();
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.UserInfoService#listUserByRole(int, int)
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
		return this.userInfoDao.listUserByRole(offset, pageSize);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.UserInfoService#listUserBySql(java.lang.String)
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
		return this.userInfoDao.listUserBySql(sql);
	}

}
