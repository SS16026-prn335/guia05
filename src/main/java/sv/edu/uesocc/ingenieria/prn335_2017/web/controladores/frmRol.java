/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.controladores;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.RolFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.Rol;

/**
 *
 * @author luis
 */
@Named
@ViewScoped
public class frmRol implements Serializable {

    @EJB
    private RolFacadeLocal rolEJB;
    private Rol r;
    private List<Rol> roles;

    @PostConstruct
    public void init() {
        roles = rolEJB.findAll();
        r = new Rol();
        r.setIdRol(null);
        r.setNombre("");
        r.setActivo(false);
        r.setDescripcion("");
    }
    
    
    /**
     * manda a llamar los datos de la variable
     * @return 
     */
    public List<Rol> getRoles() {
        return roles;
    }
    
    /**
     * se le asigna los valores a la variable
     * @param roles 
     */
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    /**
     * manda a llamar los datos de la variable
     * @return 
     */
    public Rol getR() {
        return r;
    }

    /**
     * se le asigna los valores a la variable
     * @param r 
     */
    public void setR(Rol r) {
        this.r = r;
    }

    /**
     * metodo sirve para guardar los campos ingresados
     * @return 
     */
    public String guardar() {
        if (r != null) {
            System.out.println("¡¡SI HA INGRESADO DATOS!!");
            rolEJB.create(r);
            roles = rolEJB.findAll();
        } else {
            System.out.println("¡¡NO INGRESO DATOS: NULL!!");
        }
        r = new Rol();
        return "c_guardar";
    }
    
    /**
     * metodo usado para limpiar la interfaz del usuario
     * @return 
     */
    public String limpiar() {
        System.out.println("ENTRO AL LIMPIADOR");
        r = new Rol();
        r.setIdRol(null);
        r.setNombre("");
        r.setActivo(false);
        r.setDescripcion("");
        return "Ola";
    }

}
