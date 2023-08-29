package com.ni.emp.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class EmployeeServiceInterceptorConfig  extends WebMvcConfigurationSupport  {
	
	
	@Autowired
	private RequestResponseInterceptor requestResponseInterceptor;
	
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestResponseInterceptor);
		super.addInterceptors(registry);
	}
	
	
	
	
	
}
