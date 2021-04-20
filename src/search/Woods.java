package search;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.environment.Environment;

public class Woods extends Environment {

    public Woods() {
        // Create the environment state
        this.environmentState = new WoodsState();
    }

    public WoodsState getEnvironmentState() {
        return (WoodsState) super.getEnvironmentState();
    }

    /* This method is called by the simulator. Given the Agent, it creates
     * a new perception reading, for example, the agent position.*/
    @Override
    public CaperucitaPerception getPercept() {
        
    	//Creamos la percepción que el agente obtendría, a partir del estado actual del ambiente
    	CaperucitaPerception perception = new CaperucitaPerception();
		
        //Pimero chequeamos que la habitación en la que está el agente está sucia
        /*Habitacion h = this.getEnvironmentState().getposicionAspiradora();
        boolean estaSucia = false;
        for(Habitacion hab : this.getEnvironmentState().gethabitacionesSucias())
        	if(hab.getNombre().equals(h.getNombre()))
        		estaSucia = true;
        
        //Si lo está, el valor de la percepción será 1; en caso contrario será 0
        if(estaSucia)
        	perception.setsuciedad(1);
        else
        	perception.setsuciedad(0);
        */
        // Return the perception
        return perception;
    }

    
    public String toString() {
        return environmentState.toString();
    }

    //Este método indica bajo qué condición se considera que el agente ha fallado
    public boolean agentFailed(Action actionReturned) {
    	boolean failed = false;

    	//Notar que en este punto tenemos 3 posibilidades inmediatas:
    	//1 - Agregar al estado del ambiente el atributo que nos indica falla (energía)
    	//2 - Agregar un operador que se denomine "apagar" (que vendrá en "actionReturned")
    	//3 - Modificar GoalBasedAgentSimulator para que pase el AgentState en lugar de Action

        return failed;
    }

}
