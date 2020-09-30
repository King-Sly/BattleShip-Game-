package sinkngship;

import java.util.Random;

public class RandomPositionOrientation {
    private static final Random RAND_NUM_GEN = new Random();

    //Instance variables
    private final int SIZE; //Should only be set once, never changed
    private int row;
    private int column;
    private int orientation; // 0 = horizontal; 1 = vertical
    // 2 = diagonal \; 3 = diagonal /

    /**
     * Constructor
     * Makes a valid, random position and orientation.
     *
     * @param size - the size of the grid
     */
    RandomPositionOrientation(int size){
        SIZE = size;
        makeValidPositionOrientation();
    }//Constructor

    /**
     * Default Constructor
     * Makes a valid, random position and orientation.
     */
    RandomPositionOrientation(){
        SIZE = 10;
        makeValidPositionOrientation();
    }//Default Constructor

    /**
     * Getter for middle-of-ship row of random position.
     * @return row of random position
     */
    public int getRow(){
        return row;
    }//getRow

    /**
     * Getter for middle-of-ship column of random position.
     * @return column of random position
     */
    public int getColumn(){
        return column;
    }//getColumn

    /**
     * Getter for random orientation (0=-;1=|;2=\;3=/).
     * @return random orientation
     * 0 = horizontal; 1 = vertical
     * 2 = diagonal \; 3 = diagonal /
     */
    public int getOrientation(){
        return orientation;
    }//getOrientation

    /**
     * This only makes the random position and
     * orientation but does not check whether
     * a ship could actually be placed like that.
     * I.e. it might not be valid for placing.
     */
    private void makeRandomPositionOrientation(){
        row = RAND_NUM_GEN.nextInt(SIZE);
        column = RAND_NUM_GEN.nextInt(SIZE);
        orientation = RAND_NUM_GEN.nextInt(4);
    }//makeRandomPositionOrientation

    /**
     * Determines if the random combination is valid.
     * @return true if the combination of row, column, and
     *         orientation can actually be used to place a
     *         ship;  false otherwise.
     */
    private boolean testCombo(){
        //top and bottom edges are only valid when orientation is horizontal
        if ((row == 0 || row == SIZE - 1) && orientation != 0)
            return false;
        //left and right edges are only valid when orientation is vertical
        if ((column == 0 || column == SIZE - 1) && orientation != 1)
            return false;
        return true;
    }//testCombo

    /**
     * This makes a random VALID position and orientation.
     */
    public void makeValidPositionOrientation(){
        boolean isValid = false;
        while (! isValid){
            makeRandomPositionOrientation();
            isValid = testCombo();
        }//while
    }//makeValidPositionOrientation

    /**
     * String representation
     */
    public String toString(){
        String orientSymbol = "";

        switch (orientation){
            case 0:
                orientSymbol = "--";
                break;
            case 1:
                orientSymbol = "|";
                break;
            case 2:
                orientSymbol = "\\";
                break;
            case 3:
                orientSymbol = "/";
        }

        return "(Row: " + row + " Col: " + column + " Orient: "
                + orientSymbol + ")";
    }

}
