/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author KHAIRANI
 */
import javax.swing.*;      

public class imageDisplay {    
    public imageDisplay() {    
        JFrame f = new JFrame("Button Example");            
        JButton b = new JButton(new ImageIcon("C:\\Users\\KHAIRANI\\Downloads\\Green Mountain Adventure Logo.png"));
        b.setBounds(100, 400, 400, 300);    
        f.add(b);    
        f.setSize(900, 900);    
        f.setLayout(null);    
        f.setVisible(true);    
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    }         
    
    public static void main(String[] args) {   
        new imageDisplay();
    }    
}

