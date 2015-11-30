/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.customeraccount.business.services;

import ch.hearc.ig.odi.customeraccount.business.Account;
import ch.hearc.ig.odi.customeraccount.business.Customer;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sergio.dasilvad
 */

@Named(value="customerDetailBean")
@SessionScoped
public class CustomerDetailBean implements Serializable{

    @Inject Services services;

    private int number;
    private String firstName;
    private String lastName;
    private List<Account> accounts;
    
    public String detailAccount(String number, int customerNumber){
        AccountDetailBean accountDetailBean = Tools.findBean("accountDetailBean", AccountDetailBean.class);
        
        for(Account account: accounts){
            if(account.getNumber().equals(number)){
                accountDetailBean.setNumber(account.getNumber());
                accountDetailBean.setNumCustomer(customerNumber);
                accountDetailBean.setName(account.getName());
                accountDetailBean.setBalance(account.getBalance());
                accountDetailBean.setRate(account.getRate());
            }
        }
       
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

}
