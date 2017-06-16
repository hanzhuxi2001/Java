package mutlThread;
public class ThreadDomain16
{
    public synchronized void print1()
    {
        System.out.println("ThreadDomain16.print1()");
        print2();
    }
    
    public synchronized void print2()
    {
        System.out.println("ThreadDomain16.print2()");
        print3();
    }
    
    public synchronized void print3()
    {
        System.out.println("ThreadDomain16.print3()");
    }
}