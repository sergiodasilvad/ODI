package ch.hearc.ig.odi.customeraccount.business;

import java.util.*;

public class Customer {

    private Map<String, Account> accounts;
    private int number;
    private String firstName;
    private String lastName;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Customer() {
    }
    
    /**
     *
     * @param number
     * @param firstName
     * @param lastName
     */
    public Customer(int number, String firstName, String lastName) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new HashMap<String, Account>();
    }

    /**
     *
     * @param number
     * @return
     */
    public Account getAccountByNumber(String number) {
        return accounts.get(number);
    }

    /**
     *
     * @param number
     * @param name
     * @param rate
     */
    public Account addAccount(String number, String name, double rate) {
         return accounts.put(number, new Account(number, name, rate, this));
    }
    
    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }
    
}
