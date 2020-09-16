package junitproj;

import java.util.Objects;

public class Person implements Cloneable, Comparable<Person>
{

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    @Override
    public String toString()
    {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Person)
        {
            if ((firstName.equals(((Person) obj).firstName))
                    && (lastName.equals(((Person) obj).lastName)))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.firstName);
        hash = 17 * hash + Objects.hashCode(this.lastName);
        return hash;
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    public int compareTo(Person p)
    {
        int i = lastName.compareTo(p.lastName);
        if (i != 0)
        {
            if (i < 0)
            {
                return -1;
            }
            else if (i > 0)
            {
                return 1;
            }
        }

        i = firstName.compareTo(p.firstName);
        if (i != 0)
        {
            if (i < 0)
            {
                return -1;
            }
            else if (i > 0)
            {
                return 1;
            }
        }

        return 0;

    }
}
