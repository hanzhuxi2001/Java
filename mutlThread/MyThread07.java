package mutlThread;

public class MyThread07 extends Thread {
	//sleep(long millis)方法的作用是在指定的毫秒内让当前"正在执行的线程"休眠（暂停执行）。
	//这个"正在执行的线程"是关键，指的是Thread.currentThread()返回的线程。根据JDK API的说法，"该线程不丢失任何监视器的所属权"，
	//简单说就是sleep代码上下文如果被加锁了，锁依然在，但是CPU资源会让出给其他线程。看一下例子：
	public void run() {
		try {
			System.out.println("run threadName = " + this.getName() + " begin");
			Thread.sleep(2000);
			System.out.println("run threadName = " + this.getName() + " end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MyThread07 mt = new MyThread07();
		System.out.println("begin = " + System.currentTimeMillis());
		mt.start();
		System.out.println("end = " + System.currentTimeMillis());
	}

}