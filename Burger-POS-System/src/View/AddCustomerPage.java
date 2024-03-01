/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.OrderController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author ishan
 */
public class AddCustomerPage extends JFrame {
    
    private JLabel lblAddCustomer;
    private JLabel lblName;
    private JLabel lblAddress;
    private JLabel lblPhoneNo;
    
    private JTextField txtName;
    private JTextField txtAddress;
    private JTextField txtPhoneNo;
    
    private JButton btnAdd;
    
    public AddCustomerPage() {
        setTitle("Add Customer");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        
        Font lblFonts=new Font("",Font.BOLD,15);
        
        lblAddCustomer = new JLabel();
        lblAddCustomer.setText("Add Customer");
        lblAddCustomer.setFont(new Font("",Font.PLAIN,35));
        lblAddCustomer.setForeground(Color.white);
        lblAddCustomer.setBounds(0,0,700,70);
        lblAddCustomer.setVerticalAlignment(JLabel.CENTER);
        lblAddCustomer.setHorizontalAlignment(JLabel.CENTER);
        lblAddCustomer.setBackground(new Color(255,25,25));
        lblAddCustomer.setOpaque(true);
        
        lblName = new JLabel();
        lblName.setText("Customer Name: ");
        lblName.setFont(lblFonts);
        lblName.setBounds(60, 180, 150, 20);
        
        lblAddress = new JLabel();
        lblAddress.setText("Address: ");
        lblAddress.setFont(lblFonts);
        lblAddress.setBounds(60, 220, 150, 20);
        
        lblPhoneNo = new JLabel();
        lblPhoneNo.setText("Phone Number: ");
        lblPhoneNo.setFont(lblFonts);
        lblPhoneNo.setBounds(60, 260, 150, 20);
        
        txtName = new JTextField();
        txtName.setBounds(190, 180, 250, 25);
        
        txtAddress = new JTextField();
        txtAddress.setBounds(190, 220, 250, 25);
        
        txtPhoneNo = new JTextField();
        txtPhoneNo.setBounds(190, 260, 250, 25);
        
        btnAdd = new JButton("SAVE");
        btnAdd.setFont(lblFonts);
        btnAdd.setForeground(Color.white);
        btnAdd.setBackground(Color.red);
        btnAdd.setBounds(425, 330, 100, 25);
        btnAdd.setFocusable(false);
        btnAdd.addActionListener(evt ->{
            
        });
        
        add(lblAddCustomer);
        add(lblName);
        add(lblAddress);
        add(lblPhoneNo);
        
        add(txtName);
        add(txtAddress);
        add(txtPhoneNo);
        
        add(btnAdd);
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/icon/icons8-customer-48.png")));
    }
    
}
