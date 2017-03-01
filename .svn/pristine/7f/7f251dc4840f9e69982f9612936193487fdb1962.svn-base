package com.bbsBlog.util;

import javax.servlet.http.*;

import com.bbsBlog.entity.UserInfo;

import java.sql.Timestamp;
import java.util.*;

public class SessionListener implements HttpSessionListener {

	@SuppressWarnings("rawtypes")
	private static java.util.Hashtable hUserName = new Hashtable();
	private int activeSessions = 0;

	public int getActiveSessions() {
		return activeSessions;
	}

	public void sessionCreated(HttpSessionEvent se) {
		Date date = new Date();
		Timestamp now1 = new Timestamp(date.getTime());
		System.out.println("客户端已连接服务器 --会话号为： " + se + now1);
		this.activeSessions = this.activeSessions + 1;
		se.getSession().getServletContext()
				.setAttribute("activeSessions", this.activeSessions);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		Date date = new Date();
		Timestamp now2 = new Timestamp(date.getTime());
		System.out.println("用户会话已失效session -- " + se + now2);
		if (se.getSession().getAttribute("applyerName") != null)
			hUserName.remove(se.getSession().getAttribute("applyerName")
					.toString().trim());
		if (se.getSession().getAttribute("adminName") != null)
			hUserName.remove(se.getSession().getAttribute("adminName")
					.toString().trim());
		if (this.activeSessions > 0) {
			this.activeSessions = this.activeSessions - 1;
		}

	}

	@SuppressWarnings("unchecked")
	public synchronized static boolean isLogined(HttpSession session,
			String user_name) {// （踢掉先登陆者再抢）是否该帐户已经在使用Action调用
		Date date = new Date();
		Timestamp now3 = new Timestamp(date.getTime());
		boolean flag = false;
		
		if (hUserName.containsKey(user_name)) {
			flag = true;
			HttpSession vsession = (HttpSession) hUserName.get(user_name);
			try {
				vsession.invalidate();// 踢掉先登陆者
				System.out.println("用户 - " + user_name + " || 已存在 - " + session
						+ now3);
				System.out.println("用户 - " + user_name + " || 被挤掉了" + now3);

			} catch (Exception ex) {
			}
		} else {
			flag = false;

		}
		// hUserName.remove(user_id1);
		hUserName.remove(user_name);
		hUserName.put(user_name, session);
		
		if (flag == false) {// 如果没有登陆则在哈西表中记录
			// hUserName.put(user_id1, session);
			hUserName.put(user_name, session);
			System.out.println("用户已经登陆： - " + user_name + " || 会话号为： - "
					+ session + now3);
			
			
			System.out.println(hUserName);
		}
		return flag;
	}


	public synchronized static boolean deleteUserName(HttpSession session,
			String user_name, UserInfo userInfo) {
		Date date = new Date();
		HttpSession vsession = (HttpSession) hUserName.get(user_name);

		System.out.println("用户已登出： - " + user_name + " || 会话号为： - " + session
				+ date);
		System.out.println("vsession"+vsession);
		if(vsession!=null){
		vsession.invalidate();
		}else session.invalidate();
		hUserName.remove(user_name); // 删除用户Action调用
		

	
		
		return true;
	}

	public synchronized static boolean deleteUnitUserName(HttpSession session,
			String user_name) {
		Date date = new Date();
		HttpSession vsession = (HttpSession) hUserName.get(user_name);

		System.out.println("用户已登出： - " + user_name + " || 会话号为： - " + session
				+ date);
		hUserName.remove(user_name); // 删除用户Action调用
		// hUserName.remove(groupId);
		vsession.invalidate();//
		return true;
	}

	public synchronized static void Isconnent(HttpSession session,
			String user_id1, String user_name) {
		Date date = new Date();
		System.out.println("用户已登出: - " + user_name + " || session - " + session
				+ "|| 当前时间为" + date);
		hUserName.remove(user_id1); // 删除用户Action调用

	}

	public synchronized static boolean isOnline(HttpSession session,
			String user_id1) {// 登陆后使用判断是否已经登陆Action调用
		boolean flag = false;
		// System.out.println("======isOnline=======");
		HttpSession vsession = null;
		try {
			vsession = (HttpSession) hUserName.get(user_id1);
		} catch (Exception e) {
			flag = true;
			System.out.println(user_id1 + "验证登陆异常");
			flag = false;
		}
		if (vsession != null) {
			if (session.getId().equals(vsession.getId())) {
				flag = true;
				System.out.println(user_id1 + "通过验证");
			} else {
				flag = false;
			}
		}
		return flag;

	}

	@SuppressWarnings("rawtypes")
	public static java.util.Hashtable gethUserName() {
		return hUserName;
	}

	@SuppressWarnings("rawtypes")
	public static void sethUserName(java.util.Hashtable hUserName) {
		SessionListener.hUserName = hUserName;
	}


}
