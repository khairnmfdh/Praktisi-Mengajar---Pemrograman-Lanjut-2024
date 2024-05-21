/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author KHAIRANI
 */
import javax.swing.*;  
public class TextAreaExample  
{  
     TextAreaExample(){  
        JFrame f= new JFrame();  
        JTextArea area=new JTextArea("Type here");  
        area.setBounds(10,30, 200,200);  
        f.add(area);  
        f.setSize(300,300);  
        f.setLayout(null);  
        f.setVisible(true);  
     }  
public static void main(String args[])  
    {  
   new TextAreaExample();  
    }}  
