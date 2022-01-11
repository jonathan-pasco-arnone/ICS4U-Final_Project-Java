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
final class Battleship {

    /*
    * You may customize the following 6 constants to your hearts content
    */
    /**
    * Number of ships that take up 4 squares - default = 1.
    */
    private static int numFours = 1;
    /**
    * Number of ships that take up 3 squares - defualt = 3.
    */
    private static int numThrees = 3;
    /**
    * Number of ships that take up 2 squares - default = 2.
    */
    private static int numTwos = 2;
    /**
    * Number of ships that take up 1 squares - default = 2.
    */
    private static int numOnes = 2;
    /**
    * The amount of rows in the grid - defualt = 10.
    */
    private static int numRows = 10;
    /**
    * The amount of columns in the grid - defualt = 10 - max = 26.
    */
    private static int numCol = 10;

    /**
    * All of the ship quantities in an array.
    */
    private static ArrayList<Integer> allShipQuantities
        = new ArrayList<Integer>();

    /**
    * The amount of ships * 2 (because player and enemy).
    * Exclusively for defineing coordinate holding array.
    */
    private static int quantityTypesOfShips = 8;
    /**
    * A 3D array list holding all of the coordinates for all
    * the ships ever generated.
    */
    private static ArrayList<ArrayList<ArrayList<Integer>>> allShipCoords
        = new ArrayList<ArrayList<ArrayList<Integer>>>();

    /**
    * Four as a constant.
    */
    private static int FOUR = 4;
    /**
    * Three as a constant.
    */
    private static int THREE = 3;
    /**
    * Two as a constant.
    */
    private static int TWO = 2;
    /**
    * One as a constant.
    */
    private static int ONE = 1;

    /**
    * The unicode for a blank square.
    * Used as the "water" on the grid.
    */
    private static String blank = "\u2588"; // A blank background

    /**
    * String that tells the player it is their grid.
    */
    private static String yourGridStr = "=====================\n"
        + "------Your Grid------\n=====================\n";
    /**
    * String that tells the player that it is the enemies grid.
    */
    private static String enemyGridStr = "\n\n\n=====================\n"
        + "------Enemy Grid-----\n=====================\n";

    /**
    * Unicode for changing text color to blue.
    * Used for the "water".
    */
    private static String BLUE = "\033[0;34m";
    /**
    * Unicode for changing text color to red.
    * Used for hit or sunk.
    */
    private static String RED = "\033[0;31m";
    /**
    * Unicode for changing text color to yellow.
    * Used for miss.
    */
    private static String YELLOW = "\033[0;33m";
    /**
    * Unicode for changing text color to a bold version of magenta.
    * Used for end of game.
    */
    private static String MAGENTA_BOLD = "\033[1;35m";
    /**
    * Unicode for changing text color to a bold version of white.
    * Used for end of game.
    */
    private static String BOLD_WHITE = "\033[1;37m";
    /**
    * Unicode for changing text background to cyan.
    * Used for end of game.
    */
    private static String CYAN_BACKGROUND = "\033[46m";
    /**
    * Unicode for changing text background to yellow.
    */
    private static String YELLOW_BACKGROUND = "\033[43m";
    /**
    * Unicode for changing text background to magenta.
    */
    private static String MAGENTA_BACKGROUND = "\033[45m";
    /**
    * Unicode for changing text background to white.
    */
    private static String WHITE_BACKGROUND = "\033[47m";
    /**
    * Unicode for changing text color and background color back
    * to its original form.
    */
    private static String RESET = "\033[0m";

    /**
    * String for grid to represent hit.
    */
    private static String hit = "H";
    /**
    * String for grid to represent miss.
    */
    private static String miss = "M";
    /**
    * String for grid to represent sunk.
    */
    private static String sunk = "S";

    /**
    * Char array of the whole alphabet in capital and lower case.
    */
    private static char[] alphabet = ("ABCDEFGHIJKL"
        + "MNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz").toCharArray();
    /**
    * The amount of capital letters
    */
    private static int capitalLetters = 26;
    /**
    * The maximum integer value a char can represent.
    */
    private static int maxCharValue = 9;

    /**
    * Class holding all pixel art.
    */
    private static PixelArt artPrinter = new PixelArt();

