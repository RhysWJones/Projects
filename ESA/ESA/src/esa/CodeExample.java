/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esa;

/**
 *
 * @author danpa
 */
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.SwingUtilities;


public class CodeExample extends JPanel{
static JFrame frame;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TabbedPaneDemo codeExample = new TabbedPaneDemo();
                frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Container panel = frame.getContentPane();
                panel.setLayout(new BorderLayout());
                panel.add(new TabbedPaneDemo(), BorderLayout.CENTER);
                frame.pack();
                frame.setSize(1000, 1000);
                frame.setVisible(true);
            }
        });

    }
}
