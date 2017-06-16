package javaCore;

public class DeadLock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String resource1 = "Andy";
		final String resource2 = "Han";
		Thread t1 = new Thread() {
			public void run() {
				synchronized (resource1) {
					System.out.println("Thread 1: locked resource 1");

					try {
						Thread.sleep(100);
						System.out.println("Thread 1: Waiting for lock 2...");

					} catch (Exception e) {
					}

					synchronized (resource2) {
						System.out.println("Thread 1: Holding lock 1 & 2...");
					}
				}
			}

		};

		Thread t2 = new Thread() {
			public void run() {
				synchronized (resource2) {
					System.out.println("Thread2:lock resource2");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Thread 2: Waiting for lock 1...");

					synchronized (resource1) {
						System.out.println("Thread 2: Holding lock 1 & 2...");
					}
				}

			}

		};
		t1.start();
		t2.start();
	}
}
