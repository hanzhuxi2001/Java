package javaCore.array;

import java.util.LinkedList;
import java.util.List;

/**
 * private Entry<E> addBefore(E e, Entry<E> entry) { Entry<E> newEntry = new
 * Entry<E>(e, entry, entry.previous); newEntry.previous.next = newEntry;
 * newEntry.next.previous = newEntry; size++; modCount++; return newEntry; }
 * 第2行new了一个Entry出来，可能不太好理解，根据Entry的构造函数，我把这句话"翻译"一下，可能就好理解了：
 * 
 * 1、newEntry.element = e;
 * 
 * 2、newEntry.next = header.next;
 * 
 * 3、newEntry.previous = header.previous;
 * 
 * header.next和header.previous上图中已经看到了，都是0x00000000，那么假设new出来的这个Entry的地址是0x00000001，继续画图表示：
 * 
 * 
 * 一共五步，每一步的操作步骤都用数字表示出来了：
 * 
 * 1、新的entry的element赋值为111;
 * 
 * 2、新的entry的next是header的next，header的next是0x00000000，所以新的entry的next即0x00000000;
 * 
 * 3、新的entry的previous是header的previous，header的previous是0x00000000，所以新的entry的next即0x00000000;
 * 
 * 4、"newEntry.previous.next =
 * newEntry"，首先是newEntry的previous，由于newEntry的previous为0x00000000，所以newEntry.previous表示的是header，header的next为newEntry，即header的next为0x00000001;
 * 
 * 5、"newEntry.next.previous = newEntry"，和4一样，把header的previous设置为0x00000001;
 * 
 * 为什么要这么做？还记得双向链表的两个特点吗，一是任意节点都可以向前和向后寻址，二是整个链表头的previous表示的是链表的尾Entry，链表尾的next表示的是链表的头Entry。现在链表头就是0x00000000这个Entry，链表尾就是0x00000001，可以自己看图观察、思考一下是否符合这两个条件。
 * 
 * 最后看一下add了一个字符串"222"做了什么，假设新new出来的Entry的地址是0x00000002，画图表示：
 * 
 * @author hd
 *
 */
public class LinkListTest {
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		list.add("111");
		list.add("222");
	}
	/**
	 * 1、顺序插入速度ArrayList会比较快，因为ArrayList是基于数组实现的，数组是事先new好的，只要往指定位置塞一个数据就好了；LinkedList则不同，每次顺序插入的时候LinkedList将new一个对象出来，如果对象比较大，那么new的时间势必会长一点，再加上一些引用赋值的操作，所以顺序插入LinkedList必然慢于ArrayList
	 * 
	 * 2、基于上一点，因为LinkedList里面不仅维护了待插入的元素，还维护了Entry的前置Entry和后继Entry，如果一个LinkedList中的Entry非常多，那么LinkedList将比ArrayList更耗费一些内存
	 * 
	 * 3、数据遍历的速度，看最后一部分，这里就不细讲了，结论是：使用各自遍历效率最高的方式，ArrayList的遍历效率会比LinkedList的遍历效率高一些
	 * 
	 * 4、有些说法认为LinkedList做插入和删除更快，这种说法其实是不准确的：
	 * 
	 * （1）LinkedList做插入、删除的时候，慢在寻址，快在只需要改变前后Entry的引用地址
	 * 
	 * （2）ArrayList做插入、删除的时候，慢在数组元素的批量copy，快在寻址
	 * 
	 * 所以，如果待插入、删除的元素是在数据结构的前半段尤其是非常靠前的位置的时候，LinkedList的效率将大大快过ArrayList，因为ArrayList将批量copy大量的元素；越往后，对于LinkedList来说，因为它是双向链表，所以在第2个元素后面插入一个数据和在倒数第2个元素后面插入一个元素在效率上基本没有差别，但是ArrayList由于要批量copy的元素越来越少，操作速度必然追上乃至超过LinkedList。
	 */
}
