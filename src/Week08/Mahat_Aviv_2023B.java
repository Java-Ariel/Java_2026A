package Week08;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Aviv_2023B {

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
    static Random rand = new Random();

    public static void main(String[] args) {
        boolean bool;
        while (true) {
            System.out.println("Enter q number");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    int number;
                    int count = 0;
                    int sumD;
                    int sum = 0;
                    while ((number = in.nextInt()) != 500) {
                        count++;
                        sum += number;
                        if (number % 2 != 0) {
                            sumD = sumDigit(number);
                            System.out.println(sumD);
                        }
                    }
                    System.out.println((double) sum / count);
                    break;
                case 2:

                    int validCount = 0;
                    for (int i = 0; i < 23; i++) {
                        String s = in.next();
                        bool = isValidStr(s);
                        if (bool)
                            validCount++;
                    }
                    System.out.println(validCount);
                    break;
                case 3:
                    int[] arr = new int[20];
                    while (!isSetOfFriends(arr)) {
                        for (int i = 0; i < arr.length; i++) {
                            arr[i] = rand.nextInt(10, 100);
                        }
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
                    int[] a = fillArray();
                    int[] b = fillArray();
                    System.out.println(Arrays.toString(a));
                    System.out.println(Arrays.toString(b));
                    int[] c = differenceArray(a, b);

                    System.out.println(Arrays.toString(c));
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

    public static boolean isSetOfFriends(int[] arr) {
        if (arr.length % 2 != 0)
            return false;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count != 2)
                return false;
            count = 0;
        }
        return true;
    }

    private static boolean isValidStr(String s) {
        int count = 0;
        int size = s.length();
        for (int i = 0; i < size - 1; i++) {
            char current = s.charAt(i);
            char next = s.charAt(i + 1);
            if (current == 'A') {
                count++;
                if (current == next)
                    return false;
            }
        }
        count += (s.charAt(size - 1) == 'A') ? 1 : 0;
        return count >= 2;
    }

    private static int sumDigit(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static boolean isDivisible(String s, int k) {
        if (k <= 0 && s.length() % k != 0)
            return false;
        int size = s.length() / k;
        String str = s.substring(0, size);
        for (int i = 0; i < s.length(); i += size) {
            if (!str.equals(s.substring(i, i + size))) ;
            return false;
        }
        return true;
    }

    public static int maxDivisor(String s) {
        for (int i = s.length(); i >= 2; i--) {
            if (isDivisible(s, i))
                return i;
        }
        return -1;
    }

    public static String[] maxDivisor(String[] arr) {
        int count = 0;
        for (String s : arr) {
            if (maxDivisor(s) == -1)
                count++;
        }
        String[] newArr = new String[count];
        for (String s : arr) {
            if (maxDivisor(s) == -1)
                newArr[--count] = s;
        }
        return newArr;
    }


    public static int[] buildDiffArray(int[] a, int[] b) {

        int count = 0;
        boolean exist = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++)
                if (a[i] == b[j])
                    exist = true;
            if (!exist)
                count++;
            exist = false;
        }
        int[] c = new int[count];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j])
                    exist = true;
            }
            if (!exist)
                c[--count] = a[i];

            exist = false;
        }
        return c;
    }

    public static int[] fillArray() {
        int size = rand.nextInt(1, 15);
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = rand.nextInt(10, 100);
        }
        return a;
    }

    //O(n)
    public static int[] differenceArray(int[] a, int[] b) {
        int[] existA = contains(a); // O(n) n = len(a)
        int[] existB = contains(b); // O(n) n = max(len(a),len(b))
        // l= len(a), k=len(b) -> n=max(len(a),len(b))

        System.out.println(Arrays.toString(existA));
        System.out.println(Arrays.toString(existB));
        int count = 0;
        for (int i = 0; i < existB.length; i++) {
            if (existA[i] > 0 && existB[i] == 0)
                count++;
        }
        int[] c = new int[count];
        for (int i = 0; i < existB.length; i++) {
            if (existA[i] > 0 && existB[i] == 0)
                c[--count] = i + 10;
        }
        return c;
    }

    //O(n)
    public static int[] comp(int[] a, int[] b) {
        int[] existA = contains(a);
        int[] existB = contains(b);
        int cnt = 0;
        for (int i = 0; i < existB.length; i++) {
            if (existA[i] == 0 && existB[i] == 0)
                cnt++;
        }
        int[] c = new int[cnt];
        for (int i = 0; i < existB.length; i++) {
            if (existA[i] == 0 && existB[i] == 0)
                c[--cnt] = i + 10;
        }
        return c;
    }

    public static int[] contains(int[] a) {
        int[] exist = new int[90];
        for (int num : a)
            exist[num - 10]++;
        return exist;
    }

    //O(log(n))
    static private boolean isCute(int num) {
        int r = num % 10;
        int lenNum = (int) Math.log10(num);
        int temp = (int) Math.pow(10, lenNum);
        int l = num / temp;
        return r % l == 0;
    }


// 11,22,33,44
// 113,223,334,443
// 113,223,334,443
// 113,223,334,443

    //O(n^2*log(n))
    static public boolean isSweet(int[][] mat) {
        boolean flag;
        for (int col = 0; col < mat.length; col++) {
            flag = true;
            for (int row = 0; row < mat.length; row++) {
                if (!isCute(mat[row][col])) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return true;

        }
        return true;
    }
    //O(n^2*log(n))
    static public boolean isSweet2(int[][] mat) {
        for (int col = 0; col < mat.length; col++) {
            int row;
            for (row = 0; row < mat.length; row++)
                if (!isCute(mat[row][col]))
                    break;
            if (row == mat.length)
                return true;
        }
        return false;
    }

}

class Box {
    static Random rand = new Random();

    private String color;
    private int length;
    private int width;
    private int height;

    public Box(String color, int length, int width, int height) {
        this.color = color;
        this.length = length;
        this.width = width;
        this.height = height;

    }

    public Box() {
        this.color = "Black";
        this.length = rand.nextInt(20, 101);
        this.width = rand.nextInt(20, 101);
        this.height = rand.nextInt(20, 101);
    }

    public static boolean isBlackWhite(Box[] arr) {
        boolean black = false;
        boolean white = false;
        for (Box box : arr) {
            if (box.getColor().equals("Black")) {
                black = true;
            } else if (box.getColor().equals("White")) {
                white = true;
            } else return false;
        }
//        int blackCnt = 0;
//        int whiteCnt = 0;
//
//        for (Box box : arr) {
//            if (box.getColor().equals("Black")) {
//                blackCnt++;
//            } else if (box.getColor().equals("White")) {
//                whiteCnt++;
//            }
//        }
//        return blackCnt > 0 && whiteCnt > 0 && whiteCnt + blackCnt == arr.length;
        return black && white;
    }

    // get / set עבור color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // get / set עבור length
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // get / set עבור width
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    // get / set עבור height
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
