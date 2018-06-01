/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Evento;
import entidades.Documento;
import entidades.Seccion;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juan Antonio
 */
@Stateless
public class NegocioImpl implements Negocio {
    int contId=0;
    @PersistenceContext(unitName = "PCeraEJB-ejbPU")
    private EntityManager em; 

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public void crearEvento(Evento e){
        contId++;
        e.setIdEvento(contId);
        em.persist(e);
    }
    
    @Override
    public List<Evento> getEv(){
        return em.createQuery("SELECT e FROM Evento e").getResultList();
    }
    
    @Override
    public void editarEvento(Evento e){
        em.merge(e);
    }
    
    @Override
    public void RellenarBd(){
        List<Evento> lista = new ArrayList<Evento>();
        Evento e = new Evento();
        Seccion sec= new Seccion(0);
        e.setUbicacon("Baena");
        e.setSeccion(sec);
        e.setDescripcion("akdfjasdf dfkadfs");
        e.setIdEvento(1);
        e.setNombre("Montar en burro");
        em.persist(e);
        lista.add(e);
        
        throw new UnsupportedOperationException("Not suported yet.");
    }
    
    @Override
    public void registrarUsuario(Usuario u) throws ScoutException {
        em.persist(u);
    }

    @Override
    public void borrarDocumento(Documento d) throws ScoutException {
        em.remove(d);
    }

    @Override
    public byte[] descargarDocumento(Documento d) throws ScoutException {
        Object o = this.em.createQuery("select d.archivo from Documento d where d.idDocumento ='" + d.getIdDocumento().toString() + "'").getSingleResult();
        byte[] t = (byte[])o;
        return t;
    }

    @Override
    public void descargarListadoDocumentacion() throws ScoutException {
        this.em.createQuery("select d from Documento d").getResultList();
    }

    @Override
    public List<Documento> documentosDeUsuario(Integer u) throws ScoutException {
        List l = this.em.createQuery("select d from Documento d where d.usuarioIdUsuario = '"+u+"'").getResultList();
        return l;
    }

}
