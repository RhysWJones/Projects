package carddeckproj;

public class CardDeckProj
{

    public static void main(String[] args)
    {
        //Creating card objects and constructing them.
        Deck theDeck = new Deck();
        Hand handOfCards = new Hand();
        
        //outputs
//        getSuits(theCards);
//        getRanks(theCards);
        printCards(theDeck);
        
        //Create hand of five cards
        createHand(theDeck, handOfCards);
        printHand(handOfCards);
        printHandValues(handOfCards);
        
    }
    
    public static void createHand(Deck theDeck, Hand handOfCards)
    {
        handOfCards.addCard(theDeck.theCards[23]);
        handOfCards.addCard(theDeck.theCards[27]);
        handOfCards.addCard(theDeck.theCards[6]);
        handOfCards.addCard(theDeck.theCards[48]);
        handOfCards.addCard(theDeck.theCards[32]);
    }
    
    public static void printHand(Hand handOfCards)
    {
        System.out.println("Hand: " + handOfCards.toString());
        System.out.println("");
    }
    
    public static void printHandValues (Hand handOfCards)
    {
        System.out.println("Hand total: " + handOfCards.getHandValue());
        System.out.println("");
    }
    
    public static void getSuits(Deck theDeck)
    {
        System.out.println("getSuit:");
        for (int i = 0; i < theDeck.theCards.length; i++)
        {
            System.out.println(theDeck.theCards[i].getSuit());
        }
        System.out.print("\n");
    }
    
    public static void getRanks(Deck theDeck)
    {
        System.out.println("getRank:");
        for (Card cards : theDeck.theCards)
        {
            System.out.println(cards.getRank());
        }
        System.out.print("\n");
    }
    
    public static void printCards(Deck theDeck)
    {
        theDeck.toString(theDeck.theCards);
    }
}
