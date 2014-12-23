package com.bin.configtomcat;

public class ConfigTomcatContext {
	// 测试编译文件的路径设置;可以在build path下重新制定编译目录;
	
	/*
	 * 注:详细可参考PPT
	 * 1.配置Tomcat的虚拟主机:从tomcat5开始在Tomcat7\conf\Catalina\localhost中配置虚拟主机;
	 * 不建议直接在server.xml中进行配置;
	 * <Context path="/test" docBase="c:/test" reloadable="true" />
	 * 2.以下这条就是实际中部署后的配置文件.可以将docBase直接设置为eclipse的workspace目录中的项目,
	 * 这样就可以不用刷新,直接部署;
	 * <Context docBase="D:\Developer\Tomcat7\webapps\JavaWeb_atguitu" path="/JavaWeb_atguitu"
	 *  reloadable="true" source="org.eclipse.jst.jee.server:JavaWeb_atguitu"/>
	 * 而对于Path可以不用配置,因为文件名就代表了path;path就是项目的contextPath路径.
	 * tomcat自动根据source的值往tomcat中编译文件到D:\Developer\Tomcat7\webapps\JavaWeb_atguitu;
	 * 3.reloadable:当docBase中的class文件被改变就会重新被加载;
	 * 4.可以通过run on server来运行web项目;
	 * 
	 */
}
