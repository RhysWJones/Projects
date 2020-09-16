/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import command.CommandFactory;
import database.Admin;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TabbedPane extends JPanel
{

    static JFrame frame;

    public TabbedPane(Admin admin)
    {
        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();
        ArrayList<JLabel> flightLabels = (ArrayList<JLabel>) CommandFactory.create(CommandFactory.VIEW_ALL_FLIGHT_LABELS).execute();

        JPanel viewFlightsPanel = new JPanel();
        viewFlightsPanel.setLayout(new BoxLayout(viewFlightsPanel, BoxLayout.Y_AXIS));
        viewFlightsPanel.add(new accordion("Flight", flightLabels));
        tabbedPane.addTab("View flights", viewFlightsPanel);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JPanel addPanel = new JPanel();
        addPanel.setLayout(new GridLayout(0, 2));
        addPanel.add(new AddNewFlight().getPanel());
        addPanel.add(new AddNewPassenger().getPanel());
        addPanel.add(new AddNewPlane().getPanel());
        addPanel.add(new AddNewRisk());
        tabbedPane.addTab("Add (ADMIN ONLY)", addPanel);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        tabbedPane.setEnabledAt(1, admin.isAuthenticated());

        SearchPassenger search = new SearchPassenger();
        tabbedPane.addTab("Search", search.getPanel());
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        //Add the tabbed pane to this panel.
        add(tabbedPane);

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

}
