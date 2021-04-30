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
		CaperucitaState caperucitaState = (CaperucitaState) s;
		int orientation = caperucitaState.getOrientation();
		if (orientation == CaperucitaState.UP) {
        	orientation = 4;
        
        } else {
        	orientation--;
        }
        
        caperucitaState.setOrientation(orientation);
    	//System.out.println("orientacion2 "+caperucitaState.toString());
        return caperucitaState;
	}

	@Override
	public Double getCost() {
		return new Double(0);
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		WoodsState environmentState = (WoodsState) est;
        CaperucitaState caperucitaState = ((CaperucitaState) ast);

        int orientation = caperucitaState.getOrientation();
        if (orientation == CaperucitaState.UP) {
        	orientation = 4;
        } else {
        	orientation--;
        }
        
        caperucitaState.setOrientation(orientation);
        environmentState.setAgentOrientation(orientation);
        //System.out.println(environmentState.toString());
        return environmentState;
	}

	@Override
	public String toString() {
		return "Girar a la izquierda";
	}
}
