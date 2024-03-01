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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ishan
 */
public class PlaceOrderPage extends JFrame {
    
    private JLabel lblPlaceOrder;
    
    private JLabel lblOrderId;
    private JLabel lblCustomerId;
    private JLabel lblCustomerName;
    private JLabel lblQuantity;
    private JLabel lblNetTotal;
    private JLabel lblNetTotalValue;
    
    private JTextField txtOrderId;
    private JTextField txtCustomerName;
    private JTextField txtCustomerId;
    private JTextField txtQuantity;
    
    private JButton btnAddingTotal;
    private JButton btnPlaceOrder;
    private JButton btnCancel;
    
    private int quantity;
    
    public PlaceOrderPage() {
        setTitle("Place Order");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        
        Font lblFonts=new Font("",Font.BOLD,15);
        
        lblPlaceOrder = new JLabel();
        lblPlaceOrder.setText("Place Order");
        lblPlaceOrder.setFont(new Font("",Font.PLAIN,40));
        lblPlaceOrder.setForeground(Color.white);
        lblPlaceOrder.setBounds(0,0,500,70);
        lblPlaceOrder.setVerticalAlignment(JLabel.CENTER);
        lblPlaceOrder.setHorizontalAlignment(JLabel.CENTER);
        lblPlaceOrder.setBackground(new Color(255,25,25));
        lblPlaceOrder.setOpaque(true);
        
        lblOrderId = new JLabel();
        lblOrderId.setText("Order Id: ");
        lblOrderId.setFont(lblFonts);
        lblOrderId.setBounds(50, 100, 100, 20);
        
        lblCustomerId = new JLabel();
        lblCustomerId.setText("Customer Id: ");
        lblCustomerId.setFont(lblFonts);
        lblCustomerId.setBounds(50, 150, 150, 20);
        
        lblCustomerName = new JLabel();
        lblCustomerName.setText("Customer Name: ");
        lblCustomerName.setFont(lblFonts);
        lblCustomerName.setBounds(50, 200, 150, 20);
        
        lblQuantity = new JLabel();
        lblQuantity.setText("Quantity: ");
        lblQuantity.setFont(lblFonts);
        lblQuantity.setBounds(50, 250, 100, 20);
        
        lblNetTotal = new JLabel();
        lblNetTotal.setText("Net Total: ");
        lblNetTotal.setFont(lblFonts);
        lblNetTotal.setBounds(50, 300, 100, 20);
        
        lblNetTotalValue = new JLabel();
        lblNetTotalValue.setText("0.00");
        lblNetTotalValue.setFont(lblFonts);
        lblNetTotalValue.setBounds(150, 300, 100, 20);
        lblNetTotalValue.setForeground(Color.red);
        
        txtOrderId = new JTextField("O000");
        txtOrderId.setEditable(false);
        txtOrderId.setBounds(130, 100, 100, 20);
        txtOrderId.setText(OrderController.generateOrderId());
        
        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(180, 200, 150, 25);
        
        txtCustomerId=new JTextField();
        txtCustomerId.setBounds(160, 150, 150, 25);
        txtCustomerId.setEditable(false);
        txtCustomerId.setText(OrderController.generateCustomerId());
        
        txtQuantity = new JTextField();
        txtQuantity.setBounds(140, 250, 150, 25);
        
        btnAddingTotal = new JButton("ADD");
        btnAddingTotal.setFont(lblFonts);
        btnAddingTotal.setForeground(Color.white);
        btnAddingTotal.setBackground(Color.red);
        btnAddingTotal.setBounds(290, 250, 90, 25);
        btnAddingTotal.setFocusable(false);
        btnAddingTotal.addActionListener(evt ->{
            quantity=Integer.parseInt(txtQuantity.getText());
            quantity*=OrderController.burgerPrice;
            lblNetTotalValue.setText(quantity+"/=");
        });
        
        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.setFont(lblFonts);
        btnPlaceOrder.setForeground(Color.white);
        btnPlaceOrder.setBackground(Color.red);
        btnPlaceOrder.setBounds(300, 400, 150, 40);
        btnPlaceOrder.setFocusable(false);
        btnPlaceOrder.addActionListener(evt ->{
            System.out.println("Order placed..");
            OrderDetails orderObj = new OrderDetails(
                txtOrderId.getText(),
                txtCustomerId.getText(),
                txtCustomerName.getText(),
                1,
                    Integer.parseInt(txtQuantity.getText()),
                    quantity
            );
            System.out.println(orderObj);
            OrderController.add(orderObj);
            ClearText();
            setNextId();
        });
        
        btnCancel = new JButton("Cancel");
        btnCancel.setFont(lblFonts);
        btnCancel.setForeground(Color.white);
        btnCancel.setBackground(Color.red);
        btnCancel.setBounds(190, 400, 100, 40);
        btnCancel.setFocusable(false);
        btnCancel.addActionListener(evt ->{
            ClearText();
        });
        
        add(lblPlaceOrder);
        add(lblOrderId);
        add(lblCustomerId);
        add(lblCustomerName);
        add(lblQuantity);
        add(lblNetTotal);
        add(lblNetTotalValue);
        
        add(txtOrderId);
        add(txtCustomerName);
        add(txtCustomerId);
        add(txtQuantity);
        
        add(btnAddingTotal);
        add(btnPlaceOrder);
        add(btnCancel);
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/icon/icons8-customer-48.png")));
    }
    
    private void ClearText(){
        txtCustomerName.setText(null);
        txtQuantity.setText(null);
        lblNetTotalValue.setText("0.00");
    }
    
    private void setNextId(){
        txtCustomerId.setText(OrderController.generateCustomerId());
        txtOrderId.setText(OrderController.generateOrderId());
    }
}
