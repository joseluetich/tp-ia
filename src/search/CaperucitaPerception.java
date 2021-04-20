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

    private int wolfSensor;
    private int flowerSensor;
    private int candySensor;
    private int treeSensor;
    private int lives;
    private int candies;

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
        
        /*this.setTopSensor(ambienteCaperucita.getTopCell(row, col));
        this.setLeftSensor(ambienteCaperucita.getLeftCell(row, col));
        this.setRightSensor(ambienteCaperucita.getRightCell(row, col));
        this.setBottomSensor(ambienteCaperucita.getBottomCell(row, col));*/
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        str.append("Lives: " + this.lives);
        str.append("; ");
        str.append("Candies: " + this.candies);
        str.append("; ");
        str.append("Wolf Sensor: " + this.wolfSensor);
        str.append("; ");
        str.append("Flower Sensor: " + this.flowerSensor);
        str.append("; ");
        str.append("Tree Sensor: " + this.treeSensor);
        str.append("; ");
        str.append("Candy Sensor: " + this.candySensor);

        return str.toString();
    }
    
    public int getWolfSensor() {
		return wolfSensor;
	}

	public void setWolfSensor(int wolfSensor) {
		this.wolfSensor = wolfSensor;
	}

	public int getFlowerSensor() {
		return flowerSensor;
	}

	public void setFlowerSensor(int flowerSensor) {
		this.flowerSensor = flowerSensor;
	}

	public int getCandySensor() {
		return candySensor;
	}

	public void setCandySensor(int candySensor) {
		this.candySensor = candySensor;
	}

	public int getTreeSensor() {
		return treeSensor;
	}

	public void setTreeSensor(int treeSensor) {
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
