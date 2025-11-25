package Week03;

import java.util.Random;
import java.util.Scanner;

public class Mahat_Summer_2024A {

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
    static Random rd = new Random();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter q number");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    int count = 0;
                    int sumEven = 0;

                    for (int i = 0; i < 20; i++) {

                        int num1;
                        while ((num1 = in.nextInt()) < 0) ;
                        count += (num1 > 9 && num1 < 100) ? 1 : 0;
//                        count += (Math.log10(num1) + 1 == 2) ? 1 : 0;
                        sumEven += (num1 % 2 == 0) ? 1 : 0;
                        int num2;
                        while ((num2 = in.nextInt()) < 0) ;
//                        count += (num2 > 9 && num2 < 100) ? 1 : 0;
                        count += (Math.log10(num2) + 1 == 2) ? 1 : 0;
                        sumEven += (num2 % 2 == 0) ? 1 : 0;
                    }

                    System.out.println(count);
                    System.out.println(sumEven);
                    break;
                case 2:
                    String s;
                    int cnt = 0;
                    while ((s = in.nextLine()).length() % 2 != 0) {
                        for (int i = 0; i < s.length(); i++) {
                            if (s.charAt(i) == 'Z') {
                                System.out.println("Has Z");
                                break;
                            }
                        }
                        int lastIndex = s.length() - 1;
                        cnt += (s.charAt(0) == s.charAt(lastIndex)) ? 1 : 0;

                    }
                    System.out.println(cnt);
                    break;
                case 3:
                    int[] countNumber = new int[90];
                    for (int i = 0; i < 40; i++) {
                        int item = rd.nextInt(10, 100);
                        countNumber[item - 10]++;
                    }
                    int maxInx = 0;
                    //[2,0,0,0,0,0,0,0,0,0,0,0,30,0,0,0,0,0,]
                    for (int i = 0; i < countNumber.length; i++) {
                        if (countNumber[i] > countNumber[maxInx])
                            maxInx = i;

                    }
                    System.out.println(maxInx);
                    for (int i = 0; i < countNumber.length; i++) {
                        if (countNumber[i] == 0)
                            System.out.println(i + 10);
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
                case -1:
                    return;
            }
        }
    }

    //O(k)
    //  נניח שגודל המערך הינו n איברים ונניח שk זה מספר בין 0 ל - n אם k = n כלומר k הוא גודל המערך אז אפשר לומר שהסיבוכיות היא O(n)
    // אחרת ניתן לומר סיבוכיות של O(k) כאשר k הוא לפחות n
    public static boolean isPerfectK(int[] arr, int k) {

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        return sum % k == 0;

    }

    //O(n^2) or m = max ( k,n) = O(m^2)
    public static boolean isSuperPerfect(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (!isPerfectK(arr, i))
                return false;
        }
        return true;
    }
}

class Food {
    private String name;
    private double price;
    private boolean isMilk;
    private double rating;


    public Food(String name, double price, boolean isMilk, double rating) {
        this.name = name;
        this.price = price;
        this.isMilk = isMilk;
        this.rating = rating;
    }

    public boolean canChange(Food other) {
        if (isMilk != other.isMilk() || this.rating != other.rating || this.price != other.price)
            return false;

        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isMilk() {
        return isMilk;
    }

    public void setMilk(boolean isMilk) {
        this.isMilk = isMilk;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public static void changes(Food[] arr, Food newFood) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].canChange(newFood))
                System.out.println(arr[i].getName());
        }

    }

    public static void offers(Food[] arr) {
        //[d,d,d,d,d,d,d,d,d,d,d,d,d,d,d,d,d]

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].getPrice() + arr[j].getPrice() < 100)
                    System.out.println(arr[i].getName() + " With " + arr[j].getName());
            }
        }

    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", isMilk=" + isMilk +
                ", rating=" + rating +
                '}';
    }
}
