package factorymethodpatternguiproj;

import java.awt.FlowLayout;
import javax.swing.JCheckBox;

/**
 *
 * @author Rhys Jones
 */
public class CheckButtonUIProduct extends UIProduct
{

    public CheckButtonUIProduct(String[] options)
    {
        super(options);
        
        setLayout(new FlowLayout());
        
        for(int i = 0; i < options.length; i++)
        {
            JCheckBox checkBox = new JCheckBox(options[i]);
            add(checkBox);
        }
    }
}
