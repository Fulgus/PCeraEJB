/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entidades.Cuota;
import entidades.Documento;
import entidades.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import negocio.Negocio;
import negocio.ScoutException;

/**
 *
 * @author Juan Antonio
 */
@Named(value = "controlPerfilAdministrador")
@SessionScoped
public class controlPerfilAdministrador implements Serializable {
    
    @EJB
    private Negocio negocio;
    
    private List<Usuario> l = new ArrayList<>();
    private List<Documento> d = new ArrayList<>();
    private List<Cuota> c = new ArrayList<>(); 
    private Integer idUserDocumentos;
    
    public controlPerfilAdministrador() {
        //public Usuario(Integer idUsuario, String usuario, String contraseña, String nombre, 
        //String apellidos, String dni, Date fechaNacimiento, Integer tipoUsuario, String email, 
        //String direccion, String sexo) 
        l.add(new Usuario(1, "pepe", "2014", "Pepe", "García", "23412332R", new Date(1999, 5, 12), Usuario.PERF_EDUCANDO, "mail@mail.com", "casa, 4", "mucho"));
        l.add(new Usuario(2, "xXWillyrexXx", "2015", "Paco", "García", "23412332R", new Date(1999, 5, 12), Usuario.PERF_EDUCANDO, "mail@mail.com", "casa, 4", "mucho"));
        l.add(new Usuario(3, "Wigeta", "2016", "Mustafar", "García", "23412332R", new Date(1999, 5, 12), Usuario.PERF_EDUCANDO, "mail@mail.com", "casa, 4", "mucho"));
        l.add(new Usuario(4, "MickJackson", "2017", "Laura", "García", "23412332R", new Date(1999, 5, 12), Usuario.PERF_EDUCANDO, "mail@mail.com", "casa, 4", "mucho"));
        l.add(new Usuario(5, "TheCook", "2018", "Adolfo", "García", "23412332R", new Date(1999, 5, 12), Usuario.PERF_EDUCANDO, "mail@mail.com", "casa, 4", "mucho"));
        l.add(new Usuario(6, "JijiNoseMeOcurreMas", "2019", "Lucia", "García", "23412332R", new Date(1999, 5, 12), Usuario.PERF_EDUCANDO, "mail@mail.com", "casa, 4", "mucho"));

        //Documentos
        d.add(new Documento(1, "DNI", new Date(2001, 2, 2), 1));
        d.add(new Documento(2, "Foto", new Date(2001, 2, 2), 1));
        d.add(new Documento(3, "Recibo", new Date(2001, 2, 2), 1));
        d.add(new Documento(4, "Factura", new Date(2001, 2, 2), 1)); 
        
        c.add(new Cuota(l.get(0),1, new Date("5/12/2014"),30));
        c.add(new Cuota(l.get(1),1, new Date("5/12/2015"),35));
        c.add(new Cuota(l.get(2),1, new Date("5/12/2016"),30));
        c.add(new Cuota(l.get(3),1, new Date("5/12/2017"),32));
        
    }
    
    public List<Usuario> getListaEducandos() {
        return l;
    }
    
    public List<Cuota> getListaCuota() {
        return c;
    }
    
    public String clickVerDocumentacion(Integer idUser) {
        this.setIdUserDocumentos(idUser);
        return "gestionDocumentacionDocumentos.xhtml";
    }

    public String clickEnviarIRPF() {
        return "EnvioIRPF.xhtml";
    }
    
    public List<Documento> getListaDocumentosDeUsuario() {
        try {
            return this.negocio.documentosDeUsuario(this.idUserDocumentos);
        } catch (ScoutException ex) {
        }
        return null;
    }
    
    public void clickBotonDescargarListado() {
        try {
            this.negocio.descargarListadoDocumentacion();
        } catch (ScoutException ex) {
        }
    }
    
    public void clickBotonBorrarDocumento(Documento d){
        try {
            this.negocio.borrarDocumento(d);
        } catch (ScoutException ex) {
        }
    }
    
    public void clickBotonDescargarDocumento(Documento d){
        try {
            this.negocio.descargarDocumento(d);
        } catch (ScoutException ex) {
        }
    }
    
    public void clickBotonBorrarUsuario(){
        //Rellenar
    }
    
    public List<Usuario> getL() {
        return l;
    }
    
    public void setL(List<Usuario> l) {
        this.l = l;
    }
    
    public List<Documento> getD() {
        return d;
    }
    
    public void setD(List<Documento> d) {
        this.d = d;
    }
    
    public Integer getIdUserDocumentos() {
        return idUserDocumentos;
    }
    
    public void setIdUserDocumentos(Integer idUserDocumentos) {
        this.idUserDocumentos = idUserDocumentos;
    }
    
}
