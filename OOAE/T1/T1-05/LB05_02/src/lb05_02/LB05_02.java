package lb05_02;

public class LB05_02
{

    public static void main(String[] args)
    {
        //countToTen();
        System.out.println("");
        countToTenFail();
    }

    public static void countToTen()
    {
        for (int i = 0; i < 10; i++)
        {
            if (i < 10)
            {
                System.out.println(i + 1);
            }

            else
            {
                assert (i < 10) : "Number is: " + i;
            }
        }
    }
    
    public static void countToTenFail()
    {
        for (int i = 0; i <= 11; i++)
        {
            if (i < 10)
            {
                System.out.println(i + 1);
            }

            else
            {
                assert ((i+1) < 10) : "Number is: " + (i+1);
            }
        }
    }
}
