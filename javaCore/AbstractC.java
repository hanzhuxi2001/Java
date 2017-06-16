package javaCore;

public abstract class AbstractC implements InterfaceA, InterfaceB {
	public void A1() {
	} // 我实现了InterfaceA的A1()方法

	public void B2() {
	} // 我实现了InterfaceB的B2()方法

	abstract void C(); // 我自己定义了一个抽象方法
}