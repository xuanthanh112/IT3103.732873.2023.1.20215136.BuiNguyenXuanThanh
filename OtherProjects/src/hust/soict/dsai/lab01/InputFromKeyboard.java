package hust.soict.dsai.lab01;

import java.util.Locale;
import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("What's your name? ");
        String strName = keyboard.nextLine();
        System.out.println("How old are you? ");
        int iAge = keyboard.nextInt();
        System.out.println("How tall are you (m)? ");
        double dHeight = keyboard.nextDouble();

        System.out.println("Mr/Ms. " + strName + ", " + iAge + " years old. " + "Your height is " + dHeight + ".");
    }
}
