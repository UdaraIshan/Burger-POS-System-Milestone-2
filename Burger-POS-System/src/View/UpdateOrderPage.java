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
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author ishan
 */
public class UpdateOrderPage extends JFrame {
    
    private JLabel lblUpdateOrder;
    private JLabel lblOrderId;
    private JLabel lblCustomerId;
    private JLabel lblCustomerName;
    private JLabel lblQuantity;
    private JLabel lblNetTotal;
    private JLabel lblNetTotalValue;
    private JLabel lblOrderStatus;
    
    private JButton btnUpdateOrder;
    private JButton btnSearch;
    private JButton btnAdd;
    
    private JTextField textOrderId;
    private JTextField textCustomerId;
    private JTextField textCustomerName;
    private JTextField textQuantity;
    private JTextField textOrderStatus;
    
    private OrderDetails orderDetails;
    private int quantity;
    
    public UpdateOrderPage() {
        setTitle("Update Order");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        
        Font lblFonts=new Font("",Font.BOLD,15);
        
        lblUpdateOrder = new JLabel();
        lblUpdateOrder.setText("Update Order");
        lblUpdateOrder.setFont(new Font("",Font.PLAIN,35));
        lblUpdateOrder.setForeground(Color.white);
        lblUpdateOrder.setBounds(0,0,700,70);
        lblUpdateOrder.setVerticalAlignment(JLabel.CENTER);
        lblUpdateOrder.setHorizontalAlignment(JLabel.CENTER);
        lblUpdateOrder.setBackground(new Color(255,25,25));
        lblUpdateOrder.setOpaque(true);
        
        lblOrderStatus = new JLabel();
        lblOrderStatus.setText("Order Status: ");
        lblOrderStatus.setFont(lblFonts);
        lblOrderStatus.setBounds(100, 130, 150, 20);
        
        lblOrderId = new JLabel();
        lblOrderId.setText("Order Id: ");
        lblOrderId.setFont(lblFonts);
        lblOrderId.setBounds(100, 180, 100, 20);
        
        lblCustomerId = new JLabel();
        lblCustomerId.setText("Customer Id: ");
        lblCustomerId.setFont(lblFonts);
        lblCustomerId.setBounds(100, 230, 150, 20);
        
        lblCustomerName = new JLabel();
        lblCustomerName.setText("Customer Name: ");
        lblCustomerName.setFont(lblFonts);
        lblCustomerName.setBounds(100, 280, 150, 20);
        
        lblQuantity = new JLabel();
        lblQuantity.setText("Quantity: ");
        lblQuantity.setFont(lblFonts);
        lblQuantity.setBounds(100, 330, 100, 20);
        
        lblNetTotal = new JLabel();
        lblNetTotal.setText("Total: ");
        lblNetTotal.setFont(lblFonts);
        lblNetTotal.setBounds(100, 380, 100, 20);
        
        lblNetTotalValue = new JLabel();
        lblNetTotalValue.setText("0.00");
        lblNetTotalValue.setFont(lblFonts);
        lblNetTotalValue.setBounds(270, 380, 150, 20);
        lblNetTotalValue.setForeground(Color.red);
        
        btnAdd = new JButton("ADD");
        btnAdd.setFont(lblFonts);
        btnAdd.setForeground(Color.white);
        btnAdd.setBackground(Color.red);
        btnAdd.setBounds(425, 330, 100, 25);
        btnAdd.setFocusable(false);
        btnAdd.addActionListener(evt ->{
            int quantity = Integer.parseInt(textQuantity.getText());
            double total = quantity * OrderController.burgerPrice;
            lblNetTotalValue.setText(String.valueOf(total));
        });
        
        btnUpdateOrder = new JButton();
        btnUpdateOrder.setText("Update");
        btnUpdateOrder.setForeground(Color.white);
        btnUpdateOrder.setBackground(Color.red);
        btnUpdateOrder.setFont(lblFonts);
        btnUpdateOrder.setFocusable(false);
        btnUpdateOrder.setBounds(480, 470, 100, 30);
        btnUpdateOrder.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                String orderId = textOrderId.getText();
                String customerName = textCustomerName.getText();
                String customerId = textCustomerId.getText();
                int quantity = Integer.parseInt(textQuantity.getText());
                String orderStatusStr = textOrderStatus.getText();

                int orderStatus = OrderDetails.getOrderStatusNumber(orderStatusStr);

                double netTotal = Double.parseDouble(lblNetTotalValue.getText());
                boolean success = OrderController.updateOrder(orderId, customerName, customerId, orderStatus, quantity, netTotal);
                
                ClearText();
            }
        });
        
        textOrderStatus = new JTextField();
        textOrderStatus.setBounds(270, 130, 150, 25);
        
        textOrderId = new JTextField();
        textOrderId.setBounds(270, 180, 150, 25);
        
        btnSearch = new JButton();
        btnSearch.setText("Search");
        btnSearch.setForeground(Color.white);
        btnSearch.setBackground(Color.red);
        btnSearch.setFont(lblFonts);
        btnSearch.setFocusable(false);
        btnSearch.setBounds(425, 180, 100, 25);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String orderId = textOrderId.getText();
                OrderDetails orderDetails = getOrderDetailsFromDataSource(orderId);

                if (orderDetails != null) {
                    textCustomerName.setText(orderDetails.getCustomerName());
                    textCustomerId.setText(orderDetails.getCustomerId());
                    textQuantity.setText(String.valueOf(orderDetails.getOrderQTY()));
                    lblNetTotalValue.setText(String.valueOf(orderDetails.getOrderValue()));
                    
                    String orderStatusText = getOrderStatusText(orderDetails.getOrderStatus());
                    textOrderStatus.setText(orderStatusText);
                } else {
                    lblOrderStatus.setText("Order Status: Order not found");
                }
            }
        });
        
        textCustomerId = new JTextField();
        textCustomerId.setBounds(270, 230, 150, 25);
        
        textCustomerName = new JTextField();
        textCustomerName.setBounds(270, 280, 150, 25);
        
        textQuantity = new JTextField();
        textQuantity.setBounds(270, 330, 150, 25);
        
        add(lblUpdateOrder);
        add(lblOrderId);
        add(lblCustomerId);
        add(lblCustomerName);
        add(lblQuantity);
        add(lblNetTotal);
        add(lblNetTotalValue);
        add(lblOrderStatus);
        
        add(btnUpdateOrder);
        add(btnSearch);
        add(btnAdd);
        
        add(textOrderStatus);
        add(textOrderId);
        add(textCustomerId);
        add(textCustomerName);
        add(textQuantity);

        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/icon/icons8-customer-48.png")));
        
    }
    
    private OrderDetails getOrderDetailsFromDataSource(String orderId) {
         OrderDetails[] orderArray = OrderController.toArray();
        for (int i = 0; i < orderArray.length; i++) {
            OrderDetails obj = orderArray[i];
            if (obj.getOrderId().equals(orderId)) {
                return obj;
            }
        }
        return null;
    }
    
    private String getOrderStatusText(int orderStatus) {
        String statusText;
        switch (orderStatus) {
            case 0:
                statusText = "CANCEL";
                break;
            case 1:
                statusText = "PREPARING";
                break;
            case 2:
                statusText = "DELETED";
                break;
            default:
                statusText = "Unknown";
                break;
        }
        return statusText;
    }
    
    private void ClearText(){
        textOrderId.setText(null);
        textCustomerId.setText(null);
        textCustomerName.setText(null);
        textQuantity.setText(null);
        lblNetTotalValue.setText("0.00");
        textOrderStatus.setText(null);
    }
}
