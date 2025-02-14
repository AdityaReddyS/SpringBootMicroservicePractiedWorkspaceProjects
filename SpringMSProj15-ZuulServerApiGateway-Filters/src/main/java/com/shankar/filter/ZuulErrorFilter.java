package com.shankar.filter;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;



@Component
public class ZuulErrorFilter extends ZuulFilter{
	private Logger logger=LoggerFactory.getLogger(ZuulFilter.class);
	@Override
	public boolean shouldFilter() {
		
		return true;
	}
	@Override
	public Object run() throws ZuulException {
		//get request context object
		RequestContext context=RequestContext.getCurrentContext();
		
		System.out.println("ZuulErrorFilter.run()::from Error-filter ");
		//get throwable object
		Throwable th=context.getThrowable();
		//write log messages to current request
		logger.info("=====from Error filter======");
		logger.error("Exception Message::"+th.getMessage()+" class "+th.getClass());
		//logger.info("router host::"+context.getRouteHost().toString());
	
		return null;
	}

	

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FilterConstants.ERROR_TYPE;
	}

}
