package Week01;

import java.util.Scanner;

public class Mahat_Aviv_2025B {

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
        boolean bool;
        while (true) {
            System.out.println(ANSI_BLUE + "Enter q number");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    int zeroCnt = 0;
                    int sumPos = 0;
                    int cntNeg = 0;
                    while (zeroCnt != 3) {
                        int item = in.nextInt();
                        if (item == 0)
                            zeroCnt++;

                        sumPos += (item > 0) ? item : 0;
                        cntNeg += (item < 0) ? 1 : 0;
                    }
                    System.out.println(sumPos);
                    System.out.println(cntNeg);

                    break;
                case 2:
                    int evenLen = 0;
                    int oddLen = 0;
                    String s;
                    while ((s = in.next()).charAt(0) != 'Z' && s.charAt(s.length() - 1) != 'Z') {
                        if (s.length() % 2 == 0) evenLen++;
                        else oddLen++;
//                        evenLen += (s.length() % 2 == 0) ? 1 : 0;
//                        oddLen += (s.length() % 2 != 0) ? 1 : 0;
                    }
                    System.out.println(evenLen);
                    System.out.println(oddLen);

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    int[] a = {5, 3, 7, 1, 10, 19, 16, 14, 35};
                    bool = q5_a(a);
                    System.out.println("bool = q5_a(a) -> " + bool);
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

    public static boolean q5_a(int[] arr) {

        for (int i = 0; i < arr.length - 2; i += 2) {
            if (arr[i] > arr[i + 2])
                return false;
        }
        return true;
    }

    public static boolean q5_b(int[] arr) {
        int evenIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenIndex = i;
                break;
            }
        }
        for (int i = evenIndex + 1; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                if (arr[evenIndex] > arr[i]) {
                    return false;
                } else {
                    evenIndex = i;
                }

            }
        }
        return true;
    }
}