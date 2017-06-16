package mutlThread;

public class MyThread16 extends Thread {
	public void run() {
		ThreadDomain16 td = new ThreadDomain16();
		td.print1();
	}

	/**
	 * 关键字synchronized拥有锁重入的功能。
	 * 所谓锁重入的意思就是：当一个线程得到一个对象锁后，再次请求此对象锁时时可以再次得到该对象的锁的。看一个例子：
	 * 看到可以直接调用ThreadDomain16中的打印语句，这证明了对象可以再次获取自己的内部锁。
	 * 这种锁重入的机制，也支持在父子类继承的环境中。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread16 mt = new MyThread16();
		mt.start();
	}
}
