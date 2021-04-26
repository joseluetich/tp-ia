package search;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class WoodsState extends EnvironmentState {
	
	private int[][] wood;
    private int candiesQuantity;
    private int[] agentPosition;
    private int agentOrientation;
    private int agentLives;
    
    public WoodsState() {
    	this.initState();
    }

    @Override
    public void initState() {
        this.wood = new int[9][14];
    	this.setCandiesQuantity(3);
    	
    	for(int i=0; i<9; i++) {
    		for(int j=0; j<14; j++) {
    			wood[i][j] = CaperucitaPerception.EMPTY_PERCEPTION;
    		}
    	}
    	this.setAgentPosition(new int[]{1, 1}); //ver
    	this.setAgentLives(3);
    	
    	//TODO Diseñar el nivel.
    	
    	//Ejemplo pacman
    	/*
        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                world[row][col] = PacmanPerception.EMPTY_PERCEPTION;
            }
        }

        // Sets some cells with foods and enemies. 
        world[0][0] = PacmanPerception.FOOD_PERCEPTION;
        world[0][2] = PacmanPerception.FOOD_PERCEPTION;
        world[3][1] = PacmanPerception.ENEMY_PERCEPTION;
        world[2][1] = PacmanPerception.FOOD_PERCEPTION;
        world[0][3] = PacmanPerception.ENEMY_PERCEPTION;
        world[1][2] = PacmanPerception.FOOD_PERCEPTION;

        this.setAgentPosition(new int[]{1, 1});
        this.setAgentEnergy(50);
        */
    }

    @Override
    public String toString() {
    	
        String str = "";
        int dulces = 0;
        str += "Cantidad De Dulces por juntar: { ";
        for(int i=0; i<9; i++) {
    		for(int j=0; j<14; j++) {
    			if(wood[i][j] == CaperucitaPerception.CANDY_PERCEPTION) {
    				dulces++;
    			}
    		}
        }
        str += (dulces+" }\n");
        
        str += ("Cantidad de Vidas: { "+agentLives+" }"); 
        
        str += ("Posicion del Agente: { "+agentPosition[0]+", "+agentPosition[1]+" }"); 
         
        return str;
    }

	public int[][] getWood() {
		return wood;
	}

	public void setWood(int[][] wood) {
		this.wood = wood;
	}
	
	public void setWood(int row, int col, int value) {
        this.wood[row][col] = value;
    }

	public int getCandiesQuantity() {
		return candiesQuantity;
	}

	public void setCandiesQuantity(int candiesQuantity) {
		this.candiesQuantity = candiesQuantity;
	}

	public int[] getAgentPosition() {
        return agentPosition;
    }

    public void setAgentPosition(int[] agentPosition) {
        this.agentPosition = agentPosition;
    }
    
	public int getAgentOrientation() {
		return agentOrientation;
	}

	public void setAgentOrientation(int agentOrientation) {
		this.agentOrientation = agentOrientation;
	}
	
	public int getAgentLives() {
		return agentLives;
	}

	public void setAgentLives(int agentLives) {
		this.agentLives = agentLives;
	}
	
	public int[] thereIsWolf(int row, int column, int orientation) {
		int[][] woodActual = this.getWood();		
		int[] result = {-1 , -1};
		
		if(orientation == CaperucitaState.UP) {
			int rowInitial = row - 1;
			while(woodActual[rowInitial][column] != CaperucitaPerception.TREE_PERCEPTION) {
				if(woodActual[rowInitial][column] == CaperucitaPerception.WOLF_PERCEPTION) {
					result[0] = rowInitial;
					result[1] = column;
					return result; 
				}
				rowInitial--;
			}
		}
		
		else if(orientation == CaperucitaState.RIGHT) {
			int columnInitial = column + 1;
			while(woodActual[row][columnInitial] != CaperucitaPerception.TREE_PERCEPTION) {
				if(woodActual[row][columnInitial] == CaperucitaPerception.WOLF_PERCEPTION) {
					result[0] = row;
					result[1] = columnInitial;
					return result; 
				}
				columnInitial++;
			}
		}
		
		else if(orientation == CaperucitaState.DOWN) {
			int rowInitial = row + 1;
			while(woodActual[rowInitial][column] != CaperucitaPerception.TREE_PERCEPTION) {
				if(woodActual[rowInitial][column] == CaperucitaPerception.WOLF_PERCEPTION) {
					result[0] = rowInitial;
					result[1] = column;
					return result; 
				}
				rowInitial++;
			}
		}
		
		else if(orientation == CaperucitaState.LEFT) {
			int columnInitial = column - 1;
			while(woodActual[row][columnInitial] != CaperucitaPerception.TREE_PERCEPTION) {
				if(woodActual[row][columnInitial] == CaperucitaPerception.WOLF_PERCEPTION) {
					result[0] = row;
					result[1] = columnInitial;
					return result; 
				}
				columnInitial--;
			}
		}
		
		return result;
	}
    
	public int[] thereIsFlower(int row, int column, int orientation) {
		int[][] woodActual = this.getWood();		
		int[] result = {-1, -1};
		
		if(orientation == CaperucitaState.UP) {
			int rowInitial = row - 1;
			while(woodActual[rowInitial][column] != CaperucitaPerception.TREE_PERCEPTION) {
				if(woodActual[rowInitial][column] == CaperucitaPerception.FLOWER_PERCEPTION) {
					result[0] = rowInitial;
					result[1] = column;
					return result;
				}
				rowInitial--;
			}
		}
		
		else if(orientation == CaperucitaState.RIGHT) {
			int columnInitial = column + 1;
			while(woodActual[row][columnInitial] != CaperucitaPerception.TREE_PERCEPTION) {
				if(woodActual[row][columnInitial] == CaperucitaPerception.FLOWER_PERCEPTION) {
					result[0] = row;
					result[1] = columnInitial;
					return result;
				}
				columnInitial++;
			}
		}
		
		else if(orientation == CaperucitaState.DOWN) {
			int rowInitial = row + 1;
			while(woodActual[rowInitial][column] != CaperucitaPerception.TREE_PERCEPTION) {
				if(woodActual[rowInitial][column] == CaperucitaPerception.FLOWER_PERCEPTION) {
					result[0] = rowInitial;
					result[1] = column;
					return result;
				}
				rowInitial++;
			}
		}
		
		else if(orientation == CaperucitaState.LEFT) {
			int columnInitial = column - 1;
			while(woodActual[row][columnInitial] != CaperucitaPerception.TREE_PERCEPTION) {
				if(woodActual[row][columnInitial] == CaperucitaPerception.FLOWER_PERCEPTION) {
					result[0] = row;
					result[1] = columnInitial;
					return result;
				}
				columnInitial--;
			}
		}
		
		return result;
	}
	
	public int[] thereIsTree(int row, int column, int orientation) {
		int[][] woodActual = this.getWood();		
		int[] result = {-1, -1};
		
		if(orientation == CaperucitaState.UP) {
			if (woodActual[row - 1][column] == CaperucitaPerception.TREE_PERCEPTION) {
				result[0] = row - 1;
				result[1] = column;
				return result;
			}
		}
		
		else if(orientation == CaperucitaState.RIGHT) {
			if (woodActual[row][column + 1] == CaperucitaPerception.TREE_PERCEPTION) {
				result[0] = row;
				result[1] = column + 1;
				return result;
			}
		}
		
		else if(orientation == CaperucitaState.DOWN) {
			if (woodActual[row + 1][column] == CaperucitaPerception.TREE_PERCEPTION) {
				result[0] = row + 1;
				result[1] = column;
				return result;
			}
		}
		else if(orientation == CaperucitaState.LEFT) {
			if (woodActual[row][column - 1] == CaperucitaPerception.TREE_PERCEPTION) {
				result[0] = row;
				result[1] = column - 1;
				return result;
			}
		}
		
		return result;
	}
	
	public int[][] thereIsCandy(int row, int column, int orientation) {
		int[][] woodActual = this.getWood();		
		int[][] result = new int[3][2];
		int i = 0;
		
		if(orientation == CaperucitaState.UP) {
			int rowInitial = row - 1;
			while(woodActual[rowInitial][column] != CaperucitaPerception.TREE_PERCEPTION) {
				if(woodActual[rowInitial][column] == CaperucitaPerception.CANDY_PERCEPTION) {
					int[] newCandy = {rowInitial, column};
					result[i] = newCandy;
					i++;
				}
				rowInitial--;
			}
		}
		
		else if(orientation == CaperucitaState.RIGHT) {
			int columnInitial = column + 1;
			while(woodActual[row][columnInitial] != CaperucitaPerception.TREE_PERCEPTION) {
				if(woodActual[row][columnInitial] == CaperucitaPerception.CANDY_PERCEPTION) {
					int[] newCandy = {row, columnInitial};
					result[i] = newCandy;
					i++;
				}
				columnInitial++;
			}
		}
		
		else if(orientation == CaperucitaState.DOWN) {
			int rowInitial = row + 1;
			while(woodActual[rowInitial][column] != CaperucitaPerception.TREE_PERCEPTION) {
				if(woodActual[rowInitial][column] == CaperucitaPerception.CANDY_PERCEPTION) {
					int[] newCandy = {rowInitial, column};
					result[i] = newCandy;
					i++;
				}
				rowInitial++;
			}
		}
		
		else if(orientation == CaperucitaState.LEFT) {
			int columnInitial = column - 1;
			while(woodActual[row][columnInitial] != CaperucitaPerception.TREE_PERCEPTION) {
				if(woodActual[row][columnInitial] == CaperucitaPerception.CANDY_PERCEPTION) {
					int[] newCandy = {row, columnInitial};
					result[i] = newCandy;
					i++;
				}
				columnInitial--;
			}
		}
		
		return result;
	}
}

