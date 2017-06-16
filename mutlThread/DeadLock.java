package mutlThread;

/**
 * 避免死锁的方式
 * 
 * 既然可能产生死锁，那么接下来，讲一下如何避免死锁。
 * 
 * 1、让程序每次至多只能获得一个锁。当然，在多线程环境下，这种情况通常并不现实
 * 
 * 2、设计时考虑清楚锁的顺序，尽量减少嵌在的加锁交互数量
 * 
 * 3、既然死锁的产生是两个线程无限等待对方持有的锁，那么只要等待时间有个上限不就好了。
 * 当然synchronized不具备这个功能，但是我们可以使用Lock类中的tryLock方法去尝试获取锁，
 * 这个方法可以指定一个超时时限，在等待超过该时限之后变回返回一个失败信息
 * 
 * @author hd
 *
 */
public class DeadLock {
	private final Object left = new Object();
	private final Object right = new Object();

	public void leftRight() throws Exception {
		synchronized (left) {
			Thread.sleep(2000);
			synchronized (right) {
				System.out.println("leftRight end!");
			}
		}
	}

	public void rightLeft() throws Exception {
		synchronized (right) {
			Thread.sleep(2000);
			synchronized (left) {
				System.out.println("rightLeft end!");
			}
		}
	}

	public static void main(String[] args) {
		DeadLock dl = new DeadLock();
		Thread0 t0 = new Thread0(dl);
		Thread1 t1 = new Thread1(dl);
		t0.start();
		t1.start();

	}
}