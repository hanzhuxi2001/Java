package mutlThread;
public class MyThread25_2 extends Thread
{
    private ThreadDomain25 td;
    
    public MyThread25_2(ThreadDomain25 td)
    {
        this.td = td;
    }
    
    public void run()
    {
        td.printC();
    }
   // 从运行结果来，对printC()方法的调用和对printA()方法、printB()方法的调用时异步的，这说明了静态同步方法和非静态同步方法持有的是不同的锁，前者是类锁，后者是对象锁。
//所谓类锁，举个再具体的例子。假如一个类中有一个静态同步方法A，new出了两个类的实例B和实例C，线程D持有实例B，线程E持有实例C，只要线程D调用了A方法，那么线程E调用A方法必须等待线程D执行完A方法，尽管两个线程持有的是不同的对象。

    public static void main(String[] args)
    {
        ThreadDomain25 td = new ThreadDomain25();
		MyThread25_0 mt0 = new MyThread25_0();
        MyThread25_1 mt1 = new MyThread25_1();
        MyThread25_2 mt2 = new MyThread25_2(td);
        mt0.start();
        mt1.start();
        mt2.start();
    }
}