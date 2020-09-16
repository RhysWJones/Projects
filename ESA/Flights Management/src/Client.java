
import GUI.LoginView;
import javax.swing.JFrame;

public class Client
{

    static JFrame frame;

    public static void main(String[] args)
    {
        new LoginView().setVisible(true);
//        new SearchPassenger().setVisible(true);
//          SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                TabbedPane codeExample = new TabbedPane();
//                frame = new JFrame();
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                Container panel = frame.getContentPane();
//                panel.setLayout(new BorderLayout());
//                panel.add(new TabbedPane(), BorderLayout.CENTER);
//                frame.pack();
//                frame.setSize(1151, 1000);
//                frame.setLocationRelativeTo(null);
//                frame.setVisible(true);
//            }
//        });
//        //atm just runs this command but will make it so command runs when tab is selected
        //CommandFactory.create(CommandFactory.VIEW_ALL_DEPARTMENTS).execute();
        //CommandFactory.create(CommandFactory.ADD_PASSENGER).execute();
        //CommandFactory.create(CommandFactory.VIEW_ALL_PASSENGERS).execute();
        //CommandFactory.create(CommandFactory.VIEW_ALL_PASSENGERS_RISKS).execute();
        // new AllPassengersRisk_ByFlightView(new PassengerRisk_ByFlightHandler().findAllPassengersRisks()).print();

//        FlightHandler f = new FlightHandler();
//        
//        f.addNewPlane("des", 100,"Ryanair","bicycle");
//        
//        Date date = Date.valueOf("2018-03-03");
//        Time time = Time.valueOf("20:30:00");
//        
//        f.addNewFlight(6, "Budapest", "Warsaw", date, time, date, time);
//        f.addNewSeat(10, 10, true);
//        f.addNewSeat(10, 12, true);
//        f.addNewSeat(10, 15, true);
//        f.addNewSeat(10, 17, true);
    }
}
