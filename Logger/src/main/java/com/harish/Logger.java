package com.harish;

import java.util.ArrayList;
import java.util.List;

public class Logger {

	private String appName;
	private List<Thread> threadList = new ArrayList<Thread>();
	
	public Logger(String appName) {
		this.appName = appName;
	}
	
	
	public void log(String message) {
		Log l = new Log(appName, message);
		threadList.add(l);
		l.start();
		
		for(Thread t : threadList) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
	
}
