package com.webder.threads;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main thread");
		MyThread th = new MyThread("child 1");		
		MyThread th2 = new MyThread("Child 2");
		MyThread th3 = new MyThread("child 3");		
		MyThread th4 = new MyThread("Child 4");
		//Thread newThread = new Thread(th);

	/*	do {
			System.out.println(".");
			try {
				Thread.sleep(100);

			} catch (InterruptedException e) {
				System.out.println("Main thread interrupted");
				e.printStackTrace();
			}
			
			//If you want to wait for a thread to finish you use .join()
			//on the contrary, use .isAlive() to confirm that the thread is still running
		} while (th.thread.isAlive() || th2.thread.isAlive() || th3.thread.isAlive());
	*/
		try {
			
			/*th.thread.join(); //Wait until specified thread ends
			System.out.println("Child n1 joined");
			
			th2.thread.join();
			System.out.println("Child n2 joined");
			
			th3.thread.join();
			System.out.println("Child n3 joined");*/
			
			//Every thread starts with priority level 5
			th.thread.setPriority(Thread.MIN_PRIORITY);
			System.out.println("Child n1 priority is " + th.thread.getPriority());

			th2.thread.setPriority(Thread.NORM_PRIORITY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class MyThread implements Runnable{
	
	Thread thread; 

	String myThread;
	
	// Constructor
	public MyThread(String myThread) {
		this.myThread = myThread;

		thread = new Thread(this, myThread);
		thread.start();
		
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
