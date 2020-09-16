/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.Risk;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author danpa
 */
public class GetRisksView
{

    ArrayList<Risk> risks;

    public GetRisksView(ArrayList<Risk> risks)
    {
        this.risks = risks;
    }

    public ArrayList<String> getRiskNames()
    {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < risks.size(); i++)
        {
            names.add(risks.get(i).getRiskFactor());
        }
        return names;
    }

    public ArrayList<JLabel> GetLabels()
    {
        ArrayList<JLabel> labels = new ArrayList<>();

        risks.forEach((Risk) ->
        {
            labels.add(new JLabel(Risk.getLabel()));
        });
        return labels;
    }

}
