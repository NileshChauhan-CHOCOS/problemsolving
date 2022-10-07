package com.practice.singleton.threadsafe;

// Not work in concurrent environment
public class DataBaseConnection {
    private String port=null;
    private String userName=null;
    private String password=null;
    private static DataBaseConnection dbConnection=null;
    private DataBaseConnection(String port, String userName, String password){
        this.password = password;
        this.userName=userName;
        this.port=port;
    }

    public synchronized static DataBaseConnection getDbConnection(String userName, String password, String port){
        if(dbConnection == null){
            dbConnection = new DataBaseConnection(port, userName, password);
        }
        return dbConnection;
    }

    public String toString(){
        return "port : " + this.port + " , " + "username : " + this.userName+ " , " + "password : " + this.password;
    }
}
