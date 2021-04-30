package search;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class CaperucitaGoal extends GoalTest {
	
	@Override
    public boolean isGoalState(AgentState agentState) {
    	if (((CaperucitaState) agentState).arrivedToFlowers()) {
    		int position[] = {((CaperucitaState) agentState).getCurrentRow(),
    				((CaperucitaState) agentState).getCurrentColumn()};
        	System.out.println("nueva pos : ["+position[0]+", "+position[1]+"] ");
            return true;
        }
        return false;
    }
}