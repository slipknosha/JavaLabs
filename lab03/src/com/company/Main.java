package com.company;
import droid.Droid;
import menu.Menu;
import java.util.ArrayList;


public class Main {

    static private final ArrayList<Droid> droids = new ArrayList<>();

    public static void main(String[] args) {
        Menu menu = new Menu(droids);
        menu.switching(droids);

    }
}
