package factorymethodpatternguiproj;

import java.awt.FlowLayout;
import javax.swing.JComboBox;

/**
 *
 * @author Rhys Jones
 */
public class ListBoxUIProduct extends UIProduct
{
    
    public ListBoxUIProduct(String[] options)
    {
        super(options);
        
        setLayout(new FlowLayout());
        
        JComboBox comboBox = new JComboBox(options);
        
        add(comboBox);
    }
}
