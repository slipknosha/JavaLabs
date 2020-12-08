package menu;
import battle.Battle;
import droid.Droid;
import defaultdroid.DefaultDroid;
import megadroid.MegaDroid;
import ultradroid.UltraDroid;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner in = new Scanner(System.in);
    Battle battle;
    private ArrayList<Droid> droids;
    int amountDroids = 0;
    byte menu;

    public Menu(ArrayList<Droid> droids) {
        this.droids = droids;
        battle = new Battle();
    }

    public void switching(ArrayList<Droid> droids) {
        System.out.printf("Hello, this is game you cant play, because its fucking random battle\r\n");
        while(true) {
            System.out.printf("\r\nMenu:\r\n0.Create Droid\r\n1.Droids list\r\n2.Battle one versus one\r\n3.Battle team versus team\r\n4.Exit\r\n");
            menu = in.nextByte();
            switch(menu) {
                case 0:
                    createDroid(droids);
                    amountDroids++;
                    battle.setAmountDroids(amountDroids);
                    break;
                case 1:
                    droidsList(droids);
                    break;
                case 2:
                    if(droids.size() > 1) {
                        byte selectFirstDroid;
                        byte selectSecondDroid;
                        System.out.printf("Select the first droid for battle:\r\n");
                        droidsList(droids);
                        selectFirstDroid = in.nextByte();
                        System.out.printf("Select the second droid for battle:\r\n");
                        droidsList(droids);
                        selectSecondDroid = in.nextByte();
                        battle.oneVersusOne(droids.get(selectFirstDroid), droids.get(selectSecondDroid));
                        break;
                    } else {
                        System.out.printf("Add one more droid\r\n");
                        break;
                    }
                case 3:
                    if(droids.size() % 2 == 0) {
                        battle.teamVersusTeam(droids);
                        break;
                    } else {
                        System.out.printf("Add one more droid\r\n");
                        break;
                    }
                case 4:
                    return;
            }

        }
    }

    public void createDroid(ArrayList<Droid> droids) {
        byte type;
        System.out.printf("What kind of droid do you want to crate\r\n0.Default droid\r\n1.Mega droid\r\n2.Ultra droid\r\n");
        type = in.nextByte();
        switch(type) {
            case 0:
                DefaultDroid defaultDroid = new DefaultDroid();
                System.out.printf("Enter the name of droid: ");
                in.nextLine();
                defaultDroid.setName(in.nextLine());
                System.out.printf("Enter the health of the droid: ");
                defaultDroid.setHealth(in.nextInt());
                in.nextLine();
                System.out.printf("Maximum damage of the default droid %d\r\n", defaultDroid.getDefaultWeapon());
                defaultDroid.setDamage(defaultDroid.getDefaultWeapon());
                defaultDroid.setDroidType("default");
                droids.add(defaultDroid);
                break;
            case 1:
                MegaDroid megaDroid = new MegaDroid();
                System.out.printf("Enter the name of droid: ");
                in.nextLine();
                megaDroid.setName(in.nextLine());
                System.out.printf("Enter the health of the droid: ");
                megaDroid.setHealth(in.nextInt());
                in.nextLine();
                System.out.printf("Maximum damage of the default droid %d\r\n", megaDroid.getMegaWeapon());
                megaDroid.setDamage(megaDroid.getMegaWeapon());
                megaDroid.setDroidType("mega");
                droids.add(megaDroid);
                break;
            case 2:
                UltraDroid ultraDroid = new UltraDroid();
                System.out.printf("Enter the name of droid: ");
                in.nextLine();
                ultraDroid.setName(in.nextLine());
                System.out.printf("Enter the health of the droid: ");
                ultraDroid.setHealth(in.nextInt());
                in.nextLine();
                System.out.printf("Maximum damage of the default droid %d\r\n",ultraDroid.getUltraWeapon());
                ultraDroid.setDamage(ultraDroid.getUltraWeapon());
                ultraDroid.setDroidType("mega");
                droids.add(ultraDroid);
                break;
        }
    }

    public void droidsList(ArrayList<Droid> droids) {
        for(int droid = 0; droid < amountDroids; droid++) {
            System.out.printf("%d.Droid %s, type: %s, has %d HP, has %d max damage and has %s weapon\r\n",
                    droid,
                    droids.get(droid).getName(),
                    droids.get(droid).getDroidType(),
                    droids.get(droid).getHealth(),
                    droids.get(droid).getDamage(),
                    droids.get(droid).getDroidType());
        }
    }

}
