package actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import search.CaperucitaPerception;
import search.CaperucitaState;
import search.WoodsState;

public class TurnLeft extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO
		CaperucitaState caperucitaState = (CaperucitaState) s;

        int row = caperucitaState.getCurrentRow();
        int col = caperucitaState.getCurrentColumn();

        /* The 'Eat' action can be selected only if there is food in the current
         * position. Otherwise return 'null'. */
        if (caperucitaState.getWood()[row][col] == CaperucitaPerception.CANDY_PERCEPTION) {
            // If the action is Eat, then the actual position has no more food.
        	caperucitaState.setWoodPosition(row, col, CaperucitaPerception.EMPTY_PERCEPTION);
            return caperucitaState;
        }
        return null;
	}

	@Override
	public Double getCost() {
		return new Double(1);
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO
		WoodsState environmentState = (WoodsState) est;
        CaperucitaState caperucitaState = ((CaperucitaState) ast);

        int row = environmentState.getAgentPosition()[0];
        int col = environmentState.getAgentPosition()[1];

        if (environmentState.getWood()[row][col] == CaperucitaPerception.CANDY_PERCEPTION) {
            // Update the real wood
            environmentState.setWood(row, col, CaperucitaPerception.EMPTY_PERCEPTION);
            // Update caperucita state
            caperucitaState.setWoodPosition(row, col, CaperucitaPerception.EMPTY_PERCEPTION);
            
            return environmentState;
        }

        return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Go Forward";
	}

	

	
}
