package javaCore;

public class SingletonT {
	private static SingletonT instance = new SingletonT();

	private SingletonT() {
		System.out.println("default construct");
	}

	private void SingletonT() {
		System.out.println("void not the default construct  construct");
	}

	public static SingletonT getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		SingletonT s=getInstance();
	}
}
