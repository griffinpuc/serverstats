package com.griffinpuc.serverstats.Library;

import java.sql.Timestamp;

public class User {

    private String uuid;
    private String userName;
    private Timestamp lastLogin;
    private Timestamp firstLogin;

    public User(String uuid, String userName, Timestamp firstLogin, Timestamp lastLogin){
        this.uuid = uuid;
        this.userName = userName;
        this.firstLogin = firstLogin;
        this.lastLogin = lastLogin;
    }

    public String getUuid(){
        return this.uuid;
    }

    public String getUserName(){
        return this.userName;
    }

    public Timestamp getFirstLogin(){
        return this.firstLogin;
    }

    public Timestamp getLastLogin(){
        return this.lastLogin;
    }

}
