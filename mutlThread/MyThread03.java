package mutlThread;
public class MyThread03 extends Thread
{
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
    }
}