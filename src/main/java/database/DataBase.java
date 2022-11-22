package database;

import models.User;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static DataBase DATABASE;

    private DataBase() {
    }

    public static DataBase getDataBase() {
        if (DATABASE == null) {
            DATABASE = new DataBase();
        }
        return DATABASE;
    }

    private List<User> usersList;

    public List<User> readFile() {
        usersList = new ArrayList<>();

        try {
            List<String> list = Files.readAllLines(Paths.get("users.txt"));
            for (String line : list) {
                String[] tokens = line.split("\s+");
                if (tokens.length != 3) {
                    continue;
                }
                String number = tokens[0];
                int pin = Integer.parseInt(tokens[1]);
                int money = Integer.parseInt(tokens[2]);
                User user = new User(number, pin, money);
                usersList.add(user);
            }
            System.out.println(usersList);
            return usersList;
        } catch (NumberFormatException e) {
            System.out.println("Check the data.");
        } catch (IOException e) {
            System.out.println("File not found.");
        }
        System.out.println("No data.");
        return new ArrayList<>();
    }

    public void saveUsers() {
        try (FileWriter fileWriterUsers = new FileWriter("users.txt")) {
            for (User users : usersList) {
                fileWriterUsers.write(users.toString());
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
