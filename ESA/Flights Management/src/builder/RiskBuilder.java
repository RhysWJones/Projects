package builder;

import database.Risk;

/**
 *
 * @author Krzychu-x
 */
public class RiskBuilder
{

    Risk risk = new Risk();

    public RiskBuilder withRiskID(int riskID)
    {
        risk.setRiskID(riskID);
        return this;
    }

    public RiskBuilder withRiskFactor(String riskFactor)
    {
        risk.setRiskFactor(riskFactor);
        return this;
    }

    public RiskBuilder withRiskScore(int riskScore)
    {
        risk.setRiskScore(riskScore);
        return this;
    }

    public Risk build()
    {
        return risk;
    }
}
