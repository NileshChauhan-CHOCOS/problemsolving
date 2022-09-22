package com.practice.singleton.modelcalss;

public class Employee {
    private final String firstName;
    private final String lastName;
    private static Employee instance = null;
    private Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Employee getInstance(String firstName, String lastName){
        if(instance == null){
            instance = new Employee(firstName, lastName);
        }
        return instance;
    }

    public String toString(){
        return this.firstName + " " + this.lastName;
    }
}
