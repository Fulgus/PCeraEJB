/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Usuario;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import negocio.ContraseniaInvalidaException;
import negocio.NegocioImpl;
import negocio.UsuarioNoRegistradoException;




@Named(value = "login")
@RequestScoped
public class Login {

 
    private NegocioImpl negocioImpl;

    private String user;
    private String contrasenia;
    //private List<Usuario> usuarios;

    @Inject
    private ControlInicio ctrl;


    public Login() {
    }

    public String getUsuario() {
        return user;
    }

    public String getContrasenia() {
        return contrasenia;
    }


    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @SuppressWarnings("empty-statement")
    public String autenticar() {
        try{
            Usuario usuario=negocioImpl.login(user,contrasenia);
            ctrl.setUsuario(usuario);
            return ctrl.clickLinkInicio();
        }catch(ContraseniaInvalidaException | UsuarioNoRegistradoException e){
             FacesContext ctx = FacesContext.getCurrentInstance();
             ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no valido", "Usuario no valido"));
            return null;
        }

    }
}



