/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.io.*;
/**
 *
 * @author KHAIRANI
 */
public class DemoEksepsi1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
       File test = new File("c:\test.txt");
       test.createNewFile();
    }catch (IOException e){
        System.out.println("IO Exception sudah ditangani");
    }
    }
}
