package search;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class CaperucitaState extends SearchBasedAgentState {

	public static int UP = 1;
	public static int RIGHT = 2;
	public static int DOWN = 3;
	public static int LEFT = 4;
	
    private int currentRow;
    private int currentColumn;
    private int orientation;
    private int candies;
    private int lives;
    private int movements;
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
		this.movements = 0;
		wood = new int[9][14];
		this.lives = 3;
		this.initState();
	}
    
    @Override
    public void initState() {
        for (int i=0; i<wood.length; i++) {
            for (int j=0; j<wood.length; j++) {
                wood[i][j] = CaperucitaPerception.UNKNOWN_PERCEPTION;
            }
        }

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
        int[][] newWood = new int[9][14];
        for (int i=0; i<wood.length; i++) {
            for (int j=0; j<wood.length; j++) {
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
        	 if(candySensor[i] != null) {
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

        str = str + " position=\"(" + getCurrentRow() + "," + "" + getCurrentColumn() + ")\"";
        str = str + " candies=\"" + candies + "\"";
        str = str + " lives=\"" + lives + "\"\n";

        str = str + "wood=\"[ \n";
        for (int i=0; i<wood.length; i++) {
            str = str + "[ ";
            for (int j=0; j<wood.length; j++) {
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

    /* This method is used in the search process to verify if the node already
     * exists in the actual search. */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CaperucitaState))
            return false;

        int[][] woodObj = ((CaperucitaState) obj).getWood();
        int currentRowObj = ((CaperucitaState) obj).getCurrentRow();
        int currentColumnObj = ((CaperucitaState) obj).getCurrentColumn();

        for (int i=0; i<wood.length; i++) {
            for (int j=0; j<wood.length; j++) {
            	if(wood[i][j] != woodObj[i][j]) {
            		return false;
            	}
            }
        }
        
        if (currentRow != currentRowObj || currentColumn != currentColumnObj) {
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
    
    //ver la clase pacman
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

	public int getMovements() {
		return movements;
	}

	public void setMovements(int movements) {
		this.movements = movements;
	}
	

}
