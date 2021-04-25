package search;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class CaperucitaMain {

	public static void main(String[] args) throws PrologConnectorException {
		Caperucita agent = new Caperucita();
		
		Woods enviroment = new Woods();
		
		SearchBasedAgentSimulator simulator =
				new SearchBasedAgentSimulator(enviroment, agent);
		
		simulator.start();
	}

}
