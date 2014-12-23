package com.bin.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class BindingListener implements HttpSessionBindingListener {

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		event.getSession() ;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		
	}

}
