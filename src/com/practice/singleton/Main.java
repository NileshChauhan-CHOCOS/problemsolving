package com.practice.singleton;

import com.practice.singleton.modelcalss.Employee;

public class Main {
    public static void main(String[] args){
        Employee emp = Employee.getInstance("ABC", "XYZ");
        Employee employee = Employee.getInstance("PQR", "LMN");
        System.out.println(employee.equals(emp));
        System.out.println(emp.toString());
        System.out.println(employee.toString());
    }
}
