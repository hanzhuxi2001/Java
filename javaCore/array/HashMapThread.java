package javaCore.array;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 我们必须要知道，由于线程B已经执行完毕，因此根据Java内存模型（JMM），现在table里面所有的Entry都是最新的，也就是7的next是3，3的next是null。3放置到table[3]的位置上了，下面的步骤是：
 * 
 * 1、e=next，即e=7
 * 
 * 2、判断e不等于null，循环继续
 * 
 * 3、next=e.next，即next=7的next，也就是3
 * 
 * 4、放置7这个Entry
 * 
 * 所以，用图表示就是：
 * Thread1
 * []
 * [3]->[7]->[5]
 * Thread2
 * [null]
 * [5]
 * [null]
 * [7]->[3]
 * 
 * when T1 is trying to resize, and 3 is trying to go next.
 * 
 * T2 completed, and 7 next is 3, but on T1, 3 next is 7.
 *  
 *  java 8 seems is trying to avoid via the hash method, But i think it just trying to avoid,
 *  I believe not able to, just jave 8 is more optimizer than java7
 * @author hd
 *
 */
public class HashMapThread extends Thread {
	private static AtomicInteger ai = new AtomicInteger(0);
	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>(1);

	public void run() {
		while (ai.get() < 100000) {
			map.put(ai.get(), ai.get());
			ai.incrementAndGet();
		}
	}
/**
 * 如何解决

把一个线程非安全的集合作为全局共享的，本身就是一种错误的做法，并发下一定会产生错误。

所以，解决这个问题的办法很简单，有两种：

1、使用Collections.synchronizedMap(Mao<K,V> m)方法把HashMap变成一个线程安全的Map

2、使用Hashtable、ConcurrentHashMap这两个线程安全的Map

不过，既然选择了线程安全的办法，那么必然要在性能上付出一定的代价----毕竟这个世界上没有十全十美的事情，既要运行效率高、又要线程安全。


 * @param args
 */
	public static void main(String[] args) {
		HashMapThread hmt0 = new HashMapThread();
		HashMapThread hmt1 = new HashMapThread();
		HashMapThread hmt2 = new HashMapThread();
		HashMapThread hmt3 = new HashMapThread();
		HashMapThread hmt4 = new HashMapThread();
		hmt0.start();
		hmt1.start();
		hmt2.start();
		hmt3.start();
		hmt4.start();
	}
}