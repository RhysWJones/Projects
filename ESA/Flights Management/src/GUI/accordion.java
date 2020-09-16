package GUI;

import com.javaswingcomponents.accordion.JSCAccordion;
import com.javaswingcomponents.accordion.TabOrientation;
import com.javaswingcomponents.framework.painters.configurationbound.GradientColorPainter;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class accordion extends JPanel
{

    static JPanel frame;
    private JSCAccordion accordion = new JSCAccordion();
    //private ArrayList<JPanel> tabs = new ArrayList();
    private String type;

    public accordion(String type, ArrayList<JLabel> panels)
    {
        this.type = type;
        for (int i = 0; i < panels.size(); i++)
        {
            addTab(type + " " + (i + 1), i, panels.get(i));
        }

        accordion.setTabOrientation(TabOrientation.VERTICAL);

        GradientColorPainter backgroundPainter = (GradientColorPainter) accordion.getBackgroundPainter();
        backgroundPainter = (GradientColorPainter) accordion.getBackgroundPainter();
        backgroundPainter.setStartColor(Color.BLACK);
        backgroundPainter.setEndColor(Color.BLACK);

        setLayout(new GridLayout(1, 1, 30, 30));
        add(accordion);
    }

    /**
     * When adding a tab to the accordion, you must supply text for the tab as
     * well as a component that will be used as the content contained for tab.
     * The example below will add five tabs The first tab will contain the text
     * "Tab 1" and a JButton The second tab will contain the text "Tab 2" and a
     * JLabel The third tab will contain the text "Tab 3" and a JTree wrapped in
     * a JScrollpane The fourth tab will contain the text "Tab 4" and an empty
     * JPanel, with opaque = true The fifth tab will contain the text "Tab 5"
     * and an empty JPanel with opaque = false
     *
     * The key thing to note is the effect of adding an opaque or non opaque
     * component to the accordion.
     *
     * @param accordion
     */
    private void addTab(String name, int tabNum, JLabel panel)
    {
        JPanel opaquePanel = new JPanel();
        opaquePanel.setOpaque(true);
        opaquePanel.setBackground(Color.WHITE);
        opaquePanel.add(panel);
        accordion.addTab(name, opaquePanel);
        //tabs.add(opaquePanel);
    }
}
