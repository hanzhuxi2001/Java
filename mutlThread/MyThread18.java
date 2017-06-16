package mutlThread;

public class MyThread18 extends Thread {
	private ThreadDomain18 td;

	public MyThread18(ThreadDomain18 td) {
		this.td = td;
	}

	public void run() {
		try {
			td.doLongTimeTask();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 这个实验可以得出以下两个结论：
	 * 
	 * 1、当A线程访问对象的synchronized代码块的时候，B线程依然可以访问对象方法中其余非synchronized块的部分，第一部分的执行结果证明了这一点
	 * 
	 * 2、当A线程进入对象的synchronized代码块的时候，B线程如果要访问这段synchronized块，那么访问将会被阻塞，第二部分的执行结果证明了这一点
	 * 
	 * 所以，从执行效率的角度考虑，有时候我们未必要把整个方法都加上synchronized，而是可以采取synchronized块的方式，对会引起线程安全问题的那一部分代码进行synchronized就可以了。
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadDomain18 td = new ThreadDomain18();
		MyThread18 mt0 = new MyThread18(td);
		MyThread18 mt1 = new MyThread18(td);
		mt0.start();
		mt1.start();
	}

}