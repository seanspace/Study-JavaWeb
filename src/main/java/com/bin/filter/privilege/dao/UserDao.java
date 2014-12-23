package com.bin.filter.privilege.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bin.filter.privilege.Authority;
import com.bin.filter.privilege.User;

public class UserDao {
	
	private static Map<String, User> users ;
	
	static {
		users = new HashMap<String, User>() ;
		List<Authority> authorities = new ArrayList<>() ;
		authorities.add(new Authority("Article_1", "/JavaWeb_atguitu/article/article_1.jsp")) ;
		authorities.add(new Authority("Article_2", "/JavaWeb_atguitu/article/article_2.jsp")) ;
		users.put("AAA", new User("AAA", authorities)) ;
		
		authorities = new ArrayList<>() ;
		authorities.add(new Authority("Article_3", "/JavaWeb_atguitu/article/article_3.jsp")) ;
		authorities.add(new Authority("Article_3", "/JavaWeb_atguitu/article/article_3.jsp")) ;
		users.put("BBB", new User("BBB", authorities)) ;
	}
	
	User get(String username) {
		
		return null ;
	}
	
	void update(String username,List<Authority> authority){
		users.get(username).setAuthority(authority);
		
	}
}
