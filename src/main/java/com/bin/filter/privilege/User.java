package com.bin.filter.privilege;

import java.util.List;

public class User {
	private String usename ;
	private List<Authority> authority ;
	public String getUsename() {
		return usename;
	}
	public void setUsename(String usename) {
		this.usename = usename;
	}
	public List<Authority> getAuthority() {
		return authority;
	}
	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}
	public User(String usename, List<Authority> authority) {
		super();
		this.usename = usename;
		this.authority = authority;
	}
	@Override
	public String toString() {
		return "User [usename=" + usename + ", authority=" + authority + "]";
	}
	
}
