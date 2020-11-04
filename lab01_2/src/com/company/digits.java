package com.company;
/**Клас, який опрацьовує інформацію по завданню */
public class digits {
    private int rangeBot;
    private int rangeTop;
    private int pairedSum;
    private int unpairedSum;
    private int[] array;
    private int range;
    private int[] fibonacci;
    private int maxUnpaired;
    private int maxPaired;
    private double pairedPercent;
    private double unpairedPercent;

    /**Конструктор класу*/
    digits(int r, int t, int b) {
        range = r;
        rangeTop = t;
        rangeBot = b;
        array = new int[rangeTop - rangeBot];
        fibonacci = new int[range];
    }

    /**Функція яка рахує фібоначі*/
    void fibonnaciLoop() {
        fibonacci[0] = maxUnpaired;
        fibonacci[1] = maxPaired;
        int paired = 0;
        int unpaired = 0;
        System.out.println(fibonacci[0]);
        System.out.println(fibonacci[1]);
        for (int i = 2; i < range; ++i) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            System.out.println(fibonacci[i]);
            if (fibonacci[i] % 2 == 0) {
                paired++;
            }
            if (fibonacci [i] % 2 != 0) {
                unpaired++;
            }
        }
        pairedPercent = ((double)paired/range) * 100;
        unpairedPercent = ((double)unpaired/range) * 100;
        System.out.println("paired percent " + pairedPercent);
        System.out.println("paired percent " + unpairedPercent);
    }
    /**Наповнення масиву*/
    void fillingArray() {
        for (int i = 0; i < rangeTop - rangeBot; i++) {
            array[i] = i;
        }
    }
    /**Сума парних та не парних*/
    void sum() {
        maxPaired = array[0];
        maxUnpaired = array[0];
        for(int i = 0; i < rangeTop - rangeBot; i++) {
            if (array[i] % 2 == 0) {
                pairedSum += i;
                if (array[i] > maxPaired) {
                    maxPaired = array[i];
                }
            }
            if (array[i] % 2 != 0) {
                unpairedSum += i;
                if (array[i] > maxUnpaired) {
                    maxUnpaired = array[i];
                }
            }
        }
        System.out.println("paired sum " + pairedSum);
        System.out.println("unpaired sum " + unpairedSum);
    }
    /**Друк чисел*/
    void printNumbers() {
        for(int i = rangeTop - rangeBot - 1; i >= 0; i--) {
            if(array[i] % 2 != 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println(' ');
        for (int i = 0; i < rangeTop - rangeBot; i++) {
            if(array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println(' ');
    }
}
