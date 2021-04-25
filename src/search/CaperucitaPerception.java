package search;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.environment.Environment;

public class CaperucitaPerception {

	public static int UNKNOWN_PERCEPTION = -1;   
	private int suciedad;

    public CaperucitaPerception() {
    	//Aqu� crearimos los objetos, listas, arrays que componen la percepci�n
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
       
        //Aqu� creamos la percepci�n inicial del agente
        //Pimero chequeamos que la habitaci�n en la que est� el agente est� sucia
        Habitacion h = environmentState.getposicionAspiradora();
        boolean estaSucia = environmentState.gethabitacionesSucias().contains(h);
        
        //Si lo est�, el valor de la percepci�n ser� 1; en caso contrario ser� 0
        if(estaSucia)
        	suciedad = 100000000;
        else
        	suciedad = 0;
        
    }
}
