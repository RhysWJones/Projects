package view;

import database.Flight;
import database.Seat;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;

public class AllFlightsView
{

    ArrayList<Flight> flights;
    ArrayList<JLabel> flightCards = new ArrayList();

    public AllFlightsView(ArrayList<Flight> flights)
    {
        this.flights = flights;
    }

    public ArrayList<Integer> getFlightNames()
    {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < flights.size(); i++)
        {
            list.add(flights.get(i).getFlightID());
        }
        return list;
    }

    public ArrayList<JLabel> makeCards()
    {

        for (Flight f : flights)
        {
            JLabel label = new JLabel();

            StringBuilder buff = new StringBuilder();
            buff.append("<html><table>");
            buff.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "Flight number: " + f.getFlightID(), "\tPlane id: " + f.getPlaneID()));
            buff.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "\tFrom: " + f.getfOrigin(), "\tTo: " + f.getfDestination()));
            buff.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "\tDeparture date: " + f.getDepartureDate(), "\tArrival date: " + f.getArrivalDate()));
            buff.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "\tPlane designation: " + f.getPlane().getDesignation(), "\tPlane capacity: " + f.getPlane().getCapacity()));
            buff.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "\tPlane airline: " + f.getPlane().getAirline(), "\tEquipment: " + f.getPlane().getEquipment()));
            buff.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "\tDeparture time: " + f.getDepartureTime(), "\tArrival time: " + f.getArrivalTime()));
            buff.append("</table></html>");

            label.setText(buff.toString());
            label.setFont(new Font("Serif", Font.PLAIN, 40));
            flightCards.add(label);
        }
        return flightCards;
    }

    public ArrayList<String> getString()
    {
        ArrayList<String> allFlights = new ArrayList<String>();

        for (Flight f : flights)
        {

            allFlights.add("FLIGHT" + "\n\tFlight number: " + f.getFlightID() + "\tPlane id: " + f.getPlaneID() + "\n\tFrom: " + f.getfOrigin()
                    + "\tTo: " + f.getfDestination() + "\n\tDeparture date: " + f.getDepartureDate()
                    + "\tArrival date: " + f.getArrivalDate() + "\n\tPlane designation: "
                    + f.getPlane().getDesignation()
                    + "\tPlane capacity: " + f.getPlane().getCapacity()
                    + "\n\tPlane airline: " + f.getPlane().getAirline()
                    + "\tEquipment: " + f.getPlane().getEquipment()
                    + "\n");

            for (Seat s : f.getSeat())
            {
                allFlights.add("\tSeat id: " + s.getSeatID() + "\tSeat number: " + s.getSeatNumber() + "\t\tSeat taken: " + s.getSeatTaken());
            }
            allFlights.add("\n");
        }
        return allFlights;
    }
}
