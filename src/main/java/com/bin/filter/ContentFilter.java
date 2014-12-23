package com.bin.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 * 1.获取请求参数的值
		 * 2.把其中fuck,shit等字符替换为***
		 * 3.目标页
		 */
		String content = request.getParameter("content") ;
		HttpServletRequest request2 = new MyHttpServletRequest(request) ;
		if (content.contains(" fuck ")) {
			/*
			 * 1.request中并没有setParameter方法;所以我们的目标:改变getParameter方法的行为:若该方法中包含fuck,则替换为 " *** "
			 * 	>若对于一个雷的方法不满意,需要进行重写,最常用的方式是,继承父类.但是HttpServletRequest是个接口,我们无法全部实现.
			 * 	>若实现则需要继承org.apache.catalina.connector.RequestFacade,而这仅仅是Tomcat服务器的实现,若更换服务器,该方案无法使用.
			 * 
			 * 2.直接写一个HttpServletRequest接口的实现类:无法实现其中方法,×.
			 * 
			 * 3.装饰目前的HttpServletRequest对象:装饰其getParameter方法,而其他方法,而其他方法还和其实现相同.
			 * 	> 创建一个类,该类实现HttpServletRequest接口,把当前doFilter方法中的request传入到该类中,
			 * 		作为其成员变量,使用该成员变量去实现接口的全部方法.
			 */
			
//			chain.doFilter(request2, response);
//			return ;
		}
		
		chain.doFilter(request2, response);
	}

}
