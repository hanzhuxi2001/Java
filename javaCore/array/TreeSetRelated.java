package javaCore.array;

public class TreeSetRelated implements Comparable {
	private String name; // 姓名
	private int age; // 年龄

	public TreeSetRelated(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * 获取学生姓名
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	//
	// @Override
	// public int compareTo(TreeSetRelated o) {
	// return this.age - o.age; // 比较年龄(年龄的升序)
	// }

	public int compareTo(TreeSetRelated o) {
		return this.age - o.age; // 比较年龄(年龄的升序)
	}

	@Override
	public int compareTo(Object o) {
		TreeSetRelated a = (TreeSetRelated) o;
		return this.age - a.age; // 比较年龄(年龄的升序)
	}

}
