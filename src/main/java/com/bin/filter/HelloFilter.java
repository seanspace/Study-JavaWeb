package com.bin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init..HelloFilter");
		// Filter随web项目启动时创建,调用本方法;并且filter只会加载一次,就永久在内存中;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("1.Before HelloFilter's chain doFilter...");
		// 访问对应的映射路径时,调用本方法;
		
		chain.doFilter(request, response);// 放行的方法;
		
		System.out.println("2.After HelloFilter's chain doFilter");
	}

	@Override
	public void destroy() {
		System.out.println("destroy...HelloFilter");
	}

}
