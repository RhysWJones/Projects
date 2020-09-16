package genericclassproj;

import java.util.ArrayList;

public class SimpleStack<T>
{

    private ArrayList<T> stack;

    public SimpleStack()
    {
        stack = new ArrayList();
    }

    public boolean push(T element)
    {
        return stack.add(element);
    }

    public T pop()
    {
        try
        {
            return stack.remove(stack.size() - 1);
        }
        catch (IndexOutOfBoundsException e)
        {
            return null;
        }
    }

    public T peek()
    {
        try
        {
            return stack.get(stack.size() - 1);
        }
        catch (IndexOutOfBoundsException e)
        {
            return null;
        }
    }

}
