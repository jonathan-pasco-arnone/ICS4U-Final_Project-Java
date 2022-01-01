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

    private static int numFours = 1; // Number of ships that take up 4 squares - default = 1
    private static int numThrees = 0; // Number of ships that take up 3 squares - defualt = 3
    private static int numTwos = 0; // Number of ships that take up 2 squares - default = 2
    private static int numOnes = 0; // Number of ships that take up 1 squares - default = 2
    private static int numRows = 10; // The amount of rows in the grid - defualt = 10
    private static int numCol = 10; // The amount of columns in the grid - defualt = 10

    private static String blank = "\u2588"; // A blank background

    private static String yourGridStr = "=====================\n------Your " +
                                     "Grid------\n=====================\n";
    private static String enemyGridStr = "\n\n\n=====================\n------Enemy " +
                                     "Grid-----\n=====================\n";

    private static String BLUE = "\033[0;34m";
    private static String RED = "\033[0;31m";
    private static String YELLOW = "\033[0;33m";
    private static String MAGENTA_BOLD = "\033[1;35m";
    private static String BOLD_WHITE = "\033[1;37m";
    private static String CYAN_BACKGROUND = "\033[46m";
    private static String RESET = "\033[0m";

    private static String hit = "H";
    private static String miss = "M";

    private static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static int maxCharValue = 9;

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
    public static void enemyTurn(final ArrayList<ArrayList<String>> playerGrid) {

        do {

        Random randRow = new Random();
        Random randCol = new Random();

        // Picks a random column that is not higher tan the total columns
        final int rowCoord = randRow.nextInt(numRows);
        // Picks a random row that is not higher than the total rows
        final int columnCoord = randCol.nextInt(numCol);

        // Determines the alphabetical value of the random horizontal coordinate
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

            System.out.println("The computer chose the vertical coordinate of "
                + rowCoord + " and the horizontal coordinate of " + horizontalCoordStr);

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
    public static void playerTurn(final ArrayList<ArrayList<String>> enemyGrid) {

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
                if ((String.valueOf(bothCoords.charAt(index)).equals(Character.toString(alphabet[letter])))) {
                    columnCoordStr += Integer.toString(letter);
                }
            }

            // Checks from number 0 to 9
            for (int row = 0; row <= maxCharValue; row++) {

                /*
                * Checks if the current index is the current row
                */
                if (String.valueOf(bothCoords.charAt(index)).equals(Integer.toString(row))) {

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
            columnCoord = Integer.parseInt(columnCoordStr);
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
        if (columnCoord < 0 || columnCoord > (numCol - 1)) {
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
            System.out.println("\nMISS\n\n");
            enemyGrid.get(rowCoord).remove(columnCoord);
            enemyGrid.get(rowCoord).add(columnCoord, miss);

        // If the selected place is a ship
        } else if (enemyGrid.get(rowCoord).get(columnCoord).equals("4") ||
                   enemyGrid.get(rowCoord).get(columnCoord).equals("3") ||
                   enemyGrid.get(rowCoord).get(columnCoord).equals("2") ||
                   enemyGrid.get(rowCoord).get(columnCoord).equals("1")) {

            System.out.println("\nHIT\n\n");
            enemyGrid.get(rowCoord).remove(columnCoord);
            enemyGrid.get(rowCoord).add(columnCoord, hit);

        // If the location selected is not on the grid
        } else {
            System.out.println("\nYou must select a loctaion within the grid\n\n");
            throw new java.util.InputMismatchException();
        }

        System.out.println("You chose (" + rowCoord + ", " + alphabet[columnCoord] + ")");

        try {
            /*
            * Waits 1 second so the
            * player can see if you hit or missed.
            */
            Thread.currentThread().sleep(1000);
        } catch(InterruptedException ex) {
        }
    }

    public static String getLetter(int number) {

        String returnValue = "";

        /*
        * The inputted number will be from 0-25. If not then it cannot
        * be assigned an alphabetical value, so it will return nothing.
        */
        if (number > 25) {
            returnValue = "";
        } else {
            returnValue = Character.toString(alphabet[number]);
        }

        return returnValue;
    }




    // The main game
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
                * This function (as with all java functions) uses pointers,
                * which allows it to change the player grid
                * without having to return the arrays.
                */
                enemyTurn(playerGrid);                

                /*
                * Waits 2 second so the
                * player can see what the enemy has done
                */
                Thread.currentThread().sleep(2000);

                final String currentResult = gameResult(playerGrid, enemyGrid);

                /*
                * Checks a function to see if the game is over.
                * If so, who wins? If not, then continue.
                */
                if (currentResult.equals("player win")) {
                    gameOn = false;

                    System.out.println("\n\n");
                    System.out.print(MAGENTA_BOLD);
                    System.out.print(CYAN_BACKGROUND);
                    System.out.print("YOU WIN!!");
                    System.out.print(RESET);
                    System.out.println();

                    break;
                } else if (currentResult.equals("enemy win")) {
                    gameOn = false;

                    System.out.println("\n\n");
                    System.out.print(MAGENTA_BOLD);
                    System.out.print(CYAN_BACKGROUND);
                    System.out.print(RESET);
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
            for (int counter = 0; counter < (String.valueOf(numRows - 1).length() - String.valueOf(row).length()); counter++) {
                System.out.print(" ");
            }

            grid.add(new ArrayList<String>());

            for (int column = 0; column < numCol; column++) {
                int currentIndexNumber = 0;

                if (printGrid.get(row).get(column) == hit) {
                    grid.get(row).add(column, hit);
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
                    currentIndexNumber = Integer.parseInt(grid.get(row).get(column));
                }

                if (currentIndexNumber == 4 || currentIndexNumber == 3 || currentIndexNumber == 2 || currentIndexNumber == 1) {
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
    static boolean isHorizontalnValid(final ArrayList<ArrayList<String>> initialGrid, final int shipSize) {

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
    static boolean isVerticalValid(final ArrayList<ArrayList<String>> initialGrid, final int shipSize) {

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
    static ArrayList<ArrayList<String>> generateEachShip(final ArrayList<ArrayList<String>> initialGrid, final int shipSize) {
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
                // Picks a random row from the 0th to the last which happens to be 4
                final int randRow = randTwo.nextInt(numRows - shipSize + 1);

                int count = 0;
                for (int counter = 0; counter < shipSize; counter++) {
                    if (returnGrid.get(randRow + counter).get(randCol) == blank) {
                        count++;
                    }
                    if (count == shipSize) {
                        for (int row = 0; row < shipSize; row++) {
                            returnGrid.get(randRow + row).remove(randCol);
                            returnGrid.get(randRow + row).add(randCol, "" + shipSize);
                        }
                        // A ship has now been generated
                        shipNotGenerated = false;
                    }
                }
                

            // Horizontal    
            } else if (orientation == 1 && isHorizontalnValid(returnGrid, shipSize)) {
                Random rand = new Random();
                Random randTwo = new Random();

                // Picks a random column that is not higher than 10
                final int randCol = rand.nextInt(numCol - shipSize + 1);
                // Picks a random row from the 0th to the last which happens to be 4
                final int randRow = randTwo.nextInt(numRows);

                int count = 0;
                for (int counter = 0; counter < shipSize; counter++) {
                    if (returnGrid.get(randRow).get(randCol + counter) == blank) {
                        count++;
                    }
                    if (count == shipSize) {
                        for (int column = 0; column < shipSize; column++) {
                            returnGrid.get(randRow).remove(randCol + column);
                            returnGrid.get(randRow).add(randCol + column, Integer.toString(shipSize));
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
    static ArrayList<ArrayList<String>> generateShips(final ArrayList<ArrayList<String>> initialGrid) {
        ArrayList<ArrayList<String>> returnGrid =
            new ArrayList<ArrayList<String>>();

        returnGrid = initialGrid;

        // Makes all the fours
        for (int counter = 0; counter < numFours; counter++) {
            if (returnGrid.get(0).get(0) == "fail") {
                System.out.println("Could not print " + numFours +" fours");
                break;
            } else {
                returnGrid = generateEachShip(returnGrid, 4);
            }
        }

        // Makes all the threes
        for (int counter = 0; counter < numThrees; counter++) {
            if (returnGrid.get(0).get(0) == "fail") {
                System.out.println("Could not print " + numThrees +" threes");
                break;
            } else {
                returnGrid = generateEachShip(returnGrid, 3);
            }
        }

        // Makes all the twos
        for (int counter = 0; counter < numTwos; counter++) {
            if (returnGrid.get(0).get(0) == "fail") {
                System.out.println("Could not print " + numTwos +" twos");
                break;
            } else {
                returnGrid = generateEachShip(returnGrid, 2);
            }
        }

        // Makes all the ones
        for (int counter = 0; counter < numOnes; counter++) {
            if (returnGrid.get(0).get(0) == "fail") {
                System.out.println("Could not print " + numOnes +" ones");
                break;
            } else {
                returnGrid = generateEachShip(returnGrid, 1);
            }
        }

        return returnGrid;
    }

    /**
    * This sets up the game.
    *
    * @return returns the fully made grid
    */
    static ArrayList<ArrayList<String>> setUpGame() {
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
        finalGrid = generateShips(grid);

        return finalGrid;
    }

    /**
    * This is the main function.
    *
    * @param args this will not be used
    */
    public static void main(final String[] args) {
        System.out.println("This is the Battleship program\n");

        System.out.println("\007");

        if (numCol > 25) {
            System.out.println("There are too many columns. Please make it between 1 and 25");
            // Ends the program
            System.exit(0);
        }

        ArrayList<ArrayList<String>> playerGrid =
            new ArrayList<ArrayList<String>>();
        playerGrid = setUpGame();

        if (playerGrid.get(0).get(0) != "fail") {
            System.out.println(yourGridStr);
            printGrid(playerGrid);
        }

        ArrayList<ArrayList<String>> enemyGrid =
            new ArrayList<ArrayList<String>>();
        enemyGrid = setUpGame();
 
        if (enemyGrid.get(0).get(0) != "fail") {
            System.out.println(enemyGridStr);
            // Prints the enemies grid from the players perspective
            printEnemyGrid(enemyGrid);
        }
        if (playerGrid.get(0).get(0) != "fail" && enemyGrid.get(0).get(0) != "fail") {
            playGame(playerGrid, enemyGrid);
        }
    }
}
