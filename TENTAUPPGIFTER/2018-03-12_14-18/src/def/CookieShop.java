package def;

import java.util.Scanner;

public class CookieShop {

    public static void main(String[] args) {
        GlassCounter glassCounter = new GlassCounter();
        glassCounter.add(new ChocolateChip(5));
        glassCounter.add(new FrostedCookie(6));
        glassCounter.add(new PlainCookie());
        glassCounter.add(new ChocolateChip(8));

        System.out.println("Welcome to the cookie shop- Great American Cookies!");
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("What cookie would you like (1-" + glassCounter.noOfCookies() + ")");
            int selection = input.nextInt();
            Cookie fresh = glassCounter.bakeNew(selection);
            System.out.println("There you go! Enjoy your freshly baked ");
            fresh.describeYourself(); // t.ex. "Chocolate Chip Cookie of size 8 (with gluten)
                                      // eller "Plain Cookie of size 5, (gluten-free)

            if (Cookie.getCookiesBaked() % 10 == 0) {
                System.out.println("Please come again, most valued customer!");
            }

        } while (true);
    }
}
