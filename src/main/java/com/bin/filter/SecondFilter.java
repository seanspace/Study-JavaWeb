package com.bin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("second init...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("3. Before SecondFilter chain doFilter...");
		// 访问对应的映射路径时,调用本方法;
		
		chain.doFilter(request, response);// 放行的方法;
		
		System.out.println("4.After SecondFilter chain doFilter");
	}

	@Override
	public void destroy() {
		System.out.println("seconde destroy...");
	}

}
