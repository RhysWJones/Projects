package junitproj;

import java.util.*;

public class DVD implements Cloneable, Comparable<DVD>
{

    private String title;
    private Person leadActor;
    private int noOfStars;

    public DVD(String title, Person leadActor, int noOfStars)
    {
        this.title = title;
        this.leadActor = leadActor;
        this.noOfStars = noOfStars;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Person getLeadActor()
    {
        return leadActor;
    }

    public void setLeadActor(Person leadActor)
    {
        this.leadActor = leadActor;
    }

    public int getNoOfStars()
    {
        return noOfStars;
    }

    public void setNoOfStars(int noOfStars)
    {
        this.noOfStars = noOfStars;
    }

    @Override
    public String toString()
    {
        return "Title: " + title + "\nLead Actor: " + leadActor.toString() + "\nNumber of stars: " + noOfStars;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof DVD)
        {
            if ((title.equals(((DVD) obj).title))
                    && (noOfStars == (((DVD) obj).noOfStars))
                    && (leadActor.equals(((DVD) obj).leadActor)))
            {
                return true;
            } else
            {
                return false;
            }
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.leadActor);
        hash = 97 * hash + this.noOfStars;
        return hash;
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    public Object deepClone() throws CloneNotSupportedException
    {
        DVD d = (DVD) super.clone();
        Person p1 = (Person) d.getLeadActor().clone();
        d.setLeadActor(p1);
        return d;
    }

    @Override
    public int compareTo(DVD d)
    {
        int i = title.compareTo(d.title);
        if (i != 0)
        {
            if (i < 0)
            {
                return -1;
            } else
            {
                if (i > 0)
                {
                    return 1;
                }
            }
        }

        i = leadActor.compareTo(d.leadActor);
        if (i != 0)
        {
            if (i < 0)
            {
                return -1;
            } else
            {
                if (i > 0)
                {
                    return 1;
                }
            }
        }

        i = (noOfStars - d.noOfStars);
        if (i != 0)
        {
            if (i < 0)
            {
                return -1;
            } else
            {
                if (i > 0)
                {
                    return 1;
                }
            }
        }

        return 0;
    }

    public static class DVDComparator implements Comparator<DVD>
    {

        public DVDComparator()
        {

        }

        @Override
        public int compare(DVD d1, DVD d2)
        {
            int i;

            i = (d1.noOfStars - d2.noOfStars);
            if (i != 0)
            {
                if (i < 0)
                {
                    return -1;
                } else
                {
                    if (i > 0)
                    {
                        return 1;
                    }
                }
            }

            i = d1.leadActor.compareTo(d2.leadActor);
            if (i != 0)
            {
                if (i < 0)
                {
                    return -1;
                } else
                {
                    if (i > 0)
                    {
                        return 1;
                    }
                }
            }

            i = d1.title.compareTo(d2.title);
            if (i != 0)
            {
                if (i < 0)
                {
                    return -1;
                } else
                {
                    if (i > 0)
                    {
                        return 1;
                    }
                }
            }

            return 0;
        }

    }
}
