package mutlThread;

public class MyThread08 extends Thread {
	public void run() {
		long beginTime = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < 50000000; i++) {
			Thread.yield();
			count = count + i + 1;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("用时：" + (endTime - beginTime) + "毫秒！");
	}

	public static void main(String[] args) {
		interruptTest();
		//MyThread08 mt = new MyThread08();
		//mt.start();
	}

	private static void interruptTest() {
		Thread.currentThread().interrupt();
	    System.out.println("是否停止1？" + Thread.interrupted());
	    System.out.println("是否停止2？" + Thread.interrupted());
	    System.out.println("end!");
	}
}