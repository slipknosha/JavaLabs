package com.company;
import java.util.Scanner;

/**Головний клас програми*/
public class Main {

    /**Головна функція програми*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ran, ranB, ranT;
        System.out.println("enter range of fibanacci");
        ran = in.nextInt();
        System.out.println("enter the top of digits range");
        ranT = in.nextInt();
        System.out.println("enter the bot of digits range");
        ranB = in.nextInt();
        digits obj = new digits(ran, ranT, ranB);
        obj.fillingArray();
        obj.sum();
        obj.printNumbers();
        obj.fibonnaciLoop();
    }
}


