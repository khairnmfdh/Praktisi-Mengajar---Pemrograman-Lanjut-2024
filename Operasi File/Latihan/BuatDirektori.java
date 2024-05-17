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
public class BuatDirektori {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File dir1 = new File("Folder1");
        System.out.println(dir1.mkdir());
        File file1 = new File(dir1, "File1.txt");
        System.out.println(file1.getPath());
        System.out.println(dir1.isDirectory());
    }
}
