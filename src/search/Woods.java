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
        
    	// Create a new perception to return
    	CaperucitaPerception perception = new CaperucitaPerception();
        
        // Get the actual position of the agent to be able to create the perception
        int row = this.getEnvironmentState().getAgentPosition()[0];
        int col = this.getEnvironmentState().getAgentPosition()[1];
        int orientation = this.getEnvironmentState().getAgentOrientation();

        // Set the perception sensors
        perception.setWolfSensor(this.getEnvironmentState().thereIsWolf(row, col, orientation));
        perception.setFlowerSensor(this.getEnvironmentState().thereIsFlower(row, col, orientation));
        perception.setCandySensor(this.getEnvironmentState().thereIsCandy(row, col, orientation));
        perception.setTreeSensor(this.getEnvironmentState().thereIsTree(row, col, orientation));
        perception.setLives(this.getEnvironmentState().getAgentLives());
        perception.setCandies(this.getEnvironmentState().getCandiesQuantity());
        
        // Return the perception
        return perception;
    }

    
    public String toString() {
        return environmentState.toString();
    }
    
    @Override
    public boolean agentFailed(Action actionReturned) {

        WoodsState woodsState = this.getEnvironmentState();

        int agentLives = woodsState.getAgentLives();

        if(agentLives <= 0)
            return true;

        return false;
    }
}
