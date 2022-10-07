package com.practice.singleton.threadsafe.and.performance;

import java.util.concurrent.locks.ReentrantLock;


// Performance increased thread
public class DBConnection {
    private final String port;
    private final String userName;
    private final String password;

    private static DBConnection instance=null;
    private DBConnection(String userName, String password, String port){
        this.userName=userName;
        this.password=password;
        this.port=port;
    }
    public static DBConnection getInstance(String userName, String password, String port){
        if (instance == null){
               synchronized (DBConnection.class){
                   if(instance == null){
                       instance = new DBConnection(userName, password, port);
                   }
               }
        }
        return instance;
    }

    public String toString(){
        return "port : " + this.port + " , " + "username : " + this.userName+ " , " + "password : " + this.password;
    }
}
