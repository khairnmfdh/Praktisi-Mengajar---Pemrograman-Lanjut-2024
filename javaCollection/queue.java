/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.javacollection;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author KHAIRANI
 */
public class queue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue<String> queues = new ArrayDeque<>(10);
        queues.offer("Nicole");
        queues.offer("Caroline");
        queues.offer("Sydney");
        
        for(String next = queues.poll(); next != null; next = queues.poll()){
            System.out.print(" (");
            System.out.print(queues.size());
            System.out.print(")");
            System.out.println(next);
        }
        
    }
    
}
