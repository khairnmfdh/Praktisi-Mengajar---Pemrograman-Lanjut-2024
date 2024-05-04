/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javacollection;

import java.util.List;

/**
 *
 * @author KHAIRANI
 */
public class iterable {

    public static void main(String[] args) {
        Iterable<String> names = List.of("Khai", "Matt", "Dan");
        
        for(var name: names){
            System.out.println(name);
        }
    }
}
