package innerclassesproj;

public class Student
{
    private static String name;
    private static Address homeAddress, uniAddress;
    
    public Student(String name, int houseNum, String homeStreet)
    {
        this.name = name;
        homeAddress = new Address(houseNum, homeStreet);
    }
    
    public void setUniAddress(Address uniAddress)
    {
        this.uniAddress = uniAddress;
    }
    
    public void setUniAddress(int hNum, String StrName)
    {
        uniAddress = new Address(hNum, StrName);
    }
    
    @Override
    public String toString()
    {
        if (homeAddress != null && uniAddress != null)
        {
        return "Home Address:\n" + homeAddress + "\n\nUni Address:\n" + uniAddress;
        }
        
        else if (homeAddress != null && uniAddress == null)
        {
            return "" + homeAddress;
        }
        
        else if (homeAddress == null && uniAddress != null)
        {
            return "" + uniAddress;
        }
        
        else
        {
            return "Student has no Address";
        }
    }
    
    public static class Address
    {
        private int number;
        private String street;
        
        public Address(int number, String street)
        {
            this.number = number;
            this.street = street;
        }
        
        @Override
        public String toString()
        {
            return name + "\n" + number + " " + street;
        }
    }
}
