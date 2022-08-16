package com.example.gui;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {
    private SimpleStringProperty userID;
    private SimpleStringProperty userNAME;
    private SimpleStringProperty userSURNAME;
    private SimpleStringProperty userCOVID;
    private SimpleStringProperty userEMAIL;

    public User(String userID, String userNAME, String userSURNAME, String userCOVID, String userEMAIL) {
        this.userID = new SimpleStringProperty(userID);
        this.userNAME = new SimpleStringProperty(userNAME);
        this.userSURNAME = new SimpleStringProperty(userSURNAME);
        this.userCOVID = new SimpleStringProperty(userCOVID);
        this.userEMAIL = new SimpleStringProperty(userEMAIL);
    }

    public String getUserID() {
        return userID.get();
    }

    public void setUserID(String userID) {
        this.userID = new SimpleStringProperty(userID);
    }

    public String getUserNAME() {
        return userNAME.get();
    }

    public void setUserNAME(String userNAME) {
        this.userNAME = new SimpleStringProperty(userNAME);
    }

    public String getUserSURNAME() {
        return userSURNAME.get();
    }

    public void setUserSURNAME(String userSURNAME) {
        this.userSURNAME = new SimpleStringProperty(userSURNAME);
    }

    public String getUserCOVID() {
        return userCOVID.get();
    }

    public void setUserCOVID(String userCOVID) {
        this.userCOVID = new SimpleStringProperty(userCOVID);
    }

    public String getUserEMAIL() {
        return userEMAIL.get();
    }

    public void setUserEMAIL(String userEMAIL) {
        this.userEMAIL = new SimpleStringProperty(userEMAIL);
    }
}
