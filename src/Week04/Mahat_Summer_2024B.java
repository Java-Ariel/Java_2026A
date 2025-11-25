package Week04;

import java.util.Arrays;
import java.util.Scanner;

public class Mahat_Summer_2024B {

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
                    int[] arr = {4, 12, 15, 7};
                    int[][] mat = {
                            {31, 8, 10, 12},
                            {4, 12, 10, 27},
                            {11, 6, 4, 14},
                            {19, 1, 4, 100},
                            {12, 2, 15, 15},
                            {7, 1, 7, 7}
                    };


                    boolean bool = isExtreme(mat, 0, 4);
                    System.out.println(bool);
                    bool = isPair(mat, arr);
                    System.out.println(bool);
                    break;
                case 13:
                    break;
                case 14:
                    int[] t = {1, 2, 3, 4, 5, 6};
                    allSubArray(t);
                    break;
                case -1:
                    return;
            }
        }
    }
    //    {},
    //    {31, 8, 10, 12},
    //    {4, 12, 10, 27},
    //    {11, 6, 4, 14},
    //    {19, 1, 4, 100},
    //    {12, 2, 15, 15},
    //    {12, 2},
    //    {7, 1, 7, 7}

    // col =2

    //O(n)
    public static boolean isExtreme(int[][] mat, int col, int value) {

        //O(n) n = mat.length
        for (int rows = 0; rows < mat.length; rows++) {
            if (mat[rows].length - 1 < col)
                return false;
        }
        int min, max;
        min = max = mat[col][0];

        //O(n) n = mat.length
        for (int row = 0; row < mat.length; row++) {
            if (mat[row][col] < min)
                min = mat[row][col];
            if (mat[row][col] > max)
                max = mat[row][col];

        }

        return value == min || value == max;
    }

    //O(n^2)
    public static boolean isPair(int[][] mat, int[] arr) {
        //O(n)
        for (int i = 0; i < arr.length; i++) {
            if (!isExtreme(mat, i, arr[i])) // O(n)
                return false;
        }
        return true;
    }

    public static boolean exists(int num, int dig) {

        while (num != 0) {

            int digit = num % 10;
            if (digit == dig)
                return true;
            num /= 10;

        }
        return false;

    }

    public static boolean isFullSet(int[] arr, int left, int right) {
        if (left < 0 || left > arr.length || right < 0 || right > arr.length)
            return false;
        //    {19, 1, 4, 100,54,34,24,78,65,232,4566,245},
        //            ^               ^
        //    left    |     right     |
        int[] counter = new int[10];
        for (int i = left; i <= right; i++) {
            int num = arr[i];
            while (num != 0) {
                int digit = num % 10;
                counter[digit]++;
                num /= 10;
            }
        }
        for (int i = 0; i < counter.length; i++) {
            if (arr[i] == 0)
                return false;
        }

        return true;
    }

    public static int minFullSet(int[] arr) {

        if (!isFullSet(arr, 0, arr.length))
            return -1;

        int min = arr.length;

        for (int sizeOfSubArray = 1; sizeOfSubArray < arr.length; sizeOfSubArray++) {
            for (int i = 0; i < arr.length - sizeOfSubArray - 1; i++) {
                if (isFullSet(arr, i, i + sizeOfSubArray - 1)) {
                    if (min > sizeOfSubArray)
                        min = sizeOfSubArray;
                }
            }

        }

        return min;
    }

    public static void allSubArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println("SubArray [size=" + i + 1 + "]");

            for (int j = 0; j < arr.length - i; j++) {
                int[] subArr = Arrays.copyOfRange(arr, j, j + i + 1);
                System.out.print(Arrays.toString(subArr) + ((j + 1 == arr.length - i) ? "" : ", "));
            }
            System.out.println();
        }
    }

    // O(1) -> כיוון ואנחנו מבצעים בעבור כל גודל של מערך פעולה יחידה (בדיקת תנאי)
    public static boolean isFall(int[] arr, int index) {

        if (index <= 0 || index >= arr.length - 1)
            return false;
        return arr[index] < arr[index - 1] && arr[index] < arr[index + 1];
    }

    //O(n) -> בעבור כל מערך אנחנו מבצעים בדיוק n-2 פעולות ולכן זה מתאים לנוסחה לינארית של פונקצית זמן כלומר
    // an+b => a=1,n,b=-2 ~ O(n)
    public static int countFall(int[] arr) {
        int cntFall = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (isFall(arr, i))
                cntFall++;
        }
        return cntFall;

    }
}