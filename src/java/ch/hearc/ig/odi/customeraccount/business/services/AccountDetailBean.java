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

    private Account account;
    
    public AccountDetailBean(){
        
    }

    public String returnToCustomer(){
        CustomerBean customerBean = Tools.findBean("customerBean", CustomerBean.class);
        customerBean.displayCustomer(account.getCustomer());
        return "success";
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
