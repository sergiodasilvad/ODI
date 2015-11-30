/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.customeraccount.business.services;

import javax.faces.context.FacesContext;

/**
 *
 * @author sergio.dasilvad
 */
public class Tools {

    public static <T> T findBean(String managedBeanName, Class<T> beanClass) {
        FacesContext context = FacesContext.getCurrentInstance();
        return beanClass.cast(context.getApplication().evaluateExpressionGet(context, "#{" + managedBeanName + "}", beanClass));
    }
}
