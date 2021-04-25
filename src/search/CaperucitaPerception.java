package search;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.environment.Environment;

public class CaperucitaPerception {

	public static int UNKNOWN_PERCEPTION = -1;   
	private int suciedad;

    public CaperucitaPerception() {
    	//Aquí crearimos los objetos, listas, arrays que componen la percepción
    	suciedad = UNKNOWN_PERCEPTION;
    }

    public CaperucitaPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method initializa a perception of the agent.
     */
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {
    	
        Caperucita agent = (Caperucita) agentIn;
        AmbienteCaperucita environment = (AmbienteCaperucita) environmentIn;
        EstadoAmbiente environmentState = environment.getEnvironmentState();
       
        //Aquí creamos la percepción inicial del agente
        //Pimero chequeamos que la habitación en la que está el agente está sucia
        Habitacion h = environmentState.getposicionAspiradora();
        boolean estaSucia = environmentState.gethabitacionesSucias().contains(h);
        
        //Si lo está, el valor de la percepción será 1; en caso contrario será 0
        if(estaSucia)
        	suciedad = 100000000;
        else
        	suciedad = 0;
        
    }
}
