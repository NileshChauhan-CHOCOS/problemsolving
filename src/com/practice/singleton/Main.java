package com.practice.singleton;

import com.practice.singleton.modelcalss.Employee;
import com.practice.singleton.threadsafe.DataBaseConnection;
import com.practice.singleton.threadsafe.and.performance.DBConnection;

public class Main {
    public static void main(String[] args){
        Employee emp = Employee.getInstance("ABC", "XYZ");
        Employee employee = Employee.getInstance("PQR", "LMN");
        System.out.println(employee.equals(emp));
        System.out.println(emp.toString());
        System.out.println(employee.toString());

        DataBaseConnection dbConnection= DataBaseConnection.getDbConnection("XYZ", "LMN", "2700");
        System.out.println(dbConnection.toString());

        DBConnection dbConnection1 = DBConnection.getInstance("XYZ", "PQR", "2707");
        System.out.println(dbConnection1.toString());
    }
}
