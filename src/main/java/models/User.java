package models;

public class User {
    private String cardNumber;
    private int pinCode;
    private int money;

    public User(String cardNumber, int pinCode, int money) {
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.money = money;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getPinCode() {
        return pinCode;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return  cardNumber + ' ' + pinCode + ' '+ money +"\r\n";
    }
}
