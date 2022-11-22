package menuutil;

public class Menu {

    public static void printMenu() {
        MenuOption[] menuOptions = MenuOption.values();
        for (MenuOption option : menuOptions) {
            if (option.equals(MenuOption.valueOf("DEFAULT"))) {
                continue;
            }
            System.out.println(option);
        }
    }

    public static MenuOption retrieveUserChoice() {
        return MenuOption.convert(UserChoiceInput.getUserChoiceInput());
    }

}
