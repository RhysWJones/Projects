package carddeckproj;

import java.awt.*;
import javax.swing.*;

public class DisplayableHand extends Hand implements Displayable
{
    private Image image;

    @Override
    public void display(Graphics g, int x, int y)
    {
        for (int i = 0; i<theCards.length; i++)
        {
            image = new ImageIcon(getClass().getResource("/images/" + getCardNumber(theCards[i]) + ".png")).getImage();
            g.drawImage(image, (i*75 + x), y, null);
        }
    }
    
    private int getCardNumber(Card card)
    {
        return (card.getSuit().ordinal() * 13) + card.getRank().ordinal();
    }

}
