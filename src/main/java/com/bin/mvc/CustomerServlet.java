package com.bin.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取表单参数:
		 * 2.检验name是否已经被占用.若已经被占用,响应带newCustomer.jsp页面
		 * 	显示一个错误消息:用户名已经被占用.同时表单值可以回显;
		 * 2.把参数封装为一个customer对象.
		 * 3.调用customerDao的save方法执行保存
		 * 4.重定向到success.jsp
		 */
		
		/*
		 * 面向接口编程:
		 * 在类中调用接口的方法,而不必关系方法的具体实现,
		 * 这样有利于解耦合.可扩展性更强.
		 */
	}

}
