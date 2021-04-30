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
		CaperucitaState caperucitaState = (CaperucitaState) s;

        int row = caperucitaState.getCurrentRow();
        int column = caperucitaState.getCurrentColumn();
        int orientation = caperucitaState.getOrientation();
        int[][] woodActual = caperucitaState.getWood();
        
        if(orientation == CaperucitaState.UP) {
			int rowInitial = row;
			while(woodActual[rowInitial][column] != CaperucitaPerception.TREE_PERCEPTION
					&& woodActual[rowInitial][column] != CaperucitaPerception.FLOWER_PERCEPTION) {
				if(woodActual[rowInitial][column] == CaperucitaPerception.CANDY_PERCEPTION) {
					caperucitaState.setWoodPosition(rowInitial, column, CaperucitaPerception.EMPTY_PERCEPTION);
		        	caperucitaState.setCandies(caperucitaState.getCandies()+1);
				}
				else if(woodActual[rowInitial][column] == CaperucitaPerception.WOLF_PERCEPTION) {
					int lives = caperucitaState.getLives();
					caperucitaState.setLives(lives--);	
					// TODO VUELVE A ARRANCAR
				}
				rowInitial--;
			}
			if(woodActual[rowInitial][column] == CaperucitaPerception.FLOWER_PERCEPTION) {
				caperucitaState.setCurrentRow(rowInitial);
				caperucitaState.setCurrentColumn(column);
				System.out.println("nueva pos: ["+rowInitial+", "+column+"] ");
			}
			if(woodActual[rowInitial][column] == CaperucitaPerception.TREE_PERCEPTION) {
				caperucitaState.setCurrentRow(rowInitial+1);
				caperucitaState.setCurrentColumn(column);
				//System.out.println("nueva pos: ["+rowInitial+", "+column+"] ");
			}
			//caperucitaState.setCurrentRow(rowInitial);
			caperucitaState.setWood(woodActual);
		}
		
		else if(orientation == CaperucitaState.RIGHT) {
			int columnInitial = column;
			while(woodActual[row][columnInitial] != CaperucitaPerception.TREE_PERCEPTION
					&& woodActual[row][columnInitial] != CaperucitaPerception.FLOWER_PERCEPTION) {
				if(woodActual[row][columnInitial] == CaperucitaPerception.CANDY_PERCEPTION) {
					caperucitaState.setWoodPosition(row, columnInitial, CaperucitaPerception.EMPTY_PERCEPTION);
		        	caperucitaState.setCandies(caperucitaState.getCandies()+1);
				}
				else if(woodActual[row][columnInitial] == CaperucitaPerception.WOLF_PERCEPTION) {
					int lives = caperucitaState.getLives();
					caperucitaState.setLives(lives--);	
					// TODO VUELVE A ARRANCAR
				}
				columnInitial++;
			}
			if(woodActual[row][columnInitial] == CaperucitaPerception.FLOWER_PERCEPTION) {
				caperucitaState.setCurrentRow(row);
				caperucitaState.setCurrentColumn(columnInitial);
				//System.out.println("nueva pos: ["+rowInitial+", "+column+"] ");
			}
			if(woodActual[row][columnInitial] == CaperucitaPerception.TREE_PERCEPTION) {
				caperucitaState.setCurrentRow(row);
				caperucitaState.setCurrentColumn(columnInitial-1);
				//System.out.println("nueva pos: ["+rowInitial+", "+column+"] ");
			}
			//caperucitaState.setCurrentColumn(columnInitial);
			
			caperucitaState.setWood(woodActual);
		}
		
		else if(orientation == CaperucitaState.DOWN) {
			int rowInitial = row;
			while(woodActual[rowInitial][column] != CaperucitaPerception.TREE_PERCEPTION
					&& woodActual[rowInitial][column] != CaperucitaPerception.FLOWER_PERCEPTION) {
				if(woodActual[rowInitial][column] == CaperucitaPerception.CANDY_PERCEPTION) {
					caperucitaState.setWoodPosition(rowInitial, column, CaperucitaPerception.EMPTY_PERCEPTION);
		        	caperucitaState.setCandies(caperucitaState.getCandies()+1);
				}
				else if(woodActual[rowInitial][column] == CaperucitaPerception.WOLF_PERCEPTION) {
					int lives = caperucitaState.getLives();
					caperucitaState.setLives(lives--);	
					// TODO VUELVE A ARRANCAR
				}
				rowInitial++;
			}
			if(woodActual[rowInitial][column] == CaperucitaPerception.FLOWER_PERCEPTION) {
				caperucitaState.setCurrentRow(rowInitial);
				caperucitaState.setCurrentColumn(column);
				//System.out.println("nueva pos: ["+rowInitial+", "+column+"] ");
			}
			if(woodActual[rowInitial][column] == CaperucitaPerception.TREE_PERCEPTION) {
				caperucitaState.setCurrentRow(rowInitial-1);
				caperucitaState.setCurrentColumn(column);
				//System.out.println("nueva pos: ["+rowInitial+", "+column+"] ");
			}
			
			//caperucitaState.setCurrentRow(rowInitial);
			
			caperucitaState.setWood(woodActual);
		}
		
		else if(orientation == CaperucitaState.LEFT) {
			int columnInitial = column;
			while(woodActual[row][columnInitial] != CaperucitaPerception.TREE_PERCEPTION
					&& woodActual[row][columnInitial] != CaperucitaPerception.FLOWER_PERCEPTION) {
				if(woodActual[row][columnInitial] == CaperucitaPerception.CANDY_PERCEPTION) {
					caperucitaState.setWoodPosition(row, columnInitial, CaperucitaPerception.EMPTY_PERCEPTION);
		        	caperucitaState.setCandies(caperucitaState.getCandies()+1);
				}
				else if(woodActual[row][columnInitial] == CaperucitaPerception.WOLF_PERCEPTION) {
					int lives = caperucitaState.getLives();
					caperucitaState.setLives(lives--);	
					// TODO VUELVE A ARRANCAR
				}
				columnInitial--;
			}
			if(woodActual[row][columnInitial] == CaperucitaPerception.FLOWER_PERCEPTION) {
				caperucitaState.setCurrentRow(row);
				caperucitaState.setCurrentColumn(columnInitial);
				//System.out.println("nueva pos: ["+rowInitial+", "+column+"] ");
			}
			if(woodActual[row][columnInitial] == CaperucitaPerception.TREE_PERCEPTION) {
				caperucitaState.setCurrentRow(row);
				caperucitaState.setCurrentColumn(columnInitial+1);
				//System.out.println("nueva pos: ["+rowInitial+", "+column+"] ");
			}
			
			//caperucitaState.setCurrentColumn(columnInitial);
			
			caperucitaState.setWood(woodActual);
		}
        
        return caperucitaState;
	}

	@Override
	public Double getCost() {
		return new Double(1);
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		CaperucitaState caperucitaState = (CaperucitaState) ast;
		WoodsState enviromentState = (WoodsState) est;

        int row = enviromentState.getAgentPosition()[0];
        int column = enviromentState.getAgentPosition()[1];
        int orientation = enviromentState.getAgentOrientation();
        int[][] woodActual = enviromentState.getWood();
        
        if(orientation == CaperucitaState.UP) {
			int rowInitial = row;
			while(woodActual[rowInitial][column] != CaperucitaPerception.TREE_PERCEPTION
					&& woodActual[rowInitial][column] != CaperucitaPerception.FLOWER_PERCEPTION) {
				if(woodActual[rowInitial][column] == CaperucitaPerception.CANDY_PERCEPTION) {
					enviromentState.setWood(rowInitial, column, CaperucitaPerception.EMPTY_PERCEPTION);
					caperucitaState.setCandies(caperucitaState.getCandies()+1);
				}
				else if(woodActual[rowInitial][column] == CaperucitaPerception.WOLF_PERCEPTION) {
					int lives = enviromentState.getAgentLives();
					enviromentState.setAgentLives(lives--);
					caperucitaState.setLives(lives--);
					// TODO VUELVE A ARRANCAR
				}
				rowInitial--;
			}
			
			if(woodActual[rowInitial][column] == CaperucitaPerception.FLOWER_PERCEPTION) {
				caperucitaState.setCurrentRow(rowInitial);
				caperucitaState.setCurrentColumn(column);
				int[] newPosition = {rowInitial, column};
				enviromentState.setAgentPosition(newPosition);
				System.out.println("nueva pos: ["+rowInitial+", "+column+"] ");
			}
			if(woodActual[rowInitial][column] == CaperucitaPerception.TREE_PERCEPTION) {
				caperucitaState.setCurrentRow(rowInitial+1);
				caperucitaState.setCurrentColumn(column);
				int[] newPosition = {rowInitial+1, column};
				enviromentState.setAgentPosition(newPosition);
				//System.out.println("nueva pos: ["+rowInitial+", "+column+"] ");
			}
			//caperucitaState.setCurrentRow(rowInitial);
			caperucitaState.setWood(woodActual);
			
			// Seteamos nueva posicion de caperucita
//			caperucitaState.setCurrentRow(rowInitial);
			
			// Buscamos nueva posicion del lobo
			/*int newRowWolf, newColWolf;
			do {
				newRowWolf = (int) Math.random()*9;
				newColWolf = (int) Math.random()*14;
			} while(woodActual[newRowWolf][newColWolf] != CaperucitaPerception.EMPTY_PERCEPTION);
			
			// Seteamos nueva posicion del lobo
			for(int i=0; i<9; i++) {
	    		for(int j=0; j<14; j++) {
	    			if(woodActual[i][j] == CaperucitaPerception.WOLF_PERCEPTION)
	    				woodActual[i][j] = CaperucitaPerception.EMPTY_PERCEPTION;
	    		}
	    	}
			
			woodActual[newRowWolf][newColWolf] = CaperucitaPerception.WOLF_PERCEPTION;
			*/
			enviromentState.setWood(woodActual);
			
			String str = "";
			str = str + "\nWood actual=\"[ \n";
	        for (int i=0; i<9; i++) {
	            str = str + "[ ";
	            for (int j=0; j<14; j++) {
	                if (woodActual[i][j] == -1) {
	                    str = str + "* ";
	                } else {
	                    str = str + woodActual[i][j] + " ";
	                }
	            }
	            str = str + " ]\n";
	        }
	        str = str + " ]\"";
	        
			
			caperucitaState.setWood(woodActual); 
		}
		
		else if(orientation == CaperucitaState.RIGHT) {
			int columnInitial = column;
			while(woodActual[row][columnInitial] != CaperucitaPerception.TREE_PERCEPTION
					&& woodActual[row][columnInitial] != CaperucitaPerception.FLOWER_PERCEPTION) {
				if(woodActual[row][columnInitial] == CaperucitaPerception.CANDY_PERCEPTION) {
					enviromentState.setWood(row, columnInitial, CaperucitaPerception.EMPTY_PERCEPTION);
				}
				else if(woodActual[row][columnInitial] == CaperucitaPerception.WOLF_PERCEPTION) {
					int lives = enviromentState.getAgentLives();
					enviromentState.setAgentLives(lives--);	
					// TODO VUELVE A ARRANCAR
				}
				columnInitial++;
			}
			if(woodActual[row][columnInitial] == CaperucitaPerception.FLOWER_PERCEPTION) {
				caperucitaState.setCurrentRow(row);
				caperucitaState.setCurrentColumn(columnInitial);
				int[] newPosition = {row, columnInitial};
				enviromentState.setAgentPosition(newPosition);
				//System.out.println("nueva pos: ["+rowInitial+", "+column+"] ");
			}
			if(woodActual[row][columnInitial] == CaperucitaPerception.TREE_PERCEPTION) {
				caperucitaState.setCurrentRow(row);
				caperucitaState.setCurrentColumn(columnInitial-1);
				int[] newPosition = {row, columnInitial-1};
				enviromentState.setAgentPosition(newPosition);
				//System.out.println("nueva pos: ["+rowInitial+", "+column+"] ");
			}/*
			//Buscamos nueva posicion del lobo
			int newRowWolf, newColWolf;
			do {
				newRowWolf = (int) Math.random()*9;
				newColWolf = (int) Math.random()*14;
			} while(woodActual[newRowWolf][newColWolf] != CaperucitaPerception.EMPTY_PERCEPTION);
									
			// Seteamos nueva posicion del lobo
			for(int i=0; i<9; i++) {
				for(int j=0; j<14; j++) {
					if(woodActual[i][j] == CaperucitaPerception.WOLF_PERCEPTION)
						woodActual[i][j] = CaperucitaPerception.EMPTY_PERCEPTION;
				}
			}
									
			woodActual[newRowWolf][newColWolf] = CaperucitaPerception.WOLF_PERCEPTION;
				*/										
			enviromentState.setWood(woodActual);
			caperucitaState.setWood(woodActual); 
		}
		
		else if(orientation == CaperucitaState.DOWN) {
			int rowInitial = row;
			while(woodActual[rowInitial][column] != CaperucitaPerception.TREE_PERCEPTION
					&& woodActual[rowInitial][column] != CaperucitaPerception.FLOWER_PERCEPTION) {
				if(woodActual[rowInitial][column] == CaperucitaPerception.CANDY_PERCEPTION) {
					enviromentState.setWood(rowInitial, column, CaperucitaPerception.EMPTY_PERCEPTION);
				}
				else if(woodActual[rowInitial][column] == CaperucitaPerception.WOLF_PERCEPTION) {
					int lives = enviromentState.getAgentLives();
					enviromentState.setAgentLives(lives--);	
					// TODO VUELVE A ARRANCAR
				}
				rowInitial++;
			}
			if(woodActual[rowInitial][column] == CaperucitaPerception.FLOWER_PERCEPTION) {
				caperucitaState.setCurrentRow(rowInitial);
				caperucitaState.setCurrentColumn(column);
				int[] newPosition = {rowInitial, column};
				enviromentState.setAgentPosition(newPosition);
				//System.out.println("nueva pos: ["+rowInitial+", "+column+"] ");
			}
			if(woodActual[rowInitial][column] == CaperucitaPerception.TREE_PERCEPTION) {
				caperucitaState.setCurrentRow(rowInitial-1);
				caperucitaState.setCurrentColumn(column);
				int[] newPosition = {rowInitial-1, column};
				enviromentState.setAgentPosition(newPosition);
				//System.out.println("nueva pos: ["+rowInitial+", "+column+"] ");
			}/*
			// Buscamos nueva posicion del lobo
			int newRowWolf, newColWolf;
			do {
				newRowWolf = (int) Math.random()*9;
				newColWolf = (int) Math.random()*14;
			} while(woodActual[newRowWolf][newColWolf] != CaperucitaPerception.EMPTY_PERCEPTION);
						
			// Seteamos nueva posicion del lobo
			for(int i=0; i<9; i++) {
				for(int j=0; j<14; j++) {
					if(woodActual[i][j] == CaperucitaPerception.WOLF_PERCEPTION)
						woodActual[i][j] = CaperucitaPerception.EMPTY_PERCEPTION;
				}
			}
						
			woodActual[newRowWolf][newColWolf] = CaperucitaPerception.WOLF_PERCEPTION;
						*/
			enviromentState.setWood(woodActual);
			caperucitaState.setWood(woodActual); 
		}
		
		else if(orientation == CaperucitaState.LEFT) {
			int columnInitial = column;
			while(woodActual[row][columnInitial] != CaperucitaPerception.TREE_PERCEPTION
					&& woodActual[row][columnInitial] != CaperucitaPerception.FLOWER_PERCEPTION) {
				if(woodActual[row][columnInitial] == CaperucitaPerception.CANDY_PERCEPTION) {
					enviromentState.setWood(row, columnInitial, CaperucitaPerception.EMPTY_PERCEPTION);
				}
				else if(woodActual[row][columnInitial] == CaperucitaPerception.WOLF_PERCEPTION) {
					int lives = enviromentState.getAgentLives();
					enviromentState.setAgentLives(lives--);	
					// TODO VUELVE A ARRANCAR
				}
				columnInitial--;
			}
			if(woodActual[row][columnInitial] == CaperucitaPerception.FLOWER_PERCEPTION) {
				caperucitaState.setCurrentRow(row);
				caperucitaState.setCurrentColumn(columnInitial);
				int[] newPosition = {row, columnInitial};
				enviromentState.setAgentPosition(newPosition);
				//System.out.println("nueva pos: ["+rowInitial+", "+column+"] ");
			}
			if(woodActual[row][columnInitial] == CaperucitaPerception.TREE_PERCEPTION) {
				caperucitaState.setCurrentRow(row);
				caperucitaState.setCurrentColumn(columnInitial+1);
				int[] newPosition = {row, columnInitial+1};
				enviromentState.setAgentPosition(newPosition);
				//System.out.println("nueva pos: ["+rowInitial+", "+column+"] ");
			}
								
			/*//Buscamos nueva posicion del lobo
			int newRowWolf, newColWolf;
			do {
				newRowWolf = (int) Math.random()*9;
				newColWolf = (int) Math.random()*14;
			} while(woodActual[newRowWolf][newColWolf] != CaperucitaPerception.EMPTY_PERCEPTION);
									
			// Seteamos nueva posicion del lobo
			for(int i=0; i<9; i++) {
				for(int j=0; j<14; j++) {
					if(woodActual[i][j] == CaperucitaPerception.WOLF_PERCEPTION)
						woodActual[i][j] = CaperucitaPerception.EMPTY_PERCEPTION;
				}
			}
									
			woodActual[newRowWolf][newColWolf] = CaperucitaPerception.WOLF_PERCEPTION;
			*/											
			enviromentState.setWood(woodActual);
			caperucitaState.setWood(woodActual); 
		}
        
        return enviromentState;
	}

	@Override
	public String toString() {
		return "Moverse hacia adelante";
	}

	
}
