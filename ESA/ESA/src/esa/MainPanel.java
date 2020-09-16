/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esa;

import com.javaswingcomponents.accordion.JSCAccordion;
import com.javaswingcomponents.accordion.TabOrientation;
import com.javaswingcomponents.accordion.listener.AccordionEvent;
import com.javaswingcomponents.accordion.listener.AccordionListener;
import com.javaswingcomponents.accordion.plaf.AccordionUI;
import com.javaswingcomponents.accordion.plaf.basic.BasicHorizontalTabRenderer;
import com.javaswingcomponents.accordion.plaf.darksteel.DarkSteelAccordionUI;
import com.javaswingcomponents.framework.painters.configurationbound.GradientColorPainter;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author danpa
 */
public class MainPanel extends JPanel{
static JPanel frame; 
private JSCAccordion accordion = new JSCAccordion();    
private ArrayList<JPanel> tabs = new ArrayList();
private String type;

public MainPanel(String type) {
		this.type = type;
                for(int i=0;i<5;i++){
                   addTab(type +" "+ (i+1),i); 
                }		
		howToListenForChanges(accordion);
		howToChangeTabOrientation(accordion);
		howToChangeTheLookAndFeel(accordion);
		howToCustomizeALookAndFeel(accordion);
		setLayout(new GridLayout(1,1,30,30));
		add(accordion);
	}

	/**
	 * When adding a tab to the accordion, you must supply text for the tab
	 * as well as a component that will be used as the content contained for tab.
	 * The example below will add five tabs
	 * The first tab will contain the text "Tab 1" and a JButton
	 * The second tab will contain the text "Tab 2" and a JLabel
	 * The third tab will contain the text "Tab 3" and a JTree wrapped in a JScrollpane
	 * The fourth tab will contain the text "Tab 4" and an empty JPanel, with opaque = true
	 * The fifth tab will contain the text "Tab 5" and an empty JPanel with opaque = false
	 * 
	 * The key thing to note is the effect of adding an opaque or non opaque component to
	 * the accordion.
	 * @param accordion
	 */
	private void addTab(String name, int tabNum) {
		
		JPanel opaquePanel = new JPanel();
		opaquePanel.setOpaque(true);
		opaquePanel.setBackground(Color.GRAY);
                
		accordion.addTab(name, opaquePanel);                
                tabs.add(opaquePanel);
//		accordion.addTab("Tab 1", detailsPanel());
//		accordion.addTab("Tab 2", new JLabel("Label"));
//		accordion.addTab("Tab 3", new JScrollPane(new JTree()));
//		accordion.addTab("Tab 4", opaquePanel);
//		accordion.addTab("Tab 5", transparentPanel);
	}
	
	/**
	 * It can be useful to be notified when changes occur on the accordion. 
	 * The accordion can notify a listener when a tab is added, selected or removed.
	 * @param accordion
	 */
	private void howToListenForChanges(JSCAccordion accordion) {
		accordion.addAccordionListener(new AccordionListener() {
			
			@Override
			public void accordionChanged(AccordionEvent accordionEvent) {
				//available fields on accordionEvent.
				
				switch (accordionEvent.getEventType()) {
				case TAB_ADDED: {
					//add your logic here to react to a tab being added.
					break;
				}
				case TAB_REMOVED: {
					//add your logic here to react to a tab being removed.
					break;					
				}
				case TAB_SELECTED: {
                                    int selected = accordionEvent.getSource().getSelectedIndex();
					tabs.get(selected).add(detailsPanel(type,selected));
					break;					
				}
				}
			}
		});
	}
	
	/**
	 * You can change the tab orientation to slide either vertically or horizontally.
	 * @param accordion
	 */
	private void howToChangeTabOrientation(JSCAccordion accordion) {
		//will make the accordion slide from top to bottom
		accordion.setTabOrientation(TabOrientation.VERTICAL);
		
		//will make the accordion slide from left ro right
		//accordion.setTabOrientation(TabOrientation.HORITZONTAL);
	}
	
	/**
	 * You can change the look and feel of the component by changing its ui.
	 * In this example we will change the UI to the DarkSteelUI
	 * @param accordion
	 */
	private void howToChangeTheLookAndFeel(JSCAccordion accordion) {
		//We create a new instance of the UI
		AccordionUI newUI = DarkSteelAccordionUI.createUI(accordion);
		//We set the UI
		accordion.setUI(newUI);
	}
	
	/**
	 * The easiest way to customize a AccordionUI is to change the 
	 * default Background Painter, AccordionTabRenderers or tweak values
	 * on the currently installed Background Painter, AccordionTabRenderers and UI.
	 * @param accordion
	 */
	private void howToCustomizeALookAndFeel(JSCAccordion accordion) {
		//example of changing a value on the ui.
		DarkSteelAccordionUI ui = (DarkSteelAccordionUI) accordion.getUI();
		ui.setHorizontalBackgroundPadding(10);
		
		//example of changing the AccordionTabRenderer
		BasicHorizontalTabRenderer tabRenderer = new BasicHorizontalTabRenderer(accordion);
		tabRenderer.setFontColor(Color.RED);
		accordion.setHorizontalAccordionTabRenderer(tabRenderer);
		
		//example of changing the background painter.
		GradientColorPainter backgroundPainter = (GradientColorPainter) accordion.getBackgroundPainter();
		backgroundPainter = (GradientColorPainter) accordion.getBackgroundPainter();
		backgroundPainter.setStartColor(Color.BLACK);
		backgroundPainter.setEndColor(Color.WHITE);
		
		//the outcome of this customization is not the most visually appealing result
		//but it just serves to illustrate how to customize the accordion's look and feel.
		//The UI is darkSteel.
		//The backgroundPainter is a gradient running from Black to White
		//The accordionTabRenderer belongs to the BasicAccordionUI
		//And finally the text of the tab is red!
	}
        
        private JLabel detailsPanel(String type, int selected){
            JLabel label = new JLabel("<html>Hello World!<br/>The scorecard for "+ type +": " + selected +" Will go here</html>");
            label.setFont(new Font("Serif", Font.PLAIN, 30));
            return label;
            
        }
}
