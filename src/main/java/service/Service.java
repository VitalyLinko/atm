package service;

import database.DataBase;
import menuutil.UserChoiceInput;
import models.Atm;
import models.User;

import java.util.List;

public class Service {
    private static Service SERVICE;

    private Service() {
    }

    public static Service getService() {
        if (SERVICE == null) {
            SERVICE = new Service();
        }
        return SERVICE;
    }

    DataBase dataBase = DataBase.getDataBase();
    Atm atm = Atm.getAtm();

    public List<User> loadList() {
        return dataBase.readFile();
    }

    public void withdrawMoney(User user) {
        System.out.println("Enter the amount to be withdrawn. ");
        int moneyToDraw = UserChoiceInput.getUserChoiceInput();
        if (moneyToDraw <= user.getMoney() & moneyToDraw <= atm.getAtmMoney()) {
            user.setMoney(user.getMoney() - moneyToDraw);
            atm.setAtmMoney(atm.getAtmMoney() - moneyToDraw);
            System.out.println("The money was withdraw.");
        } else {
            System.out.println("You do not have enough money.");
        }
    }

    public void depositMoney(User user) {
        System.out.println("Enter the amount to be deposited (max = 1 000 000): ");
        while (true) {
            int moneyToAdd = UserChoiceInput.getUserChoiceInput();
            if (moneyToAdd <= 1_000_000) {
                user.setMoney(user.getMoney() + moneyToAdd);
                atm.setAtmMoney(atm.getAtmMoney() + moneyToAdd);
                System.out.println("The money was deposited.");
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
    }

    public void saveUsersList() {
        dataBase.saveUsers();
    }

    public void readAtmMoney(){
        atm.readMoney();
    }

    public void saveAtmMoney() {
        atm.saveAtm();
    }


}
