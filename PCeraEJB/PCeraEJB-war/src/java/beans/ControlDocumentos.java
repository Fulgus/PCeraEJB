/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Documento;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Manolo
 */
@Named(value = "controlDocumentos")
@RequestScoped
public class ControlDocumentos {

    private Documento doc;
    /**
     * Creates a new instance of ControlDocumentos
     */
    public ControlDocumentos() {
    }

    public Documento getDoc() {
        return doc;
    }

    public void setDoc(Documento doc) {
        this.doc = doc;
    }
    
    public String volverPerfil(){
        return "perfilEducando.xhtml";
    }
    
    public String subirDoc(){
        return "subirDocumento.xhtml";
    }
    
    public String descargarDoc(){
        return "descargarDocumento.xhtml";
    }
    
    public String modificarDoc(){
        return "modificarDocumento.xhtml";
    }
    
    public String volverDocsPrincipal(){
        return "documentosPrincipal.xhtml";
    }
    
    public String uploadDoc(){
        return "documentoSubido.xhtml";
    }
    
    public String docSubido(){
        return "documentosPrincipal.xhtml";
    }
}

