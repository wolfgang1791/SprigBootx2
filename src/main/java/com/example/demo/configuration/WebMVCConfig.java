package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.component.RequestTimeInterceptor;




@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter{

	@Autowired
	@Qualifier("requesttimeintercepetor")
	private RequestTimeInterceptor requesttimeinterceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requesttimeinterceptor);
	}
	
	
}
