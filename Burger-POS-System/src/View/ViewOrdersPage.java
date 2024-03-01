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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ishan
 */
public class ViewOrdersPage extends JFrame{
    
    private JLabel lblViewOrder;
    private DefaultTableModel dtm;
    private JTable ordersTable;
    private JScrollPane tblPane;
    
    public ViewOrdersPage() {
        setTitle("View Orders");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        
        lblViewOrder = new JLabel();
        lblViewOrder.setText("View Orders");
        lblViewOrder.setFont(new Font("",Font.PLAIN,40));
        lblViewOrder.setForeground(Color.white);
        lblViewOrder.setBackground(Color.red);
        lblViewOrder.setBounds(0, 0, 800, 70);
        lblViewOrder.setVerticalAlignment(JLabel.CENTER);
        lblViewOrder.setHorizontalAlignment(JLabel.CENTER);
        lblViewOrder.setOpaque(true);
        
        String [] columnNames = {"Order ID","Customer ID","Customer Name","Order Status","Quantity","Total"};
        dtm = new DefaultTableModel(columnNames,0);
        ordersTable = new JTable(dtm);
        
        JScrollPane tblPane=new JScrollPane(ordersTable);
        tblPane.setBounds(70, 80, 650, 400);
        
        add(lblViewOrder);
        add(tblPane);
        
        loadTable();
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/icon/icons8-customer-48.png")));
    }
    
    private void loadTable(){
        OrderDetails [] orderArray = OrderController.toArray();
        dtm.setRowCount(0);
        for(int i = 0; i < orderArray.length; i++){
            OrderDetails obj = orderArray[i];
            Object[] rowdata={
                obj.getOrderId(),
                obj.getCustomerId(),
                obj.getCustomerName(),
                obj.getOrderStatus(),
                obj.getOrderQTY(),
                obj.getOrderValue()
            };
            dtm.addRow(rowdata);
        }
    }
}
