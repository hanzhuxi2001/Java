package mutlThread;

public class MyThread02 extends Thread {
	public void run() {
		try {
			for (int i = 0; i < 3; i++) {
				Thread.sleep((int) (Math.random() * 1000));
				System.out.println("runrun = " + Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// startThread();
		// runn();
		// isAlivee();
		// priority();
		// priorityHigh();
		// daemonThread();
		// interruptTest();
		joinTest();
	}

	// 意思是，join()方法会使调用join()方法的线程（也就是mt线程）所在的线程（也就是main线程）无限阻塞，
	// 直到调用join()方法的线程销毁为止，此例中main线程就会无限期阻塞直到mt的run()方法执行完毕。
	// join()方法的一个重点是要区分出和sleep()方法的区别。join(2000)也是可以的，表示调用join()方法所在的线程最多等待2000ms，两者的区别在于：
	// sleep(2000)不释放锁，join(2000)释放锁，因为join()方法内部使用的是wait()，因此会释放锁。
	// 看一下join(2000)的源码就知道了，join()其实和join(2000)一样，无非是join(0)而已：
	private static void joinTest() throws InterruptedException {
		MyThread36 mt = new MyThread36();
		mt.start();
		mt.join();
		System.out.println("我想当mt对象执行完毕之后我再执行，我做到了");
	}

	private static void interruptTest() throws InterruptedException {
		MyThread12 mt = new MyThread12();
		mt.start();
		Thread.sleep(2000);
		mt.interrupt();
	}

	private static void daemonThread() throws InterruptedException {
		MyThread11 mt = new MyThread11();
		mt.setDaemon(true);
		mt.start();
		Thread.sleep(5000);
		System.out.println("我离开thread对象再也不打印了，我停止了！");
	}

	private static void priorityHigh() {
		for (int i = 0; i < 5; i++) {
			MyThread10_0 mt0 = new MyThread10_0();
			mt0.setPriority(5);
			mt0.start();
			MyThread10_1 mt1 = new MyThread10_1();
			mt1.setPriority(4);
			mt1.start();
		}
	}

	private static void priority() {
		System.out.println("main thread begin, priority = " + Thread.currentThread().getPriority());
		System.out.println("main thread end, priority = " + Thread.currentThread().getPriority());
		MyThread09_1 thread = new MyThread09_1();
		thread.start();
	}

	private static void isAlivee() throws InterruptedException {
		MyThread06 mt = new MyThread06();
		System.out.println("begin == " + mt.isAlive());
		mt.start();
		Thread.sleep(100);
		System.out.println("end == " + mt.isAlive());
	}

	private static void startThread() {
		MyThread02 mt = new MyThread02();
		mt.start();

		try {
			for (int i = 0; i < 3; i++) {
				Thread.sleep((int) (Math.random() * 1000));
				System.out.println("run = " + Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		MyThread03 mt0 = new MyThread03();
		MyThread03 mt1 = new MyThread03();
		MyThread03 mt2 = new MyThread03();

		mt0.start();
		mt1.start();
		mt2.start();
	}

	public static void runn() {
		System.out.println("");

		System.out.println("this is run task");

		MyThread02 mt = new MyThread02();
		mt.run();

		try {
			for (int i = 0; i < 3; i++) {
				Thread.sleep((int) (Math.random() * 1000));
				System.out.println("run = " + Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyThread06 extends Thread {
	public void run() {
		System.out.println("run = " + this.isAlive());
	}
}

class MyThread09_0 extends Thread {
	public void run() {
		System.out.println("MyThread9_0 run priority = " + this.getPriority());
	}
}

class MyThread09_1 extends Thread {
	public void run() {
		System.out.println("MyThread9_1 run priority = " + this.getPriority());
		MyThread09_0 thread = new MyThread09_0();
		thread.start();
	}
}

class MyThread10_0 extends Thread {
	public void run() {
		long beginTime = System.currentTimeMillis();
		for (int j = 0; j < 100000; j++) {
		}
		long endTime = System.currentTimeMillis();
		System.out.println("◆◆◆◆◆ thread0 use time = " + (endTime - beginTime));
	}
}

class MyThread10_1 extends Thread {
	public void run() {
		long beginTime = System.currentTimeMillis();
		for (int j = 0; j < 100000; j++) {
		}
		long endTime = System.currentTimeMillis();
		System.out.println("◇◇◇◇◇ thread1 use time = " + (endTime - beginTime));
	}
}

class MyThread11 extends Thread {
	private int i = 0;

	public void run() {
		try {
			while (true) {
				i++;
				System.out.println("i = " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyThread12 extends Thread {
	public void run() {
		for (int i = 0; i < 500000; i++) {
			System.out.println("i = " + (i + 1));
		}
	}
}

class MyThread36 extends Thread {
	public void run() {
		try {
			int secondValue = (int) (Math.random() * 10000);
			System.out.println(secondValue);
			Thread.sleep(secondValue);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
