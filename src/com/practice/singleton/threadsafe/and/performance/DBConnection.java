package com.practice.singleton.threadsafe.and.performance;

import java.util.concurrent.locks.ReentrantLock;


// Performance increased thread
public class DBConnection {
    private final String port;
    private final String userName;
    private final String password;

    private static DBConnection instance=null;
    private static final ReentrantLock lock = new ReentrantLock();
    private DBConnection(String userName, String password, String port){
        this.userName=userName;
        this.password=password;
        this.port=port;
    }
    public static DBConnection getInstance(String userName, String password, String port){
        if (instance == null){
                lock.lock();
                if(instance == null){
                    instance = new DBConnection(userName, password, port);
                }
                lock.unlock();
        }
        return instance;
    }

    public String toString(){
        return "port : " + this.port + " , " + "username : " + this.userName+ " , " + "password : " + this.password;
    }
}
