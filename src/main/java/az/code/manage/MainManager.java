package az.code.manage;

import java.util.Scanner;

import static az.code.manage.ProductManager.printProductOpMenu;
import static az.code.manage.SaleManager.printSaleOpMenu;


public class MainManager {
    public static void manageMarket() {
        Scanner scanner = new Scanner(System.in);

        printMainMenu();

        int command = scanner.nextInt();
        while (command != 3) {
            switch (command) {
                case 1 -> printProductOpMenu();
                case 2 -> printSaleOpMenu();
            }
        }
        System.out.println("Bye");
    }

    public static void printMainMenu() {
        System.out.println("1 - Product operations");
        System.out.println("2 - Sale operations");
        System.out.println("3 - exit");
    }
}
