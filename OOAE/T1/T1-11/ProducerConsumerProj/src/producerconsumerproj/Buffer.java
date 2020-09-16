package producerconsumerproj;

import java.util.*;

public class Buffer
{

    private Queue<Integer> theData;
    private final int MAX;  // maximum size of the buffer
    private int numItems;

    public Buffer(int m)
    {
        MAX = m;
        theData = new LinkedList<Integer>();
        numItems = 0;
    }

    public synchronized int getNext(int consumerNo) throws InterruptedException
    {
        while (theData.size() == 0)
        {
            System.out.println("Consumer " + consumerNo + " attempting to remove from empty buffer - wait");
            wait();
        }
        int data = theData.remove();
        --numItems;
        System.out.println("Consumer " + consumerNo + " retrieved " + data + " from buffer: " + theData.toString());
        notifyAll();
        return data;
    }

    public synchronized void add(int data, int producerNo) throws InterruptedException
    {
        while (numItems == MAX)
        {
            System.out.println("Producer " + producerNo + " attempting to add to full buffer - wait");
            wait();
        }
        theData.add(data);
        System.out.println("Producer " + producerNo + " added " + data + " to buffer:" + theData.toString());
        ++numItems;
        notifyAll();
    }
}
