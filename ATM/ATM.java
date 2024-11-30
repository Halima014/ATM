package javaATM;

import java.io.IOException;

public class ATM {
    public static void main(String[] args) {
        try {
            OptionMenu optionMenu = new OptionMenu();
            optionMenu.getLogin(); // Call the login method
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}