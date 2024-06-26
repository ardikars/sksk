package com.example;

public class Student {
    private String Nim;
    private String Name;
    private String Address;
    private String Major;
    private int Age;

    public Student(String Nim, String Name, String Address, String Major, int Age){
        this.Nim = Nim;
        this.Name = Name;
        this.Address = Address;
        this.Major = Major;
        this.Age = Age;
    }

    public String getName(){
        return this.Name;
    }    

    public String getNim(){
        return this.Nim;
    }    

    public String getAddres(){
        return this.Address;
    }    

    public String getMajor(){
        return this.Major;
    }    

    public int getAge(){
        return this.Age;
    }    
}
