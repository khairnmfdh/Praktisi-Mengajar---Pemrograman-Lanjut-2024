/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.antreancatsalon.model;

import com.mycompany.antreancatsalon.*;

public class Cat {
    private String catName;
    private String breed;
    private int catAge;
    private String service;
    private String date;

    public Cat(String catName, String breed, int catAge, String service, String date) {
        this.catName = catName;
        this.breed = breed;
        this.catAge = catAge;
        this.service = service;
        this.date = date;
    }
    
    public String getCatName(){
        return catName;
    }
    public String getBreed(){
        return breed;
    }
    public int getCatAge(){
        return catAge;
    }
    public String getService(){
        return service;
    }
    public String getDate(){
        return date;
    }
    
    @Override
    public String toString() {
        return "Cat{name='" + catName + "', breed='" + breed + "age='"+catAge+"}";
    }
}

