package mutlThread;

public class ThreadDomain13 {
	private int num = 0;

	public synchronized void addNum(String userName) {
		try {
			if ("a".equals(userName)) {
				num = 100;
				System.out.println("a set over!");
				Thread.sleep(2000);
			} else {
				num = 200;
				System.out.println("b set over!");
			}
			System.out.println(userName + " num = " + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
/**
 * 这里有一个重要的概念。关键字synchronized取得的锁都是对象锁，而不是把一段代码或方法（函数）当作锁，
 * 哪个线程先执行带synchronized关键字的方法，哪个线程就持有该方法所属对象的锁，其他线程都只能呈等待状态。
 * 但是这有个前提：既然锁叫做对象锁，那么势必和对象相关，所以多个线程访问的必须是同一个对象。
 * @param args
 */
	public static void main(String[] args) {
		// ThreadDomain13 td = new ThreadDomain13();
		// MyThread13_0 mt0 = new MyThread13_0(td);
		// MyThread13_1 mt1 = new MyThread13_1(td);
		// mt0.start();
		// mt1.start();
		ThreadDomain13 td0 = new ThreadDomain13();
		ThreadDomain13 td1 = new ThreadDomain13();
		MyThread13_0 mt0 = new MyThread13_0(td0);
		MyThread13_1 mt1 = new MyThread13_1(td1);
		mt0.start();
		mt1.start();
	}
}