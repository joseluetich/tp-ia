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

        int distanceX = caperucitaState.getFlowerPosition()[0] - caperucitaState.getCurrentRow();
        int distanceY = caperucitaState.getFlowerPosition()[1] - caperucitaState.getCurrentColumn();
        double dX = (distanceX)^2;
        double dY = (distanceY)^2;
        return dX+dY;
        
    }
}
