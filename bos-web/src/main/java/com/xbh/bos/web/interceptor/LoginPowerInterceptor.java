package com.xbh.bos.web.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xbh
 * @date 2019年1月4日15:24:48
 * @Description 对页面进行登录拦截
 */
public class LoginPowerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object user = request.getSession().getAttribute("user");

		if (user == null || "".equals(user)) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}


		return super.preHandle(request, response, handler);
	}
}
