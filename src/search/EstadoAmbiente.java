package search;

import java.util.ArrayList;
import java.util.List;
import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoAmbiente extends EnvironmentState {
	
    private List<Habitacion> habitacionesSucias;
    private Habitacion posicionAspiradora;
	
    public EstadoAmbiente() {
        
    	habitacionesSucias = new ArrayList<Habitacion>();
    	posicionAspiradora = new Habitacion();
    	
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

    	//El estado inicial del estado del Ambiente; el escenario de entrada
    	Habitacion h1 = new Habitacion("h1");
    	Habitacion h2 = new Habitacion("h2");
       	
    	habitacionesSucias.add(h1);
    	habitacionesSucias.add(h2);
    	
    	posicionAspiradora = h1; 	
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
    	
        String str = "";
        
        str += "Habitaciones sucias: {";
        for(Habitacion h : habitacionesSucias)
        	str+= h.toString() + ", ";
        str = str.substring(0,str.length()-2);
        str += "}\n";
        
        str += "Posición del agente: ";
        str += posicionAspiradora.toString(); 

        return str;
    }

     public List<Habitacion> gethabitacionesSucias(){
        return habitacionesSucias;
     }
     
     public void sethabitacionesSucias(List<Habitacion> arg){
        habitacionesSucias = arg;
     }
    
     public Habitacion getposicionAspiradora(){
        return posicionAspiradora;
     }
     
     public void setposicionAspiradora(Habitacion arg){
        posicionAspiradora = arg;
     }


}
