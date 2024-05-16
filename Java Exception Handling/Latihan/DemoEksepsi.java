/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author KHAIRANI
 */
public class DemoEksepsi {
public static void main(String[] args) {
    try{
        int []arr = new int[11];
        System.out.print(arr[11]);
        System.out.println("Baris ini tidak pernah dieksekusi");
    } catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Terjadi eksepsi karena index melebihi kapasitas");
    }
    System.out.println("Setelah blok try-catch");
    }
}