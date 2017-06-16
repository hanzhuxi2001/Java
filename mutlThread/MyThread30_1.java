package mutlThread;

/**
 * wait()方法可以使调用该线程的方法释放共享资源的锁，然后从运行状态退出，进入等待队列，直到再次被唤醒。
 * 
 * notify()方法可以随机唤醒等待队列中等待同一共享资源的一个线程，并使得该线程退出等待状态，进入可运行状态
 * 
 * notifyAll()方法可以使所有正在等待队列中等待同一共享资源的全部线程从等待状态退出，进入可运行状态
 * 
 * 最后，如果wait()方法和notify()/notifyAll()方法不在同步方法/同步代码块中被调用，那么虚拟机会抛出java.lang.IllegalMonitorStateException，注意一下。
 * 
 * @author hd
 *
 */
public class MyThread30_1 extends Thread {
	private Object lock;

	public MyThread30_1(Object lock) {
		this.lock = lock;
	}

	public void run() {
		synchronized (lock) {
			System.out.println("开始------notify time = " + System.currentTimeMillis());
			lock.notify();
			System.out.println("结束------notify time = " + System.currentTimeMillis());
		}
	}

	public static void main(String[] args) throws Exception {
		Object lock = new Object();
		MyThread30_0 mt0 = new MyThread30_0(lock);
		mt0.start();
		Thread.sleep(3000);
		MyThread30_1 mt1 = new MyThread30_1(lock);
		mt1.start();
	}

}