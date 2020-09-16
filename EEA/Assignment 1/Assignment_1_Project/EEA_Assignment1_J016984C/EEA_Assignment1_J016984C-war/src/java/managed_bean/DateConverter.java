package managed_bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "dateConverter")
public class DateConverter implements Converter
{
    private final SimpleDateFormat sdf;
    
    public DateConverter()
    {
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
    }
    
    @Override
    public Object getAsObject(FacesContext context,
                              UIComponent component,
                              String dateValue) throws ConverterException
    {
        try
        {
            Date d = sdf.parse(dateValue);
            return d;
        }
        catch (ParseException e)
        {
            throw new ConverterException(e);
        }
    }
    
    @Override
    public String getAsString(FacesContext context,
                              UIComponent component,
                              Object value) throws ConverterException
    {
        if (value == null)
        {
            return "";
        }
        
        if (value instanceof Date)
        {
            Date d = (Date)value;
            return sdf.format(d);
        }
        
        String msgInfo = "Unexpected type " + value.getClass().getName();
        FacesMessage msg = new FacesMessage("Conversion error", 
                                            msgInfo);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        throw new ConverterException(msg);
    }
}
