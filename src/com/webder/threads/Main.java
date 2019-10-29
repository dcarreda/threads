package com.webder.threads;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main thread");
		MyThread th = new MyThread("child 1");		
		
		Thread newThread = new Thread(th);
		newThread.start();
		System.out.println("Main thread 2");

	}

}

class MyThread implements Runnable{

	String myThread;
	

	public MyThread(String myThread) {
		this.myThread = myThread;
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println( myThread + "Starting");
		for(int i =0; i<10; i++) {
			try {
				Thread.sleep(400);
				System.out.println("in " + myThread + " count is " 
						+ i);

			} catch (InterruptedException e) {
				System.out.println( myThread + "interrupted");
				e.printStackTrace();
			}
		}
		System.out.println( myThread + " terminated");

	}
	
}
