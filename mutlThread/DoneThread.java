package mutlThread;

import java.util.concurrent.CountDownLatch;

/**
 * 效果十分明显，解释一下：
 * 
 * 1、启动2个线程DoneThread线程等待3个WorkThread全部执行完
 * 
 * 2、3个WorkThread全部执行完，最后执行完的WorkThread3执行了秒符合预期
 * 
 * 3、后三句从时间上看几乎同时出现，说明CountDownLatch设置为3，WorkThread3执行完，两个wait的线程马上就执行后面的代码了
 * 
 * 这相当于是一种进化版本的等待/通知机制，它可以的实现的是多个工作线程完成任务后通知多个等待线程开始工作，之前的都是一个工作线程完成任务通知一个等待线程或者一个工作线程完成任务通知所有等待线程。
 * 
 * CountDownLatch其实是很有用的，特别适合这种将一个问题分割成N个部分的场景，所有子部分完成后，通知别的一个/几个线程开始工作。比如我要统计C、D、E、F盘的文件，可以开4个线程，分别统计C、D、E、F盘的文件，统计完成把文件信息汇总到另一个/几个线程中进行处理
 * 
 * @author hd
 *
 */
public class DoneThread extends Thread {
	private CountDownLatch cdl;

	public DoneThread(String name, CountDownLatch cdl) {
		super(name);
		this.cdl = cdl;
	}

	public void run() {
		try {
			System.out.println(this.getName() + "要等待了, 时间为" + System.currentTimeMillis());
			cdl.await();
			System.out.println(this.getName() + "等待完了, 时间为" + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		CountDownLatch cdl = new CountDownLatch(2);
		DoneThread dt0 = new DoneThread("DoneThread1", cdl);
		DoneThread dt1 = new DoneThread("DoneThread2", cdl);
		dt0.start();
		dt1.start();
		WorkThread wt0 = new WorkThread("WorkThread1", cdl, 2);
		WorkThread wt1 = new WorkThread("WorkThread2", cdl, 3);
		WorkThread wt2 = new WorkThread("WorkThread3", cdl, 4);
		WorkThread wt3 = new WorkThread("WorkThread4", cdl, 5);
		wt0.start();
		wt1.start();
		wt2.start();
		wt3.start();

	}
}