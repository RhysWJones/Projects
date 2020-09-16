package Subject;

import Observer.Observer;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Rhys Jones
 */
public class JButtonSubject extends JButton implements Subject
{

    private ArrayList<Observer> observers;

    //Subject state
    private int numberOfClicks;

    public JButtonSubject(String buttonName)
    {
        super(buttonName);
        observers = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer)
    {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer)
    {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers()
    {
        for (Observer o : observers)
        {
            o.update(this);
        }
    }

    public int getNumberOfClicks()
    {
        return numberOfClicks;
    }

    //Set state equivalent
    public void incrementNumberOfclicks()
    {
        this.numberOfClicks++;
        notifyObservers();
    }

}
