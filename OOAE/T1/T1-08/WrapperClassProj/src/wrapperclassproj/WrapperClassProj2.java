package wrapperclassproj;

public class WrapperClassProj2
{

    public static void main(String[] args)
    {
        Double answer1 = add(2, 7);
        Number answer2 = add(new Integer(4), new Double(5.2));
        double answer3 = add(8, 1.3);
        System.out.println(answer1 + " " + answer2 + " " + answer3);
    }
    
    public static <T extends Number> double add(T num1, T num2)
    {
        return num1.doubleValue() + num2.doubleValue();
    }
}
