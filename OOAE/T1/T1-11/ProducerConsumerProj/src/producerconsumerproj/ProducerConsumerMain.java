package producerconsumerproj;

public class ProducerConsumerMain
{

    public static void main(String[] args)
    {
        Buffer b = new Buffer(2);
        Producer p1 = new Producer(b, 1);
        Producer p2 = new Producer(b, 2);
        Consumer c1 = new Consumer(b, 1);
        Consumer c2 = new Consumer(b, 2);
        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
    
}
