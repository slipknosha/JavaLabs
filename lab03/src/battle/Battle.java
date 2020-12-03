package battle;
import droid.Droid;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Battle {

    Random random = new Random();
    Scanner in = new Scanner(System.in);
    private int amountDroids;

    public Battle(ArrayList<Droid> droids, int amountDroids) {
        //System.out.print("Enter amount of droids: ");
        //amountDroids = in.nextInt();
        this.amountDroids = amountDroids;
        //in.nextLine();
        for(int counter = 0; counter < this.amountDroids; counter++) {
            Droid droid = new Droid();
            System.out.printf("Enter the name of droid %d: ", counter);
            droid.setName(in.nextLine());
            System.out.printf("Enter the health of the droid %d: ", counter);
            droid.setHealth(in.nextInt());
            in.nextLine();
            System.out.printf("Enter the damage of the droid %d: ", counter);
            droid.setDamage(in.nextInt());
            in.nextLine();
            droids.add(droid);
        }
    }

    public void oneVersusOne(Droid firstDroid, Droid secondDroid) {
        boolean firstMove = random.nextBoolean();
        System.out.printf("\r\nIn battle take part 2 droids:\r\n%s have %d HP and %d max damage\r\n%s have %d HP and %d max damage\r\n\r\n",
        firstDroid.getName(), firstDroid.getHealth(), firstDroid.getDamage(), secondDroid.getName(), secondDroid.getHealth(), secondDroid.getDamage());
        for(int move = 0; ; move++, firstMove = !firstMove) {
            if(firstDroid.getHealth() <= 0) {
                System.out.printf("%s won\r\n", secondDroid.getName());
                break;
            } else if (secondDroid.getHealth() <= 0) {
                System.out.printf("%s won\r\n", firstDroid.getName());
                break;
            }
            if (firstMove == true) {
                firstDroid.toDamage(secondDroid);
                System.out.printf("%s droid attacked %s droid\r\n" +
                        "%s have %d HP and %s have %d HP\r\n\r\n",firstDroid.getName(), secondDroid.getName(),  firstDroid.getName(), firstDroid.getHealth(), secondDroid.getName(), secondDroid.getHealth());
            } else {
                secondDroid.toDamage(firstDroid);
                System.out.printf("%s droid attacked %s droid\r\n" +
                        "%s have %d HP and %s have %d HP\r\n\r\n",secondDroid.getName(), firstDroid.getName(), firstDroid.getName(), firstDroid.getHealth(), secondDroid.getName(), secondDroid.getHealth());
            }
        }
    }

    public void teamVersusTeam(ArrayList<Droid> droids) {

        final ArrayList<Droid> firstTeam = new ArrayList<>();
        final ArrayList<Droid> secondTeam = new ArrayList<>();
        boolean firstMove = random.nextBoolean();
        boolean breakLoop = false;
        int memberFromFirstTeam = 0;
        int memberFromSecondTeam = 0;
        int deathFromFirstTeam = 0;
        int deathFromSecondTeam = 0;
        boolean firstEntryLoop1 = true;
        boolean firstEntryLoop2 = true;

        System.out.printf("In battle take part 2 teams\r\n" +
                "In the first team will play\r\n");
        for(int member = 0; member < amountDroids/2; member++) {
            firstTeam.add(droids.get(member));
            System.out.printf("Droid %s he has %d HP and %d max damage\r\n", firstTeam.get(member).getName(),
                    firstTeam.get(member).getHealth(), firstTeam.get(member).getDamage());
        }

        System.out.printf("In the second team will play\r\n");
        for(int member = 4; member < amountDroids; member++) {
            secondTeam.add(droids.get(member));
            System.out.printf("Droid %s he has %d HP and %d max damage\r\n", secondTeam.get(member).getName(),
                    secondTeam.get(member).getHealth(), secondTeam.get(member).getDamage());
        }



        for(int move = 0; ; move++, firstMove = !firstMove) {
            for(int member = 0; member < amountDroids/2 - deathFromFirstTeam; member++) {
                if(deathFromFirstTeam == amountDroids/2) {
                    breakLoop = true;
                    break;
                }
                if(firstTeam.get(member).getHealth() <=0 ) {
                    deathFromFirstTeam++;
                    firstTeam.remove(member);
                    break;
                }
            }
            if(breakLoop == true) {
                breakLoop = false;
                break;
            }

            for(int member = 0; member < amountDroids/2 - deathFromFirstTeam; member++) {
                if(deathFromSecondTeam == amountDroids/2) {
                    breakLoop = true;
                    break;
                }
                if(secondTeam.get(member).getHealth() <=0 ) {
                    deathFromSecondTeam++;
                    secondTeam.remove(member);
                    break;
                }
            }
            if(breakLoop == true) {
                breakLoop = false;
                break;
            }

            if(firstMove == true) {
                memberFromFirstTeam = random.nextInt(amountDroids/2 - deathFromFirstTeam);
                memberFromSecondTeam = random.nextInt(amountDroids/2 - deathFromSecondTeam);
                firstTeam.get(memberFromFirstTeam).toDamage(secondTeam.get(memberFromSecondTeam));
            } else {
                memberFromFirstTeam = random.nextInt(amountDroids/2 - deathFromFirstTeam);
                memberFromSecondTeam = random.nextInt(amountDroids/2 - deathFromSecondTeam);
                secondTeam.get(memberFromSecondTeam).toDamage(firstTeam.get(memberFromFirstTeam));
            }
        }

    }



}
