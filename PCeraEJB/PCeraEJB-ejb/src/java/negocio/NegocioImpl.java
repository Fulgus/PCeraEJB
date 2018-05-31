/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Documento;
import entidades.Usuario;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juan Antonio
 */
@Stateless
public class NegocioImpl implements Negocio {

    @PersistenceContext(unitName = "PCeraEJB-ejbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void registrarUsuario(Usuario u) throws ScoutException {
        em.persist(u);
    }

    @Override
    public void borrarDocumentacion(Documento d) throws ScoutException {
        em.remove(d);
    }

    @Override
    public void descargarDocumento(Documento d) throws ScoutException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void descargarListadoDocumentacion() throws ScoutException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
