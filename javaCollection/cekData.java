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
public class cekData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>();
        names.addAll(Arrays.asList("Hailey", "Justin", "Selena"));
        System.out.print("Apakah justin ada dalam data? ");
        System.out.println(names.contains("Justin"));
         System.out.println("Current Data: ");
        for(var name : names){
            System.out.println(name);
        }
        
        names.remove("Justin");
        System.out.print("\nApakah justin ada dalam data? ");
        System.out.println(names.contains("Justin"));
        System.out.println("Updated Data:");
        for(var name : names){
            System.out.println(name);
        }
    }
    
}
