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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ishan
 */
public class SearchBestCustomerPage extends JFrame {
    
    private JLabel lblSearchBestCustomer;
    private DefaultTableModel dtm;
    private JTable ordersTable;
    private JScrollPane tblPane;
    
    public SearchBestCustomerPage() {
        setTitle("Search Best Customer");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        
        Font lblFonts=new Font("",Font.BOLD,15);
        
        lblSearchBestCustomer = new JLabel();
        lblSearchBestCustomer.setText("Search Best Customer");
        lblSearchBestCustomer.setFont(new Font("",Font.PLAIN,30));
        lblSearchBestCustomer.setForeground(Color.white);
        lblSearchBestCustomer.setBounds(0,0,700,70);
        lblSearchBestCustomer.setVerticalAlignment(JLabel.CENTER);
        lblSearchBestCustomer.setHorizontalAlignment(JLabel.CENTER);
        lblSearchBestCustomer.setBackground(new Color(255,25,25));
        lblSearchBestCustomer.setOpaque(true);
        
        String [] columnNames = {"Customer ID","Customer Name","Total"};
        dtm = new DefaultTableModel(columnNames,0);
        ordersTable = new JTable(dtm);
        
        JScrollPane tblPane=new JScrollPane(ordersTable);
        tblPane.setBounds(90, 110, 500, 400);
        
        add(tblPane);
        add(lblSearchBestCustomer);
        loadTable();
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/icon/icons8-customer-48.png")));
    }
    
    private void loadTable(){
        OrderDetails [] orderArray = OrderController.toArray();
        
        for (int i = 0; i < orderArray.length - 1; i++) {
            for (int j = 0; j < orderArray.length - i - 1; j++) {
                if ((orderArray[j].getOrderValue()) < (orderArray[j + 1].getOrderValue())) {
                    // Swap elements
                    OrderDetails temp = orderArray[j];
                    orderArray[j] = orderArray[j + 1];
                    orderArray[j + 1] = temp;
                }
            }
        }
        
        dtm.setRowCount(0);
        for(int i = 0; i < orderArray.length; i++){
            OrderDetails obj = orderArray[i];
            Object[] rowdata={
                obj.getCustomerId(),
                obj.getCustomerName(),
                obj.getOrderValue()
            };
            dtm.addRow(rowdata);
        }
    }
    
}
