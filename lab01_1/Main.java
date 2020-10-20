package com.company;

class MyFirstJavaClass {
    int veryHighDigit;
    char oneByte;

    public void print() {
        System.out.println(oneByte);
        System.out.println(veryHighDigit);
    }
}

public class Main {

    public static void main(String[] args) {
        MyFirstJavaClass object = new MyFirstJavaClass();
        object.print();
        System.out.println("Hello World!");
        for (int i = 0; i < 3; i++) {
            System.out.print(args[i] + ' ');
        }
    }
}
