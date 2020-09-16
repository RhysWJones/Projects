
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Adapted from Liang Introduction to Java Programming exercise 24.2
 */
public class RaceCarApplet extends JApplet implements Runnable
{

    private RaceCarPanel rcp;
    private JButton btnGo = new JButton("Go");
    private Thread repaintThread;

    public void init()
    {
        rcp = new RaceCarPanel();
        JPanel panel2 = new JPanel();
        panel2.add(btnGo);
        btnGo.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                rcp.go();
            }
        });

        add(rcp, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
    }

    public void start()
    {
        repaintThread = new Thread(this);
        repaintThread.start();
    }

    public void stop()
    {
        rcp.stop();
        repaintThread = null;
    }

    public void run()
    {
        try
        {
            while (true)
            {
                rcp.repaint();
                Thread.sleep(25);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
