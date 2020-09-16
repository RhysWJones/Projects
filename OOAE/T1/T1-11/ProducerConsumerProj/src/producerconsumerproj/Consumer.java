package producerconsumerproj;

public class Consumer extends Thread
{
    private Buffer buffer;
    private int consumerNum;

    public Consumer(Buffer buffer, int consumerNum)
    {
        this.buffer = buffer;
        this.consumerNum = consumerNum;
    }

    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            try
            {
                buffer.getNext(consumerNum);
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                System.out.println("Thread interrupted.\n" + e);
            }
        }
    }

}
