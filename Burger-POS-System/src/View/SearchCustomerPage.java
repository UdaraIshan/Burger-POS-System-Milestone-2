/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.OrderController;
import Model.OrderDetails;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ishan
 */
public class SearchCustomerPage extends JFrame {
    
    private JLabel lblCustomerId;
    private JLabel lblSearch;
    private JLabel lblCustomerName;
    private JLabel lblDetails;
    
    private JTextField textCustomerId;
    
    private DefaultTableModel dtm;
    private JTable ordersTable;
    private JScrollPane tblPane;
    
    private JButton btnSearch;
    
    public SearchCustomerPage() {
        setTitle("Search Customer");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        
        Font lblFonts=new Font("",Font.BOLD,15);
        
        lblSearch = new JLabel();
        lblSearch.setText("Search Customer Details");
        lblSearch.setFont(new Font("",Font.PLAIN,30));
        lblSearch.setForeground(Color.white);
        lblSearch.setBounds(0,0,700,70);
        lblSearch.setVerticalAlignment(JLabel.CENTER);
        lblSearch.setHorizontalAlignment(JLabel.CENTER);
        lblSearch.setBackground(new Color(255,25,25));
        lblSearch.setOpaque(true);
        
        lblCustomerId = new JLabel();
        lblCustomerId.setText("Enter Customer Id: ");
        lblCustomerId.setFont(lblFonts);
        lblCustomerId.setBounds(50, 100, 150, 20);
        
        textCustomerId = new JTextField();
        textCustomerId.setBounds(195, 100, 150, 25);
        
        lblCustomerName = new JLabel();
        lblCustomerName.setText("Name: ");
        lblCustomerName.setFont(lblFonts);
        lblCustomerName.setBounds(50, 130, 100, 20);
        
        btnSearch = new JButton();
        btnSearch.setText("Search");
        btnSearch.setForeground(Color.white);
        btnSearch.setBackground(Color.red);
        btnSearch.setFont(lblFonts);
        btnSearch.setFocusable(false);
        btnSearch.setBounds(345, 100, 100, 25);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerId = textCustomerId.getText();
                loadTableForCustomer(customerId);
            }
        });
        
        lblDetails = new JLabel();
        lblDetails.setText("Order Details");
        lblDetails.setFont(new Font("",Font.PLAIN,25));
        lblDetails.setForeground(Color.white);
        lblDetails.setBounds(0,160,700,40);
        lblDetails.setVerticalAlignment(JLabel.CENTER);
        lblDetails.setHorizontalAlignment(JLabel.CENTER);
        lblDetails.setBackground(new Color(255,25,25));
        lblDetails.setOpaque(true);
        
        String [] columnNames = {"Order ID","Order Quantity","Total"};
        dtm = new DefaultTableModel(columnNames,0);
        ordersTable = new JTable(dtm);
        
        JScrollPane tblPane=new JScrollPane(ordersTable);
        tblPane.setBounds(80, 220, 530, 250);
        
        add(lblSearch);
        add(lblCustomerId);
        add(lblCustomerName);
        add(lblDetails);
        
        add(textCustomerId);
        
        add(tblPane);
        
        add(btnSearch);
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/icon/icons8-customer-48.png")));
    } 
    
    private void loadTableForCustomer(String customerId) {
        OrderDetails[] orderArray = OrderController.toArray();
        dtm.setRowCount(0);
        for (int i = 0; i < orderArray.length; i++) {
            OrderDetails obj = orderArray[i];
            if (obj.getCustomerId().equals(customerId)) {
                Object[] rowdata = {
                    obj.getOrderId(),
                    obj.getOrderQTY(),
                    obj.getOrderValue()
                };
                dtm.addRow(rowdata);
            }
        }
    }
}
