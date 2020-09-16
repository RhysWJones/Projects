package junitproj;

public class DVD
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
}
