package Week06;

import java.util.Scanner;

public class Mahat_Aviv_2024B {

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

                    Toy t1 = new Toy(1122, 10, 120.0, true);
                    Toy t2 = new Toy(2233, 55.0);
                    if (t1.getAge() > 6 && !t1.getIsPossible())
                        System.out.println("1");
                    else
                        System.out.println("2");
                    if (t2.getPrice() < 100)
                        System.out.println("3");
                    else if (!t2.getIsPossible())
                        System.out.println("4");


                    //---------------------------------------------

//                    Toy t1 = new Toy(1122, 10, 120.0, true);
//                    Toy t2 = new Toy(2233, 55.0);
                    t1.setPossible(false);
                    t2.setPrice(150);
                    t2.setPossible(true);
                    if (t1.getAge() > 6 && !t1.getIsPossible())
                        System.out.println("1");
                    else
                        System.out.println("2");
                    if (t2.getPrice() < 100)
                        System.out.println("3");
                    else if (!t2.getIsPossible())
                        System.out.println("4");
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
}

class Toy {
    // שדות (Attributes)
    private int code;
    private int age;
    private double price;
    private boolean isPossible;

    // בונה (Constructor)
    public Toy(int code, int age, double price, boolean isPossible) {
        this.code = code;
        this.age = age;
        this.price = price;
        this.isPossible = isPossible;
    }

    public Toy(int code, double price) {
        this.code = code;
        this.price = price;
        this.age = 10;
        this.isPossible = false;
    }


    // get/set לשדות

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getIsPossible() {
        return isPossible;
    }

    public void setPossible(boolean isPossible) {
        this.isPossible = isPossible;
    }
}


class AIQData {
    // שדות (Attributes)
    private String date;
    private String city;
    private int popul;
    private int aiq;

    // בונה (Constructor)
    public AIQData(String date, String city, int popul, int aiq) {
        this.date = date;
        this.city = city;
        this.popul = popul;
        this.aiq = aiq;
    }

    public int raiting() {
        int rate = (aiq / 50) + 1; // value between 1-11

        return (rate < 5) ? rate : 5;
//        return Math.min(aqi / 50 + 1, 5);
    }

    // get/set לשדות
    public static void printDangerous(AIQData[] arr, String checkDate) {
        for (AIQData data : arr) {
            if (data.raiting() > 3 && data.getDate().equals(checkDate))
                System.out.println(data.getCity());
        }

        for (int i = 0; i < arr.length; i++) {
            AIQData data = arr[i];
            if (data.raiting() > 3)
                System.out.println(data.getCity());
        }

    }


    public static void printCities(AIQData[] arr, String[] cities) {

        for (int i = 0; i < cities.length; i++) {
            int good = 0;
            int bad = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].getCity().equals(cities[i])) {
                    if (arr[j].raiting() > 3)
                        bad++;
                    else
                        good++;
                }
            }

            System.out.println(cities[i]);
            System.out.println(good+bad);
            System.out.println(good);
            System.out.println(bad);
        }


    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPopul() {
        return popul;
    }

    public void setPopul(int popul) {
        this.popul = popul;
    }

    public int getAiq() {
        return aiq;
    }

    public void setAiq(int aiq) {
        this.aiq = aiq;
    }
}
