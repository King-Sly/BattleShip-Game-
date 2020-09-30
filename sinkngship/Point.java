package sinkngship;

public class Point {
    //Instance variables
    private int x;
    private int y;
    private int row;
    private int column;

    /**
     * Constructor
     * Takes user-relative x, y coordinate and maps it to
     * computer-relative row and column (0-based).
     *
     * @param x coordinate, axis is horizontal, +ve increasing left to right
     * @param y coordinate, axis is vertical, +ve increasing top to bottom
     */
    Point(int x, int y){
        this.x = x;
        this.y = y;
        row = y - 1;
        column = x - 1;
    }//constructor

    /**
     * Default Constructor
     * Makes user-point (1, 1), computer-point(0,0)
     */
    Point(){
        x = 1;
        y = 1;
        row = 0;
        column = 0;
    }//Default constructor

    /**
     * Getter for row.
     *
     * @return the row (0-based)
     */
    public int getRow(){
        return row;
    }//getRow

    /**
     * Getter for column.
     *
     * @return the column (0-based)
     */
    public int getColumn(){
        return column;
    }//getColumn

    /**
     * Gives a string representation of a point.
     *
     * @return a string representation of a point
     */
    public String toString(){
        return "(Row: " + row + " Col: " + column + ")";
        //return "(x: " + x + " y: " + y + ")";
    }//toString


    public boolean equals(Object other){
        Point realOther = (Point) other;
        return (x == realOther.x && y == realOther.y);
    }
}
