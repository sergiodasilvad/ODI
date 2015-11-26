package ch.hearc.ig.odi.customeraccount.business;

import java.util.*;

public class Bank {

    
    private int number;
    private String name;
    private Collection<Account> accounts;
    private Collection<Customer> customers;

    public Bank() {
    }

    /**
     *
     * @param number
     * @param name
     */
    
    public Bank(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    
    /**
     *
     * @param number
     * @return
     */
    public Account getAccountByNumber(String number) {
        Account anAccount = new Account();
        for (Account ac : accounts) {
            if (ac.getNumber().equals(number)) {
                anAccount = ac;
            }
        }
       
        return anAccount;
    }
    
    public Customer getCustomerByNumber(int number) {
        Customer aCustomer = new Customer();
        for (Customer cust : customers) {
            if (cust.getNumber() == number) {
                aCustomer = cust;
            }
        }
       
        return aCustomer;
    }
    

    /**
     *
     * @param number
     * @param name
     * @param rate
     * @param customer
     */
    public void addAccount(String number, String name, double rate,Customer customer) {
        this.accounts.add(new Account(number, name, rate, customer));
    }
    
     public void addCustomer(int number, String firstName, String lastName) {
        this.customers.add(new Customer(number, firstName, lastName));
    }

}
