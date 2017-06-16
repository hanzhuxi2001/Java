package mutlThread;

public class MyThread00 extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "在运行!");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyThread00 mt0 = new MyThread00();
		mt0.start();
		//Exception in thread "main" java.lang.IllegalThreadStateException
		mt0.start();

		for (int i = 0; i < 5; i++) {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + "在运行！");
		}
	}
}