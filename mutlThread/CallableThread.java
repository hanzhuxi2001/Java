package mutlThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 使用Callable、Future和FutureTask的好处
 * 
 * 上面演示了两个例子，其实反映的是现实中一种情况，把上面的例子稍微扩展一下就是：
 * 
 * 有一个method()方法，方法中执行方法A返回一个数据要10秒钟，A方法后面的代码一共要执行20秒钟，但是这20秒的代码中有10秒的方法并不依赖方法A的执行结果，有10秒钟的代码依赖方法A的执行结果。此时若采用同步的方式，那么势必要先等待10秒钟，等待方法A执行完毕，返回数据，再执行后面20秒的代码。
 * 
 * 不得不说这是一种低效率的做法。有了Callable、Future和FutureTask，那么：
 * 
 * 1、先把A方法的内容放到Callable实现类的call()方法中
 * 
 * 2、method()方法中，Callable实现类传入Executor的submit方法中
 * 
 * 3、执行后面方法中10秒不依赖方法A运行结果的代码
 * 
 * 4、获取方法A的运行结果，执行后面方法中10秒依赖方法A运行结果的代码
 * 
 * 这样代码执行效率一下子就提高了，程序不必卡在A方法处。
 * 
 * 当然，也可以不用Callable，采用实现Runnable的方式，run()方法执行完了想个办法给method()方法中的某个变量V赋个值就好了。但是我上一篇文章开头就说了，之所以要用多线程组件，就是因为JDK帮我们很好地实现好了代码细节，让开发者更多可以关注业务层的逻辑。如果使用Runnable的方式，那么我们自己就要考虑很多细节，比如Runnable实现类的run()方法执行完毕给V赋值是否线程安全、10秒后如果A方法没有执行完导致V还没有值怎么办，何况JDK还给用户提供了取消任务、判断任务是否存在等方法。既然JDK已经帮我们考虑并实现这些细节了，在没有有说服力的理由的情况下，我们为什么还要自己写run()方法的实现呢？
 * 
 * @author hd
 *
 */
public class CallableThread implements Callable<String> {
	public String call() throws Exception {
		System.out.println("进入CallableThread的call()方法, 开始睡觉, 睡觉时间为" + System.currentTimeMillis());
		Thread.sleep(10000);
		return "123";
	}

	public static void main(String[] args) throws Exception {
		ExecutorService es = Executors.newCachedThreadPool();
		CallableThread ct = new CallableThread();
		FutureTask<String> f = new FutureTask<String>(ct);
		es.submit(f);
		// Future<String> f = es.submit(ct);
		// es.shutdown();

		Thread.sleep(5000);
		System.out.println("主线程等待5秒, 当前时间为" + System.currentTimeMillis());

		String str = f.get();
		System.out.println("Future已拿到数据, str = " + str + ", 当前时间为" + System.currentTimeMillis());
	}

}