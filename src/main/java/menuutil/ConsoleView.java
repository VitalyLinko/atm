package menuutil;

import models.User;
import service.Service;
import validator.Validator;

public class ConsoleView {

    public static void showConsoleView() {
        boolean continueProgram = true;

        Service service = Service.getService();
        service.readAtmMoney();
        User user = Validator.getValidator().loginUser(service.loadList());

        while (continueProgram) {
            Menu.printMenu();
            MenuOption userChoice = Menu.retrieveUserChoice();
            switch (userChoice) {
                case CHECKING_BALANCE:
                    System.out.println("Your balance is: " + user.getMoney());
                    break;
                case WITHDRAW_CASH:
                    service.withdrawMoney(user);
                    break;
                case DEPOSIT:
                    service.depositMoney(user);
                    break;
                case STOP:
                    service.saveAtmMoney();
                    service.saveUsersList();
                    continueProgram = false;
                    break;
                case DEFAULT:
                    System.out.println("No such option");
            }
        }
    }
}
