/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

 
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Cuota;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Documento;
import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Marcos
 */

@Named(value = "controlCuota")
@RequestScoped
public class ControlCuota {
    private double importe;
    private Integer Anio;
    private final List<Usuario> l = new ArrayList<>();
    private final List<Cuota> c = new ArrayList<>(); 
    
    public ControlCuota(){
        l.add(new Usuario(1, "pepe", "2014", "Pepe", "García", "23412332R", new Date(1999, 5, 12), Usuario.PERF_EDUCANDO, "mail@mail.com", "casa, 4", "mucho"));
        l.add(new Usuario(2, "xXWillyrexXx", "2015", "Paco", "García", "23412332R", new Date(1999, 5, 12), Usuario.PERF_EDUCANDO, "mail@mail.com", "casa, 4", "mucho"));
        l.add(new Usuario(3, "Wigeta", "2016", "Mustafar", "García", "23412332R", new Date(1999, 5, 12), Usuario.PERF_EDUCANDO, "mail@mail.com", "casa, 4", "mucho"));
        l.add(new Usuario(4, "MickJackson", "2017", "Laura", "García", "23412332R", new Date(1999, 5, 12), Usuario.PERF_EDUCANDO, "mail@mail.com", "casa, 4", "mucho"));
        l.add(new Usuario(5, "TheCook", "2018", "Adolfo", "García", "23412332R", new Date(1999, 5, 12), Usuario.PERF_EDUCANDO, "mail@mail.com", "casa, 4", "mucho"));
        l.add(new Usuario(6, "JijiNoseMeOcurreMas", "2019", "Lucia", "García", "23412332R", new Date(1999, 5, 12), Usuario.PERF_EDUCANDO, "mail@mail.com", "casa, 4", "mucho"));
        
        c.add(new Cuota(l.get(0),1, new Date("5/12/2014"),30));
        c.add(new Cuota(l.get(1),1, new Date("5/12/2015"),35));
        c.add(new Cuota(l.get(2),1, new Date("5/12/2016"),30));
        c.add(new Cuota(l.get(3),1, new Date("5/12/2017"),32));
    }
    
    public String anioFecha(Date d){
        
        SimpleDateFormat df = new SimpleDateFormat ("yyyy");
        String fecha = df.format(d);
        return fecha;
    }
    
    public int ContarEducandos(List l){
        int num;
        num= l.size();
        return num;
    }
    
    
    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Integer getAnio() {
        return Anio;
    }

    public void setFecha(Integer Anio) {
        this.Anio = Anio;
    }
    
    //Este metodo controla que cancelas la creación de cuota
    public String btnCancelarCrCuota(){
        return "GestionarCuota.xhtml";
    }
    
    //Este metodo controla que crea la cuota
    public String btnCrearCrCuota(){
        return "GestionarCuota.xhtml";
    }
    //Este metodo controla el cierre del popup de IRPF
    public String btnCerrarIRPF(){
        return "VerCuota.xhtml";
    }
    
    public String btnVerCuenta(){
        return "VerCuota.xhtml";
    }
    
    public String btnEnviarIRPF(){
        return "EnvioIRPF.xhtml";
    }
    
    public String btnAceptarMetPag(){
        return "perfilEducando.xhtml";
    }
    
    public String btnAtrasMetPag(){
        return "perfilEducando.xhtml";
    }
}
