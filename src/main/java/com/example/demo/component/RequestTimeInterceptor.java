package com.example.demo.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requesttimeintercepetor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
	
	public static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
	
	
	//primero
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) // antes de ejecutar el metodo del controlador
			throws Exception {
		request.setAttribute("starttime", System.currentTimeMillis());
		return true;
	}

		// segundo
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)// antes del completado- escupir
			throws Exception {
		long startime = (long) request.getAttribute("starttime");
		LOG.info("request url:"+request.getRequestURL().toString()+" total time: "+ (System.currentTimeMillis()-startime));
	}
	

}
