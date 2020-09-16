package carddeckproj;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class DisplayableCard extends Card implements Displayable
{

    private Image image;
    private String imageFilename = "";

    public DisplayableCard(Rank rank, Suit suit)
    {
        super(rank, suit);
    }

    @Override
    public void display(Graphics g, int x, int y)
    {
        image = new ImageIcon(getClass().getResource("/images/" + getCardNumber() + ".png")).getImage();
        g.drawImage(image, x, y, null);
    }
    
    private int getCardNumber()
    {
        return (super.getSuit().ordinal() * 13) + super.getRank().ordinal();
    }

}
