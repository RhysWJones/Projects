package factorymethodpatternguiproj;

/**
 *
 * @author Rhys Jones
 */
public class ConcreteFactory extends Factory
{

    @Override
    public UIProduct createUIProduct(String[] options)
    {
        UIProduct product;
        if (options.length > 3)
        {
            product = new ListBoxUIProduct(options);
        }
        else
        {
            product = new CheckButtonUIProduct(options);
        }

        return product;
    }

}
