package vehicleshowroomproj;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShowroomGui extends JFrame implements ActionListener
{

    private JButton nextVehicle, previousVehicle, buy;
    private JTextArea display;
    private Showroom showroom = new Showroom();
    private BuyerDialog bDialog;

    public ShowroomGui()
    {
        super("Vehicle Showroom");
        addVehiclesToShowroom(showroom);
        setSize(800, 300);
        setLocation(0, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createGui();

        setVisible(true);
    }

    public void createGui()
    {
        nextVehicle = new JButton("Next Vehicle");
        nextVehicle.addActionListener(this);

        previousVehicle = new JButton("Previous Vehicle");
        previousVehicle.addActionListener(this);

        buy = new JButton("Buy Vehicle");
        buy.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                bDialog = new BuyerDialog("Customer Name Dialog", ShowroomGui.this);
            }
        });

        display = new JTextArea(showroom.getCurrentVehicleAsString());
        display.setEditable(false);

        getContentPane().setLayout(new BorderLayout(10, 10));
        getContentPane().add(display, BorderLayout.CENTER);//NEW - The place to display cars in the middle
        getContentPane().add(previousVehicle, BorderLayout.WEST);
        getContentPane().add(buy, BorderLayout.SOUTH);
        getContentPane().add(nextVehicle, BorderLayout.EAST);

    }

    public void addVehiclesToShowroom(Showroom showroom)
    {
//        showroom.addVehicle(new Vehicle("Mercedes", "SLK", "12h123b", "12/9/2017", 'C', 43000));
//        showroom.addVehicle(new Vehicle("peugeot", "208", "96a858h", "17/9/2014", 'B', 19595));
//        showroom.addVehicle(new Vehicle("Fiat", "500", "57f158p", "10/10/2017", 'G', 18700));
//        showroom.addVehicle(new Vehicle("Ford", "Kuga", "46n947l", "27/8/2013", 'D', 21000));
        showroom.setCurrentVehicle(showroom.getVehicleInShowroom(0));
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        if (e.getSource() == previousVehicle)
        {
            showroom.previousVehicle();
            display.setText(showroom.getCurrentVehicleAsString());
        }

        else if (e.getSource() == nextVehicle)
        {
            showroom.nextVehicle();
            display.setText(showroom.getCurrentVehicleAsString());
        }

    }
    
    public Showroom getShowroom()
    {
        return showroom;
    }
    
    public JTextArea getVehicleDisplay()
    {
        return display;
    }

}

class BuyerDialog extends JDialog implements ActionListener
{

    JTextField name;
    JLabel prompt = new JLabel("Enter Name");
    JFrame owner;

    BuyerDialog(String sTitle, JFrame frame)
    {
        super(frame, sTitle, true);
        this.owner = frame;
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setBounds(130, 75, 200, 100);
        JPanel formPanel = new JPanel(new GridLayout(0, 2));
        name = new JTextField(8);
        name.addActionListener(this);

        JPanel nameP = new JPanel();
        JPanel promptP = new JPanel();
        promptP.add(prompt);
        nameP.add(name);
        formPanel.add(promptP);
        formPanel.add(nameP);
        add(formPanel);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        Customer customer = new Customer(name.getText());
        ((ShowroomGui) owner).getShowroom().getCurrentVehicle().buy("", customer);
        ((ShowroomGui) owner).getVehicleDisplay().setText(((ShowroomGui) owner).getShowroom().getCurrentVehicleAsString());
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
