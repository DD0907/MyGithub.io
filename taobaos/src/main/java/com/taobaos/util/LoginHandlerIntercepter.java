package com.taobaos.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginHandlerIntercepter implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String currentURL = request.getRequestURI();
		String ctxPath = request.getContextPath();
		// 除掉项目名称时访问页面当前路径
		String targetURL = currentURL.substring(ctxPath.length());
		HttpSession session = request.getSession(false);
		if (!("/taobaos/login.htm".equals(targetURL))) {
			if (session == null || session.getAttribute("phone") == null) {
				response.sendRedirect("/taobaos/login.htm");
				System.out.println("你需要登录");
				return false;
			} else {
				System.out.println("你已经登录");
				return true;
			}
		} else {
			System.out.println("你已经登录");
			return true;
		}
	}
}
