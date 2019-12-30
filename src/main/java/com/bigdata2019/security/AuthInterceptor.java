package com.bigdata2019.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		
		//	1. Type of Handler(DefaultServletHttpRequestHandler or HandlerMethod?) 
		if(handler instanceof HandlerMethod == false) {
			return true;
		}
		
		//	2. Casting - (Controller method)
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		//	3. Check if handler has annotation @Auth. If Auth is null here, then there is no annotation @Auth in this handler.
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		//	4. if handler does not have annotation @Auth 
		if(auth==null) return true;
		
		//	5. else... check authentication
		HttpSession session = request.getSession();
		if(session ==null || session.getAttribute("authUser")==null) {
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
		}
		
		//	6. Authentication done. Move onto next controller.
		return true;
	}

}
