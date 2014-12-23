package com.bin.tag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ReadFileTag extends SimpleTagSupport{
	// 相对于当前WEb应用的根路径的文件名;
	private String src ;
	
	public void setSrc(String src){
		this.src = src ;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext() ;
		InputStream inputStream = pageContext.getServletContext().getResourceAsStream(src) ;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)) ;
		
		String string = null ;
		while ((string = reader.readLine()) != null) {
			// 若文件中有标签,则会被浏览器翻译;需要使用正则表达式,去修改;
			// String.replaceAll()方法正是使用的下面的方式替换;
			Pattern.compile("<").matcher(string).replaceAll("&lt") ;
			Pattern.compile("<").matcher(string).replaceAll("&gt") ;
			pageContext.getOut().println(string);
			pageContext.getOut().println("<br>");
		}
		
	}
	
	
}
