/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author Santiago
 */
@Named(value = "controlInicio")
@SessionScoped
public class ControlInicio implements Serializable {

    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public int getUsuarioId(){
        return usuario.getIdUsuario();
    }

    //Control de los diferentes botones de la plantilla
    public String clickLinkInformacion() {
        return "informacion.xhtml";
    }

    public String clickLinkApuntate() {
        return "apuntate.xhtml";
    }

    public String clickLinkInicio() {
        return "index.xhtml";
    }

    public String clickLinkLogin() {
        return "inicioSesion.xhtml";
    }
    
    public String clickLinkEventos() {
        return "Listaeventos.xhtml";
    }
    
    public String clickLinkCrearEvento() {
        return "subirEvento.xhtml";
    }

    //Al pulsar el botón perfil (hay que estar logeado para que aparezca) elige a que tipo de perfil entra en funcion del usuario logeado
    public String clickLinkPerfil() {

        switch (usuario.getTipoUsuario()) {
            case 0:
                return "perfilAdministrador.xhtml";
            case 1:
                return "perfilAdministrador.xhtml";
            default:
                return "perfilEducando.xhtml";
        }

    }

    public String clickLinkCuota() {
        return "GestionarCuota.xhtml";
    }
    // Destruye la sesión (y con ello, el ámbito de este bean)

    public String logout() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "inicioSesion.xhtml";
    }

    //Crea una nueva instancia de ControlInicio
    public ControlInicio() {
    }
}
