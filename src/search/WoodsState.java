package search;

import domain.Casilla;
import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class WoodsState extends EnvironmentState {
	
    private Casilla[][] wood;
    private int candiesQuantity;
    private int[] agentPosition;
    private int agentLives;
    
    public WoodsState() {
        wood = new Casilla[9][14];
    	this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {
    	this.setCandiesQuantity(3);
    	
    	//El estado inicial del estado del Ambiente; el escenario de entrada
    	for(int i=0; i<9; i++) {
    		for(int j=0; j<14; j++) {
    			wood[i][j] = new Casilla();
    		}
    	}
    	this.setAgentPosition(new int[]{1, 1}); //ver
    	
    	
    	//TODO ver como se inicializa el tipo de casilla 	
    	// ver si es necesario la entidad casilla. puedo poner
    	// numeros en cada celda, dependiendo de la percepcion directamente
    	
    	/*Ejemplo pacman
    	// Sets all cells as empty
        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                world[row][col] = PacmanPerception.EMPTY_PERCEPTION;
            }
        }

        // Sets some cells with foods and enemies. 
        world[0][0] = PacmanPerception.FOOD_PERCEPTION;
        world[0][2] = PacmanPerception.FOOD_PERCEPTION;
        world[3][1] = PacmanPerception.ENEMY_PERCEPTION;
        world[2][1] = PacmanPerception.FOOD_PERCEPTION;
        world[0][3] = PacmanPerception.ENEMY_PERCEPTION;
        world[1][2] = PacmanPerception.FOOD_PERCEPTION;

        this.setAgentPosition(new int[]{1, 1});
        this.setAgentEnergy(50);*/
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
    	
        String str = "";
        /*
        str += "Habitaciones sucias: {";
        for(Habitacion h : habitacionesSucias)
        	str+= h.toString() + ", ";
        str = str.substring(0,str.length()-2);
        str += "}\n";
        
        str += "Posición del agente: ";
        str += posicionAspiradora.toString(); 
         */
        return str;
    }

	public Casilla[][] getWood() {
		return wood;
	}

	public void setWood(Casilla[][] wood) {
		this.wood = wood;
	}

	public int getCandiesQuantity() {
		return candiesQuantity;
	}

	public void setCandiesQuantity(int candiesQuantity) {
		this.candiesQuantity = candiesQuantity;
	}

	public int[] getAgentPosition() {
        return agentPosition;
    }

    public void setAgentPosition(int[] agentPosition) {
        this.agentPosition = agentPosition;
    }

}

