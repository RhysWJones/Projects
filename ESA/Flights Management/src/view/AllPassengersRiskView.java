package view;

import database.PassengerRisk_ByFlight;
import database.Risk;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Krzychu-x
 */
public class AllPassengersRiskView
{

    ArrayList<PassengerRisk_ByFlight> risks;
    ArrayList<JLabel> labels = new ArrayList<JLabel>();

    public AllPassengersRiskView(ArrayList<PassengerRisk_ByFlight> risks)
    {
        this.risks = risks;
    }

    public ArrayList<String> print()
    {
        ArrayList<String> riskString = new ArrayList<String>();

        System.out.println("All passengers risks\n");
        for (PassengerRisk_ByFlight p : risks)
        {
            riskString.add("Passenger ID:  " + p.getPassenger().getPassengerID() + "\tPassenger name: " + p.getPassenger().getForename() + " " + p.getPassenger().getSurname() + "\tFlight ID:  " + p.getFlight().getFlightID());

            int totalRiskScore = 0;
            for (Risk r : p.getRisk())
            {
                riskString.add("\tRisk ID:  " + r.getRiskID() + "\tRisk factor:  " + r.getRiskFactor() + "\tRisk score:  " + r.getRiskScore());
                totalRiskScore += r.getRiskScore();
            }
            riskString.add("\n\t\t\t\tTotal risk scores: " + totalRiskScore + "\n");
        }
        return riskString;
    }

    public ArrayList<JLabel> getLabels()
    {
        StringBuilder buff;

        for (PassengerRisk_ByFlight p : risks)
        {
            buff = new StringBuilder();
            buff.append("<html><table>");
            buff.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "\tPassenger name: " + p.getPassenger().getForename() + " " + p.getPassenger().getSurname(), "\tFlight ID:  " + p.getFlight().getFlightID()));
            int totalRiskScore = 0;
            for (Risk r : p.getRisk())
            {
                buff.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "\tRisk factor:  " + r.getRiskFactor(), "\tRisk score:  " + r.getRiskScore()));
                totalRiskScore += r.getRiskScore();
            }
            buff.append(String.format("<tr><td align='left'>%s</td><td></td></tr>", "\t\t\t\tTotal risk scores: " + totalRiskScore));
            buff.append(String.format("<tr><td align='left'>%s</td><td></td><td>%s</td></tr>", "------------------------", "---------------------"));
            buff.append("</table></html>");
            JLabel newLabel = new JLabel(buff.toString());
            labels.add(newLabel);
        }
        return labels;
    }
}
