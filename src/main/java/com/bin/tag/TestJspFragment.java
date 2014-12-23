package com.bin.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestJspFragment extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		// JSpFragment:标签体内容的封装对象;
		JspFragment bodyContent = getJspBody() ;
		// JspFragment.invoke(Writer):即为标签体内容输出的字符流,
		// bodyContent.invoke(null);若为null输出到getjspContext.getOut(),即输出到页面上;
		
		/*
		 * 1. 利用StringWriter()得到标签体内容;
		 * 2. 把标签体的内容都变为大写;
		 * 3. 获取JSP页面的out隐含对象,输出到页面上;
		 */
		StringWriter sw = new StringWriter() ;
		bodyContent.invoke(sw);// 由容器,把标签体的内容,放到指定的输出流中;
		
		String content = sw.toString().toUpperCase() ;
		
		getJspContext().getOut().print("我在测试Fragment输出到页面:" + content); 
		
		
	}
}
