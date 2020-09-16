package guiobserverpatternproj;

import Observer.JTextAreaObserver;
import Subject.JButtonSubject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Rhys Jones
 */
public class GuiObserverPatternProj extends JFrame implements ActionListener
{

    public GuiObserverPatternProj()
    {
        super("OBSERVER PATTERN GUI PROJ - OOAE WEEK 3");

        //Setup overall panel
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 5));
        panel.setLayout(new BorderLayout());

        //Setup Text Area
        JTextAreaObserver textArea = new JTextAreaObserver();
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createEtchedBorder());

        //Setup panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(150, 0, 150, 50));
        buttonPanel.setLayout(new GridLayout(2, 1));
        
        //Create buttons(subjects) and attach to the observer
        JButtonSubject button1 = new JButtonSubject("Button 1");
        button1.attach(textArea);
        button1.addActionListener(this);

        JButtonSubject button2 = new JButtonSubject("Button 2");
        button2.attach(textArea);
        button2.addActionListener(this);
        
        //Add buttons to panel
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        //Add text area and button panel to the main panel
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.WEST);

        //Create overall view settings
        add(panel);
        setSize(600, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        new GuiObserverPatternProj();
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() instanceof JButtonSubject)
        {
            ((JButtonSubject) ae.getSource()).incrementNumberOfclicks();
        }
    }

}
