package command;

import model.ConsultantHandler;
import view.AllConsultantsView;

/**
 *
 * @author Rhys Jones
 */
public class GetAllConsultantsCommand implements Command
{
    ConsultantHandler receiver;
    
    public GetAllConsultantsCommand(ConsultantHandler receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute()
    {
        new AllConsultantsView(receiver.findAllConsultants()).print();
    }
    
    
}
