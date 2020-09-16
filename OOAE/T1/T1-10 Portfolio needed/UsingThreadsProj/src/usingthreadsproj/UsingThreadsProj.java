package usingthreadsproj;

import java.util.ArrayList;

public class UsingThreadsProj
{

    public static void main(String[] args)
    {
        ArrayList<Message> msgs = new ArrayList<Message>();
        msgs.add(new Message("Hello world", 2));
        msgs.add(new Message("Goodbye world", 3));
        msgs.add(new Message("Help!", 5));
        printMessages(msgs);

    }

    public static void printMessages(ArrayList<Message> msgs)
    {

        for (Message m : msgs)
        {

            m.start();
        }
    }
}
