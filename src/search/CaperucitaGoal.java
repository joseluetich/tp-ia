package search;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class CaperucitaGoal extends GoalTest {

    @Override
    public boolean isGoalState(AgentState agentState) {
    	if (((CaperucitaState) agentState).arrivedToFlowers()) {
            return true;
        }
        return false;
    }
}