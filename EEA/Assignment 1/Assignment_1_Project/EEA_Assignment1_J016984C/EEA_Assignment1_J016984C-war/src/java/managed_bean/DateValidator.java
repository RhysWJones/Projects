package managed_bean;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Rhys
 */
@FacesValidator(value = "dateValidator")
public class DateValidator implements Validator
{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
    {
        String msg;

        Date today = new Date();
        
        if (component.getId().equals("collectionDate"))
        {
            Date dateToCheck = (Date) value;
            
            if (dateToCheck.before(today))
            {
                msg = "You cannot book a collection for the past or for the same day";
                throw new ValidatorException(new FacesMessage(msg));
            }
        }
        
        if(component.getId().equals("newDeliveryDate"))
        {
            Date dateToCheck = (Date) value;
            
            if (dateToCheck.before(today))
            {
                msg = "You cannot book a collection for the past or for the same day";
                throw new ValidatorException(new FacesMessage(msg));
            }
        }
    }

}
