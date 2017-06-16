package mutlThread;

public class MyThread28 extends Thread {
	// volatile的作用就是这样，被volatile修饰的变量，保证了每次读取到的都是最新的那个值。
	// 线程安全围绕的是可见性和原子性这两个特性展开的，volatile解决的是变量在多个线程之间的可见性，但是无法保证原子性。

	private volatile boolean isRunning = true;

	public boolean isRunning() {
		return isRunning;
	}

	// can also put this method as synchronized
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public void run() {
		System.out.println("进入run了");
		while (isRunning() == true) {
		}
		System.out.println("线程被停止了");
	}

	public static void main(String[] args) {
		try {
			MyThread28 mt = new MyThread28();
			mt.start();
			Thread.sleep(1000);
			mt.setRunning(false);
			System.out.println("已赋值为false");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}