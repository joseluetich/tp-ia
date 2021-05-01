package actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import search.CaperucitaPerception;
import search.CaperucitaState;
import search.WoodsState;

public class MoveForward extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		CaperucitaState capState = (CaperucitaState) s;

        int row = capState.getCurrentRow();
        int column = capState.getCurrentColumn();
        int orientation = capState.getOrientation();
        int[][] woodPercibido = capState.getWood();
        
        if(orientation == CaperucitaState.UP) {
        	while(!capState.hayArbol(row,column) && !capState.hayFlores(row, column)) {
        		if(capState.hayDulce(row,column)) {
        			woodPercibido[row][column] = CaperucitaPerception.EMPTY_PERCEPTION;
        			capState.setCandies(capState.getCandies()+1);
        		}
        		else if(capState.hayLobo(row,column)) {
        			capState.setLives(capState.getLives()-1);
					// TODO VUELVE A ARRANCAR
				}
				else {
					//Si no hay nada, deja de ser unknown y es empty
					woodPercibido[row][column] = CaperucitaPerception.EMPTY_PERCEPTION;
				}
				row--; //voy para arriba
        	}
			if(capState.hayFlores(row, column)) {
				capState.setCurrentRow(row);
				capState.setCurrentColumn(column);
			}
			if(capState.hayArbol(row, column)) {
				capState.setCurrentRow(row+1); //si en row hay arbol, debe posicionarse abajo
				capState.setCurrentColumn(column);
			}
		}
        
        if(orientation == CaperucitaState.RIGHT) {
        	while(!capState.hayArbol(row,column) && !capState.hayFlores(row, column)) {
        		if(capState.hayDulce(row,column)) {
        			capState.setWoodPosition(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
        			capState.setCandies(capState.getCandies()+1);
        		}
        		else if(capState.hayLobo(row,column)) {
					capState.setLives(capState.getLives()-1);
					// TODO VUELVE A ARRANCAR
				}
				else {
					capState.setWoodPosition(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
				}
				column++; //voy para la derecha
        	}
			if(capState.hayFlores(row, column)) {
				capState.setCurrentRow(row);
				capState.setCurrentColumn(column);
			}
			if(capState.hayArbol(row, column)) {
				capState.setCurrentRow(row);
				capState.setCurrentColumn(column-1);
			}
		}
        
        if(orientation == CaperucitaState.DOWN) {
        	while(!capState.hayArbol(row,column) && !capState.hayFlores(row, column)) {
        		if(capState.hayDulce(row,column)) {
        			capState.setWoodPosition(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
        			capState.setCandies(capState.getCandies()+1);
        		}
        		else if(capState.hayLobo(row,column)) {
        			capState.setLives(capState.getLives()-1);
					// TODO VUELVE A ARRANCAR
				}
				else {
					capState.setWoodPosition(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
				}
				row++;
        	}
			if(capState.hayFlores(row, column)) {
				capState.setCurrentRow(row);
				capState.setCurrentColumn(column);
			}
			if(capState.hayArbol(row, column)) {
				capState.setCurrentRow(row-1);
				capState.setCurrentColumn(column);
			}
		}
		
        if(orientation == CaperucitaState.LEFT) {
        	while(!capState.hayArbol(row,column) && !capState.hayFlores(row, column)) {
        		if(capState.hayDulce(row,column)) {
        			capState.setWoodPosition(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
        			capState.setCandies(capState.getCandies()+1);
        		}
        		else if(capState.hayLobo(row,column)) {
					capState.setLives(capState.getLives()-1);
					// TODO VUELVE A ARRANCAR
				}
				else {
					capState.setWoodPosition(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
				}
				column--; //voy para la derecha
        	}
			if(capState.hayFlores(row, column)) {
				capState.setCurrentRow(row);
				capState.setCurrentColumn(column);
			}
			if(capState.hayArbol(row, column)) {
				capState.setCurrentRow(row);
				capState.setCurrentColumn(column+1);
			}
		}
		
        return capState;
	}

	@Override
	public Double getCost() {
		return new Double(1);
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		CaperucitaState capState = (CaperucitaState) ast;
		WoodsState woodState = (WoodsState) est;

        int row = woodState.getAgentPosition()[0];
        int column = woodState.getAgentPosition()[1];
        int orientation = woodState.getAgentOrientation();
        int[][] wood = woodState.getWood();
        
        if(orientation == CaperucitaState.UP) {
        	while(!capState.hayArbol(row,column) && !capState.hayFlores(row, column)) {
        		if(capState.hayDulce(row,column)) {
        			woodState.setWood(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
        			//capState.setCandies(capState.getCandies()+1);
        		}
        		else if(capState.hayLobo(row,column)) {
        			woodState.setAgentLives(woodState.getAgentLives()-1);
					// TODO VUELVE A ARRANCAR
				}
				else {
					capState.setWoodPosition(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
				}
				row--; //voy para arriba
        	}
			if(capState.hayFlores(row, column)) {
				capState.setCurrentRow(row);
				capState.setCurrentColumn(column);
				int[] newPosition = {row, column};
				woodState.setAgentPosition(newPosition);
			}
			if(capState.hayArbol(row, column)) {
				capState.setCurrentRow(row+1); //si en row hay arbol, debe posicionarse abajo
				capState.setCurrentColumn(column);
				int[] newPosition = {row+1, column};
				woodState.setAgentPosition(newPosition);
			}
			/*
			// Buscamos nueva posicion del lobo
			int newRowWolf, newColWolf;
			do {
				newRowWolf = (int) Math.random()*9;
				newColWolf = (int) Math.random()*14;
			} while(woodActual[newRowWolf][newColWolf] != CaperucitaPerception.EMPTY_PERCEPTION);
			
			// Seteamos nueva posicion del lobo
			for(int i=0; i<9; i++) {
	    		for(int j=0; j<14; j++) {
	    			if(hayLobo(i,j))
	    				woodActual[i][j] = CaperucitaPerception.EMPTY_PERCEPTION;
	    		}
	    	}
			woodActual[newRowWolf][newColWolf] = CaperucitaPerception.WOLF_PERCEPTION;
			*/
			//enviromentState.setWood(woodActual);	        
			//caperucitaState.setWood(woodActual);
		}
        
        if(orientation == CaperucitaState.RIGHT) {
        	while(!capState.hayArbol(row,column) && !capState.hayFlores(row, column)) {
        		if(capState.hayDulce(row,column)) {
        			woodState.setWood(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
        			//capState.setCandies(capState.getCandies()+1);
        		}
        		else if(capState.hayLobo(row,column)) {
        			woodState.setAgentLives(woodState.getAgentLives()-1);
					// TODO VUELVE A ARRANCAR
				}
				else {
					capState.setWoodPosition(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
				}
				column++;
        	}
			if(capState.hayFlores(row, column)) {
				capState.setCurrentRow(row);
				capState.setCurrentColumn(column);
				int[] newPosition = {row, column};
				woodState.setAgentPosition(newPosition);
			}
			if(capState.hayArbol(row, column)) {
				capState.setCurrentRow(row); //si en row hay arbol, debe posicionarse abajo
				capState.setCurrentColumn(column-1);
				int[] newPosition = {row, column-1};
				woodState.setAgentPosition(newPosition);
			}
			/*
			// Buscamos nueva posicion del lobo
			int newRowWolf, newColWolf;
			do {
				newRowWolf = (int) Math.random()*9;
				newColWolf = (int) Math.random()*14;
			} while(woodActual[newRowWolf][newColWolf] != CaperucitaPerception.EMPTY_PERCEPTION);
			
			// Seteamos nueva posicion del lobo
			for(int i=0; i<9; i++) {
	    		for(int j=0; j<14; j++) {
	    			if(hayLobo(i,j))
	    				woodActual[i][j] = CaperucitaPerception.EMPTY_PERCEPTION;
	    		}
	    	}
			woodActual[newRowWolf][newColWolf] = CaperucitaPerception.WOLF_PERCEPTION;
			*/
			//enviromentState.setWood(woodActual);	        
			//caperucitaState.setWood(woodActual);
		}
        
        if(orientation == CaperucitaState.DOWN) {
        	while(!capState.hayArbol(row,column) && !capState.hayFlores(row, column)) {
        		if(capState.hayDulce(row,column)) {
        			woodState.setWood(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
        			//capState.setCandies(capState.getCandies()+1);
        		}
        		else if(capState.hayLobo(row,column)) {
        			woodState.setAgentLives(woodState.getAgentLives()-1);
					// TODO VUELVE A ARRANCAR
				}
				else {
					capState.setWoodPosition(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
				}
				row++;
        	}
			if(capState.hayFlores(row, column)) {
				capState.setCurrentRow(row);
				capState.setCurrentColumn(column);
				int[] newPosition = {row, column};
				woodState.setAgentPosition(newPosition);
			}
			if(capState.hayArbol(row, column)) {
				capState.setCurrentRow(row-1);
				capState.setCurrentColumn(column);
				int[] newPosition = {row-1, column};
				woodState.setAgentPosition(newPosition);
			}
			/*
			// Buscamos nueva posicion del lobo
			int newRowWolf, newColWolf;
			do {
				newRowWolf = (int) Math.random()*9;
				newColWolf = (int) Math.random()*14;
			} while(woodActual[newRowWolf][newColWolf] != CaperucitaPerception.EMPTY_PERCEPTION);
			
			// Seteamos nueva posicion del lobo
			for(int i=0; i<9; i++) {
	    		for(int j=0; j<14; j++) {
	    			if(hayLobo(i,j))
	    				woodActual[i][j] = CaperucitaPerception.EMPTY_PERCEPTION;
	    		}
	    	}
			woodActual[newRowWolf][newColWolf] = CaperucitaPerception.WOLF_PERCEPTION;
			*/
			//enviromentState.setWood(woodActual);	        
			//caperucitaState.setWood(woodActual);
		}
			
        if(orientation == CaperucitaState.LEFT) {
        	while(!capState.hayArbol(row,column) && !capState.hayFlores(row, column)) {
        		if(capState.hayDulce(row,column)) {
        			woodState.setWood(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
        			//capState.setCandies(capState.getCandies()+1);
        		}
        		else if(capState.hayLobo(row,column)) {
        			woodState.setAgentLives(woodState.getAgentLives()-1);
					// TODO VUELVE A ARRANCAR
				}
				else {
					capState.setWoodPosition(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
				}
				column--;
        	}
			if(capState.hayFlores(row, column)) {
				capState.setCurrentRow(row);
				capState.setCurrentColumn(column);
				int[] newPosition = {row, column};
				woodState.setAgentPosition(newPosition);
			}
			if(capState.hayArbol(row, column)) {
				capState.setCurrentRow(row); //si en row hay arbol, debe posicionarse abajo
				capState.setCurrentColumn(column+1);
				int[] newPosition = {row, column+1};
				woodState.setAgentPosition(newPosition);
			}
			/*
			// Buscamos nueva posicion del lobo
			int newRowWolf, newColWolf;
			do {
				newRowWolf = (int) Math.random()*9;
				newColWolf = (int) Math.random()*14;
			} while(woodActual[newRowWolf][newColWolf] != CaperucitaPerception.EMPTY_PERCEPTION);
			
			// Seteamos nueva posicion del lobo
			for(int i=0; i<9; i++) {
	    		for(int j=0; j<14; j++) {
	    			if(hayLobo(i,j))
	    				woodActual[i][j] = CaperucitaPerception.EMPTY_PERCEPTION;
	    		}
	    	}
			woodActual[newRowWolf][newColWolf] = CaperucitaPerception.WOLF_PERCEPTION;
			*/
			//enviromentState.setWood(woodActual);	        
			//caperucitaState.setWood(woodActual);
		}
     
        return woodState;
	}

	@Override
	public String toString() {
		return "Moverse hacia adelante";
	}

	
}
