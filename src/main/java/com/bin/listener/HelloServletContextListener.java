package com.bin.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 8个listener中最常用的一个:ServletContextListener;
 */
public class HelloServletContextListener implements ServletContextListener ,ServletRequestListener,HttpSessionListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("servletContextListener-- ServletContext 对象创建");
		sce.getServletContext() ;
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("servletContextListener-- ServletContext 对象销毁.");
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Listener -- HttpSession被创建.");
		se.getSession() ;//三个对象的生命周期.
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Listener -- HttpSession被销毁");
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("Listener -- Request被销毁.");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("Listener -- Request被创建.");
	}

}
