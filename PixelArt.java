/*
* This is the class file with pixel art programs
*
* @author  Jonathan Pasco-Arnone
* @version 1.0
* @since   2022-1-11
*/

/**
* This is the class file to hold all the pixel art.
*/
public class PixelArt {

    /**
    * Unicode for changing text color and background color back
    * to its original form.
    */
    private static String RESET = "\033[0m";

    /**
    * The size of one block in the pixel function.
    */
    private static String onePixel = "    ";
    /**
    * The size of three quarters of a block in the pixel function.
    */
    private static String threeQuarterPixel = "   ";
    /**
    * The size of half of a block in the pixel function.
    */
    private static String halfPixel = "  ";
    /**
    * The size of a quarter of a block in the pixel function.
    */
    private static String quarterPixel = " ";

    /**
    * An empty constructor.
    */
    public PixelArt() {
    }

    /**
    * Pixel art for "YOU WIN".
    *
    * @param title the title of the pixel art you want to print
    * @param backgroundColor the background color
    * @param textColor the color of the text
    */
    public void pixelArt(final String title, final String backgroundColor, final String textColor) {
        if (title.equals("you win")) {
            pixelArt("you", backgroundColor, textColor);
            pixelArt("win", backgroundColor, textColor);
        }

        if (title.equals("win")) {
            // Top of W / Top of I / Top of N
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + textColor + onePixel + onePixel + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + textColor + onePixel + halfPixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + halfPixel + textColor + onePixel);

            // Second to top of W / Second to top of I / Second to top of N
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + textColor + onePixel + onePixel + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + textColor + onePixel + halfPixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + halfPixel + textColor + onePixel);

            // Third to top of W / Third to top of I / Third to top of N
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + quarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + halfPixel + textColor + onePixel + halfPixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + halfPixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + quarterPixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + textColor + onePixel);

            // 4th to top of W / 4th to top of I / 4th to top of N
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + quarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + halfPixel + textColor + onePixel + halfPixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + halfPixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + quarterPixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + textColor + onePixel);

            // 5th to top of W / 5th to top of I / 5th to top of N
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + textColor + onePixel + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + halfPixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + halfPixel + textColor + onePixel);

            // 6th to top of W / 6th to top of I / 6th to top of N
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + textColor + onePixel + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + halfPixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + halfPixel + textColor + onePixel);

            // 7th to top of W / 7th to top of I / 7th to top of N
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + threeQuarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + halfPixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(halfPixel + onePixel + onePixel + onePixel + onePixel + onePixel + quarterPixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + textColor + onePixel);

            // 8th to top of W / 8th to top of I / 8th to top of N
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + threeQuarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + halfPixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + threeQuarterPixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + textColor + onePixel);

            // 9th to top of W / 9th to top of I / 9th to top of N
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(halfPixel + textColor + onePixel);

            // 10th to top of W / 10th to top of I / 10th to top of N
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(halfPixel + textColor + onePixel);

            // 11th to top of W / 11th to top of I / 11th to top of N
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + quarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(halfPixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(quarterPixel + onePixel + onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(textColor + onePixel);

            // 12th to top of W / 12th to top of I / 12th to top of N
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + quarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(halfPixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(quarterPixel + onePixel + onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(textColor + onePixel);

            // 13th to top of W / 13th to top of I / 13th to top of N
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + halfPixel + textColor + onePixel + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + textColor + onePixel + onePixel);

            System.out.print(backgroundColor);
            System.out.print(halfPixel + onePixel + onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // 14th to top of W / 14th to top of I / 14th to top of N
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + halfPixel + textColor + onePixel + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + textColor + onePixel + onePixel);

            System.out.print(backgroundColor);
            System.out.print(halfPixel + onePixel + onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // 15th to top of W / 15th to top of I / 15th to top of N
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + threeQuarterPixel + textColor + onePixel + halfPixel);
            System.out.print(backgroundColor);
            System.out.print(halfPixel + onePixel + onePixel + textColor + onePixel + halfPixel);

            System.out.print(backgroundColor);
            System.out.print(threeQuarterPixel + onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel + onePixel + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // 16th to top of W / 16th to top of I / 16th to top of N
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + threeQuarterPixel + textColor + onePixel + halfPixel);
            System.out.print(backgroundColor);
            System.out.print(halfPixel + onePixel + onePixel + textColor + onePixel + halfPixel);

            System.out.print(backgroundColor);
            System.out.print(threeQuarterPixel + onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel + onePixel + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);


            // Buffer lines
            System.out.print(backgroundColor);
            System.out.println("\n");
        }

        if (title.equals("you")) {
            // Starting buffer of magenta
            System.out.println(backgroundColor);
            for (int counter = 0; counter < 23; counter++) {
                System.out.println(quarterPixel);
            }

            // Top of Y / Top of O / Top of U
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + textColor + onePixel + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // Second to top of Y / Second to top of O / Second to top of U 
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + textColor + onePixel + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // Third to top of Y / Third to top of O / Third to top of U 
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + quarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + halfPixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + threeQuarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // 4th to top of Y / 4th to top of O / 4th to top of U 
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + quarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + halfPixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + threeQuarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // 5th to top of Y / 5th to top of O / 5th to top of U 
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // 6th to top of Y / 6th to top of O / 6th to top of U 
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // 7th to top of Y / 7th to top of O / 7th to top of U 
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + threeQuarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + halfPixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(halfPixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + threeQuarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // 8th to top of Y / 8th to top of O / 8th to top of U 
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + threeQuarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + halfPixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(halfPixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + threeQuarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // 9th to top of Y / 9th to top of O / 9th to top of U 
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(textColor + onePixel + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + threeQuarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(halfPixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + threeQuarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // 10th to top of Y / 10th to top of O / 10th to top of U 
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(textColor + onePixel + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + threeQuarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(halfPixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + threeQuarterPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // 11th to top of Y / 11th to top of O / 11th to top of U 
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // 12th to top of Y / 12th to top of O / 12th to top of U 
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // 13th to top of Y / 13th to top of O / 13th to top of U 
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel +  textColor + onePixel);

            // 14th to top of Y / 14th to top of O / 14th to top of U 
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + halfPixel + textColor + onePixel);
            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // 15th to top of Y / 15th to top of O / 15th to top of U 
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // 16th to top of Y / 16th to top of O / 16th to top of U 
            System.out.println(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + onePixel + onePixel + textColor + onePixel + onePixel);

            System.out.print(backgroundColor);
            System.out.print(onePixel + onePixel + onePixel + onePixel + textColor + onePixel);
            System.out.print(onePixel + onePixel + onePixel + textColor + onePixel);

            // Buffer lines
            System.out.print(backgroundColor);
            System.out.println("\n\n\n");

        }

        // Resets all the colors and background colors
        System.out.print(RESET);
    }
}
