package usingthreadsproj;

import java.util.concurrent.ThreadLocalRandom;

public class Message extends Thread
{

    private String msg = "";
    private int num = 0;

    public Message(String msg, int num)
    {
        this.msg = msg;
        this.num = num;
    }

    public void run()
    {
        for (int i = 0; i < num; i++)
        {
            System.out.println(msg + " " + i);
            try
            {
//                Thread.sleep(1000);
                Thread.sleep(ThreadLocalRandom.current().nextLong(5000));
            }
            catch (InterruptedException e)
            {
                System.out.println("Thread interrupted: " + e);
            }
        }
    }

}
