package com.bin.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class HelloServlet
 * 
 * 1.访问这个servlet的路径:
 *   a.启动时并没有初始化这个servlet.
 *   b.浏览器访问,输出如下结果:
 *   	construct HelloServlet
 *   	init
 *   	service
 *     说明:第一次访问时,先得到一个示例对象.然后调用初始化方法.然后执行service方法;
 *   d.同一个页面连续刷新3下,访问这个servlet输出如下:
 *     construct HelloServlet
 *     init
 *     service
 *     service
 *     service
 *     说明刷新的这3次都是同一个实例的同一个方法;service;Servlet是一个单实例,有线程安全问
 *   e.开两个窗口进行分别3次刷新.输出如下:
 *   	construct HelloServlet
		init
		service
		service
		service
		service
		service
		service
	f.用google浏览器和IE分别刷新两次输出如下:
		construct HelloServlet
		init
		service
		service
		service
		service
	g.关闭tomcat,输出如下:
		destroy
	h.<load-on-startup>和容器一起启动.输出:
		construct HelloServlet
		init
 */
public class HelloServlet implements Servlet {
	public HelloServlet() {
		System.out.println("construct HelloServlet");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
		/*
		 * ServletConfig
		 */
		// 获取初始化参数值;
		String user = config.getInitParameter("user") ;
		System.out.println(user);
		
		// 获取参数名称;
		Enumeration<String> names = config.getInitParameterNames() ;
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String value = config.getInitParameter(name) ;
			System.out.println("^^" + value);
			System.out.println("name:" + name);
		}
		
		// 获取servletname:<servlet-name>helloServlet</servlet-name>
		String servletName = config.getServletName() ;
		System.out.println(servletName);
		
		/*
		 * ServletContext
		 */
		// 获取ServletContext对象
		ServletContext servletContext = config.getServletContext() ;
		
		// 获取当前应用的初始化参数:
		String driver = servletContext.getInitParameter("driver") ;
		System.out.println("driver:" + driver);
		Enumeration<String> name2 = servletContext.getInitParameterNames() ;
		while (name2.hasMoreElements()) {
			String name = (String) name2.nextElement();
			System.out.println("-->" + name);
		}
		
		// 获取某个文件的相对路径名
		String realPath = servletContext.getRealPath("note.txt") ;
			// 参数的当前路径,为部署后的项目的根路径:JavaWeb_atguitu
		System.out.println(realPath);//D:\Developer\Tomcat7\webapps\JavaWeb_atguitu\note.txt
		
		// 获取当前WEB应用的名称:
		String contextPath = servletContext.getContextPath() ;
		System.out.println("contextPath:" + contextPath);//   "/JavaWeb_atguitu"
		
		// 获取当前应用的某一个文件的输入流:
		ClassLoader classLoader = getClass().getClassLoader() ;// 根路径,相对于classpath,也就是/WEB-INF/classes/
		InputStream inputStream = classLoader.getResourceAsStream("/jdbc.properties") ;
		InputStream inputStream3 = classLoader.getResourceAsStream("jdbc.properties") ;
		System.out.println("1. " + inputStream);//1. java.io.BufferedInputStream@5b522d7c
		System.out.println("3. " + inputStream3);//1. java.io.BufferedInputStream@5b522d7c
		
		// 根路径,相对于当前的应用部署路径,也就是:JavaWeb_atguitu
		InputStream inputStream2 = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties") ;
		InputStream inputStream4 = servletContext.getResourceAsStream("WEB-INF/classes/jdbc.properties") ;
		System.out.println("2. " + inputStream2);//2. java.io.FileInputStream@702856ba
		System.out.println("4. " + inputStream4);//2. java.io.FileInputStream@702856ba
		
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig");
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service");
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo");
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
		
	}
	
}
