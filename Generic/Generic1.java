/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.generic1;

/**
 *
 * @author KHAIRANI
 */
public class Generic1 <T>{
    private T data;
    
    public Generic1(T data){
        this.data = data;
    }
    public T getDataT(){
        return data;
    }
    public void setDataT(T data){
        this.data = data;
        
    }
    public void displayType(){
        System.out.println("Tipe data:"+data.getClass().getName());
    }
}
