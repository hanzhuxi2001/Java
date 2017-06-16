package mutlThread;

public class MyThread04 extends Thread {
	static {
		System.out.println("静态块的打印：" + Thread.currentThread().getName());
	}

	public MyThread04() {
		System.out.println("构造方法的打印：" + Thread.currentThread().getName());
	}

	public void run() {
		System.out.println("run()方法的打印：" + Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		MyThread04 mt = new MyThread04();
		mt.start();
	}
}