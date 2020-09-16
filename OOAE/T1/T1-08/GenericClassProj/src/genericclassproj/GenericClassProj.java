package genericclassproj;

public class GenericClassProj
{

    public static void main(String[] args)
    {
        SimpleStack theStack = new SimpleStack();
        System.out.println(theStack.push("Hello")); //return true
        System.out.println(theStack.push("World")); //return true
        System.out.println(theStack.pop()); //return World
        System.out.println(theStack.peek()); //return Hello
        System.out.println(theStack.push("Goodbye")); //return true
        System.out.println(theStack.pop()); //return Goodbye
        System.out.println(theStack.pop()); //return Hello
        System.out.println(theStack.pop()); //return null
        System.out.println(theStack.peek()); //return null
    }

}
