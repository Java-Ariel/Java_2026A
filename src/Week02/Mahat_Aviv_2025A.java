package Week02;

import java.util.Random;
import java.util.Scanner;

public class Mahat_Aviv_2025A {
    static Random rand = new Random();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter q number");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:

                    System.out.println((Math.log10(1234) + 1));
                    int evenCount = 0;
                    int isEvenDigit = 0;
                    for (int i = 0; i < 60; i++) {
                        int item = rand.nextInt(100, 1000);
//                        if (item % 2 == 0)
//                            evenCount++;
                        evenCount += (item % 2 == 0) ? 1 : 0;
                        //755
                        //5
                        //5%2
                        //755/10=75%10=5%2==0

//                        if (item % 10 % 2 == 0)
//                            isEvenDigit++;
//                        else if ((item / 10 % 10) % 2 == 0)
//                            isEvenDigit++;
//                        else if ((item / 100) % 2 == 0)
//                            isEvenDigit++;

                        isEvenDigit += ((item % 10) % 2 == 0) ? 1 : ((item / 10 % 10) % 2 == 0) ? 1 : ((item / 100) % 2 == 0) ? 1 : 0;

                        while (item != 0) {
                            int digit = item % 10;
                            if (digit % 2 == 0) {
                                isEvenDigit++;
                                break;
                            }
                            item /= 10;
                        }
                        System.out.println(evenCount);
                        System.out.println(isEvenDigit);
                    }

                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    int[][] matrix =
                            {{1, 2, 3, 4},
                                    {1, 2, 3, 4},
                                    {1, 2, 3, 4},
                                    {1, 2, 3, 4}

                            };


                    boolean bool = q14_a(matrix);
                    break;
                case -1:
                    return;
            }
        }
    }

    private static boolean q14_a(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                String item = matrix[j][i] + "";
                boolean bool = false;
                for (int k = 0; k < item.length(); k++) {
                    if (item.charAt(k) == i) {
                        bool = true;
                    }
                }
                if (!bool)
                    return false;

            }
        }
        return true;
    }
}

