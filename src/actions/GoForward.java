package actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import search.CaperucitaPerception;
import search.CaperucitaState;
import search.WoodsState;

public class GoForward extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		CaperucitaState capState = (CaperucitaState) s;

        int row = capState.getCurrentRow();
        int column = capState.getCurrentColumn();
        int orientation = capState.getOrientation();
        int[][] woodPercibido = capState.getWood();
        
        
        if(orientation == CaperucitaState.UP) {
        	if(capState.hayArbol(row-1,column)) {
        		return null;
        	}
        }
        if(orientation == CaperucitaState.DOWN) {
        	if(capState.hayArbol(row+1,column)) {
        		return null;
        	}
        }
        if(orientation == CaperucitaState.RIGHT) {
        	if(capState.hayArbol(row,column+1)) {
        		return null;
        	}
        }
        if(orientation == CaperucitaState.LEFT) {
        	if(capState.hayArbol(row,column-1)) {
        		return null;
        	}
        }
        
        if(orientation == CaperucitaState.UP) {
        	while(!capState.hayArbol(row,column) && !capState.hayFlores(row, column)) {
        		if(capState.hayDulce(row,column)) {
        			capState.setWoodPosition(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
        			capState.setCandies(capState.getCandies()+1);
        		}
        		else if(capState.hayLobo(row,column)) {
					capState.setLives(capState.getLives()-1);
        			capState.setWood(this.reiniciarNivelCaperucita());
        	    	capState.setCandies(0);
        	    	capState.setCurrentRow(5);
        	    	capState.setCurrentColumn(11);
        	    	capState.setOrientation(1);
				}
				else {
					capState.setWoodPosition(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
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
        			capState.setWood(this.reiniciarNivelCaperucita());
        	    	capState.setCandies(0);
        	    	capState.setCurrentRow(5);
        	    	capState.setCurrentColumn(11);
        	    	capState.setOrientation(1);
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
        			capState.setWood(this.reiniciarNivelCaperucita());
        	    	capState.setCandies(0);
        	    	capState.setCurrentRow(5);
        	    	capState.setCurrentColumn(11);
        	    	capState.setOrientation(1);
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
        			capState.setWood(this.reiniciarNivelCaperucita());
        	    	capState.setCandies(0);
        	    	capState.setCurrentRow(5);
        	    	capState.setCurrentColumn(11);
        	    	capState.setOrientation(1);
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
        			woodState.setAgentCandies(woodState.getAgentCandies() + 1);
        			capState.setWoodPosition(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
        			//capState.setCandies(capState.getCandies()+1);
        		}
        		else if(capState.hayLobo(row,column)) {
        			woodState.setAgentLives(woodState.getAgentLives()-1);
        			woodState.setWood(this.reiniciarNivelWood());
        	    	woodState.setAgentCandies(0);
        	    	int[] newPosition = {5, 11};
    				woodState.setAgentPosition(newPosition);
        	    	woodState.setAgentOrientation(1);
        	    	capState.setWood(this.reiniciarNivelCaperucita());
        	    	capState.setCandies(0);
        	    	capState.setCurrentRow(5);
        	    	capState.setCurrentColumn(11);
        	    	capState.setOrientation(1);
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
			
			// Buscamos nueva posicion del lobo
			int newRowWolf, newColWolf;
			do {
				newRowWolf = (int) Math.floor(Math.random()*9);
				newColWolf = (int) Math.floor(Math.random()*14);
			} while(wood[newRowWolf][newColWolf] != CaperucitaPerception.EMPTY_PERCEPTION);
			
			// Seteamos nueva posicion del lobo
			for(int i=0; i<9; i++) {
				for(int j=0; j<14; j++) {
					if(capState.hayLobo(i,j)) {
						capState.setWoodPosition(i, j, CaperucitaPerception.UNKNOWN_PERCEPTION);
	    			}
					if(wood[i][j] == CaperucitaPerception.WOLF_PERCEPTION) {
						woodState.setWood(i, j, CaperucitaPerception.EMPTY_PERCEPTION);
					}
				}
			}
			woodState.setWood(newRowWolf, newColWolf, CaperucitaPerception.WOLF_PERCEPTION);
			
			//woodState.setWood(wood);	        
			//capState.setWood(wood);
		}
        
        if(orientation == CaperucitaState.RIGHT) {
        	while(!capState.hayArbol(row,column) && !capState.hayFlores(row, column)) {
        		if(capState.hayDulce(row,column)) {
        			woodState.setWood(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
        			woodState.setAgentCandies(woodState.getAgentCandies() + 1);
        			capState.setWoodPosition(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
        			//capState.setCandies(capState.getCandies()+1);
        		}
        		else if(capState.hayLobo(row,column)) {
        			woodState.setAgentLives(woodState.getAgentLives()-1);
        			woodState.setWood(this.reiniciarNivelWood());
        	    	woodState.setAgentCandies(0);
        	    	int[] newPosition = {5, 11};
    				woodState.setAgentPosition(newPosition);
        	    	woodState.setAgentOrientation(1);
        	    	capState.setWood(this.reiniciarNivelCaperucita());
        	    	capState.setCandies(0);
        	    	capState.setCurrentRow(5);
        	    	capState.setCurrentColumn(11);
        	    	capState.setOrientation(1);
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
			// Buscamos nueva posicion del lobo
			int newRowWolf, newColWolf;
			do {
				newRowWolf = (int) Math.floor(Math.random()*9);
				newColWolf = (int) Math.floor(Math.random()*14);
			} while(wood[newRowWolf][newColWolf] != CaperucitaPerception.EMPTY_PERCEPTION);
						
			// Seteamos nueva posicion del lobo
			for(int i=0; i<9; i++) {
				for(int j=0; j<14; j++) {
					if(capState.hayLobo(i,j)) {
						capState.setWoodPosition(i, j, CaperucitaPerception.UNKNOWN_PERCEPTION);
	    			}
					if(wood[i][j] == CaperucitaPerception.WOLF_PERCEPTION) {
						woodState.setWood(i, j, CaperucitaPerception.EMPTY_PERCEPTION);
					}
				}
			}
			woodState.setWood(newRowWolf, newColWolf, CaperucitaPerception.WOLF_PERCEPTION);
						
			//woodState.setWood(wood);	        
			//capState.setWood(wood);
		}
        
        if(orientation == CaperucitaState.DOWN) {
        	while(!capState.hayArbol(row,column) && !capState.hayFlores(row, column)) {
        		if(capState.hayDulce(row,column)) {
        			woodState.setWood(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
        			woodState.setAgentCandies(woodState.getAgentCandies() + 1);
        			capState.setWoodPosition(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
        			//capState.setCandies(capState.getCandies()+1);
        		}
        		else if(capState.hayLobo(row,column)) {
        			woodState.setAgentLives(woodState.getAgentLives()-1);
        			woodState.setWood(this.reiniciarNivelWood());
        	    	woodState.setAgentCandies(0);
        	    	int[] newPosition = {5, 11};
    				woodState.setAgentPosition(newPosition);
        	    	woodState.setAgentOrientation(1);
        	    	capState.setWood(this.reiniciarNivelCaperucita());
        	    	capState.setCandies(0);
        	    	capState.setCurrentRow(5);
        	    	capState.setCurrentColumn(11);
        	    	capState.setOrientation(1);
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
			// Buscamos nueva posicion del lobo
			int newRowWolf, newColWolf;
			do {
				newRowWolf = (int) Math.floor(Math.random()*9);
				newColWolf = (int) Math.floor(Math.random()*14);
			} while(wood[newRowWolf][newColWolf] != CaperucitaPerception.EMPTY_PERCEPTION);
									
			// Seteamos nueva posicion del lobo
			for(int i=0; i<9; i++) {
				for(int j=0; j<14; j++) {
					if(capState.hayLobo(i,j)) {
						capState.setWoodPosition(i, j, CaperucitaPerception.UNKNOWN_PERCEPTION);
	    			}
					if(wood[i][j] == CaperucitaPerception.WOLF_PERCEPTION) {
						woodState.setWood(i, j, CaperucitaPerception.EMPTY_PERCEPTION);
					}
				}
			}
			woodState.setWood(newRowWolf, newColWolf, CaperucitaPerception.WOLF_PERCEPTION);
			
			//woodState.setWood(wood);	        
			//capState.setWood(wood);
		}
			
        if(orientation == CaperucitaState.LEFT) {
        	while(!capState.hayArbol(row,column) && !capState.hayFlores(row, column)) {
        		if(capState.hayDulce(row,column)) {
        			woodState.setWood(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
        			capState.setWoodPosition(row, column, CaperucitaPerception.EMPTY_PERCEPTION);
        			woodState.setAgentCandies(woodState.getAgentCandies() + 1);
        			//capState.setCandies(capState.getCandies()+1);
        		}
        		else if(capState.hayLobo(row,column)) {
        			woodState.setAgentLives(woodState.getAgentLives()-1);
        			woodState.setWood(this.reiniciarNivelWood());
        	    	woodState.setAgentCandies(0);
        	    	int[] newPosition = {5, 11};
    				woodState.setAgentPosition(newPosition);
        	    	woodState.setAgentOrientation(1);
        	    	capState.setWood(this.reiniciarNivelCaperucita());
        	    	capState.setCandies(0);
        	    	capState.setCurrentRow(5);
        	    	capState.setCurrentColumn(11);
        	    	capState.setOrientation(1);
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
			// Buscamos nueva posicion del lobo
			int newRowWolf, newColWolf;
			do {
				newRowWolf = (int) Math.floor(Math.random()*9);
				newColWolf = (int) Math.floor(Math.random()*14);
			} while(wood[newRowWolf][newColWolf] != CaperucitaPerception.EMPTY_PERCEPTION);
									
			// Seteamos nueva posicion del lobo
			for(int i=0; i<9; i++) {
				for(int j=0; j<14; j++) {
					if(capState.hayLobo(i,j)) {
						capState.setWoodPosition(i, j, CaperucitaPerception.UNKNOWN_PERCEPTION);
	    			}
					if(wood[i][j] == CaperucitaPerception.WOLF_PERCEPTION) {
						woodState.setWood(i, j, CaperucitaPerception.EMPTY_PERCEPTION);
					}
				}
			}
			woodState.setWood(newRowWolf, newColWolf, CaperucitaPerception.WOLF_PERCEPTION);
									
			//woodState.setWood(wood);	        
			//capState.setWood(wood);
		}
     
        return woodState;
	}

	@Override
	public String toString() {
		return "Moverse hacia adelante";
	}

	public int[][] reiniciarNivelWood() {
		int[][] wood = new int[9][14];
    	
    	for(int i=0; i<9; i++) {
    		for(int j=0; j<14; j++) {
    			wood[i][j] = CaperucitaPerception.EMPTY_PERCEPTION;
    		}
    	}
    	
    	/*Primeras tres columnas con arboles*/
    	for(int i=0; i<9; i++) {
    		for(int j=0; j<3; j++) {
    			wood[i][j] = CaperucitaPerception.TREE_PERCEPTION;
    		}
    	}
    	
    	/*Ultimas dos columnas con arboles*/
    	for(int i=0; i<9; i++) {
    		for(int j=12; j<14; j++) {
    			wood[i][j] = CaperucitaPerception.TREE_PERCEPTION;
    		}
    	}
    	
    	for(int j=3; j<12; j++) {
    		/*Primera fila con arboles*/
    		wood[0][j] = CaperucitaPerception.TREE_PERCEPTION;
    		/*Ultima fila con arboles*/
    		wood[8][j] = CaperucitaPerception.TREE_PERCEPTION;
    	}
    	
    	/*Ubicacion de los demas arboles*/
    	//Fila 1
    	wood[1][7] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[1][11] = CaperucitaPerception.TREE_PERCEPTION;
    	//Fila 2
    	wood[2][4] = CaperucitaPerception.TREE_PERCEPTION;
    	//Fila 3
    	wood[3][9] = CaperucitaPerception.TREE_PERCEPTION;
    	//Fila 4
    	wood[4][3] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[4][4] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[4][8] = CaperucitaPerception.TREE_PERCEPTION;
    	//Fila 5
    	wood[5][4] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[5][5] = CaperucitaPerception.TREE_PERCEPTION;
    	//Fila 6
    	wood[6][5] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[6][6] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[6][7] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[6][9] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[6][11] = CaperucitaPerception.TREE_PERCEPTION;
    	//Fila 7
    	wood[7][6] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[7][11] = CaperucitaPerception.TREE_PERCEPTION;
    	
    	/*Ubicacion de los dulces*/
    	wood[1][3] = CaperucitaPerception.CANDY_PERCEPTION;
    	wood[1][10] = CaperucitaPerception.CANDY_PERCEPTION;
    	wood[3][8] = CaperucitaPerception.CANDY_PERCEPTION;
    	
    	/*Ubicacion del lobo*/
    	wood[2][11] = CaperucitaPerception.WOLF_PERCEPTION;
    	
    	/*Ubicacion del campo de flores*/
    	wood[7][7] = CaperucitaPerception.FLOWER_PERCEPTION;
    	
    	return wood;
	}
	
	public int[][] reiniciarNivelCaperucita() {
		int[][] wood = new int[9][14];
        for (int i=0; i<9; i++) {
            for (int j=0; j<14; j++) {
                wood[i][j] = CaperucitaPerception.UNKNOWN_PERCEPTION;
            }
        }
        
        wood[7][7] = CaperucitaPerception.FLOWER_PERCEPTION;
        
        /*Primeras tres columnas con arboles*/
    	for(int i=0; i<9; i++) {
    		for(int j=0; j<3; j++) {
    			wood[i][j] = CaperucitaPerception.TREE_PERCEPTION;
    		}
    	}
    	
    	/*Ultimas dos columnas con arboles*/
    	for(int i=0; i<9; i++) {
    		for(int j=12; j<14; j++) {
    			wood[i][j] = CaperucitaPerception.TREE_PERCEPTION;
    		}
    	}
    	
    	for(int j=3; j<12; j++) {
    		/*Primera fila con arboles*/
    		wood[0][j] = CaperucitaPerception.TREE_PERCEPTION;
    		/*Ultima fila con arboles*/
    		wood[8][j] = CaperucitaPerception.TREE_PERCEPTION;
    	}
    	
    	/*Ubicacion de los demas arboles*/
    	//Fila 1
    	wood[1][7] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[1][11] = CaperucitaPerception.TREE_PERCEPTION;
    	//Fila 2
    	wood[2][4] = CaperucitaPerception.TREE_PERCEPTION;
    	//Fila 3
    	wood[3][9] = CaperucitaPerception.TREE_PERCEPTION;
    	//Fila 4
    	wood[4][3] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[4][4] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[4][8] = CaperucitaPerception.TREE_PERCEPTION;
    	//Fila 5
    	wood[5][4] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[5][5] = CaperucitaPerception.TREE_PERCEPTION;
    	//Fila 6
    	wood[6][5] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[6][6] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[6][7] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[6][9] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[6][11] = CaperucitaPerception.TREE_PERCEPTION;
    	//Fila 7
    	wood[7][6] = CaperucitaPerception.TREE_PERCEPTION;
    	wood[7][11] = CaperucitaPerception.TREE_PERCEPTION;
    	
    	return wood;
	}
}
