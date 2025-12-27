package org.openmap4u.managed;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.faces.context.FacesContext;
import org.openmap4u.OpenMap4u;

/**
 *
 * @author Michael Hadrbolec
 */
@Named("m4u")
@RequestScoped
public class ManagedM4u extends OpenMap4u {

    /**
     * Creates a new instance of Map4uManagedBean
     */
    public ManagedM4u() {
        super();
    }

    public void importPackages( String  packageName) {
       // for (String packageName : packageNames) {
            FacesContext.getCurrentInstance().getELContext().getImportHandler().importPackage(packageName);
       // }
    }

}
