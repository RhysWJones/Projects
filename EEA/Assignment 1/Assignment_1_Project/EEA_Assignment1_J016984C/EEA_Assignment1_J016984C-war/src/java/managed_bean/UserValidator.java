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
@FacesValidator(value = "userValidator")
public class UserValidator implements Validator
{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
    {
        String msg;

        if (component.getId().equals("forename"))
        {
            String forenameToCheck = (String) value;

            if (!forenameToCheck.matches("[a-zA-Z]+"))
            {
                msg = "A forename can only contain alphabetic characters";
                throw new ValidatorException(new FacesMessage(msg));
            }
        }

        if (component.getId().equals("surname"))
        {
            String surnameToCheck = (String) value;

            if (!surnameToCheck.matches("[a-zA-Z]+"))
            {
                msg = "A surname can only contain alphabetic characters";
                throw new ValidatorException(new FacesMessage(msg));
            }
        }

        if (component.getId().equals("dateOfBirth"))
        {
            Date dateToCheck = (Date) value;
            Date today = new Date();

            if (dateToCheck.after(today))
            {
                msg = "You cannot have been born in the future";
                throw new ValidatorException(new FacesMessage(msg));
            }
        }

        if (component.getId().equals("email"))
        {
            String emailToCheck = (String) value;
            //Regex taken from https://stackoverflow.com/questions/201323/how-to-validate-an-email-address-using-a-regular-expression and tested at RegExr.com
            String emailRegex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

            if (!emailToCheck.matches(emailRegex))
            {
                msg = "Email is not valid";
                throw new ValidatorException(new FacesMessage(msg));
            }
        }

        if (component.getId().equals("password") || component.getId().equals("oldPassword") || component.getId().equals("newPassword"))
        {
            value = (String) value;
            if (component.getId().equals("oldPassword") || component.getId().equals("newPassword"))
            {
                if(value.equals(""))
                {
                    return;
                }
            }
            else
            {
                String passwordToCheck = (String) value;
                String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

                if (!passwordToCheck.matches(passwordRegex))
                {
                    msg = "Password complexity requires the following: 1 lowercase & 1 uppercase alphabetical character, 1 numeric character and a minimum length of 8";
                    throw new ValidatorException(new FacesMessage(msg));
                }
            }
        }

        if (component.getId().equals("postcode"))
        {
            String postcodeToCheck = (String) value;
            String britishPostcodeRegex = "([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9][A-Za-z]?))))\\s?[0-9][A-Za-z]{2})";

            if (!postcodeToCheck.matches(britishPostcodeRegex))
            {
                msg = "Postcode does not match a valid british postcode format";
                throw new ValidatorException(new FacesMessage(msg));
            }
        }
    }

}
