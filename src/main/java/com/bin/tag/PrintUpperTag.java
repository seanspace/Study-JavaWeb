package com.bin.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PrintUpperTag extends SimpleTagSupport{
	private String time;
	
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		/*
		 * 1.得到标签体的内容,
		 * 2.变为大写;
		 * 3.得到out隐含变量;
		 * 4.
		 */
		JspFragment bodyContent = getJspBody() ;
		StringWriter sWriter = new StringWriter() ;
		bodyContent.invoke(sWriter);
		String content = sWriter.toString() ;
		
		content = content.toUpperCase() ;
		
		int count = 1 ;
		count = Integer.parseInt(time) ;
		for (int i = 0; i < count; i++) {
			getJspContext().getOut().println("<br>" + (i + 1) + ":" + content);
		}
	}

}
