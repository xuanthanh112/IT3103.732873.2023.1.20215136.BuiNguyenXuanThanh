package hust.soict.dsai.aims.MainEngine;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public abstract class FirstMenu {
    private boolean inLoop = true;
    protected Store store;
    protected Cart cart;
    protected Scanner scanner;
    protected List<String> options;

    protected FirstMenu(Store store, Cart cart, Scanner scanner) {
        this.store = store;
        this.cart = cart;
        this.scanner = scanner;
    }
    protected FirstMenu(FirstMenu menu) {
        this.store = menu.store;
        this.cart = menu.cart;
        this.scanner = menu.scanner;
    }

    protected void exit() { inLoop = false; }

    protected abstract void displayInfo();
    protected abstract void handleChoice(int choice);

    public void display() {
        while (inLoop) {
            displayInfo();
            System.out.println();
            System.out.println("Options:\n---------------------------------");
            for (int i = 0; i < options.size(); ++i)
                System.out.println(i + 1 + ". " + options.get(i));
            System.out.println("0. Back");
            System.out.println("---------------------------------");
            System.out.print("Please choose a number: ");

            int choice = -1;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {}
            scanner.nextLine(); // Consume newline char

            if (choice < 0 || choice > options.size()) {
                System.out.println("\nInvalid choice!");
                scanner.nextLine();
                continue;
            }
            if (choice == 0) {
                inLoop = false;
                continue;
            }
            System.out.println();
            handleChoice(choice);
        }
    }
}
