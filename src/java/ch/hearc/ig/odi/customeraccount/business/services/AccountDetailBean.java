/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.customeraccount.business.services;

import ch.hearc.ig.odi.customeraccount.business.Account;
import ch.hearc.ig.odi.customeraccount.business.Customer;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sergio.dasilvad
 */

@Named(value="accountDetailBean")
@SessionScoped
public class AccountDetailBean implements Serializable{

    @Inject Services services;

    //private Customer customer;
    private int numCustomer;
    private String number;
    private String name;
    private double balance;
    private double rate;

    public String returnToCustomer(){
        CustomerBean customerBean = Tools.findBean("customerBean", CustomerBean.class);
        customerBean.displayCustomer(numCustomer);
        return "success";
    }

    public int getNumCustomer() {
        return numCustomer;
    }

    public void setNumCustomer(int numCustomer) {
        this.numCustomer = numCustomer;
    }    
    
   
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

}
