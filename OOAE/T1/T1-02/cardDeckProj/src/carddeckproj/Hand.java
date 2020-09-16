package carddeckproj;

public class Hand
{
    private Card[] theCards;
    private int numCards;
    private static final int max = 5;
    
    public Hand()
    {
        theCards = new Card[max];
        numCards = 0;
    }
    
    public void addCard(Card aCard)
    {
        if (numCards < max)
        {
            theCards[numCards++] = aCard;
        }
    }
    
    public int getHandValue()
    {
        int value = 0;
        for (int i = 0; i < theCards.length; i++)
        {
            value = value + (theCards[i].getRank().getNumVal());
        }
        return value;
    }
    
    @Override
    public String toString()
    {
        String s = "";
        for (int i = 0; i < numCards; i++)
        {
            s += "\n" + theCards[i];
        }
        return s;
    }
}
