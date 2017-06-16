package mutlThread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTask extends TimerTask
{
    public void run()
    {
        System.out.println("运行了！时间为：" + new Date());
    }
    public static void main(String[] args) throws Exception
    {
        MyTask task = new MyTask();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2015-10-6 18:00:00";
        Timer timer = new Timer();
        Date dateRef = sdf.parse(dateString);
        System.out.println("字符串时间：" + dateRef.toLocaleString() + " 当前时间：" + new Date().toLocaleString());
        timer.schedule(task, dateRef, 4000);
    }
}
    
