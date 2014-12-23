package com.bin.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ParentTag extends SimpleTagSupport{
	
	private String name = "www.AtGuiGu.com" ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("父标签处理器类的name" + name);
		getJspBody().invoke(null);
	}
	
	
	
}
