package carddeckproj;

import java.util.*;

public class Deck
{

    protected Card[] theCards;

    public Deck()
    {
        theCards = new Card[52];
        createDeck(theCards);
    }

    public void createDeck(Card[] theCards)
    {
        int i = 0;
        for (Suit s : Suit.values())
        {
            for (Rank r : Rank.values())
            {
                theCards[i] = new Card(r, s);
                i++;
            }
        }
    }

    public void toString(Card[] theCards)
    {
        System.out.println("Printing the deck:");
        for (Card cards : theCards)
        {
            System.out.println(cards.getRank() + " of " + cards.getSuit());
        }
        System.out.println("");
    }

    public void shuffle()
    {
        Collections.shuffle(Arrays.asList(theCards));
    }
}
