package carddeckproj;

import javax.swing.*;
import java.awt.*;

public class GuiDriver extends JFrame
{

    private CardGamePanel[] cgp = new CardGamePanel[3];
    private DisplayableDeck dd = new DisplayableDeck();
    private DisplayableHand dh = new DisplayableHand();
    private DisplayableCard dc = new DisplayableCard(Rank.ACE, Suit.SPADES);

    public GuiDriver()
    {
        super("Cards Gui");
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        createHand();

        cgp[0] = new CardGamePanel();
        cgp[0].setItem(dd, 10, 10);
        p.add(cgp[0]);

        cgp[1] = new CardGamePanel();
        cgp[1].setItem(dh, 10, 10);
        p.add(cgp[1]);
        
        cgp[2] = new CardGamePanel();
        cgp[2].setItem(dc, 10, 10);
        p.add(cgp[2]);
        
        

        add(p);
        this.setSize(400, 375);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String args[])
    {
        GuiDriver d = new GuiDriver();
    }

    public void createHand()
    {
        dd.shuffle();

        for (int i = 0; i < dh.theCards.length; i++)
        {
            dh.addCard(dd.theCards[i]);
        }
    }
}
