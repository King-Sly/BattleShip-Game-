/*
*Program to play a game of sinking the ship
*
* Name:  Kingsley Okeke Nnaemeka
* ID: 1631514
* A Java program that tells a user to choose coordinates inorder to sinking a ship of length 3.
* Feb 12th, 2020.
 */
package sinkngship;

import sinkngship.Ocean;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    /*
    *@param args the command line arguments
     */
    public static void main(String[] args) {
        Ocean atlantic = new Ocean(10);
        System.out.println("==========================================");
        System.out.println("Welcome to Sinking Ship");
        System.out.println("==========================================");
        System.out.println(atlantic);

        //gets input from the user
        Scanner input = new Scanner(System.in);
        int rowNumber = 0;
        int colNumber = 0;

        //modifies the user's input
        while(true) {
            try {
                System.out.println("Choose an x: ");
                rowNumber = input.nextInt();
                System.out.println("Choose a y: ");
                colNumber = input.nextInt();
                break;
            }catch (InputMismatchException e) {
                System.out.println("Enter only integers");
                input.nextLine();
            }
        }

        //checks if user's input is above board size
        while((rowNumber <= 0 || rowNumber > 10) || (colNumber <= 0 || colNumber > 10)){
            System.out.println("Error out of bounds for "+ rowNumber + " and " + colNumber);
            System.out.println("Choose an x: ");
            rowNumber = input.nextInt();
            System.out.println("Choose a y: ");
            colNumber = input.nextInt();

        }
        Point point2 = new Point(rowNumber, colNumber);
        atlantic.fireShot(point2);
        System.out.println(atlantic);

        int count = 0;
        int shots = 1;
        while (count < 2) {
            System.out.println("Value in table " + atlantic.table[point2.getRow()][point2.getColumn()]);
            if (atlantic.table[point2.getRow()][point2.getColumn()] == 'S') {
                count = count + 1;

            }
            if (count == 3) {
                count = count + 1;
            }
            shots += 1;
            System.out.println("Ships' position shot: " + count);

            //more error checks
            while(true) {
                try {
                    System.out.println("Choose an x: ");
                    rowNumber = input.nextInt();
                    System.out.println("Choose a y: ");
                    colNumber = input.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Enter only Integers");
                    input.nextLine();
                }
            }
            while((rowNumber <= 0 || rowNumber > 10) || (colNumber <= 0 || colNumber > 10)){
                System.out.println("Error out of bounds for "+ rowNumber + " and " + colNumber);
                System.out.println("Choose an x: ");
                rowNumber = input.nextInt();
                System.out.println("Choose a y: ");
                colNumber = input.nextInt();

            }
            point2 = new Point(rowNumber, colNumber);
            atlantic.fireShot(point2);
            System.out.println(atlantic);
        }
        System.out.println(atlantic);
        System.out.println("You have sunk the ship!");
        System.out.println("Congratulations, It took you " + shots + " shots");

    }
}
