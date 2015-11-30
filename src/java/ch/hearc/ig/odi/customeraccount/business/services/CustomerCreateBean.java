/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.customeraccount.business.services;

import ch.hearc.ig.odi.customeraccount.business.services.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sergio.dasilvad
 */
@Named
@RequestScoped

// Lié à une page (un formulaire par exemple). Couche de services permettant de ne pas avoir une classe services trop grandes
public class CustomerCreateBean implements Serializable{

    @Inject Services services;

    private int number;
    private String firstName;
    private String lastName;
    
    public CustomerCreateBean() {
    }
    
    public String addCustomer(){
        services.saveCustomer(number, firstName, lastName);
        
        return "success";
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
