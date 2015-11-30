/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.customeraccount.business.services;

import ch.hearc.ig.odi.customeraccount.business.Customer;
import ch.hearc.ig.odi.customeraccount.business.services.Services;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sergio.dasilvad
 */

@Named(value="customerBean")
@RequestScoped // Liste souvent en requete scoped

// Lié à une page (un formulaire par exemple). Couche de services permettant de ne pas avoir une classe services trop grandes
public class CustomerBean implements Serializable{

    // Injection de la classe Services
    @Inject Services services;
    
    public CustomerBean() {
    }
    
    /**
     * Récupère la liste des clients
     * @return 
     */
    public List<Customer> getCustomers(){
        System.out.println(services.getCustomersList().size());
        return services.getCustomersList();
    }
    
    /**
     * Affiche le détail d'un client
     * 1. Récupération du bean pouvant afficher le détail du client (customerDetailBean)
     * 2. Récupère le client par son numero et set le customerDetailBean
     * 3. Retourne de la chaine succès pour une redirection
     * @param number
     * @return
     */
    public String displayCustomer(int number){
        CustomerDetailBean customerDetailBean = Tools.findBean("customerDetailBean", CustomerDetailBean.class);
        
        Customer customer = services.getCustomer(number);        
        customerDetailBean.setNumber(customer.getNumber());
        customerDetailBean.setFirstName(customer.getFirstName());
        customerDetailBean.setLastName(customer.getLastName());
        customerDetailBean.setAccounts(new ArrayList(customer.getAccounts().values()));
        
        return "success";
    }
}
