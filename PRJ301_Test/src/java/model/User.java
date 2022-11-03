/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author MSI_GF63
 */
public class User {
    private String username;
    private String password;
    private ArrayList<Dummy> dummy = new ArrayList<>();
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Dummy> getDummy() {
        return dummy;
    }

    public void setDummy(ArrayList<Dummy> dummy) {
        this.dummy = dummy;
    }
    
}
