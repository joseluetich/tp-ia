package search;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class Heuristic implements IEstimatedCostFunction {

    /**
     * It returns the estimated cost to reach the goal from a NTree node.
     */
    @Override
    public double getEstimatedCost(NTree node) {
        CaperucitaState caperucitaState = (CaperucitaState) node.getAgentState();

        //return caperucitaState.getMovements();
        
        double candiesLeft = 3 - caperucitaState.getCandies();
        double livesLeft = 3 - caperucitaState.getLives();
        return candiesLeft+livesLeft;
        
    }
}
