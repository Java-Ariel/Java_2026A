package Week07;

import java.util.Random;
import java.util.Scanner;

public class Mahat_Summer_2023A {

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
        while (true) {
            System.out.println("Enter q number");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    for (int i = 1; i < 1000; i++) {
                        if (i % sumDigit(i) == 0)
                            System.out.println(i);
                    }
                    break;
                case 2:
                    int countInput = 0;
                    while (true) {
                        String number = in.nextLine();
                        countInput++;
                        if (
                                number.length() != 11 ||
                                        !number.startsWith("05") ||
                                        number.charAt(2) < '0' ||
                                        number.charAt(2) > '8' ||
                                        number.charAt(3) != '-'
                        ) {
                            continue;
                        }
                        boolean bool = isKDigit(number.substring(4));
                        if (!bool) continue;
                        break;
                    }

                    break;
                case 3:
                    break;
                case 4:
                    boolean bool = true;
                    for (int i = 0; i < 100; i++) {
                        int[] time = new int[4];
                        Time t1 = new Time(time[0], time[1]);
                        Time t2 = new Time(time[2], time[3]);
                        for (int j = 0; j < 4; j++) {
                            time[i] = in.nextInt();
                        }
                        if (t1.difference(t2) > 180)
                            bool = false;
                    }
                    if (!bool)
                        System.out.println("Bad");
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    int[] a = new int[10], b = new int[10];
                    if (a.length != b.length)
                        System.out.println("X");
                    for (int i = 0; i < a.length; i++) {
                        if (a[i] != b[b.length - i - 1])
                            System.out.println("X");
                    }

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

    private static boolean isKDigit(String number) {
        for (int i = 0; i < number.length(); i++)
            if (number.charAt(i) < '0' || number.charAt(i) > '9')
//            if (!Character.isDigit(number.charAt(i)))
                return false;

        return true;

    }

    public static boolean isOrdered(int[] arr) {

        int i;
        for (i = 0; i < arr.length; i++)
            if (arr[i] % 2 != 0)
                break;

        for (; i < arr.length; i++)
            if (arr[i] % 2 == 0)
                return false;

        return true;
    }

    public static int[] buildOrderedArray(int size, int x, int y) {
        int[] arr = new int[size];
        arr[0] = 1;
        while (!isOrdered(arr))
            for (int i = 0; i < arr.length; i++) {
                int num = x + rand.nextInt(y - x + 1);
                arr[i] = num;
            }

        return arr;
    }

    private static int sumDigit(int i) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}

class Time {
    private int hour; // העש 23-0
    private int min; // תוקד 59-0

    public Time(int hour, int min) {
        this.hour = hour;
        this.min = min;
    }

    public int getByMin() {
        return hour * 60 + min;
    }

    public int difference(Time other) {
        return other.getByMin() - this.getByMin();

    }

    public static boolean sameProducer(Coffee[] crr) {

        if (crr.length == 0)
            return false;
        String name = crr[0].getName();
        for (int i = 0; i < crr.length; i++) {
            if (!crr[i].getName().equals(name))
                return false;
        }

//        for (int i = 0; i < crr.length-1; i++) {
//            if (!crr[i].getName().equals(crr[i+1].getName()))
//                return false;
//        }
        return true;

    }

    public static String[] weakSorts(Coffee[] crr, int num) {

        int count = 0;
        for (int i = 0; i < crr.length; i++) {
            if (crr[i].getStrength() < num)
                count++;
        }
        String[] crrStrength = (count == 0) ? null : new String[count];
        count = 0;
        for (int i = 0; i < crr.length; i++) {
            if (crr[i].getStrength() < num)
                crrStrength[count++] = crr[i].getType();
        }

        return crrStrength;
    }
}

class Coffee {
    private String name;
    private String type;
    private int strength;
    private double price;

    // קונסטרקטור למחלקת Coffee
    public Coffee(String name, String type, int strength, double price) {
        this.name = name;
        this.type = type;
        this.strength = strength;
        this.price = price;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // toString להדפסת המידע על הקפה
    @Override
    public String toString() {
        return "Coffee[name=" + name + ", type=" + type + ", strength=" + strength + ", price=" + price + "]";
    }
}
