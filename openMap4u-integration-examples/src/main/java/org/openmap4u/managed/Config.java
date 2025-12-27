/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.managed;

import jakarta.annotation.PostConstruct;
import jakarta.el.ELContextEvent;
import jakarta.el.ELContextListener;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Named;
import jakarta.faces.context.FacesContext;

@Named
@ApplicationScoped
public class Config {

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        // Observer method to force bean initialization
        registerListener();
    }

    @PostConstruct
    public void registerListener() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context != null) {
            context.getApplication().addELContextListener(new ELContextListener() {
                @Override
                public void contextCreated(ELContextEvent event) {
                    event.getELContext().getImportHandler().importPackage("org.m4u.plugin.builder.core");
                }
            });
        }
    }

}