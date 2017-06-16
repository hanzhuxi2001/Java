package javaCore.array;

/**
 * 之前的List，讲了ArrayList、LinkedList，最后讲到了CopyOnWriteArrayList，就前两者而言，反映的是两种思想：
 * 
 * （1）ArrayList以数组形式实现，顺序插入、查找快，插入、删除较慢
 * 
 * （2）LinkedList以链表形式实现，顺序插入、查找较慢，插入、删除方便
 * 
 * 那么是否有一种数据结构能够结合上面两种的优点呢？有，答案就是HashMap。
 * 
 * HashMap是一种非常常见、方便和有用的集合，是一种键值对（K-V）形式的存储结构，下面将还是用图示的方式解读HashMap的实现原理，
 * 
 * 
 * @author hd
 *
 *         个人理解 HashMap 底层是个数组，因为数组有插入，特别是删除，数度慢的缺陷，因为腰复制数组。
 *         所以在每个bucket里面，hashcode相同的话，用linkelist单链表解决，这样删除可以用到linklist的特性。
 *         当然linkedlist是双向链表，这样查询访问，删除都不糊慢了。O（1+a）；
 * 
 */
public class HashMapTest {
	/**
	 * HashMap和Hashtable的区别
	 * 
	 * HashMap和Hashtable是一组相似的键值对集合，它们的区别也是面试常被问的问题之一，我这里简单总结一下HashMap和Hashtable的区别：
	 * 
	 * 1、Hashtable是线程安全的，Hashtable所有对外提供的方法都使用了synchronized，也就是同步，而HashMap则是线程非安全的
	 * 
	 * 2、Hashtable不允许空的value，空的value将导致空指针异常，而HashMap则无所谓，没有这方面的限制
	 * 
	 * 3、上面两个缺点是最主要的区别，另外一个区别无关紧要，我只是提一下，就是两个的rehash算法不同，Hashtable的是：
	 */
	int hashSeed = (int) Math.random();

	private int hash(Object k) {
		// hashSeed will be zero if alternative hashing is disabled.
		return hashSeed ^ k.hashCode();
	}

	static int hash(int h) {
		// This function ensures that hashCodes that differ only by
		// constant multiples at each bit position have a bounded
		// number of collisions (approximately 8 at default load factor).
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}
}
