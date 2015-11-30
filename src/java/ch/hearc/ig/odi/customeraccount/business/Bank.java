package ch.hearc.ig.odi.customeraccount.business;

import java.util.*;

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
     * @return
     */
    public Account addAccount(String number, String name, double rate, Customer customer) {
        customer.addAccount(number, name, rate);
        return accounts.put(number, customer.getAccountByNumber(number));
    }

    public Customer addCustomer(int number, String firstName, String lastName) {
        Customer customer = new Customer(number, firstName, lastName);
        return customers.put(customer.getNumber(), customer);
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getNumber(), customer);
    }

}
