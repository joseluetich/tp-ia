package search;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class CaperucitaState extends SearchBasedAgentState {

	public static int UP = 1;
	public static int RIGHT = 2;
	public static int DOWN = 3;
	public static int LEFT = 4;
	
	public static int ROW_SIZE = 9;
	public static int COLUMN_SIZE = 14;
	
    private int currentRow;
    private int currentColumn;
    private int orientation;
    private int candies;
    private int lives;
    private int[][] wood;
    
    public CaperucitaState(int currentRow, int currentColumn, int orientation, int candies, int lives, int[][] wood) {
		super();
		this.currentRow = currentRow;
		this.currentColumn = currentColumn;
		this.orientation = orientation;
		this.candies = candies;
		this.lives = lives;
		this.wood = wood;
	}
    
    public CaperucitaState() {
		super();
		this.candies = 0;
		this.lives = 3;
		this.initState();
	}
    
    @Override
    public void initState() {
    	this.wood = new int[ROW_SIZE][COLUMN_SIZE];
        for (int i=0; i<ROW_SIZE; i++) {
            for (int j=0; j<COLUMN_SIZE; j++) {
                wood[i][j] = CaperucitaPerception.UNKNOWN_PERCEPTION;
            }
        }
        
        wood[2][10] = CaperucitaPerception.FLOWER_PERCEPTION;
        
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
        
        this.setCurrentRow(5);
        this.setCurrentColumn(11);
        this.setOrientation(1);
    }
    
    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        int[][] newWood = new int[ROW_SIZE][COLUMN_SIZE];
        for (int i=0; i<ROW_SIZE; i++) {
            for (int j=0; j<COLUMN_SIZE; j++) {
            	newWood[i][j] = wood[i][j];
            }
        }

        int newRow = this.currentRow;
        int newColumn = this.currentColumn;
        int newOrientation = this.orientation;
        
        CaperucitaState newState = new CaperucitaState(
                newRow, newColumn, newOrientation, candies, lives, newWood);

        return newState;
    }

    /**
     * This method is used to update the Pacman State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        CaperucitaPerception caperucitaPerception = (CaperucitaPerception) p;

        int row = this.getCurrentRow();
        int col = this.getCurrentColumn();
        int orientation = this.getOrientation();
        
        int[] wolfSensor = caperucitaPerception.getWolfSensor();
        int[][] candySensor = caperucitaPerception.getCandySensor();
        int[] treeSensor = caperucitaPerception.getTreeSensor(); 
        int[] flowerSensor = caperucitaPerception.getFlowerSensor();
        
         this.candies = caperucitaPerception.getCandies();
         this.lives = caperucitaPerception.getLives();
         
         if(wolfSensor[0] != -1) {
        	 this.wood[wolfSensor[0]][wolfSensor[1]] = CaperucitaPerception.WOLF_PERCEPTION;
         }
         
         if(flowerSensor[0] != -1) {
        	 this.wood[flowerSensor[0]][flowerSensor[1]] = CaperucitaPerception.FLOWER_PERCEPTION;
         }
         
         for(int i=0; i<3; i++) {
        	 if(candySensor[i][0]!=0) {
        		 this.wood[candySensor[i][0]][candySensor[i][1]] = CaperucitaPerception.CANDY_PERCEPTION; 
        	 }
         }
         
         if(treeSensor[0] != -1) {
        	 this.wood[treeSensor[0]][treeSensor[1]] = CaperucitaPerception.TREE_PERCEPTION;
         }
    }

    @Override
    public String toString() {
        String str = "";

        str = str + " Position=\"(" + getCurrentRow() + "," + "" + getCurrentColumn() + ")\"";
        str = str + " Orientacion=\"" + getOrientation() + "\"";
        str = str + " Candies=\"" + candies + "\"";
        str = str + " Lives= " + lives + "\n";
        
        str = str + "Wood percibido = [ \n";
        for (int i=0; i<ROW_SIZE; i++) {
            str = str + "[ ";
            for (int j=0; j<COLUMN_SIZE; j++) {
                if (wood[i][j] == -1) {
                    str = str + "* ";
                } else {
                    str = str + wood[i][j] + " ";
                }
            }
            str = str + "]\n";
        }
        str = str + " ]\"";

        return str;
    }

    /* This method is used in the search process to verify if the node already
     * exists in the actual search. */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CaperucitaState))
            return false;

        int[][] woodObj = ((CaperucitaState) obj).getWood();
        int currentRowObj = ((CaperucitaState) obj).getCurrentRow();
        int currentColumnObj = ((CaperucitaState) obj).getCurrentColumn();
        int orientationObj = ((CaperucitaState) obj).getOrientation();

        for (int i=0; i<ROW_SIZE; i++) {
            for (int j=0; j<COLUMN_SIZE; j++) {
            	if(wood[i][j] != woodObj[i][j]) {
            		return false;
            	}
            }
        }
        
        if (currentRow != currentRowObj || currentColumn != currentColumnObj ||
        		orientation != orientationObj) {
            return false;
        }   
        return true;
    }
    
    public boolean arrivedToFlowers() {
        if (wood[currentRow][currentColumn] == CaperucitaPerception.FLOWER_PERCEPTION) {
        	return true;
        }
        return false;
    }
    
    public int getWoodPosition(int row, int col) {
        return wood[row][col];
    }

    public void setWoodPosition(int row, int col, int value) {
        this.wood[row][col] = value;
    }
    
    public int getCurrentRow() {
		return currentRow;
	}
    
    public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	public int getCurrentColumn() {
		return currentColumn;
	}

	public void setCurrentColumn(int currentColumn) {
		this.currentColumn = currentColumn;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public int getCandies() {
		return candies;
	}

	public void setCandies(int candies) {
		this.candies = candies;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int[][] getWood() {
		return wood;
	}

	public void setWood(int[][] wood) {
		this.wood = wood;
	}
	
	public int[] getFlowerPosition() {
		int[] position = {-1, -1};
		for(int i=0; i<ROW_SIZE; i++) {
			for(int j=0; j<COLUMN_SIZE; j++) {
				if(this.getWood()[i][j]==CaperucitaPerception.FLOWER_PERCEPTION) {
					position[0] = i;
					position[1] = j;
				}
			}
		}
		
		return position;
	}

}
