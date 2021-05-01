package search;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class CaperucitaPerception extends Perception {

	public static int UNKNOWN_PERCEPTION = -1;
    public static int EMPTY_PERCEPTION = 0;
    public static int TREE_PERCEPTION = 1;
    public static int WOLF_PERCEPTION = 2;
    public static int CANDY_PERCEPTION = 3;
    public static int FLOWER_PERCEPTION = 4;

    private int[] wolfSensor; // posicion del lobo
    private int[] flowerSensor; // si esta parada encima de las flores
    private int[][] candySensor; // cantidad de dulces en el camino
    private int[] treeSensor; // si hay un arbol en frente
    private int lives; // cantidad de vidas que tiene caperucita
    private int candies; // cantidad de dulces que tiene caperucita

    public CaperucitaPerception() {
        lives = 3;
    }

    public CaperucitaPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    @Override
    public void initPerception(Agent agent, Environment environment) {
        Caperucita caperucita = (Caperucita) agent;
        Woods ambienteCaperucita = (Woods) environment;
        WoodsState environmentState = ambienteCaperucita.getEnvironmentState();

        int row = environmentState.getAgentPosition()[0];
        int col = environmentState.getAgentPosition()[1];
        int orientation = environmentState.getAgentOrientation();
        
        this.setWolfSensor(environmentState.thereIsWolf(row, col, orientation));
        this.setFlowerSensor(environmentState.thereIsFlower(row, col, orientation));
        this.setCandySensor(environmentState.thereIsCandy(row, col, orientation));
        this.setTreeSensor(environmentState.thereIsTree(row, col, orientation));
        this.setLives(environmentState.getAgentLives());
        this.setCandies(environmentState.getAgentCandies());
        
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        str.append("Lives: " + this.lives);
        str.append("; ");
        str.append("Candies: " + this.candies);
        str.append("; ");
        if(this.wolfSensor[0]==-1) {
        	str.append("Wolf Sensor: []; ");
        }
        else {
        	str.append("Wolf Sensor: [" + this.wolfSensor[0]+", "+this.wolfSensor[1]+"]; ");
        }

        if(this.flowerSensor[0]==-1) {
        	str.append("Flower Sensor: []; ");
        }
        else {
        	str.append("Flower Sensor: [" + this.flowerSensor[0]+", "+this.flowerSensor[1]+"]; ");
        }
        
        if(this.treeSensor[0]==-1) {
        	str.append("Tree Sensor: []; ");
        }
        else {
        	str.append("Tree Sensor: [" + this.treeSensor[0]+", "+this.treeSensor[1]+"]; ");
        }
        
        str.append("Candy Sensor: [ ");
        for(int i=0; i<3; i++) {
        	if(this.candySensor[i][0] != 0) {
        		str.append("[" + this.candySensor[i][0]+", "+this.candySensor[i][1]+"] ");
            }
        }
        str.append("]; ");

        return str.toString();
    }
    
    public int[] getWolfSensor() {
		return wolfSensor;
	}

	public void setWolfSensor(int[] wolfSensor) {
		this.wolfSensor = wolfSensor;
	}

	public int[] getFlowerSensor() {
		return flowerSensor;
	}

	public void setFlowerSensor(int[] flowerSensor) {
		this.flowerSensor = flowerSensor;
	}

	public int[][] getCandySensor() {
		return candySensor;
	}

	public void setCandySensor(int[][] candySensor) {
		this.candySensor = candySensor;
	}

	public int[] getTreeSensor() {
		return treeSensor;
	}

	public void setTreeSensor(int[] treeSensor) {
		this.treeSensor = treeSensor;
	}

	public int getCandies() {
		return candies;
	}

	public void setCandies(int candies) {
		this.candies = candies;
	}

	public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
