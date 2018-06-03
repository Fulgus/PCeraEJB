/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Documento;
import entidades.Usuario;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import negocio.Negocio;
import negocio.ScoutException;

/**
 *
 * @author JoseMaria
 */
@Named(value = "perfil")
@RequestScoped
public class PerfilBean {

    private Usuario miembro;
    private Usuario perfil;
    //Campos para usuario ficticio.
    /*private String usuario;
    private String nombre;
    private String apellidos;
    private String localidad;
    private String sexo;
    private String direccion;
    private String email;*/
    private String grupo;
    private Date fecha_nacimiento;
    private Date fecha_jura_bandera;
    private Date fecha_alta;
    private String telefono;
    private String url_imagen;
    
    @EJB
    private Negocio negocio;
    /**
     * Creates a new instance of PerfilBean
     */
    public PerfilBean() throws ScoutException {
        // creamos datos ficticios
        miembro = new Usuario(1, "pepe", "asdf", "Pepe", "García", "23412332R", new Date(1999, 5, 12), Usuario.PERF_EDUCANDO, "mail@mail.com", "casa, 4", "mucho");
        //perfil = negocio.getPerfil(1);
        
        //----Dummy
        this.telefono="634872123";
        this.grupo="Lobatos";
        this.fecha_nacimiento =  new Date("5/12/1999");
        this.fecha_jura_bandera = new Date("2/15/2015");
        this.fecha_alta = new Date("10/30/2014");
        this.url_imagen = "img-profile.png";
    }

    public String getImagen() {
        //imagen por defecto por ahora.
        return url_imagen;
    }

    public Usuario getMiembro() {
        return miembro;
    }

    public String getUsuario() {
        return miembro.getUsuario();
    }

    public void setUsuario(String usuario) {
        this.miembro.setUsuario(usuario);
    }

    public String getNombre() {
        return miembro.getNombre();
    }

    public void setNombre(String nombre) {
        this.miembro.setNombre(nombre);
    }

    public String getApellidos() {
        return miembro.getApellidos();
    }

    public void setApellidos(String apellidos) {
        this.miembro.setApellidos(apellidos);
    }

    public String getSexo() {
        return miembro.getSexo();
    }

    public void setSexo(String sexo) {
        this.miembro.setSexo(sexo);
    }

    public String getDireccion() {
        return miembro.getDireccion();
    }

    public void setDireccion(String direccion) {
        this.miembro.setDireccion(direccion);
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getEmail() {
        return miembro.getEmail();
    }

    public void setEmail(String email) {
        this.miembro.setEmail(email);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_nacimiento() {
        return miembro.getFechaNacimiento();
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.miembro.setFechaNacimiento(fecha_nacimiento);
    }

    public Date getFecha_jura_bandera() {
        return fecha_jura_bandera;
    }

    public void setFecha_jura_bandera(Date fecha_jura_bandera) {
        this.fecha_jura_bandera = fecha_jura_bandera;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String mostrarFecha_juraBand() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = df.format(fecha_jura_bandera);
        return fecha;
    }

    public String mostrarFecha_nacimiento() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = df.format(getFecha_nacimiento());
        return fecha;
    }

    public String mostrarFecha_alta() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = df.format(fecha_alta);
        return fecha;
    }
        
    public void modificarUsuario(Usuario u) throws ScoutException{
        negocio.modificarUsuario(u);
    }
    
    
    public String clickLinkModificar() {
        return "modificarPerfil.xhtml";
    }

    public String clickLinkCambiarContrasenia() {
        return "modificarContrasenia.xhtml";
    }

    public String clickLinkPagarCuota() {
        return "PagarCuota.xhtml";
    }

    public String clickLinkVerDocumentacion() throws ScoutException {
        return "documentosPrincipal.xhtml";
    }

    public String clickLinkGestionUsuarios() {
        return "gestUsuarios.xhtml";
    }

    public String clickLinkGestionCuotas() {
        return "GetionarCuota.xhtml";
    }

    public String clickLinkGestionEventos() {
        return "GestionEventos.xhtml";
    }

    public String clickLinkGestionDocumentacion() {
        return "GestionDocumentacion.xhtml";
    }

    public String clickLinkPrivilegios() {
        return "privilegios.xhtml";
    }
}
