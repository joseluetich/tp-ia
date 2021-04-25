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

        //TODO funcion heuristica
        return (caperucitaState.getUnknownCellsCount() +
        		caperucitaState.getRemainingFoodCount());
    }
}
