/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Documento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import negocio.Negocio;
import negocio.ScoutException;

/**
 *
 * @author Manolo
 */
@Named(value = "controlDocumentos")
@SessionScoped
public class ControlDocumentos implements Serializable{

    private Documento doc;
    private String nombre;
    private Integer id;
    private Date fecha;
    private Integer estadoDoc;
    private List<Documento> docs = new ArrayList<>();
    
    @EJB
    private Negocio negocio;
    

    

     public ControlDocumentos() throws ScoutException {
         int cont = 1;
         Documento d1 = new Documento();
         d1.setNombre("Doc1");
         d1.setFechaSubida(new Date("32/13/2019"));
         d1.setEstadoArchivo(1);
         d1.setIdDocumento(cont);
         cont ++;
         docs.add(d1);
         //negocio.aniadirDocumento(d1);
         
         Documento d2 = new Documento();
         d2.setNombre("Doc2");
         d2.setFechaSubida(new Date("31/05/2018"));
         d2.setEstadoArchivo(0);
         d2.setIdDocumento(cont);
         cont ++;
         docs.add(d2);
        // negocio.aniadirDocumento(d2);
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getEstadoDoc() {
        return estadoDoc;
    }

    public void setEstadoDoc(Integer estadoDoc) {
        this.estadoDoc = estadoDoc;
    }

    public List<Documento> getDocs() {
        return docs;
    }

    /**
     * Creates a new instance of ControlDocumentos
     */
    public void setDocs(List<Documento> docs) {
        this.docs = docs;
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
    
    public String subirDoc(Documento doc) throws ScoutException{
        return "subirDocumento.xhtml";
    }
    
    public String descargarDoc(Documento doc) throws ScoutException{
        return "descargarDocumento.xhtml";
    }
    
    public String modificarDoc(Documento doc) throws ScoutException{
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

