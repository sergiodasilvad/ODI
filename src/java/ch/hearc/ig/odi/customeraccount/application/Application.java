/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.customeraccount.application;

import ch.hearc.ig.odi.customeraccount.business.Customer;

/**
 *
 * @author sergio.dasilvad
 */
public class Application {

    public static void main(String[] args) {
        Customer aCustomer = new Customer(1, "Da Silva dos Reis", "Sergio");
        Customer anAnotherCustomer = new Customer(2, "Jeanneret", "Max");

        aCustomer.addAccount("DSDR-01", "Epargne", 3);
        aCustomer.addAccount("DSDR-02", "Courant", 1);
        anAnotherCustomer.addAccount("JM-01", "Courant", 0.1);

        aCustomer.getAccountByNumber("DSDR-01").credit(200000);
        aCustomer.getAccountByNumber("DSDR-01").debit(1000);
        aCustomer.getAccountByNumber("DSDR-02").credit(1000);
        // ERREUR NORMALEMENT
        // aCustomer.getAccountByNumber("DSDR-02").debit(2000);
        anAnotherCustomer.getAccountByNumber("JM-01").credit(200);

        aCustomer.getAccountByNumber("DSDR-01").transfer(2000, aCustomer.getAccountByNumber("DSDR-01"), anAnotherCustomer.getAccountByNumber("JM-01"));

        System.out.println("Compte :" + anAnotherCustomer.getAccountByNumber("JM-01").getNumber() + " Montant : " + anAnotherCustomer.getAccountByNumber("JM-01").getBalance());
        System.out.println("Compte :" + aCustomer.getAccountByNumber("DSDR-01").getNumber() + " Montant : " + aCustomer.getAccountByNumber("DSDR-01").getBalance());

    }

}
