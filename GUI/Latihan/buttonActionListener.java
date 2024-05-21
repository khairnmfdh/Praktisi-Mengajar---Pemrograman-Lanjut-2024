/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author KHAIRANI
 */
import java.awt.event.*;  
import javax.swing.*;    
public class buttonActionListener {  
public static void main(String[] args) {  
    JFrame f=new JFrame("Button Example");  
    final JTextField tf=new JTextField();  
    tf.setBounds(50,50, 150,20);  
    JButton b=new JButton("Click Here");  
    b.setBounds(50,100,95,30);  
    b.addActionListener((ActionEvent e) -> {
        tf.setText("Welcome to Javatpoint.");  
    });  
    f.add(b);f.add(tf);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);   
}  
} 