    /**
    * Prevent instantiation
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private Battleship() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Tells the player the rules and how to play the game.
    */
    static void rulesAndStart() {
        // Printing all the rules
        System.out.println("Welcome to Battleship.\n\n"
            + "This game is very similar to the popularly known board game "
            + "of battleship.\nThe rules are as follows:\n    1. Every turn,"
            + " you must select a location to attack the opponent on their "
            + "grid. If the attack is a hit, miss, or sink, then the section"
            + " labelled\n       \"Enemy Grid\" will display that.\n    2. "
            + "After your turn, the enemy will select a random location to"
            + " attack, and it will be displayed on your grid in the same way"
            + " as your attacks display in theirs.\n    3. The first person "
            + "to sink all the opposing person's ships is the winner\n    4. "
            + "Have Fun! ;)");

        System.out.println("\nPress enter to begin\n");

        // Scanner to recieve input
        final Scanner start = new Scanner(System.in);
        final String startGame = start.nextLine();
    }

    /**
    * Sets up some of the arrays that will be used in the program.
    */
    static void setUpArrays() {
        /*
        * Makes this array cappable of holding all the ships elements
        * for both the player and the enemy
        */
        for (int typeOfShip = 0; typeOfShip < quantityTypesOfShips;
            typeOfShip++) {

            allShipCoords.add(new ArrayList<ArrayList<Integer>>());
        }

        // Adds all the ship quantities to this array
        allShipQuantities.add(numOnes);
        allShipQuantities.add(numTwos);
        allShipQuantities.add(numThrees);
        allShipQuantities.add(numFours);

    }

    /**
    * Checks all the ships for either the player or the enemy
    * to detect if they have sunk.
    *
    * @param grid the grid that will be checked
    * @param enemy wether it is the enemies grid or the players
    */
    static void checkSink(ArrayList<ArrayList<String>> grid, int enemy) {

        // Goes through all types of ship sizes (1-4)
        for (int shipSize = 1; shipSize <= FOUR; shipSize++) {

            // Checks every ship
            for (int ship = 0; ship < allShipQuantities.get(shipSize - ONE);
                ship++) {

                int count = 0;

                /*
                * The "* 2" is because the coordinates of the ships area
                * kept in groups of 2 (row, column), this insures that it
                * moves to the next set of coordinates
                */
                // Checks each set of coordinates
                for (int shipCoord = 0; shipCoord < (shipSize * 2);
                    shipCoord += 2) {

                    if (grid.get(allShipCoords.get(shipSize + enemy
                        - ONE).get(ship).get(shipCoord)).get(
                        allShipCoords.get(shipSize + enemy - ONE).get(
                        ship).get(shipCoord + 1)) == hit) {

                        count++;
                    }

                    if (count == shipSize) {
                        for (int counter = 0; counter < (shipSize * 2);
                            counter += 2) {
                            /*
                            * The "+ 0" is necessary for changing the index
                            * from an Integer to an int.
                            * Removes the location to have it
                            * replaced with sunk.
                            */
                            grid.get(allShipCoords.get(shipSize + enemy
                                - ONE).get(ship).get(shipCoord
                                - counter)).remove(allShipCoords.get(shipSize
                                + enemy - ONE).get(ship).get(shipCoord
                                - counter + 1) + 0);

                            // Replaces the removed location with sunk
                            grid.get(allShipCoords.get(shipSize + enemy
                                - ONE).get(ship).get(shipCoord
                                - counter)).add(allShipCoords.get(shipSize
                                + enemy - ONE).get(ship).get(shipCoord
                                - counter + 1), sunk);
                        }
                        System.out.print(RED);
                        System.out.print("\n\nSHIP SUNK\n\n");
                        System.out.print(RESET);
                    }
                }
            }
        }
    }






