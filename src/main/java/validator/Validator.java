package validator;

import menuutil.UserChoiceInput;
import models.User;

import java.util.List;
import java.util.Scanner;

public class Validator {

    Scanner scanner = new Scanner(System.in);

    private static Validator SERVICE;

    private Validator() {
    }

    public static Validator getValidator() {
        if (SERVICE == null) {
            SERVICE = new Validator();
        }
        return SERVICE;
    }

    public User loginUser(List<User> users) {
        System.out.print("Enter card number in format XXXX-XXXX-XXXX-XXXX: ");
        String cardNumber;
        while (true) {
            cardNumber = scanner.nextLine();
            for (User user : users) {
                if (cardNumber.equals(user.getCardNumber())) {
                    System.out.print("Enter pin-code. ");
                    while (true) {
                        int pin = UserChoiceInput.getUserChoiceInput();
                        if (user.getPinCode() == pin) {
                            return user;
                        } else {
                            System.out.print("Wrong pin-code. Try again.");
                        }
                    }
                }
            }
            System.out.print("Wrong card number. Try again: ");
        }
    }
}
