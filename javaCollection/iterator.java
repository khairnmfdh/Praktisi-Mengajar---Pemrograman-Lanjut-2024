/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.javacollection;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author KHAIRANI
 */
public class iterator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> names = List.of("KHAIII", "MATT", "DANIEL", "VICTORIA");
       Iterator<String> iterator = names.iterator();
       
       while(iterator.hasNext()){
           String name = iterator.next();
           System.out.println(name);
       }
    }
    
}
