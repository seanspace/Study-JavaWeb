package com.bin.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class HelloTag implements SimpleTag{

	private String value ;
	private String count ;
	
	/**
	 * 由JSP引擎调用,并设置值;这里的值来自这个标签的属性的实际值;
	 */
	public void setValue(String value) {
		this.value = value;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("doTag");
		try {
			JspWriter out =  pageContext.getOut() ;
			out.print("HelloWorld!");
			int c = 0 ;
			
			c = Integer.parseInt(count) ;
			for (int i = 0; i < c; i++) {
				out.print(i + ":" + value);
				out.print("<br>");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest() ;
		
	}

	@Override
	public JspTag getParent() {
		System.out.println("getParent");

		
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {
		System.out.println("setJspBody");
	}
	
	private PageContext pageContext ;

	/* 
	 * 由容器jsp引擎调用,传入一个pageContext对象;
	 * 一定会调用;
	 */
	@Override
	public void setJspContext(JspContext arg0) {
		System.out.println(arg0);
		pageContext = (PageContext) arg0 ;
	}

	@Override
	public void setParent(JspTag arg0) {
		System.out.println("setParent") ;
	}

}
