package generics;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Scanner;

public class orderprocessor1 {
    public static void main(String args[]) {
        int choice;
        Scanner in = new Scanner(System.in);
        System.out.println("Option 1 for Process an order");
        System.out.println("Option 2 for View all orders");
        System.out.println("Option 3 for Exit");
        System.out.println("Enter your choice:");
        choice = in.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter your item details:");
                Scanner ItemName = new Scanner(System.in);
                System.out.println("OrderId: 1");
                System.out.println("CustomerName:");
                String CustomerName = ItemName.nextLine();
                System.out.println("ItemList:");
                String Item1 = ItemName.nextLine();
                String Item2 = ItemName.nextLine();
                String Item3 = ItemName.nextLine();
                String Item4 = ItemName.nextLine();
                String Item5 = ItemName.nextLine();
                for (;;) {
                    System.out.println("Do u want to enter another item?");
                    String Item6 = ItemName.nextLine();
                    if (Item6.equals("Yes")) {
                        System.out.println("Enter the Item");
                        String Item7 = ItemName.nextLine();
                    } else if (Item6.equals("No")) {
                        System.out.println("Ok..");
                        break;
                    }
                }
            case 2:
            System.out.println("View all Orders");
            
        }
    }
}