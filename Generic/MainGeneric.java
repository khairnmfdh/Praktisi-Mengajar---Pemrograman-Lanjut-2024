/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.generic1;

/**
 *
 * @author KHAIRANI
 */
public class MainGeneric {
    public static void main(String args[]) {
        Generic1<String> objGeneric = new Generic1<String>("halo");

        String input = objGeneric.getDataT();
        System.out.println(input);
        objGeneric.displayType();

    }
}
