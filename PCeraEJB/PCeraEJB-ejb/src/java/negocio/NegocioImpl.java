/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Cuota;
import entidades.Evento;
import entidades.Documento;
import entidades.Seccion;
import entidades.Usuario;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juan Antonio
 */
@Stateless
public class NegocioImpl implements Negocio {

    int contId = 0;
    int contCuotaId = 0;
    @PersistenceContext(unitName = "PCeraEJB-ejbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void crearEvento(Evento e) {
        contId++;
        e.setIdEvento(contId);
        em.persist(e);
    }

    @Override
    public List<Evento> getEv() {
        return em.createQuery("SELECT e FROM Evento e").getResultList();
    }

    @Override
    public void editarEvento(Evento e) {
        em.merge(e);
    }

    @Override
    public void RellenarBd() {
        List<Evento> lista = new ArrayList<Evento>();
        Evento e = new Evento();
        Seccion sec = new Seccion(0);
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
    public void modificarDocumento(Documento d) {
        d.setEstadoArchivo(1);
        em.merge(d);
    }

    @Override
    public void aniadirDocumento(Documento d) {
        em.persist(d);
    }

    @Override
    public void borrarDocumento(Documento d) throws ScoutException {
        em.remove(d);
    }

    @Override
    public byte[] descargarDocumento(Documento d) throws ScoutException {
        Object o = this.em.createQuery("select d.archivo from Documento d where d.idDocumento ='" + d.getIdDocumento().toString() + "'").getSingleResult();
        byte[] t = (byte[]) o;
        return t;
    }

    @Override
    public byte[] descargarListadoDocumentacion() throws ScoutException {
        ObjectOutputStream oos = null;
        byte[] bytes = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this.em.createQuery("select d.nombre from Documento d").getResultList());
            bytes = bos.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger(NegocioImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(NegocioImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return bytes;
    }

    @Override
    public List<Documento> documentosDeUsuario(Integer u) throws ScoutException {
        List l = this.em.createQuery("select d from Documento d where d.usuarioIdUsuario = '" + u + "'").getResultList();
        return l;
    }

    @Override
    public List<Usuario> getUsuarios() throws ScoutException {
        return em.createQuery("select u from Usuario u").getResultList();
    }

    @Override
    public Usuario getPerfil(Integer id) throws ScoutException {
        Object u = this.em.createQuery("select u from Usuario u where u.idUsuario = '" + id + "'").getSingleResult();
        Usuario user = (Usuario) u;
        return user;
    }

    @Override
    public void modificarUsuario(Usuario u) throws ScoutException {
        em.merge(u);
    }

    @Override
    public List<Cuota> getCuotas() {
        return em.createQuery("select c from Cuota c").getResultList();
    }

    @Override
    public void crearCuota(Cuota c) {
        contCuotaId++;
        c.setIdCuota(contCuotaId);
        em.persist(c);
    }

    @Override
    public Cuota getCuota(Integer id) {
        Object c = this.em.createQuery("select c from Cuota c where c.idCuota = '" + id + "'").getSingleResult();
        Cuota cue = (Cuota) c;
        return cue;
    }
    
    @Override
    public Usuario login(String user, String contrasenia) throws UsuarioNoRegistradoException,ContraseniaInvalidaException{
        List<Usuario> usuario = em.createQuery("select u from Usuario u where u.usuario = user'").getResultList();
        if(usuario.isEmpty()){
            throw new UsuarioNoRegistradoException("Usuario/Contraseña invalido");
        }else{
            Usuario u = usuario.get(0);
            if(!u.getContrasenia().equals(contrasenia)){
                throw new ContraseniaInvalidaException("Usuario/Contraseña invalido");
            }else if(!u.getUsuario().equals(user)){
                throw new ContraseniaInvalidaException("Usuario/Contraseña invalido");
            }else{
                return u;
            }
        }
    }

}
