import java.util.Scanner;
public class StoreCheckout {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sumtotal = 0;
        int totalItems = 0;
        int countMouse = 0;
        int countKeyboard = 0;
        int countHeadphones = 0;
        int countLaptopStand = 0 ;

        while (true) {
            System.out.println("==== Simple store ====");
            System.out.println("1.Mouse - $20");
            System.out.println("2.Keyboard - $40");
            System.out.println("3.Headphones - $50");
            System.out.println("4.Laptop stand - $30");
            System.out.println("5.Checkout");
            System.out.println("Choose a product: ");
            int choice = scanner.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.println("Invalid option. Please enter number from 1 to 5");
                continue;
            }
            if (choice == 5) {
                break;
            }
            int price = 0;
            if (choice == 1) price = 20;
            if (choice == 2) price = 40;
            if (choice == 3) price = 50;
            if (choice == 4) price = 30;
            System.out.println("Enter quantity: ");
            int quantity = scanner.nextInt();
            if (quantity <= 0) {
                System.out.println("Invalid quantity. The number must be greater than 0");
                continue;
            }
            int cost = quantity * price;
            if ( quantity >= 5) {
                int itemDiscount = cost * 5/ 100;
                cost = cost - itemDiscount;
            }
            sumtotal = sumtotal + cost;
            totalItems = totalItems + quantity;
            if ( choice == 1) countMouse = countMouse + quantity;
            if ( choice == 2) countKeyboard = countKeyboard + quantity;
            if ( choice == 3) countHeadphones = countHeadphones + quantity;
            if ( choice == 4) countLaptopStand = countLaptopStand + quantity;
            System.out.println("Added to cart! Current total: $" + sumtotal);
        }
        System.out.println("==== Checkout ====");
        System.out.println("Sumtotal: $" + sumtotal);
        int discount=0;
        if (sumtotal >= 200) {
            discount = sumtotal * 15 / 100;
        } else if (sumtotal >= 100) {
            discount = sumtotal * 10 / 100;
        }
        int finalTotal = sumtotal - discount ;
        System.out.println("Discount: $" + discount);
        System.out.println("Final total: $" + finalTotal);
        int payment = 0;
        while (payment < finalTotal) {
            System.out.println("Enter payment amount: $ ");
            int cash = scanner.nextInt();
            payment = payment + cash;
            if (payment < finalTotal ) {
                int needed = finalTotal - payment;
                System.out.println("Insufficient payment. You still to pay : $" + needed);
            }
        }
        int change = payment - finalTotal;
        System.out.println("Payment successful! Change: $" + change);

        System.out.println("Simple store");
        System.out.println("=================");
        System.out.println("Items purchased: " + totalItems);
        System.out.println("Sumtotal: $ " + sumtotal);
        System.out.println("Discount: $" + discount);
        System.out.println("Final total: $ " + finalTotal);
        System.out.println("Payment: $" + payment);
        System.out.println("Change: $" + change);
        System.out.println("==== ITEM purchased ====");
        System.out.println("Mouse: " + countMouse);
        System.out.println("Keyboard: " + countKeyboard);
        System.out.println("Headphones:" + countHeadphones);
        System.out.println("Laptop Stand: " + countLaptopStand);
        String mostPurchasedProduct = "None";
        int maxQuantity = 0;
        if ( countMouse > maxQuantity) {
            maxQuantity = countMouse;
            mostPurchasedProduct = "Mouse";
        }
        if ( countKeyboard > maxQuantity) {
            maxQuantity = countKeyboard;
            mostPurchasedProduct = "Keyboard";
        }
        if (countHeadphones > maxQuantity) {
            maxQuantity = countHeadphones;
            mostPurchasedProduct = "Headphones";
        }
        if (countLaptopStand> maxQuantity) {
            maxQuantity = countLaptopStand;
            mostPurchasedProduct = "Laptop stand";
        }
        if (maxQuantity>0) {
            System.out.println("Most purchased product:"  + mostPurchasedProduct);
            System.out.println("Quantity:" + maxQuantity);
        }
        if ( totalItems >= 10) {
            System.out.println(" You earned a $10 for your next visit!");

        }
        System.out.println("Thank you for shopping!");
        scanner.close();
    }
}