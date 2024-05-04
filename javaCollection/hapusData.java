/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.javacollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author KHAIRANI
 */
public class hapusData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>();
        names.addAll(Arrays.asList("Harry", "Niall", "Louis", "Liam", "Zayn"));
        System.out.println("data nama sebelum diremove: ");
        for(var name: names){
            System.out.println(name);
        }
        
        names.remove("Zayn");
        System.out.println("\ndata nama setelah diremove: ");
        for(var name: names){
            System.out.println(name);
        }
    }
    
}
