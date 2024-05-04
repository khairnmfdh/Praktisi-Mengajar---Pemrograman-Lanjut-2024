/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.javacollection;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author KHAIRANI
 */
public class dequeue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Deque<String> stack = new LinkedList<>();
       
       stack.offerLast("Khai");
       stack.offerLast("Zayn");
       stack.offerLast("Gigi");
       
       for(var item= stack.pollLast(); item != null; item = stack.pollLast()){
           System.out.println(item);
       }
    }
    
}
