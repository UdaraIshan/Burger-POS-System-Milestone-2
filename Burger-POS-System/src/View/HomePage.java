/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ishan
 */
public class HomePage extends JFrame{
    
    private JButton btnAddCustomer;
    private JButton btnPlaceOrder;
    private JButton btnSearch;
    private JButton btnViewOrder;
    private JButton btnUpdateOrder;
    private JButton btnExit;
    
    private JLabel lblHome;
    
    public HomePage(){
        setTitle("Home Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        btnAddCustomer = new JButton("Add Customer");
        btnAddCustomer.setForeground(Color.white);
        btnAddCustomer.setBackground(Color.red);
        btnAddCustomer.setFont(new Font("",Font.PLAIN,17));
        btnAddCustomer.setBounds(150, 100, 200, 40);
        btnAddCustomer.setFocusable(false);
        btnAddCustomer.addActionListener(evt ->{
            new AddCustomerPage().setVisible(true);
        });
        
        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.setForeground(Color.white);
        btnPlaceOrder.setBackground(Color.red);
        btnPlaceOrder.setFont(new Font("",Font.PLAIN,17));
        btnPlaceOrder.setBounds(150, 150, 200, 40);
        btnPlaceOrder.setFocusable(false);
        btnPlaceOrder.addActionListener(evt ->{
            new PlaceOrderPage().setVisible(true);
        });
        
        btnSearch = new JButton("Search");
        btnSearch.setForeground(Color.white);
        btnSearch.setBackground(Color.red);
        btnSearch.setFont(new Font("",Font.PLAIN,17));
        btnSearch.setBounds(150, 200, 200, 40);
        btnSearch.setFocusable(false);
        btnSearch.addActionListener(evt ->{
            new SearchPage().setVisible(true);
        });
        
        btnViewOrder = new JButton("View Order");
        btnViewOrder.setForeground(Color.white);
        btnViewOrder.setBackground(Color.red);
        btnViewOrder.setFont(new Font("",Font.PLAIN,17));
        btnViewOrder.setBounds(150, 250, 200, 40);
        btnViewOrder.setFocusable(false);
        btnViewOrder.addActionListener(evt ->{
            new ViewOrdersPage().setVisible(true);
        });
        
        btnUpdateOrder = new JButton("Update Order");
        btnUpdateOrder.setForeground(Color.white);
        btnUpdateOrder.setBackground(Color.red);
        btnUpdateOrder.setFont(new Font("",Font.PLAIN,17));
        btnUpdateOrder.setBounds(150, 300, 200, 40);
        btnUpdateOrder.setFocusable(false);
        btnUpdateOrder.addActionListener(evt ->{
            new UpdateOrderPage().setVisible(true);
        });
        
        btnExit = new JButton("Exit");
        btnExit.setFont(new Font("",Font.PLAIN,17));
        btnExit.setForeground(Color.white);
        btnExit.setBackground(Color.red);
        btnExit.setBounds(295, 370, 100, 40);
        btnExit.setFocusable(false);
        btnExit.addActionListener(evt ->{
            System.exit(0);
        });
        
        lblHome = new JLabel();
        lblHome.setText("Home Page");
        lblHome.setFont(new Font("",Font.PLAIN,40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0, 0, 500, 70);
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(255,25,25));
        lblHome.setOpaque(true);
        
        add(lblHome);
        
        add(btnAddCustomer);
        add(btnPlaceOrder);
        add(btnSearch);
        add(btnViewOrder);
        add(btnUpdateOrder);
        add(btnExit);
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/icon/icons8-customer-48.png")));
    }
}
