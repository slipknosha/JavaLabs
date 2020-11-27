package customer;

public class Customer {

    private int ID;
    private String lastName;
    private String firstName;
    private String secondName;
    private String adress;
    private long creditCardNumber;
    private long creditCardBalance;

    public Customer() {}

    public Customer(int ID, String lastName, String firstName, String secondName, String adress, long creditCardNumber, long creditCardBalance) {
        this.ID = ID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.adress = adress;
        this.creditCardNumber = creditCardNumber;
        this.creditCardBalance = creditCardBalance;
    }


    @Override
    public String toString() {
        return "Customer information: [" +
                "ID=" + ID +
                ", Last Name: '" + lastName + '\'' +
                ", First Name: '" + firstName + '\'' +
                ", Second Name: '" + secondName + '\'' +
                ", Address: '" + adress + '\'' +
                ", Credit Card Number: " + creditCardNumber +
                ']';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) { this.adress = adress; }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public long getCreditCardBalance() {
        return creditCardBalance;
    }

    public void setCreditCardBalance(long creditCardBalance) {
        this.creditCardBalance = creditCardBalance;
    }


}
