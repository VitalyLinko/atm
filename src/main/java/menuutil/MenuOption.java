package menuutil;

import java.util.Arrays;
import java.util.Optional;

public enum MenuOption {
    DEFAULT(0, "Default"),
    CHECKING_BALANCE(1, "Checking the balance"),
    WITHDRAW_CASH(2, "Withdraw cash"),
    DEPOSIT(3, "Deposit"),
    STOP(4, "Stop");

    private int value;
    private String menuOptionName;

    MenuOption(int value, String menuOptionName) {
        this.value = value;
        this.menuOptionName = menuOptionName;
    }

    public static MenuOption convert(int neededValue) {
        Optional<MenuOption> option = Arrays.stream(values())
                .filter(menuOption -> menuOption.value == neededValue)
                .findFirst();
        return option.orElse(MenuOption.CHECKING_BALANCE);
    }

    @Override
    public String toString() {
        return value + " - " + menuOptionName;
    }
}
