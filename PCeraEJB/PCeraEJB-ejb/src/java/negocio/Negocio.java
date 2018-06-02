/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import entidades.Cuota;
import entidades.Evento;

import entidades.Documento;

import entidades.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan Antonio
 */
@Local
public interface Negocio {

    public void registrarUsuario(Usuario u) throws ScoutException;

    
    public void crearEvento(Evento e);
    
    public List<Evento> getEv();
    
    public void editarEvento(Evento e);
    
    public void RellenarBd();


    public void borrarDocumento(Documento d) throws ScoutException;//

    /**
     *
     * @param d
     * @return
     * @throws ScoutException
     */
    public byte[] descargarDocumento(Documento d) throws ScoutException;//

    public void descargarListadoDocumentacion() throws ScoutException;//

    public List<Documento> documentosDeUsuario(Integer u) throws ScoutException;//

    public List<Usuario> getUsuarios() throws ScoutException;
    
    public Usuario getPerfil(Integer id) throws ScoutException;
    
    public void modificarDocumento (Documento d) throws ScoutException;
    
    public void aniadirDocumento (Documento d) throws ScoutException;
    
    public List<Cuota> getCuota() throws ScoutException;
    
    public void modificarUsuario(Usuario u) throws ScoutException;
}
