package Observer;

import Subject.JButtonSubject;
import Subject.Subject;
import javax.swing.JTextArea;

/**
 *
 * @author Rhys Jones
 */
public class JTextAreaObserver extends JTextArea implements Observer
{

    //Observer states
    private int button1Clicks;
    private int button2Clicks;

    public JTextAreaObserver()
    {
        super();
    }

    @Override
    public void update(Subject subject)
    {
        if (subject instanceof JButtonSubject)
        {
            if (((JButtonSubject) subject).getText().equalsIgnoreCase("button 1"))
            {
                button1Clicks = ((JButtonSubject) subject).getNumberOfClicks();
            }

            else if (((JButtonSubject) subject).getText().equalsIgnoreCase("button 2"))
            {
                button2Clicks = ((JButtonSubject) subject).getNumberOfClicks();
            }

            String outputText = "Total clicks: " + (button1Clicks + button2Clicks)
                    + "\nButton 1 clicks: " + button1Clicks
                    + "\nButton 2 clicks: " + button2Clicks
                    + "\nAverage clicks: " + ((button1Clicks + button2Clicks) / 2);

            this.setText(outputText);
        }
    }

}
