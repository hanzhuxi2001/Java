package mutlThread;

import java.util.concurrent.Semaphore;

/**
 * 前10行为一部分，运行的线程是1 2 0 3 4，看到时间差也都是代码约定的2秒；后10行为一部分，运行的线程是9 7 6 5
 * 8，时间差也都是约定的2秒，这就体现出了Semaphore的作用了。
 * 
 * 这种通过Semaphore控制并发并发数的方式和通过控制线程数来控制并发数的方式相比，粒度更小，因为Semaphore可以通过acquire方法和release方法来控制代码块的并发数。
 * 
 * 最后注意两点：
 * 
 * 1、Semaphore可以指定公平锁还是非公平锁
 * 
 * 2、acquire方法和release方法是可以有参数的，表示获取/返还的信号量个数
 * 
 * @author hd
 *
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		final Semaphore semaphore = new Semaphore(5);

		Runnable runnable = new Runnable() {
			public void run() {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName() + "获得了信号量,时间为" + System.currentTimeMillis());
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName() + "释放了信号量,时间为" + System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaphore.release();
				}
			}
		};

		Thread[] threads = new Thread[10];
		for (int i = 0; i < threads.length; i++)
			threads[i] = new Thread(runnable);
		for (int i = 0; i < threads.length; i++)
			threads[i].start();
	}
}
