package ch.hearc.ig.odi.customeraccount.business;

import java.util.HashSet;
import ch.hearc.ig.odi.customeraccount.business.Customer;
import ch.hearc.ig.odi.customeraccount.business.Account;
import java.util.HashMap;
import java.util.Map;

public class Bank {

    private int number;
    private String name;
    private Map<String, Account> accounts;
    private Map<Integer, Customer> customers;

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

        customers = new HashMap<Integer, Customer>();
        accounts = new HashMap<String, Account>();
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

        if (accounts.containsKey(number)) {
            anAccount = accounts.get(number);
        }

        return anAccount;
    }

    public Customer getCustomerByNumber(int number) {
        Customer aCustomer = new Customer();

        if (customers.containsKey(number)) {
            aCustomer = customers.get(number);
        }

        return aCustomer;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public Map<Integer, Customer> getCustomers() {
        return customers;
    }

    /**
     *
     * @param number
     * @param name
     * @param rate
     * @param customer
     */
    public void addAccount(String number, String name, double rate, Customer customer) {
        customer.addAccount(number, name, rate);
        accounts.put(number, customer.getAccountByNumber(number));
    }

    public void addCustomer(int number, String firstName, String lastName) {
        Customer customer = new Customer(number, firstName, lastName);
        customers.put(customer.getNumber(), customer);
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getNumber(), customer);
    }
    
    public void CreateCustomers(){
            Customer cust = new Customer(1, "Jean", "Dupont");
            addCustomer(cust);
            addAccount("1", "Salaire", 0.001, cust);
            addAccount("2", "Impots", 0.002, cust);
            
            Customer cust2 = new Customer(2, "Marie", "Froideveau");
            addCustomer(cust2);
            addAccount("3", "Epargne", 0.002, cust2);
            addAccount("4", "Salaire", 0.001, cust2);
            
        }

}
