package models;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Atm {

    private long atmMoney;
    private static Atm ATM;

    private Atm() {
    }

    public static Atm getAtm() {
        if (ATM == null) {
            ATM = new Atm();
        }
        return ATM;
    }

    public long getAtmMoney() {
        return atmMoney;
    }

    public void setAtmMoney(long atmMoney) {
        this.atmMoney = atmMoney;
    }

    public void readMoney() {
        try {
            long money = Long.parseLong(Files.readString(Paths.get("atm.txt")));
            Atm.getAtm().setAtmMoney(money);
            System.out.println("ATM balance: " + Atm.getAtm().getAtmMoney());
        } catch (IOException e) {
            System.out.println("Wrong data.");
        }
    }

    public void saveAtm() {
        try (FileWriter fileWriterAtm = new FileWriter("atm.txt")) {
            fileWriterAtm.write(Long.toString(ATM.getAtmMoney()));
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
