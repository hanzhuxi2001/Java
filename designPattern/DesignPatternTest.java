package designPattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class DesignPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Test
	public void testExecutors() {
		ExecutorService es1 = Executors.newCachedThreadPool();
		ExecutorService es2 = Executors.newFixedThreadPool(10);
		ExecutorService es3 = Executors.newSingleThreadExecutor();
		System.out.println(es1);
		System.out.println(es2);
		System.out.println(es3);
	}
}
