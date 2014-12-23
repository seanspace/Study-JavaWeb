package com.bin.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SonTag extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		/*
		 * 1.得到父标签的应用;
		 * 2. 获取父标签name属性
		 * 3.打印到jsp页面;
		 */
		JspTag parent = getParent() ;
		
		ParentTag parentTag = (ParentTag) parent ;
		String name = parentTag.getName() ;
		
		getJspContext().getOut().println(name);
	}
	
}
