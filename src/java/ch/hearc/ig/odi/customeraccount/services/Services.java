/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.customeraccount.services;

import ch.hearc.ig.odi.customeraccount.business.Bank;
import ch.hearc.ig.odi.customeraccount.business.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 * Classe de services qui stocke les données de l'application dans la session de
 * l'utilisateur. Cette classe est gérée par CDI et peut donc être injectée dans
 * les autres classes Java.
 *
 * @author julien.plumez
 */
@SessionScoped
@Stateful // Quand ce n'est pas un bean, ilaut spécifier Stateful ou stateless le @Named et @SessionScoped permet de ne pas spécifier pour le bean
public class Services implements Serializable {

    private Bank bank;

    public Services() {
        bank = new Bank(1, "Raiffeisen Neuchâtel");
                
        bank.CreateCustomers();
    }

    /**
     * Dit à la banque de créer un nouveau client.
     *
     * @param number Le numéro unique du client
     * @param fn Le prénom du client
     * @param ln Le nom du client
     */
    public void saveCustomer(Integer number, String fn, String ln) {
        Customer cust = new Customer(number, fn, ln);
        bank.addCustomer(cust);
    }

    /**
     * Retourne le client de la banque qui correspond au numéro passé en
     * paramètre.
     *
     * @param number Le numéro du client à rechercher
     * @return Le client, ou null s'il n'est pas trouvé
     */
    public Customer getCustomer(Integer number) {
        return bank.getCustomerByNumber(number);
    }

    /**
     * Retourne une Map contenant tous les clients de la banqe
     *
     * @return Une Map contenant tous les clients de la banqe
     */
    public Map<Integer, Customer> getCustomers() {
        return (Map<Integer, Customer>) bank.getCustomers();

    }

    /**
     * Retourne une List contenant tous les clients de la banque. Utile pour
     * l'affichage des clients dans les facelets
     *
     * @return Une List contenant tous les clients de la banque.
     */
    public List<Customer> getCustomersList() {
        return new ArrayList(getCustomers().values());
    }
}
