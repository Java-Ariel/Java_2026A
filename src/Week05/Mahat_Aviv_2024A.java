package Week05;

import java.util.Random;
import java.util.Scanner;

public class Mahat_Aviv_2024A {

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
                    int[] arr = {12, 3, 7, 5, 15, 2, 6};
                    isArranged(arr);
                    fill(arr,2,8);
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
                case -1:
                    return;
            }
        }
    }

    private static void fill(int[] arr, int a, int b) {
        if (arr == null)
            return;

        while (!isArranged(arr)) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new Random().nextInt(a, b);
            }
        }
    }

    private static boolean isArranged(int[] arr) {
        if (arr == null || arr.length < 2)
            return false;

        int min = arr[0];
        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] < min)
                min = arr[i];
        }

        int max = arr[1];

        for (int i = 1; i < arr.length; i += 2) {
            if (arr[i] > max)
                max = arr[i];
        }

        return min > max;
    }

    private static boolean isValueArranged(int[] arr) {
        if (arr == null || arr.length < 2)
            return false;

        int min = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                min = arr[i];
        }
        if (min == 1)
            return false;

        for (int i = 1; i < arr.length; i += 2) {
            if (arr[i] % 2 == 0 && min > arr[i])
                min = arr[i];
        }

        for (int i = 1; i < arr.length; i += 2) {
            if (arr[i] % 2 != 0 && arr[i] > min)
                return false;
        }
        return true;
    }


}