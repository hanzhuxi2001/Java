package designPattern;

public class ObserverTest {
	public static void main(String[] args) {
		/** 创建主题角色 */
		ConcreteSubject subject = new ConcreteSubject();

		/** 创建观察者对象 */
		Observer observer = new ConcreteObserver();

		/** 将观察者注册到主题对象上 */
		subject.attch(observer);

		/** 改变主题对象的状态 */
		subject.change("new state");
	}
}
