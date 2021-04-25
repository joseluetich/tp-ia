package search;

import domain.Casilla;
import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class WoodsState extends EnvironmentState {
	
	 /*Este atributo inicializa el ambiente.
	  * Asi como en el pacman la comida disminuia en el atributo
	  * world del pacman, ahora las actualizaciones del bosque
	  * se realizaran en el wood de caperucita*/
	private int[][] wood;
    private int candiesQuantity;
    private int[] agentPosition;
    private int agentLives;
    
    public WoodsState() {
    	this.initState();
    }

    @Override
    public void initState() {
        this.wood = new int[9][14];
    	this.setCandiesQuantity(3);
    	
    	for(int i=0; i<9; i++) {
    		for(int j=0; j<14; j++) {
    			wood[i][j] = CaperucitaPerception.EMPTY_PERCEPTION;
    		}
    	}
    	this.setAgentPosition(new int[]{1, 1}); //ver
    	this.setAgentLives(3);
    	
    	//TODO Diseñar el nivel. Ver como se podrian
    	// inicializar varios niveles (como usarlos)
    	
    	//Ejemplo pacman
    	/*
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
        this.setAgentEnergy(50);
        */
    }

    @Override
    public String toString() {
    	
        String str = "";
        int dulces = 0;
        str += "Cantidad De Dulces: { ";
        for(int i=0; i<9; i++) {
    		for(int j=0; j<14; j++) {
    			if(wood[i][j] == CaperucitaPerception.CANDY_PERCEPTION) {
    				dulces++;
    			}
    		}
        }
        str += (dulces+" }\n");
        
        str += ("Cantidad de Vidas: { "+agentLives+" }"); 
        
        str += ("Posicion del Agente: { "+agentPosition[0]+", "+agentPosition[1]+" }"); 
         
        return str;
    }

	public int[][] getWood() {
		return wood;
	}

	public void setWood(int[][] wood) {
		this.wood = wood;
	}
	
	public void setWood(int row, int col, int value) {
        this.wood[row][col] = value;
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

	public int getAgentLives() {
		return agentLives;
	}

	public void setAgentLives(int agentLives) {
		this.agentLives = agentLives;
	}
    
}

