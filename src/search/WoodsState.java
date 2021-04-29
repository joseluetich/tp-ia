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
       
    public static int ROW_SIZE = 9;
	public static int COLUMN_SIZE = 14;
	
    public WoodsState() {
    	this.initState();
    }

    @Override
    public void initState() {
        this.wood = new int[ROW_SIZE][COLUMN_SIZE];
    	this.setCandiesQuantity(3);
    	
    	for(int i=0; i<ROW_SIZE; i++) {
    		for(int j=0; j<COLUMN_SIZE; j++) {
    			wood[i][j] = CaperucitaPerception.EMPTY_PERCEPTION;
    		}
    	}
    	
    	/*Primeras tres columnas con arboles*/
    	for(int i=0; i<ROW_SIZE; i++) {
    		for(int j=0; j<3; j++) {
    			wood[i][j] = CaperucitaPerception.TREE_PERCEPTION;
    		}
    	}
    	
    	/*Ultimas dos columnas con arboles*/
    	for(int i=0; i<ROW_SIZE; i++) {
    		for(int j=12; j<COLUMN_SIZE; j++) {
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
    	//TODO aca podemos generarlo aleatoriamente o
    	//darle una posicion inicial
    	wood[6][4] = CaperucitaPerception.WOLF_PERCEPTION;
    	
    	/*Ubicacion del campo de flores*/
    	wood[2][11] = CaperucitaPerception.FLOWER_PERCEPTION;
    	
    	/*Ubicacion de caperucita*/
    	this.setAgentPosition(new int[]{5, 11});
    	this.setAgentOrientation(1);
    	this.setAgentLives(3);
    }

    @Override
    public String toString() {
    	
        String str = "\n";
        int dulces = 0;
        str += "Cantidad De Dulces por juntar: { ";
        for(int i=0; i<ROW_SIZE; i++) {
    		for(int j=0; j<COLUMN_SIZE; j++) {
    			if(wood[i][j] == CaperucitaPerception.CANDY_PERCEPTION) {
    				dulces++;
    			}
    		}
        }
        str += (dulces+" }\n");
        
        str += ("Cantidad de Vidas: { "+agentLives+" }\n"); 
        
        str += ("Posicion del Agente: { "+agentPosition[0]+", "+agentPosition[1]+" }"); 

        str = str + "\nWood real=\"[ \n";
        for (int i=0; i<ROW_SIZE; i++) {
            str = str + "[ ";
            for (int j=0; j<COLUMN_SIZE; j++) {
                if (wood[i][j] == -1) {
                    str = str + "* ";
                } else {
                    str = str + wood[i][j] + " ";
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]\"";
        
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
			int rowInitial = row - 1;
			while(woodActual[rowInitial][column]!=CaperucitaPerception.TREE_PERCEPTION) {
				rowInitial--;
			}
			result[0] = rowInitial;
			result[1] = column;
		}
		
		else if(orientation == CaperucitaState.RIGHT) {
			int columnInitial = column + 1;
			while(woodActual[row][columnInitial]!=CaperucitaPerception.TREE_PERCEPTION) {
				columnInitial++;
			}
			result[0] = row;
			result[1] = columnInitial;
		}
		
		else if(orientation == CaperucitaState.DOWN) {
			int rowInitial = row + 1;
			while(woodActual[rowInitial][column]!=CaperucitaPerception.TREE_PERCEPTION) {
				rowInitial++;
			}
			result[0] = rowInitial;
			result[1] = column;
		}
		
		else if(orientation == CaperucitaState.LEFT) {
			int columnInitial = column - 1;
			while(woodActual[row][columnInitial]!=CaperucitaPerception.TREE_PERCEPTION) {
				columnInitial--;
			}
			result[0] = row;
			result[1] = columnInitial;
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

