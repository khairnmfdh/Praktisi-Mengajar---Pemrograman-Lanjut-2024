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
public class tambahData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Collection<String> names1 = new ArrayList<>();
        names1.add("KHAIII");
        names1.addAll(Arrays.asList("MATTHEW", "DANIEL"));
        
        for(var name: names1){
            System.out.println(name);
        }
    }
}
