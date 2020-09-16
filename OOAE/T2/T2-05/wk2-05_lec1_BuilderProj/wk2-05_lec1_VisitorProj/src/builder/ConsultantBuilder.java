package builder;

import database.Consultant;

public class ConsultantBuilder
{
    private final Consultant con = new Consultant();

    public ConsultantBuilder withId(int id)
    {
        this.con.setID(id);
        return this;
    }

    public ConsultantBuilder withName(String name)
    {
        this.con.setName(name);
        return this;
    }
    
    public ConsultantBuilder withPrice(int price)
    {
        this.con.setPrice(price);
        return this;
    }
    
    public Consultant build()
    {
        return con;
    }
}
