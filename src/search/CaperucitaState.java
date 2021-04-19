package search;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 
 */
public class CaperucitaState extends SearchBasedAgentState {

    private int currentRow;
    private int currentColumn;
    private int orientation;
    private int candies;
    private int lives;
    
    public CaperucitaState(int currentRow, int currentColumn, int orientation, int candies, int lives) {
		super();
		this.currentRow = currentRow;
		this.currentColumn = currentColumn;
		this.orientation = orientation;
		this.candies = candies;
		this.lives = lives;
	}
    
    public CaperucitaState() {
		super();
		this.candies = 0;
		this.lives = 3;
		this.initState();
	}
    //TODO Definir metodos goForward, turnLeft, turnRight, eatCandy
    
    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        int[][] newWorld = new int[4][4];

        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                newWorld[row][col] = world[row][col];
            }
        }

        int[] newPosition = new int[2];
        newPosition[0] = position[0];
        newPosition[1] = position[1];

        PacmanAgentState newState = new PacmanAgentState(newWorld,
                this.getRowPosition(), this.getColumnPosition(), this.energy);

        return newState;
    }

    /**
     * This method is used to update the Pacman State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        PacmanPerception pacmanPerception = (PacmanPerception) p;

        int row = this.getRowPosition();
        int col = this.getColumnPosition();

        if (col == 0) {
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

        energy = pacmanPerception.getEnergy();
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                world[row][col] = PacmanPerception.UNKNOWN_PERCEPTION;
            }
        }
        
        this.setRowPosition(1);
        this.setColumnPosition(1);

        this.setEnergy(50);
    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "";

        str = str + " position=\"(" + getRowPosition() + "," + "" + getColumnPosition() + ")\"";
        str = str + " energy=\"" + energy + "\"\n";

        str = str + "world=\"[ \n";
        for (int row = 0; row < world.length; row++) {
            str = str + "[ ";
            for (int col = 0; col < world.length; col++) {
                if (world[row][col] == -1) {
                    str = str + "* ";
                } else {
                    str = str + world[row][col] + " ";
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]\"";

        return str;
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PacmanAgentState))
            return false;

        int[][] worldObj = ((PacmanAgentState) obj).getWorld();
        int[] positionObj = ((PacmanAgentState) obj).getPosition();

        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                if (world[row][col] != worldObj[row][col]) {
                    return false;
                }
            }
        }

        if (position[0] != positionObj[0] || position[1] != positionObj[1]) {
            return false;
        }
        
        return true;
    }

    public boolean isAllWorldKnown() {
        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                if (world[row][col] == PacmanPerception.UNKNOWN_PERCEPTION) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public int getUnknownCellsCount() {
        int result = 0;

        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                if (world[row][col] == PacmanPerception.UNKNOWN_PERCEPTION) {
                    result++;
                }
            }
        }

        return result;
    }

    public int getRemainingFoodCount() {
        int result = 0;

        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                if (world[row][col] == PacmanPerception.FOOD_PERCEPTION) {
                    result++;
                }
            }
        }
        
        return result;
    }

    public boolean isNoMoreFood() {
        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                if (world[row][col] == PacmanPerception.FOOD_PERCEPTION) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getVisitedCellsCount() {
        return visitedCells;
    }

    public void increaseVisitedCellsCount() {
        this.visitedCells = +20;
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

}
