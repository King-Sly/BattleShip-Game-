package sinkngship;

    /*
     * Name/Author: Kingsley N Okeke
     * ID: 1631514
     * A Java class that prints the Ocean with the char character '~'
     * and toString representing the board(Ocean).
     *  Feb 12th, 2020.
     */


import java.awt.*;

    /**
     *
     * @author Kings
     * Class that takes in two fields namely size and table.
     */
    public class Ocean {
        int size;
        char[][] table;
//        int chosenRow;
//        int chosenColumn;

        /**
         * Name/Author: Okeke Kingsley Nnaemeka
         * Constructor that fills the values of the fields
         * @param size
         */
        public Ocean(int size) {
            //Initialise instance variables
            this.size = size;
            table = new char[size][size];
            //Filling the table with '~', so symbolise "empty"
            int row = 0;
            int column = 0;
            while (row < size) {
                while (column < size) {
                    table[row][column] = '~';
                    column = column + 1;
                }
                row = row + 1;
                column = 0;
            }//outer while
            sinkngship.RandomPositionOrientation middleOfShip = new sinkngship.RandomPositionOrientation();
            System.out.println(middleOfShip);
            int rowOfMiddle = middleOfShip.getRow();
            int colOfMiddle = middleOfShip.getColumn();
            int chosenOrientation = middleOfShip.getOrientation();
            table[rowOfMiddle][colOfMiddle] = '*';
            if (chosenOrientation == 0) {
                table[rowOfMiddle][colOfMiddle - 1] = '*';
                table[rowOfMiddle][colOfMiddle + 1] = '*';
            } else if (chosenOrientation == 1) {
                table[rowOfMiddle + 1][colOfMiddle] = '*';
                table[rowOfMiddle - 1][colOfMiddle] = '*';
            } else if (chosenOrientation == 2) {
                table[rowOfMiddle - 1][colOfMiddle - 1] = '*';
                table[rowOfMiddle + 1][colOfMiddle + 1] = '*';
            } else if (chosenOrientation == 3) {
                table[rowOfMiddle + 1][colOfMiddle - 1] = '*';
                table[rowOfMiddle - 1][colOfMiddle + 1] = '*';

            }

        }//constructor

        /**
         * toString returns the two dimensional array(table) as a string
         * @return a string
         */
        public String toString() {
            int row = 0;
            int column = 0;
            String repr = "" + 1 + "  ";
            System.out.println("  x" + '\u27F6');
            System.out.println("y ");
            System.out.println('\u2193');
            colNumbers();
            int rowNumbers = 1;
            while (row < size) {
                while (column < size) {
                    if(table[row][column] == '*'){
                        repr = repr + '~' + " ";
                    }else{
                        repr = repr + table[row][column] + " ";
                    }
                    column = column + 1;
                }
                row = row + 1;
                column = 0;
                rowNumbers+=1;
                if(rowNumbers == 10){
                    repr = repr + "\n" + rowNumbers + " ";
                }else if(rowNumbers==11){
                    break;
                }else{
                    repr = repr + "\n" + rowNumbers + "  ";
                }

            }
            return repr;
        }



        /**
        * fireShot checks if the user inputs the right coordinate and changes it
         * string value to X or S
         */
        public void fireShot(Point point1) {
//            point1 = new Point(chosenRow, chosenColumn);
            if (table[point1.getRow()][point1.getColumn()] == '~') {
                table[point1.getRow()][point1.getColumn()] = 'X';
                System.out.println("A nice try");
            }else if (table[point1.getRow()][point1.getColumn()] == 'X') {
                System.out.println("Error shot fired before");
            }else if (table[point1.getRow()][point1.getColumn()] == '*') {
                table[point1.getRow()][point1.getColumn()] = 'S';
                System.out.println("A ship has been hit");
            }else if(table[point1.getRow()][point1.getColumn()] == 'S'){
                System.out.println("Ship already been hit");
            }else if (table[point1.getRow()][point1.getColumn()] != '~') {
                System.out.println("Error out of bounds");
            }

        }
        /**
        *method that prints column numbers when called
         *
         */
        public void colNumbers(){
            int firstColNumbers = 0;
            System.out.print("   ");
            while(firstColNumbers < 10){
                System.out.print(firstColNumbers + 1 + " ");
                firstColNumbers+=1;
            }
            System.out.println();
        }
    }




