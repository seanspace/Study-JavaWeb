package com.bin.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet("/forwardServlet")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ForwardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ForwardServlet's doXXX");
		// 请求的转发:
		/*
		 * 1.调用HttpServletRequest的getRequestDispatcher()方法获取RequestDispatcher对象;需要传入转出的地址;
		 * 2.调用requestdisbatcher对象的forward()方法;
		 */
		String path = "ForwardServlet2" ;
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/" + path) ;
		requestDispatcher.forward(request, response);
		
	}

}
