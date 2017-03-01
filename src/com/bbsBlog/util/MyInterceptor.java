package com.bbsBlog.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String login = (String) request.getSession().getAttribute("login");
		String action = request.getRequestURI();
	/*	System.out.println("login=========>" + login);
		System.out.println("login=========>" + request.getRequestURI());*/

		if (action.contains("user.do")) {
			if (request.getParameter("action").equalsIgnoreCase("login")) {
				/*System.out.println("action=========>"
						+ request.getParameter("action"));*/
				return true;
			} else if (login != null) {
				return true;
			}else {
				response.sendRedirect("swh/houtai/login.jsp");
				return false;
			}
				

		} else if (login != null) {
			return true;
		}

		// System.out.println("MyInterceptor   wrong");
		response.sendRedirect("swh/houtai/login.jsp");
		return false;

	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj, ModelAndView mav)
			throws Exception {

	}

}