    /**
    * Determines if someone has won.
    *
    * @param playerGrid the players grid
    * @param enemyGrid the enemies grid
    * @return returns the result of the game
    */
    static String gameResult(final ArrayList<ArrayList<String>> playerGrid,
                            final ArrayList<ArrayList<String>> enemyGrid) {

        final String returnString;
        boolean playerHasShips = false;
        boolean enemyHasShips = false;

        for (int row = 0; row < numRows; row++) {
             for (int column = 0; column < numCol; column++) {
                 // If the player has any ships left
                 if (playerGrid.get(row).get(column).equals("4") ||
                     playerGrid.get(row).get(column).equals("3") ||
                     playerGrid.get(row).get(column).equals("2") ||
                     playerGrid.get(row).get(column).equals("1") ) {

                     playerHasShips = true;
                 // If the enemy has any ships left
                 } else if (enemyGrid.get(row).get(column).equals("4") ||
                     enemyGrid.get(row).get(column).equals("3") ||
                     enemyGrid.get(row).get(column).equals("2") ||
                     enemyGrid.get(row).get(column).equals("1") ) {

                     enemyHasShips = true;

                 }
             }
        }

        // Checks what the current outcome of the match is
        // If they both have ships then continue
        if (playerHasShips && enemyHasShips) {
            returnString = "continue";
        // If the player has ships and the enemy does not
        } else if (playerHasShips && !enemyHasShips) {
            returnString = "player win";
        // If the enemy has ships and the player does not
        } else if (!playerHasShips && enemyHasShips) {
            returnString = "enemy win";
        // If neither of them has ships
        } else {
            returnString = "tie";
        }

        return returnString;
    }


    /**
    * Executes the enemies turn.
    *
    * @param playerGrid the enemies grid
    */
    public static void enemyTurn(
        final ArrayList<ArrayList<String>> playerGrid) {

        do {

        Random randRow = new Random();
        Random randCol = new Random();

        // Picks a random column that is not higher tan the total columns
        final int rowCoord = randRow.nextInt(numRows);
        // Picks a random row that is not higher than the total rows
        final int columnCoord = randCol.nextInt(numCol);

        /*
        * Determines the alphabetical value of the random
        * horizontal coordinate
        */
        String horizontalCoordStr = Character.toString(alphabet[columnCoord]);

        // If the selected place is blank
        if (playerGrid.get(rowCoord).get(columnCoord) == blank) {

            // Miss
            playerGrid.get(rowCoord).remove(columnCoord);
            playerGrid.get(rowCoord).add(columnCoord, miss);

            // Sets the color to bold white
            System.out.print(BOLD_WHITE);

            System.out.println("The computer chose ("
                + rowCoord + ", " + horizontalCoordStr + ")");

            // Resets the color
            System.out.print(RESET);
            break;

        // If the selected place is a ship
        } else if (playerGrid.get(rowCoord).get(columnCoord).equals("4") ||
                   playerGrid.get(rowCoord).get(columnCoord).equals("3") ||
                   playerGrid.get(rowCoord).get(columnCoord).equals("2") ||
                   playerGrid.get(rowCoord).get(columnCoord).equals("1")) {

            // Hit
            playerGrid.get(rowCoord).remove(columnCoord);
            playerGrid.get(rowCoord).add(columnCoord, hit);

            // Sets the color to bold white
            System.out.print(BOLD_WHITE);

            System.out.println("The computer chose the vertical"
                + " coordinate of " + rowCoord + " and the horizontal"
                + " coordinate of " + horizontalCoordStr);

            // Resets the color
            System.out.print(RESET);
            break;
        }
        /*
        * If it is not blank or a ship then it must be a hit or miss
        * in which case, the while loop will force it to select a new location
        */

        } while (true);
    }

