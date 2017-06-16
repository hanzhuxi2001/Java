package mutlThread;

import java.util.concurrent.CyclicBarrier;

/**
 * 从运行结果看，由于是同一个CyclicBarrier，Thread-0先运行到了await()的地方，等着；Thread-2接着运行到了await()的地方，还等着；Thread-1最后运行到了await()的地方，所有的线程都运行到了await()的地方，所以三个线程以及指定的Runnable"同时"运行后面的代码，可以看到，await()之后，四个线程运行的时间一模一样，都是1444650322313。
 * 
 * 从使用来看，可能有人觉得CyclicBarrier和CountDownLatch有点像，都是多个线程等待相互完成之后，再执行后面的代码。实际上，CountDownLatch和CyclicBarrier都是用于多个线程间的协调的，它们二者的几个差别是：
 * 
 * 1、CountDownLatch是在多个线程都进行了latch.countDown()后才会触发事件，唤醒await()在latch上的线程，而执行countDown()的线程，执行完countDown()后会继续自己线程的工作；CyclicBarrier是一个栅栏，用于同步所有调用await()方法的线程，并且等所有线程都到了await()方法时，这些线程才一起返回继续各自的工作
 * 
 * 2、另外CountDownLatch和CyclicBarrier的一个差别是，CountDownLatch不能循环使用，计数器减为0就减为0了，不能被重置，CyclicBarrier可以循环使用
 * 
 * 3、CountDownLatch可以唤起多条线程的任务，CyclicBarrier只能唤起一条线程的任务
 * 
 * 注意，因为使用CyclicBarrier的线程都会阻塞在await方法上，所以在线程池中使用CyclicBarrier时要特别小心，如果线程池的线程过少，那么就会发生死锁了
 * 
 * @author hd
 *
 */

public class CyclicBarrierThread extends Thread {
	private CyclicBarrier cb;
	private int sleepSecond;

	public CyclicBarrierThread(CyclicBarrier cb, int sleepSecond) {
		this.cb = cb;
		this.sleepSecond = sleepSecond;
	}

	public void run() {
		try {
			System.out.println(this.getName() + "运行了");
			Thread.sleep(sleepSecond * 1000);
			System.out.println(this.getName() + "准备等待了, 时间为" + System.currentTimeMillis());
			cb.await();
			System.out.println(this.getName() + "结束等待了, 时间为" + System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("CyclicBarrier的所有线程await()结束了，我运行了, 时间为" + System.currentTimeMillis());
			}
		};
		CyclicBarrier cb = new CyclicBarrier(3, runnable);
		CyclicBarrierThread cbt0 = new CyclicBarrierThread(cb, 3);
		CyclicBarrierThread cbt1 = new CyclicBarrierThread(cb, 6);
		CyclicBarrierThread cbt2 = new CyclicBarrierThread(cb, 9);
		cbt0.start();
		cbt1.start();
		cbt2.start();
	}

}