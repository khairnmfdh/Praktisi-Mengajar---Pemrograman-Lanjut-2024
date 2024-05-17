/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.operasifile;

import java.io.File;

/**
 *
 * @author KHAIRANI
 */
public class Seperator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String folders = "data"+File.separator +"save";
        System.out.println("Creating folder"+folders);
        File dir = new File(folders);
        System.out.println(dir.getAbsolutePath());
    }
    
}