    /**
    * This gets the inputs from the user.
    *
    * @param enemyGrid the enemies grid
    */
    public static void playerTurn(
        final ArrayList<ArrayList<String>> enemyGrid) {

        // Scanners to recieve inputs
        final Scanner inputs = new Scanner(System.in);

        System.out.println("\n\nChose a place to shoot");

        System.out.println("\nSelect coordinates to attack");
        final String bothCoords = inputs.nextLine();

        String rowCoordStr = "";
        String columnCoordStr = "";

        int rowCoord = -1;
        int columnCoord = -1;

        // Will go through every element in the input
        for (int index = 0; index < bothCoords.length(); index++) {
            // Checks every letter 
            for (int letter = 0; letter < alphabet.length; letter++) {

                /*
                * If the current index of the inputted string is equal
                * to the current alphabetical value
                */
                if ((String.valueOf(bothCoords.charAt(index)).equals(
                    Character.toString(alphabet[letter])))) {

                    // Assigns the index of the alphabet to the column value
                    columnCoordStr += Integer.toString(letter);
                }
            }

            // Checks from number 0 to 9
            for (int row = 0; row <= maxCharValue; row++) {

                /*
                * Checks if the current index is the current row
                */
                if (String.valueOf(bothCoords.charAt(index)).equals(
                    Integer.toString(row))) {

                    /*
                    * Will "add" the current index to the row coord.
                    * This will allow inputs like "12D" to be 12 as
                    * apose to adding the 1 and 2 together
                    */
                    rowCoordStr += bothCoords.charAt(index);
                }
            }
        }

        if (columnCoordStr.length() >= 1) {
            if (Integer.parseInt(columnCoordStr) >= capitalLetters) {
                columnCoord = (Integer.parseInt(columnCoordStr)) - 26;
            } else {
                columnCoord = Integer.parseInt(columnCoordStr);
            }
        } else {
            System.out.println("\nPlease input a column value.\n\n");
            throw new java.util.InputMismatchException();
        }

        if (rowCoordStr.length() >= 1) {
            rowCoord = Integer.parseInt(rowCoordStr);
        } else {
            System.out.println("\nPlease input a rows value.\n\n");
            throw new java.util.InputMismatchException();
        }

        // If the row is out of bounds or is never assigned
        if (rowCoord > (numRows - 1) || rowCoord < 0) {
            System.out.println("\nPlease input from the "
                + "rows available.\n\n");
            throw new java.util.InputMismatchException();

        }

        // If the column is never assigned a value or it is out of bounds
        if (columnCoord < 0 || columnCoord >= numCol) {
            System.out.println("\nPlease input from the "
                + "columns available.\n\n");
            throw new java.util.InputMismatchException();
        }

        // If the selected location has already been attacked
        if (enemyGrid.get(rowCoord).get(columnCoord).equals(hit) ||
            enemyGrid.get(rowCoord).get(columnCoord).equals(miss)) {

            System.out.println("\nYou have already attacked this area\n\n");
            throw new java.util.InputMismatchException();

        // If the selected place is blank
        } else if (enemyGrid.get(rowCoord).get(columnCoord) == blank) {
            System.out.print(YELLOW);
            System.out.println("\nMISS\n\n");
            System.out.print(RESET);
            enemyGrid.get(rowCoord).remove(columnCoord);
            enemyGrid.get(rowCoord).add(columnCoord, miss);

        // If the selected place is a ship
        } else if (enemyGrid.get(rowCoord).get(columnCoord).equals("4") ||
                   enemyGrid.get(rowCoord).get(columnCoord).equals("3") ||
                   enemyGrid.get(rowCoord).get(columnCoord).equals("2") ||
                   enemyGrid.get(rowCoord).get(columnCoord).equals("1")) {

            System.out.print(RED);
            System.out.println("\nHIT\n\n");
            System.out.print(RESET);
            enemyGrid.get(rowCoord).remove(columnCoord);
            enemyGrid.get(rowCoord).add(columnCoord, hit);

        // If the location selected is not on the grid
        } else {
            System.out.println("\nYou must select a loctaion"
                + " within the grid\n\n");
            throw new java.util.InputMismatchException();
        }

        System.out.println("You chose (" + rowCoord + ", "
            + alphabet[columnCoord] + ")");

        try {
            /*
            * Waits 1 second so the
            * player can see if you hit or missed.
            */
            Thread.currentThread().sleep(1000);
        } catch(InterruptedException ex) {
        }
    }

    /**
    * Gets a letter from an integer.
    *
    * @param number the number to be used
    * @return the letter to be returned
    */
    public static String getLetter(int number) {

        String returnValue = "";

        /*
        * The inputted number will be from 0-25. If not then it cannot
        * be assigned an alphabetical value, so it will return nothing.
        */
        if (number >= capitalLetters) {
            returnValue = "";
        } else {
            returnValue = Character.toString(alphabet[number]);
        }

        return returnValue;
    }




