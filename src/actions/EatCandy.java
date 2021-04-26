package actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import search.*;

public class EatCandy extends SearchAction {

    /**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real wood state.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        CaperucitaState caperucitaState = (CaperucitaState) s;

        int row = caperucitaState.getCurrentRow();
        int col = caperucitaState.getCurrentColumn();

        if (caperucitaState.getWood()[row][col] == CaperucitaPerception.CANDY_PERCEPTION) {
        	caperucitaState.setWoodPosition(row, col, CaperucitaPerception.EMPTY_PERCEPTION);
        	caperucitaState.setCandies(caperucitaState.getCandies() + 1);
            return caperucitaState;
        }
        return null;
    }

    /**
     * This method updates the agent state and the real wood state.
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
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
    public Double getCost() {
        return new Double(0);
    }

    /* This method is not important for a search based agent, but is essensial
     * when creating a calculus based one. */
    @Override
    public String toString() {
        return "Comer Dulce";
    }
}