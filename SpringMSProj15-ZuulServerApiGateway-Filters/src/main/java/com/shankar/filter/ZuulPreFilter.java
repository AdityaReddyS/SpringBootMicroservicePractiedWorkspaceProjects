package com.shankar.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;



@Component
public class ZuulPreFilter extends ZuulFilter{
	private Logger logger=LoggerFactory.getLogger(ZuulFilter.class);
	@Override
	public boolean shouldFilter() {
		
		return true;
	}
	@Override
	public Object run() throws ZuulException {
		//get request context object
		RequestContext context=RequestContext.getCurrentContext();
		//get httpservletrequest object
		HttpServletRequest req=context.getRequest();
		System.out.println("ZuulPreFilter.run()::from pre-filter ");
		//write log messages to current request
		logger.info("=====from pre filter======");
		logger.info("request content type::"+req.getContentType());
		logger.info("request mode:::"+req.getMethod());
		logger.info("request path:::"+req.getServletPath());
		logger.info("request uri:::"+req.getRequestURI());
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
		return FilterConstants.PRE_TYPE;
	}

}
