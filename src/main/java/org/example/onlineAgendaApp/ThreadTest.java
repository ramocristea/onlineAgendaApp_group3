package org.example.onlineAgendaApp;

import java.util.concurrent.TimeUnit;

public class ThreadTest {
	
	public static void main(String[] args) {
		System.out.println("Before thread");
		
		Thread thread = new Thread(new Runnable() {
			
			public void run() {
//				while(1==1) {
					System.out.println("In thread");
					try {
						TimeUnit.SECONDS.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
//				}
				
			}
		});
		thread.start();
		
		System.out.println("After thread");
		
	}

}
