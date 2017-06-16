package javaCore.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ArrayList的优缺点
 * 
 * 从上面的几个过程总结一下ArrayList的优缺点。ArrayList的优点如下：
 * 
 * 1、ArrayList底层以数组实现，是一种随机访问模式，再加上它实现了RandomAccess接口，因此查找也就是get的时候非常快
 * 
 * 2、ArrayList在顺序添加一个元素的时候非常方便，只是往数组里面添加了一个元素而已
 * 
 * 不过ArrayList的缺点也十分明显：
 * 
 * 1、删除元素的时候，涉及到一次元素复制，如果要复制的元素很多，那么就会比较耗费性能
 * 
 * 2、插入元素的时候，涉及到一次元素复制，如果要复制的元素很多，那么就会比较耗费性能
 * 
 * 因此，ArrayList比较适合顺序添加、随机访问的场景。
 * 
 * @author hd
 *
 */
public class ArrayListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("111");
		list.add("222");
		list.add("333");
		list.add("444");
		list.add("555");
		list.add("666");
		list.add("777");
		list.add("888");
		list.add(2, "000");
		System.out.println(list);
		/**
		 * 另一个方法就是Vector，它是ArrayList的线程安全版本，其实现90%和ArrayList都完全一样，区别在于：
		 * 
		 * 1、Vector是线程安全的，ArrayList是线程非安全的
		 * 
		 * 2、Vector可以指定增长因子，如果该增长因子指定了， 
		 * 那么扩容的时候会每次新的数组大小会在原数组的大小基础上加上增长因子；
		 * 如果不指定增长因子，那么就给原数组大小 *2，源代码是这样的：
		 */
		List<String> synchronizedList = Collections.synchronizedList(list);
		synchronizedList.add("aaa");
		synchronizedList.add("bbb");
		for (int i = 0; i < synchronizedList.size(); i++) {
			System.out.println(synchronizedList.get(i));
		}
		/**
		 * Vector, the loadfact is 2*default load 10,can specify the load factor
		 * Capacity Increment
		 */
	}
}
