/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import database.Admin;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author danpa
 */
public class LoginResult
{

    private JFrame frame;

    public LoginResult(Admin admin)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                TabbedPane codeExample = new TabbedPane(admin);
                frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Container panel = frame.getContentPane();
                panel.setLayout(new BorderLayout());
                panel.add(codeExample, BorderLayout.CENTER);
                frame.pack();
                frame.setSize(1151, 1000);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
