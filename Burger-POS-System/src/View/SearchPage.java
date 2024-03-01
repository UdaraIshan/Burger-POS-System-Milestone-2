/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ishan
 */
public class SearchPage extends JFrame {
    
    private JLabel lblSearch;
    
    private JButton btnSearchOrder;
    private JButton btnCustomer;
    private JButton btnSearchBestCustomer;
    
    public SearchPage() {
        setTitle("Search Page");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        lblSearch = new JLabel();
        lblSearch.setText("Search Page");
        lblSearch.setFont(new Font("",Font.PLAIN,40));
        lblSearch.setForeground(Color.white);
        lblSearch.setBounds(0,0,500,70);
        lblSearch.setVerticalAlignment(JLabel.CENTER);
        lblSearch.setHorizontalAlignment(JLabel.CENTER);
        lblSearch.setBackground(new Color(255,25,25));
        lblSearch.setOpaque(true);
        
        btnSearchOrder = new JButton("Search Order");
        btnSearchOrder.setForeground(Color.white);
        btnSearchOrder.setBackground(Color.red);
        btnSearchOrder.setFont(new Font("",Font.PLAIN,17));
        btnSearchOrder.setBounds(130, 180, 230, 40);
        btnSearchOrder.setFocusable(false);
        btnSearchOrder.addActionListener(evt ->{
            new SearchOrderPage().setVisible(true);
        });
        
        btnCustomer = new JButton("Search Customer");
        btnCustomer.setForeground(Color.white);
        btnCustomer.setBackground(Color.red);
        btnCustomer.setFont(new Font("",Font.PLAIN,17));
        btnCustomer.setBounds(130, 230, 230, 40);
        btnCustomer.setFocusable(false);
        btnCustomer.addActionListener(evt ->{
            new SearchCustomerPage().setVisible(true);
        });
        
        btnSearchBestCustomer = new JButton("Search Best Customer");
        btnSearchBestCustomer.setForeground(Color.white);
        btnSearchBestCustomer.setBackground(Color.red);
        btnSearchBestCustomer.setFont(new Font("",Font.PLAIN,17));
        btnSearchBestCustomer.setBounds(130, 280, 230, 40);
        btnSearchBestCustomer.setFocusable(false);
        btnSearchBestCustomer.addActionListener(evt ->{
            new SearchBestCustomerPage().setVisible(true);
        });
        
        add(btnSearchBestCustomer);
        add(btnSearchOrder);
        add(btnCustomer);
        add(lblSearch);
        
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/icon/icons8-customer-48.png")));
    }
}
