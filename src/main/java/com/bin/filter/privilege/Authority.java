package com.bin.filter.privilege;

public class Authority {
	// 显示到页面的权限的名字;
	private String displayName ;
	// 权限对应的URL地址,开发时:private String[] urls ;
	private String url ;
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Authority(String displayName, String url) {
		super();
		this.displayName = displayName;
		this.url = url;
	}
	@Override
	public String toString() {
		return "Authority [displayName=" + displayName + ", url=" + url + "]";
	}
	
}
