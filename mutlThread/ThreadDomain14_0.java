package mutlThread;
public class ThreadDomain14_0
{
    public synchronized void methodA()
    {
        try
        {
            System.out.println("Begin methodA, threadName = " + 
                    Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("End methodA, threadName = " + 
                    Thread.currentThread().getName() + ", end Time = " + 
                    System.currentTimeMillis());
        } 
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
    public void methodB()
    {
        try
        {
            System.out.println("Begin methodB, threadName = " + 
                    Thread.currentThread().getName() + ", begin time = " + 
                    System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("End methodB, threadName = " + 
                    Thread.currentThread().getName());
        } 
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}