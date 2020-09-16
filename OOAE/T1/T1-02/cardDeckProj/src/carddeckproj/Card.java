package carddeckproj;

public class Card
{
    private Rank rank;
    private Suit suit;
    
    public Card(Rank rank)
    {
        this(rank, Suit.HEARTS);
    }
    
    public Card(Rank rank, Suit suit)
    {
        this.rank = rank;
        this.suit = suit;
    }
    
    public Rank getRank()
    {
        return rank;
    }
    
    public Suit getSuit()
    {
        return suit;
    }
    
    @Override
    public String toString()
    {
        return rank + " of " + suit;
    }
}