    /**
    * The heart of the game, where both players take their turn.
    *
    * @param playerGrid the players grid
    * @param enemyGrid the enemies grid
    */ 
    static void playGame(final ArrayList<ArrayList<String>> playerGrid,
                         final ArrayList<ArrayList<String>> enemyGrid) {

        boolean gameOn = true;

        do {
            try {

                /*
                * This function (as with all java functions) uses pointers,
                * which allows it to change the enemies grid
                * without having to return the arrays.
                */
                playerTurn(enemyGrid);

                /*
                * Will check each of the coordinates of the ships to
                * determine if they have been sunk
                */
                checkSink(enemyGrid, 0);

                /*
                * This function (as with all java functions) uses pointers,
                * which allows it to change the player grid
                * without having to return the arrays.
                */
                enemyTurn(playerGrid);                

                /*
                * Will check each of the coordinates of the ships to
                * determine if they have been sunk
                */
                checkSink(enemyGrid, 4);

                /*
                * Waits 2 second so the
                * player can see what the enemy has done
                */
                Thread.currentThread().sleep(2000);

                final String currentResult
                    = gameResult(playerGrid, enemyGrid);

                /*
                * Checks a function to see if the game is over.
                * If so, who wins? If not, then continue.
                */
                if (currentResult.equals("player win")) {
                    gameOn = false;

                    // Prints pixel art of "You Win"
                    artPrinter.pixelArt("you win", MAGENTA_BACKGROUND, WHITE_BACKGROUND);
                    System.out.println();

                    break;
                } else if (currentResult.equals("enemy win")) {
                    gameOn = false;

                    // Soon to be you lose
                    artPrinter.pixelArt("you", MAGENTA_BACKGROUND, WHITE_BACKGROUND);
                    System.out.println();

                    break;
                } else if (currentResult.equals("tie")) {
                    gameOn = false;

                    System.out.println("\n\n");
                    System.out.print(MAGENTA_BOLD);
                    System.out.print(CYAN_BACKGROUND);
                    System.out.print("You tie.");
                    System.out.print(RESET);
                    System.out.println();

                    break;
                }

                System.out.println(yourGridStr);
                printGrid(playerGrid);

                System.out.println(enemyGridStr);
                printEnemyGrid(enemyGrid);

            } catch (java.util.InputMismatchException ex) {
            } catch (InterruptedException ex) {
            }


        } while(gameOn);
    } 


    /**
    * Prints the enemies grid from the players point of view.
    *
    * @param grid the grid
    */
    static void printEnemyGrid(ArrayList<ArrayList<String>> printGrid) {
        // The grid that will be printed
        ArrayList<ArrayList<String>> grid =
            new ArrayList<ArrayList<String>>();

        // Prints the letters accross the top
        System.out.print("  ");
        for (int column = 0; column < numCol; column++) {
            System.out.print(getLetter(column) + " ");
        }
        System.out.println("");

        for (int row = 0; row < numRows; row++) {
            // Resets the color
            System.out.print(RESET);
            System.out.print(row + " ");

            /*
            * Determines how many spaces to leave between the row
            * value and the grid
            */
            for (int counter = 0; counter < (String.valueOf(numRows
                - 1).length() - String.valueOf(row).length()); counter++) {

                System.out.print(" ");
            }

            grid.add(new ArrayList<String>());

            for (int column = 0; column < numCol; column++) {
                int currentIndexNumber = 0;

                if (printGrid.get(row).get(column) == hit) {
                    grid.get(row).add(column, hit);
                    // Sets the color to red
                    System.out.print(RED);
                } else if (printGrid.get(row).get(column) == sunk) {
                    grid.get(row).add(column, sunk);
                    // Sets the color to red
                    System.out.print(RED);
                } else if (printGrid.get(row).get(column) == miss) {
                    grid.get(row).add(column, miss);
                    // Sets the color to yellow
                    System.out.print(YELLOW);
                } else {
                    grid.get(row).add(column, blank);
                    // Sets the color to blue
                    System.out.print(BLUE);
                }

                System.out.print(grid.get(row).get(column) + " ");
            }
            System.out.print("\n");
        }
        // Resets the color
        System.out.print(RESET);

    }

