package com.company;
import battle.Battle;
import droid.Droid;
import java.util.ArrayList;


public class Main {

    static private final ArrayList<Droid> droids = new ArrayList<>();

    public static void main(String[] args) {
	    Battle battle = new Battle(droids, 2);


	    battle.oneVersusOne(droids.get(0), droids.get(1));

    }
}
