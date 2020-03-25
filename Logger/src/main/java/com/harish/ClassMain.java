package com.harish;

public class ClassMain {


	public static void main(String[] args) {

		for(int i=0; i< 20; i++) {
			new Thread() {
				public void run() {
					Logger l = LogFactory.getInstance("app" + Thread.currentThread().getId());
					l.log("Message is : " + Math.random());
					l.log("Message is : Harish");
				}
			}.start();		
		}
	}
}