    /**
    * Prints the grid.
    *
    * @param grid the grid
    */
    static void printGrid(final ArrayList<ArrayList<String>> grid) {

        // Prints the letters accross the top
        System.out.print("  ");
        for (int column = 0; column < numCol; column++) {
            System.out.print(getLetter(column) + " ");
        }
        System.out.println("");

        for (int row = 0; row < numRows; row++) {
            // Resets the color
            System.out.print(RESET); 
            // Prints all the letters across the side
            System.out.print(row + " ");

            /*
            * Determines how many spaces to leave between the row
            * value and the grid
            */
            for (int counter = 0; counter < (String.valueOf(
                numRows - 1).length() - String.valueOf(row).length());
                counter++) {

                System.out.print(" ");
            }

            for (int column = 0; column < numCol; column++) {
                int currentIndexNumber = 0;

                // If the location is blank
                if (grid.get(row).get(column) == blank) {
                    // Sets the color to blue
                    System.out.print(BLUE);

                // If the current spot is a hit
                } else if (grid.get(row).get(column).equals(hit)) {
                    // Sets the color to red
                    System.out.print(RED);

                // If the current spot is a miss
                } else if (grid.get(row).get(column).equals(miss)) {
                    // Sets the color to yellow
                    System.out.print(YELLOW);

                } else {
                    currentIndexNumber = Integer.parseInt(grid.get(
                        row).get(column));
                }

                if (currentIndexNumber == 4 || currentIndexNumber == 3
                    || currentIndexNumber == 2 || currentIndexNumber == 1) {
                    // Resets the color
                    System.out.print(RESET);
                }

                System.out.print(grid.get(row).get(column) + " ");
            }
            System.out.print("\n");
        }
        // Resets the color
        System.out.print(RESET);
    }

