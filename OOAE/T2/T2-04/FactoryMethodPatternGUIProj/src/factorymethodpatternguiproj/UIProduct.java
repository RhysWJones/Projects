package factorymethodpatternguiproj;

import javax.swing.JPanel;

/**
 *
 * @author Rhys Jones
 */
public abstract class UIProduct extends JPanel
{
    protected String[] options;

    public UIProduct(String[] options)
    {
        this.options = options;
    }
}
