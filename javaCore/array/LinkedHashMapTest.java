package javaCore.array;

import java.util.LinkedHashMap;

/**
 * 1、LinkedHashMap可以认为是HashMap+LinkedList，即它既使用HashMap操作数据结构，又使用LinkedList维护插入元素的先后顺序
 * 
 * 2、LinkedHashMap的基本实现思想就是----多态。可以说，理解多态，再去理解LinkedHashMap原理会事半功倍；反之也是，对于LinkedHashMap原理的学习，也可以促进和加深对于多态的理解。
 * 其中前面四个，也就是红色部分是从HashMap.Entry中继承过来的；后面两个，也就是蓝色部分是LinkedHashMap独有的。不要搞错了next和before、After，next是用于维护HashMap指定table位置上连接的Entry的顺序的，before、After是用于维护Entry插入的先后顺序的。
 * 
 * @author hd
 *
 *         LinkedHashMap的原理，除了HashMap的结构外，LinkedHashMap还维护了一份双向链表。这个双向链表和HashMap哈希桶内的单向链表完全无关，纯粹记录数据的插入顺序，每次新的数据除了按照HashMap的逻辑存入相应的哈希桶内的链表外，还会加到双向链表的尾部。
 * 
 *         此外LinkedHashMap还提供了一个布尔参数accessOrder，即访问顺序，默认false，LinkedHashMap
 *         双向链表保持常用的插入顺序，设置为true后，每次get或者put数据，都会将目标数据移动到双向链表的尾部。这样，head就是最近最少使用的数据。
 */
public class LinkedHashMapTest {
	public static void main(String[] args) {
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		linkedHashMap.put("111", "111");
		linkedHashMap.put("222", "222");
	}
}