    /**
    * Checks if horizontal is valid.
    *
    * @param initialGrid the grid
    * @param shipSize how large the ship is
    * @return returns whether it is true or false
    */
    static boolean isHorizontalnValid(
        final ArrayList<ArrayList<String>> initialGrid, final int shipSize) {

        // Checks all the rows
        for (int row = 0; row < numRows; row++) {
            int count = 0;

            // Checks all the columns
            for (int column = 0; column < numCol; column++) {
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


    /**
    * Checks if vertical is valid.
    *
    * @param initialGrid the grid
    * @param shipSize how large the ship is
    * @return returns whether it is true or false
    */
    static boolean isVerticalValid(
        final ArrayList<ArrayList<String>> initialGrid, final int shipSize) {

        // Checks all the rows
        for (int row = 0; row < numRows; row++) { 
            int count = 0;

            // Checks all the columns
            for (int column = 0; column < numCol; column++) {
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




    /**
    * Generates the fours.
    *
    * @param initialGrid the grid
    * @param shipSize how large the ship is
    * @return the new grid with ships
    */
    static ArrayList<ArrayList<String>> generateEachShip(
        final ArrayList<ArrayList<String>> initialGrid, final int shipSize,
        final int enemy) {

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
            // It will either round to 0 or 1. 0 = Vertical and 1 = Horizontal
            int orientation = (int) Math.round(Math.random());
            // Vertical
            if (orientation == 0 && isVerticalValid(returnGrid, shipSize)) {
                Random rand = new Random();
                Random randTwo = new Random();
                // Picks a random column that is not higher than 10
                final int randCol = rand.nextInt(numCol);
                /*
                * Picks a random row from the 0th to the last which
                * happens to be 4
                */
                final int randRow = randTwo.nextInt(numRows - shipSize + 1);

                int count = 0;
                for (int counter = 0; counter < shipSize; counter++) {
                    if (returnGrid.get(randRow + counter).get(randCol)
                        == blank) {

                        count++;
                    }
                    if (count == shipSize) {

                        // Generates the ship
                        for (int row = 0; row < shipSize; row++) {
                            returnGrid.get(randRow + row).remove(randCol);
                            returnGrid.get(randRow + row).add(randCol, ""
                                + shipSize);

                            allShipCoords.get(shipSize + enemy - ONE).get(
                                allShipCoords.get(shipSize + enemy
                                - ONE).size() - 1).add(randRow + row);
                            allShipCoords.get(shipSize + enemy - ONE).get(
                                allShipCoords.get(shipSize + enemy
                                - ONE).size() - 1).add(randCol);
                        }

                        // A ship has now been generated
                        shipNotGenerated = false;
                    }
                }
                

            // Horizontal    
            } else if (orientation == 1 && isHorizontalnValid(
                returnGrid, shipSize)) {

                Random rand = new Random();
                Random randTwo = new Random();

                // Picks a random column that is not higher than 10
                final int randCol = rand.nextInt(numCol - shipSize + 1);
                /*
                * Picks a random row from the 0th to the last which
                * happens to be 4
                */
                final int randRow = randTwo.nextInt(numRows);

                int count = 0;
                for (int counter = 0; counter < shipSize; counter++) {
                    if (returnGrid.get(randRow).get(randCol + counter)
                        == blank) {

                        count++;
                    }
                    if (count == shipSize) {
                        for (int column = 0; column < shipSize; column++) {
                            returnGrid.get(randRow).remove(randCol + column);
                            returnGrid.get(randRow).add(randCol + column,
                                Integer.toString(shipSize));
 
                            /*
                            * .size() gets the size of the array, but the
                            * index we need is always one less
                            */
                            allShipCoords.get(shipSize + enemy - ONE).get(
                                allShipCoords.get(shipSize + enemy
                                - ONE).size() - 1).add(randRow);
                            allShipCoords.get(shipSize + enemy - ONE).get(
                                allShipCoords.get(shipSize + enemy
                                - ONE).size() - 1).add(randCol + column);

                        }
                        // a ship has now been generated
                        shipNotGenerated = false;
                    }
                }

            } else {
                return fail;
            }
        } while (shipNotGenerated);
        return returnGrid;
    }

    /**
    * Calls all the ships to be generated.
    *
    * @param initialGrid the grid
    * @param shipSize how large the ship is
    * @return the new grid with ships
    */
    static ArrayList<ArrayList<String>> generateShips(
        final ArrayList<ArrayList<String>> initialGrid, final int enemy) {

        ArrayList<ArrayList<String>> returnGrid =
            new ArrayList<ArrayList<String>>();

        returnGrid = initialGrid;

        // Goes through all the types of ships
        for (int shipSize = 1; shipSize <= FOUR; shipSize++) {

            // Makes all the ships of type of quantity
            for (int counter = 0; counter < allShipQuantities.get(shipSize
                - ONE); counter++) {
                /*
                * Makes a new ship coordinate holder for either the player
                * or the enemy
                */
                allShipCoords.get(shipSize + enemy - ONE).add(
                    new ArrayList<Integer>());

                if (returnGrid.get(0).get(0) == "fail") {
                    System.out.println("Could not print "
                        + allShipQuantities.get(shipSize - ONE) + " "
                        + shipSize);
                    break;
                } else {
                    returnGrid = generateEachShip(returnGrid, shipSize,
                        enemy);
                }
            }
        }

        return returnGrid;
    }

    /**
    * This sets up the game.
    *
    * @return returns the fully made grid
    */
    static ArrayList<ArrayList<String>> setUpGame(final int enemy) {
        final ArrayList<ArrayList<String>> grid =
            new ArrayList<ArrayList<String>>();

        ArrayList<ArrayList<String>> finalGrid =
            new ArrayList<ArrayList<String>>();

        for (int counter = 0; counter < numRows; counter++) {
            // Adds a new row
            grid.add(new ArrayList<String>());
            for (int counterTwo = 0; counterTwo < numCol; counterTwo++) {
                // Adds a new column and a filler spot for it
                grid.get(counter).add("\u2588");
            }
        }

        finalGrid = generateShips(grid, enemy);

        return finalGrid;
    }

    /**
    * This is the main function.
    *
    * @param args this will not be used
    */
    public static void main(final String[] args) {
        setUpArrays();

        rulesAndStart();

        // Checks if there are more columns than letters
        if (numCol > 26) {
            System.out.println("There are too many columns. Please make it"
                + " between 1 and 26");
            // Ends the program
            System.exit(0);
        }

        ArrayList<ArrayList<String>> playerGrid =
            new ArrayList<ArrayList<String>>();

        // The 0 tells the enemy that it is the players grid
        playerGrid = setUpGame(0);

        // If the generation failed at any point
        if (playerGrid.get(0).get(0) != "fail") {
            System.out.println(yourGridStr);
            printGrid(playerGrid);
        }

        ArrayList<ArrayList<String>> enemyGrid =
            new ArrayList<ArrayList<String>>();

        // The four tells the program that it is the enemies grid
        enemyGrid = setUpGame(4);

        // If the generation failed at any point
        if (enemyGrid.get(0).get(0) != "fail") {
            System.out.println(enemyGridStr);
            // Prints the enemies grid from the players perspective
            printEnemyGrid(enemyGrid);
        }

        if (playerGrid.get(0).get(0) != "fail" && enemyGrid.get(0).get(0)
            != "fail") {

            playGame(playerGrid, enemyGrid);
        }
    }
}
