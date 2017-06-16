package javaCore.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Test01 {

	public static void main(String[] args) {
		Set<TreeSetRelated> set = new TreeSet<>(); // Java
													// 7的钻石语法(构造器后面的尖括号中不需要写类型)
		set.add(new TreeSetRelated("Hao LUO", 33));
		set.add(new TreeSetRelated("XJ WANG", 32));
		set.add(new TreeSetRelated("Bruce LEE", 60));
		set.add(new TreeSetRelated("Bob YANG", 22));

		for (TreeSetRelated stu : set) {
			System.out.println(stu);
		}
		// 输出结果:
		// Student [name=Bob YANG, age=22]
		// Student [name=XJ WANG, age=32]
		// Student [name=Hao LUO, age=33]
		// Student [name=Bruce LEE, age=60]
		List<TreeSetRelated> list = new ArrayList<>(); // Java
														// 7的钻石语法(构造器后面的尖括号中不需要写类型)
		list.add(new TreeSetRelated("Hao LUO", 33));
		list.add(new TreeSetRelated("XJ WANG", 32));
		list.add(new TreeSetRelated("Bruce LEE", 60));
		list.add(new TreeSetRelated("Bob YANG", 22));

		// 通过sort方法的第二个参数传入一个Comparator接口对象
		// 相当于是传入一个比较对象大小的算法到sort方法中
		// 由于Java中没有函数指针、仿函数、委托这样的概念
		// 因此要将一个算法传入一个方法中唯一的选择就是通过接口回调
		Collections.sort(list, new Comparator<TreeSetRelated>() {

			@Override
			public int compare(TreeSetRelated o1, TreeSetRelated o2) {
				return o1.getName().compareTo(o2.getName()); // 比较学生姓名
			}
		});

		for (TreeSetRelated stu : list) {
			System.out.println(stu);
		}
	}
}