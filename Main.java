import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String proceed;
        int[] sales = new int[10]; // Array to store sales amounts for each guest
        int guestCount = 0; // Track the number of guests

        do {
            System.out.println("---Guest Details---");
            System.out.print("Name: ");
            String guestName = input.nextLine();
            System.out.print("IC Number (xxxxxx-xx-xxxx): ");
            String id = input.nextLine();

            System.out.println("\nWelcome To Sport Management System");
            System.out.println("A. Sport Facilities\nB. Sport Equipment");
            System.out.print("Choice: ");

            String bookingType;
            while (true) {
                bookingType = input.nextLine();
                if (bookingType.equalsIgnoreCase("A") || bookingType.equalsIgnoreCase("B")) {
                    break;
                } else {
                    System.out.println("Invalid booking type! Please try again.\n");
                    System.out.println("A. Sport Facilities\nB. Sport Equipment");
                    System.out.print("Choice: ");
                }
            }

            if (bookingType.equalsIgnoreCase("A")) {
                System.out.println("\n---Sport Facilities [RM20 per hour]---\n1. Futsal Court" +
                        "\n2. Badminton Court\n3. Tennis Court");
                System.out.print("\nEnter your wanted facility: ");
                String facilityName = input.nextLine();
                System.out.print("Enter date: ");
                String date = input.nextLine();
                System.out.print("Enter use duration [minimum 1 hour]: ");
                int durationF = Integer.parseInt(input.nextLine());
                System.out.print("Enter time: ");
                String facilityTime = input.nextLine();

                SportFacilities sportFacilities = new SportFacilities(facilityName, date, durationF, facilityTime);
                sportFacilities.bookFacility(guestName, id);

            } else if (bookingType.equalsIgnoreCase("B")) {
                System.out.println("\n---Sport Equipment---\n1. Futsal's Shoes" +
                        "\n2. Badminton's Racket\n3. Tennis' Balls");
                System.out.print("Enter your wanted equipment: ");
                String equipmentName = input.nextLine();
                System.out.println("Price for borrowed item: RM6 per hour");
                System.out.print("Enter borrowed duration [minimum 1 hour]: ");
                int durationE = Integer.parseInt(input.nextLine());
                System.out.print("Enter amount: ");
                int amount = Integer.parseInt(input.nextLine());

                SportEquipment sportEquipment = new SportEquipment(equipmentName, durationE, amount);
                sportEquipment.bookEquipment(guestName, id);

                int totPrice = sportEquipment.calcAmount();
                System.out.println("Total Price: " + totPrice);

                // Store the sales amount for the current guest
                sales[guestCount] = totPrice;
                guestCount++;
            }

            System.out.println("\nDo you want to book anything else?");
            System.out.println("Enter [Y] to continue: \nEnter [N] to stop");
            proceed = input.nextLine();

        } while (proceed.equalsIgnoreCase("Y"));

        input.close();

        // Calculate the total sales for all guests
        int totalSales = calculateTotalSales(sales, guestCount);
        System.out.println("Total Sales: " + totalSales);
    }
    public static int calculateTotalSales(int[] sales, int guestCount) {
        int total = 0;
        for (int i = 0; i < guestCount; i++) {
            total += sales[i];
        }
        return total;
    }
}