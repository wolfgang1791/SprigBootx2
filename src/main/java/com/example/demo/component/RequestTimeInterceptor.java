package com.example.demo.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.demo.repository.LogRepository;

@Component("requesttimeintercepetor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
	
	public static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
	
	@Autowired
	@Qualifier("logrepository")
	LogRepository logrepository;
	
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
		String url = request.getRequestURL().toString();
		String username="";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.equals(null) && auth.isAuthenticated()) {
			username=auth.getName();
		}
		com.example.demo.entity.Log Log = new com.example.demo.entity.Log(new Date(), auth.getDetails().toString(), username, url);
		logrepository.save(Log);
		LOG.info("request url:"+url+" total time: "+ (System.currentTimeMillis()-startime));
	}
	

}
