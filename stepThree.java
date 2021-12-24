/*
* This program uses a custom class.
*
* @author  Jonathan Pasco-Arnone
* @version 1.0
* @since   2021-12-20
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
* This program displays what the battleships will look like on a grid.
*/
final class stepThree {

    private static int numFours = 1; // Number of ships that take up 4 squares
    private static int numThrees = 3; // Number of ships that take up 3 squares
    private static int numTwos = 2; // Number of ships that take up 2 squares
    private static int numOnes = 2; // Number of ships that take up 1 squares
    private static int numRows = 10; // The amount of rows in the grid
    private static int numCol = 10; // The amount of columns in the grid
    private static String blank = "\u2588"; // A black background

    /**
    * Prevent instantiation
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private stepThree() {
        throw new IllegalStateException("Cannot be instantiated");
    }


    /*
    * Checks if vertical is valid
    */
    static boolean isVerticalValid(final ArrayList<ArrayList<String>> initialGrid, final int shipSize) {

        for (int counter = 0; counter < numCol; counter++) { // checks all the columns
            int count = 0;
            for (int counterTwo = 0; counterTwo < shipSize; counterTwo++) { // checks the rows
                if (initialGrid.get(counter).get(counterTwo) == blank) {
                    count++;
                }
                if (count == shipSize) {
                    return true;
                }
            }
        }
        return false;
    }




    // Generates the fours
    static ArrayList<ArrayList<String>> generateFours(final ArrayList<ArrayList<String>> initialGrid) {
        ArrayList<ArrayList<String>> returnGrid =
            new ArrayList<ArrayList<String>>();
        returnGrid = initialGrid;

        boolean shipNotGenerated = true;
        do {
            int orientation = (int) Math.round(Math.random()); // It will either round to 0 or 1. 0 = Vertical and 1 = Horizontal
            orientation = 0; // temporary to make it always vertical 
            // Vertical
            if (orientation == 0 && isVerticalValid(returnGrid, 4)) {
                final int randCol = (int) (Math.random() * 9); // Picks a random column
                final int randRow = (int) (Math.random() * (9 - 4)); // Picks a random row from the 0th to the last which happens to be 4
                System.out.println("The random column is " + randCol);
                System.out.println("The random row is " + randRow);

                int count = 0;
                for (int counter = 0; counter < 4; counter++) {
                    if (returnGrid.get(randRow + counter).get(randCol) == blank) {
                        count++;
                        System.out.println("The count is " + count);
                    }
                    if (count == 4) {
                        for (int counterTwo = 0; counterTwo < 4; counterTwo++) {
                            returnGrid.get(counter + randRow - counterTwo).remove(randCol);
                            returnGrid.get(counter + randRow - counterTwo).add(randCol, "4");
                        }
                    shipNotGenerated = false; // a ship has now been generated 
                    }
                }
                

            // Horizontal    
            } else if (orientation == 1) {

                shipNotGenerated = false; // a ship has now been generated
            }
        } while (shipNotGenerated);
        return returnGrid;
    }

    /*
    *
    * Generates all the ships on the grid
    *
    */
    static ArrayList<ArrayList<String>> generateShips(final ArrayList<ArrayList<String>> initialGrid) {
        ArrayList<ArrayList<String>> returnGrid =
            new ArrayList<ArrayList<String>>();

        returnGrid = initialGrid;

        for (int counter = 0; counter < numFours; counter++) {
            returnGrid = generateFours(returnGrid);
        }


        return returnGrid;
    }



    /*
    *
    * This sets up the game
    *
    */
    static void setUpGame() {
        final ArrayList<ArrayList<String>> grid =
            new ArrayList<ArrayList<String>>();

        ArrayList<ArrayList<String>> finalGrid =
            new ArrayList<ArrayList<String>>();

        String finalGridStr;

        for (int counter = 0; counter < numRows; counter++) {
            grid.add(new ArrayList<String>()); // Adds a new row
            for (int counterTwo = 0; counterTwo < numCol; counterTwo++) {
                grid.get(counter).add("\u2588"); // Adds a new column and a filler spot for it
            }
        }
        finalGrid = generateShips(grid);

        finalGridStr = finalGrid.toString();
        finalGridStr = finalGridStr.replaceAll("\\[", "\n");
        finalGridStr = finalGridStr.replaceAll("\\p{Punct}", "");
        System.out.print("\033[0;34m"); // Makes text color blue
        System.out.println(finalGridStr);
        System.out.print("\033[0m"); // resets text color and background color
    }




    /**
    * This is the main function.
    *
    * @param args this will not be used
    */
    public static void main(final String[] args) {
        System.out.println("This is the Battleship program");
        setUpGame();

    }
}
