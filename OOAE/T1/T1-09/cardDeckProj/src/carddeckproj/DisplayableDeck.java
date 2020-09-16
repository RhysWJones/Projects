package carddeckproj;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class DisplayableDeck extends Deck implements Displayable
{

    private Image image;

    @Override
    public void display(Graphics g, int x, int y)
    {
        image = new ImageIcon(getClass().getResource("/images/b1fv.png")).getImage();
        g.drawImage(image, x, y, null);
    }

}
