package javaCore.array;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 把ArrayList换成LinkedList，main函数的代码就不贴了，运行结果为：
 * 
 * 可能有人觉得，这两个线程都是线程非安全的类，所以不行。其实这个问题和线程安不安全没有关系，换成Vector看一下运行结果：
 * 
 * Vector虽然是线程安全的，但是只是一种相对的线程安全而不是绝对的线程安全，它只能够保证增、删、改、查的单个操作一定是原子的，
 * 不会被打断，但是如果组合起来用，并不能保证线程安全性。比如就像上面的线程1在遍历一个Vector中的元素、线程2在删除一个Vector中的元素一样，势必产生并发修改异常，也就是fail-fast。
 * 
 * 
 * @author hd synchronized (list) {} can resolve the problem, but trying with
 *         the collection list.
 */
public class CopyOnWriteArrayListTest {
	public static void main(String[] args) throws InterruptedException {
		List<Integer> list = new CopyOnWriteArrayList<Integer>();
		//List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10000; i++) {
			list.add(i);
		}

		T1 t1 = new T1(list);
		T2 t2 = new T2(list);
		t1.start();
		t2.start();

	}
}

class T1 extends Thread {
	private List<Integer> list;

	public T1(List<Integer> list) {
		this.list = list;
	}

	public void run() {
		for (Integer i : list) {
		}

	}
}

class T2 extends Thread {
	private List<Integer> list;

	public T2(List<Integer> list) {
		this.list = list;
	}

	public void run() {
		for (int i = 0; i < list.size(); i++) {

			list.remove(i);
			// System.out.println(i);
			// System.out.println("list size:" + list.size());

		}

	}
}