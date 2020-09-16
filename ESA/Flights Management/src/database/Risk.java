package database;

/**
 *
 * @author Krzychu-x
 */
public class Risk
{

    private int riskID;
    private String riskFactor;
    private int riskScore;
    private PassengerRisk_ByFlight passRisk;

    public Risk()
    {
        this(-1, "", -1);
    }

    public Risk(int riskID, String riskFactor, int riskScore)
    {
        this.riskID = riskID;
        this.riskFactor = riskFactor;
        this.riskScore = riskScore;
    }

    public Risk(String riskFactor, int riskScore)
    {
        this.riskFactor = riskFactor;
        this.riskScore = riskScore;
    }

    public PassengerRisk_ByFlight getPassRisk()
    {
        return passRisk;
    }

    public void setPassRisk(PassengerRisk_ByFlight passRisk)
    {
        this.passRisk = passRisk;
    }

    public int getRiskID()
    {
        return riskID;
    }

    public void setRiskID(int riskID)
    {
        this.riskID = riskID;
    }

    public String getRiskFactor()
    {
        return riskFactor;
    }

    public void setRiskFactor(String riskFactor)
    {
        this.riskFactor = riskFactor;
    }

    public int getRiskScore()
    {
        return riskScore;
    }

    public void setRiskScore(int riskScore)
    {
        this.riskScore = riskScore;
    }

    public String getLabel()
    {
        StringBuilder buff = new StringBuilder();
        buff.append("<html><table>");
        buff.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "\tRisk Factor: " + riskFactor, "\tScore: " + riskScore));
        buff.append(String.format("<tr><td align='left'>%s</td><td></td><td>%s</td></tr>", "------------------------", "---------------------"));
        buff.append("</table></html>");
        return buff.toString();
    }

    @Override
    public String toString()
    {
        return "Risk{" + "riskID=" + riskID + ", riskFactor=" + riskFactor + ", riskScore=" + riskScore + '}';
    }

}
