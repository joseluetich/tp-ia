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

    private int leftSensor;
    private int topSensor;
    private int rightSensor;
    private int bottomSensor;
    private int lives;
    private int candy;

    public CaperucitaPerception() {
        lives = 3;
    }

    public CaperucitaPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agent, Environment environment) {
        Caperucita caperucita = (Caperucita) agent;
        Woods ambienteCaperucita = (Woods) environment;
        WoodsState environmentState = ambienteCaperucita.getEnvironmentState();

        int row = environmentState.getAgentPosition()[0];
        int col = environmentState.getAgentPosition()[1];
        /*
        this.setTopSensor(ambienteCaperucita.getTopCell(row, col));
        this.setLeftSensor(ambienteCaperucita.getLeftCell(row, col));
        this.setRightSensor(ambienteCaperucita.getRightCell(row, col));
        this.setBottomSensor(ambienteCaperucita.getBottomCell(row, col));*/
    }

    // The following methods are Pacman-specific:

    public int getLeftSensor() {
        return leftSensor;
    }

    public void setLeftSensor(int leftSensor) {
        this.leftSensor = leftSensor;
    }

    public int getTopSensor() {
        return topSensor;
    }

    public void setTopSensor(int topSensor) {
        this.topSensor = topSensor;
    }

    public int getRightSensor() {
        return rightSensor;
    }

    public void setRightSensor(int rightSensor) {
        this.rightSensor = rightSensor;
    }

    public int getBottomSensor() {
        return bottomSensor;
    }

    public void setBottomSensor(int bottomSensor) {
        this.bottomSensor = bottomSensor;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        str.append("Lives: " + this.lives);
        str.append("; ");
        str.append("Left Sensor: " + this.leftSensor);
        str.append("; ");
        str.append("Up Sensor: " + this.topSensor);
        str.append("; ");
        str.append("Right Sensor: " + this.rightSensor);
        str.append("; ");
        str.append("Down Sensor: " + this.bottomSensor);

        return str.toString();
    }
}
