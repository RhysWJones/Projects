package producerconsumerproj;

public class Producer extends Thread
{

    private Buffer buffer;
    private int producerNum;

    public Producer(Buffer buffer, int producerNum)
    {
        this.buffer = buffer;
        this.producerNum = producerNum;
    }

    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            try
            {
                buffer.add((i + 1), producerNum);
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                System.out.println("Thread interrupted.\n" + e);
            }
        }
    }

}
