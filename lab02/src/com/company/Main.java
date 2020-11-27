package com.company;
import customer.Customer;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static private final ArrayList<Customer> customers = new ArrayList<>();
    static int amountCustomers;
    static final byte SEARCH_BY_FIRST_NAME = 0;
    static final byte SEARCH_BY_FULL_NAME = 1;

    static public void SetCustomerList() {
        System.out.printf("Enter amount of the customers:\r\n");
        amountCustomers = in.nextInt();
        in.nextLine();
        for(int i = 0; i < amountCustomers; i++) {
            Customer people = new Customer();
            System.out.printf("Enter first name of the %d customer:\r\n", i + 1);
            people.setFirstName(in.nextLine());
            System.out.printf("Enter second name of the %d customer:\r\n", i + 1);
            people.setSecondName(in.nextLine());
            System.out.printf("Enter last name of the %d customer:\r\n", i + 1);
            people.setLastName(in.nextLine());
            System.out.printf("Enter ID of the %d customer:\r\n", i + 1);
            people.setID(in.nextInt());
            in.nextLine();
            System.out.printf("Enter address of the %d customer:\r\n", i + 1);
            people.setAdress(in.nextLine());
            System.out.printf("Enter credit card number of the %d customer:\r\n", i + 1);
            people.setCreditCardNumber(in.nextLong());
            in.nextLine();
            System.out.printf("Enter credit card balance of the %d customer:\r\n", i + 1);
            people.setCreditCardBalance(in.nextLong());
            in.nextLine();
            customers.add(people);
        }
    }

    static public void FindCustomerByName(String firstName, String secondName, String lastName, byte mode) {  /*if mode*/
        if(mode == SEARCH_BY_FIRST_NAME) {
            System.out.printf("I found by your request: %s\r\n", firstName);
        } else if (mode == SEARCH_BY_FULL_NAME) {
            System.out.printf("I found by your request: %s %s %s\r\n", firstName, secondName, lastName);
        } else {
            System.out.println("No results...");
            return;
        }
        System.out.printf("That we found by ");
        for (int i = 0; i < amountCustomers; i++) {
            if(mode == SEARCH_BY_FIRST_NAME && firstName.equals(customers.get(i).getFirstName())) {
                System.out.printf("%s\r\n", customers.get(i).toString());
            } else if(mode == SEARCH_BY_FULL_NAME && firstName.equals(customers.get(i).getFirstName()) && secondName.equals(customers.get(i).getSecondName()) && lastName.equals(customers.get(i).getLastName())) {
                System.out.printf("%s\r\n", customers.get(i).toString());
            }
        }
    }

    static public void FindCustomerByCreditCardRange(long minValue, long maxValue) {
        System.out.printf("I found by your request: in range %d...%d\r\n", minValue, maxValue);
        byte entry = 0;
        for (int i = 0; i < amountCustomers; i++) {
            if(customers.get(i).getCreditCardNumber() >= minValue && customers.get(i).getCreditCardNumber() <= maxValue) {
                System.out.printf("%s\r\n", customers.get(i).toString());
                entry++;
            }
        }
        if (entry == 0) {
            System.out.println("No results...");
        }
    }

    static  public void FindCustomerByCreditDebt() {
        System.out.printf("I found by your request: find the debtors");
        int amountOfDebtors = 0;
        for (int i = 0; i < amountCustomers; i++) {
            if(customers.get(i).getCreditCardBalance() < 0) {
                amountOfDebtors++;
                System.out.printf("%s\r\n", customers.get(i).toString());
            }
        }
        if(amountOfDebtors != 0) {
            System.out.printf("Amount of debtors: %d\r\n", amountOfDebtors);
        } else {
            System.out.println("No results...");
        }

    }

    public static void main(String[] args) {
        String firstName, secondName, lastName;
        long minValue, maxValue;
        while (true) {
            System.out.printf("Invoking the SetCustomerList method...\r\n");
            SetCustomerList();
            System.out.printf("Invoking the FindCustomerByName method...\r\n");
            System.out.printf("What searching do you like more\r\n1.Searching just by FIRST NAME\r\n2.Searching by FULL NAME\r\nType 1 or 2....\r\nType 0 to terminate the program...\r\n");
            byte howToSearch = in.nextByte();
            in.nextLine();
            if (howToSearch == 0) {
                break;
            } else if(howToSearch == 1) {
                System.out.printf("Enter the first name you want to search in my Database:\r\n");
                firstName = in.nextLine();
                FindCustomerByName(firstName, null, null, SEARCH_BY_FIRST_NAME);
            } else if (howToSearch == 2) {
                System.out.printf("Enter the full name you want to search in my Database:\r\n");
                System.out.printf("First name:\r\n");
                firstName = in.nextLine();
                System.out.printf("Second name:\r\n");
                secondName = in.nextLine();
                System.out.printf("Last name:\r\n");
                lastName = in.nextLine();
                FindCustomerByName(firstName, secondName, lastName, SEARCH_BY_FULL_NAME);
            } else {
                System.out.printf("Program terminated, you are idiot.");
            }
            System.out.printf("Invoking the FindCustomerByCreditCardRange method...\r\n");
            System.out.printf("Enter min/max value of range:\r\n");
            System.out.printf("Min:\r\n");
            minValue = in.nextLong();
            in.nextLine();
            System.out.printf("Max:\r\n");
            maxValue = in.nextLong();
            in.nextLine();
            FindCustomerByCreditCardRange(minValue, maxValue);
            System.out.printf("Invoking the FindCustomerByCreditDebt method...\r\n");
            FindCustomerByCreditDebt();
        }
    }
}
