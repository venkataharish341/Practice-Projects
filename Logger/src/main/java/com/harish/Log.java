package com.harish;

import java.util.Date;

public class Log extends Thread {

	private String message;
	private String appName;

	public Log(String appName,String message){
		this.appName = appName;
		this.message = message;
	}

	public void run() {
		synchronized(this) {
			System.out.println(new Date() + " " + appName + " " + message);
		}
	}
}
