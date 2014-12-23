package com.bin.filter.cache;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.filter.HttpFilter;

public class NoCacheFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 需要三个设置头可以设置禁用缓存.
		System.out.println("cacheFilter's doFilter...");
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no_cache");
		response.setHeader("Pragma", "no-cache");
		
		chain.doFilter(request, response);
	}


}
