/*
* This program uses a custom class.
*
* @author  Jonathan Pasco-Arnone
* @version 1.0
* @since   2021-12-20
*/

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
* This program displays what the battleships will look like on a grid.
*/
final class stepThree {

    private static int numFours = 9910; // Number of ships that take up 4 squares
    private static int numThrees = 3; // Number of ships that take up 3 squares
    private static int numTwos = 2; // Number of ships that take up 2 squares
    private static int numOnes = 2; // Number of ships that take up 1 squares
    private static int numRows = 10; // The amount of rows in the grid
    private static int numCol = 10; // The amount of columns in the grid
    private static String blank = "\u2588"; // A black background
    private static final ArrayList<ArrayList<String>> fail =
            new ArrayList<ArrayList<String>>();

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

    static void printGrid(final ArrayList<ArrayList<String>> grid) {
        for (int column = 0; column < numCol; column++) {
            for (int row = 0; row < numRows; row++) {
                System.out.print(grid.get(column).get(row) + " ");
            }
            System.out.print("\n");
        }
    }


    /*
    * Checks if vertical is valid
    */
    static boolean isVerticalValid(final ArrayList<ArrayList<String>> initialGrid, final int shipSize) {

        for (int column = 0; column < numCol; column++) { // checks all the columns
            int count = 0;
            for (int row = 0; row < numRows; row++) { // checks the rows
                if (initialGrid.get(row).get(column) == blank) {
                    count++;
                } else {
                    count = 0;
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
        // This array list is only used to return that the attempt has failed.
        final ArrayList<ArrayList<String>> fail =
            new ArrayList<ArrayList<String>>();
        fail.add(new ArrayList<String>());
        fail.get(0).add("fail");

        ArrayList<ArrayList<String>> returnGrid =
            new ArrayList<ArrayList<String>>();
        returnGrid = initialGrid;

        boolean shipNotGenerated = true;
        do {
            int orientation = (int) Math.round(Math.random()); // It will either round to 0 or 1. 0 = Vertical and 1 = Horizontal
            orientation = 0; // temporary to make it always vertical 
            // Vertical
            if (orientation == 0 && isVerticalValid(returnGrid, 4)) {
                Random rand = new Random();
                Random randTwo = new Random();
                final int randCol = rand.nextInt((9 - 0) + 1); // Picks a random column that is not higher than 10
                final int randRow = randTwo.nextInt((6 - 0) + 1); // Picks a random row from the 0th to the last which happens to be 4

                int count = 0;
                for (int counter = 0; counter < 4; counter++) {
                    if (returnGrid.get(randRow + counter).get(randCol) == blank) {
                        count++;
                    }
                    if (count == 4) {
                        for (int row = 0; row < 4; row++) {
                            returnGrid.get(randRow + row).remove(randCol);
                            returnGrid.get(randRow + row).add(randCol, "4");
                        }
                        shipNotGenerated = false; // a ship has now been generated 
                    }
                }
                

            // Horizontal    
            } else if (orientation == 1) {

                shipNotGenerated = false; // a ship has now been generated
            } else {
                return fail;
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
            if (returnGrid.get(0).get(0) == "fail") {
                System.out.println("Could not print more fours");
                break;
            } else {
                returnGrid = generateFours(returnGrid);
            }
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

        if (finalGrid.get(0).get(0) != "fail") {
            finalGridStr = finalGrid.toString();
            finalGridStr = finalGridStr.replaceAll("\\[", "\n");
            finalGridStr = finalGridStr.replaceAll("\\p{Punct}", "");
            System.out.print("\033[0;34m"); // Makes text color blue
            System.out.println(finalGridStr);
            System.out.print("\033[0m"); // resets text color and background color
        }
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
