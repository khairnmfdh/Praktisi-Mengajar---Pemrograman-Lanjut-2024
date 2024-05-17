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
public class BuatFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       File file1 = new File("ContohFile1.txt");
       System.out.println(file1.getAbsolutePath());
       System.out.println(file1.exists());
    }
}
