package search;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class CaperucitaState extends SearchBasedAgentState {

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
		wood = new int[9][14];
		this.lives = 3;
		this.initState();
	}
    
    //TODO Definir metodos goForward, turnLeft, turnRight, eatCandy
    
    @Override
    public void initState() {
        for (int i=0; i<wood.length; i++) {
            for (int j=0; j<wood.length; j++) {
                wood[i][j] = CaperucitaPerception.UNKNOWN_PERCEPTION;
            }
        }

        //TODO Definir posicion y orientacion inicial del agente
        this.setCurrentRow(0);
        this.setCurrentColumn(0);
        this.setOrientation(0);

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

        /*En el caso del pacman, usa las percepciones y analiza si 
         * es la primera o ultima fila/columna para hacerlo aparecer
         * por el otro lado.
         * 
         * Caperucita deberia usar los sensores para ver si hay lobo, 
         * flores, dulces o arboles.
         */
        /*if (col == 0) {
            col = 3;
        } else {
            col = col - 1;
        }
        world[row][col] = pacmanPerception.getLeftSensor();

        row = this.getRowPosition();
        col = this.getColumnPosition();

        if (col == 3) {
            col = 0;
        } else {
            col = col + 1;
        }
        world[row][col] = pacmanPerception.getRightSensor();

        row = this.getRowPosition();
        col = this.getColumnPosition();

        if (row == 0) {
            row = 3;
        } else {
            row = row - 1;
        }
        world[row][col] = pacmanPerception.getTopSensor();


        row = this.getRowPosition();
        col = this.getColumnPosition();

        if (row == 3) {
            row = 0;
        } else {
            row = row + 1;
        }
        world[row][col] = pacmanPerception.getBottomSensor();

        energy = pacmanPerception.getEnergy();*/
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

}
