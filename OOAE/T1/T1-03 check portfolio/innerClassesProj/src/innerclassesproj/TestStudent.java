package innerclassesproj;

public class TestStudent
{

    public static void main(String[] args)
    {
        Student s1 = new Student ("Daffy", 21, "Smithfield Drive");
        Student.Address anotherAddress = new Student.Address(8, "Deerfield Way");
        Student.Address uniAddress = new Student.Address(72, "Nottingham Drive");
        s1.setUniAddress(uniAddress);
        
        System.out.println(anotherAddress.toString());
        System.out.println("");
        System.out.println(s1.toString());
    }
}