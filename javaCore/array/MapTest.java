package javaCore.array;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

/**
 * 红黑树是为了维护二叉查找树的平衡而产生的一种树，根据维基百科的定义，红黑树有五个特性，但我觉得讲得不太易懂，我自己总结一下，红黑树的特性大致有三个（换句话说，插入、删除节点后整个红黑树也必须满足下面的三个性质，如果不满足则必须进行旋转）：
 * 
 * 根节点与叶节点都是黑色节点，其中叶节点为Null节点 每个红色节点的两个子节点都是黑色节点，换句话说就是不能有连续两个红色节点
 * 从根节点到所有叶子节点上的黑色节点数量是相同的 上述的性质约束了红黑树的关键：从根到叶子的最长可能路径不多于最短可能路径的两倍长。得到这个结论的理由是：
 * 
 * 红黑树中最短的可能路径是全部为黑色节点的路径 红黑树中最长的可能路径是红黑相间的路径
 * 此时（2）正好是（1）的两倍长。结果就是这个树大致上是平衡的，因为比如插入、删除和查找某个值这样的操作最坏情况都要求与树的高度成比例，这个高度的理论上限允许红黑树在最坏情况下都是高效的，而不同于普通的二叉查找树，最终保证了红黑树能够以O(log2
 * n) 的时间复杂度进行搜索、插入、删除。
 * 
 * @author hd
 *
 */
public class MapTest {

	@Test
	public void testTreeMap() {
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		treeMap.put(10, "10");
		treeMap.put(85, "85");
		treeMap.put(15, "15");
		treeMap.put(70, "70");
		treeMap.put(20, "20");
		treeMap.put(60, "60");
		treeMap.put(30, "30");
		treeMap.put(50, "50");

		for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

	static final class Entry<K, V> implements Map.Entry<K, V> {
		private static final boolean BLACK = false;
		K key;
		V value;
		Entry<K, V> left = null;
		Entry<K, V> right = null;
		Entry<K, V> parent;
		// 由于颜色只有红色和黑色两种，因此颜色可以使用布尔类型（boolean）来表示，黑色表示为true，红色为false。

		boolean color = BLACK;

		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public V setValue(V value) {
			// TODO Auto-generated method stub
			return null;
		}
		/**
		 * 从这段代码，先总结一下TreeMap添加数据的几个步骤：
		 * 
		 * 获取根节点，根节点为空，产生一个根节点，将其着色为黑色，退出余下流程
		 * 获取比较器，如果传入的Comparator接口不为空，使用传入的Comparator接口实现类进行比较；如果传入的Comparator接口为空，将Key强转为Comparable接口进行比较
		 * 从根节点开始逐一依照规定的排序算法进行比较，取比较值cmp，如果cmp=0，表示插入的Key已存在；如果cmp>0，取当前节点的右子节点；如果cmp<0，取当前节点的左子节点
		 * 排除插入的Key已存在的情况，第（3）步的比较一直比较到当前节点t的左子节点或右子节点为null，此时t就是我们寻找到的节点，cmp>0则准备往t的右子节点插入新节点，cmp<0则准备往t的左子节点插入新节点
		 * new出一个新节点，默认为黑色，根据cmp的值向t的左边或者右边进行插入
		 * 插入之后进行修复，包括左旋、右旋、重新着色这些操作，让树保持平衡性
		 * 第1~第5步都没有什么问题，红黑树最核心的应当是第6步插入数据之后进行的修复工作，对应的Java代码是TreeMap中的fixAfterInsertion方法，下面看一下put每个数据之后TreeMap都做了什么操作，借此来理清TreeMap的实现原理。
		 */
	}
}