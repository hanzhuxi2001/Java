package mutlThread;

public class MyThread19_1 extends Thread {
	private ThreadDomain19 td;

	public MyThread19_1(ThreadDomain19 td) {
		this.td = td;
	}

	public void run() {
		td.serviceMethodB();
	}
//个线程持有"对象监视器"为同一个对象的前提下，同一时间只能有一个线程可以执行synchronized(非this对象x)代码块中的代码。
	public static void main(String[] args) {
		ThreadDomain19 td = new ThreadDomain19();
		MyThread19_0 mt0 = new MyThread19_0(td);
		MyThread19_1 mt1 = new MyThread19_1(td);
		mt0.start();
		mt1.start();
	}
}