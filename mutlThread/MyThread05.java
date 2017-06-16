package mutlThread;

public class MyThread05 extends Thread {
	public MyThread05() {
		System.out.println("MyThread5----->Begin");
		System.out.println("Thread.currentThread().getName()----->" + Thread.currentThread().getName());
		System.out.println("this.getName()----->" + this.getName());
		System.out.println("MyThread5----->end");
	}

	public void run() {
		System.out.println("run----->Begin");
		System.out.println("Thread.currentThread().getName()----->" + Thread.currentThread().getName());
		System.out.println("this.getName()----->" + this.getName());
		System.out.println("run----->end");
	}

	public static void main(String[] args) {
		MyThread05 mt5 = new MyThread05();
		mt5.start();
	}
}