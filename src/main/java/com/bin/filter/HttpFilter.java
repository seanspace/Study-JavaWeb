package com.bin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义的HttpFilter,实现自Filter接口.
 */
public abstract class HttpFilter implements Filter {
	private FilterConfig filterConfig ;
	
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
	/**
	 * 不建议直接覆盖.
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig ;
		init(); 
	}

	/**
	 * 供子类继承的初始化方法.
	 */
	protected void init() {
		
	}
	/**
	 * 原生的doFilter方法,在方法内部把ServletRequest和ServletResponse
	 * 不建议直接覆盖此方法.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest) request ;
		HttpServletResponse response2 = (HttpServletResponse) response ;
		
		doFilter(request2, response2, chain); ;
	}
	

	/**
	 * 抽象方法,为Http请求定制.必须实现此方法;
	 */
	public abstract void doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain chain) throws IOException, ServletException;

	@Override
	public void destroy() {
		
	}

}
