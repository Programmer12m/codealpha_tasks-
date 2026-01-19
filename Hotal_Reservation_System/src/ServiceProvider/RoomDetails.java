package ServiceProvider;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomDetails {
    Scanner sc = new Scanner(System.in);
    LocalDateTime localDateTime = LocalDateTime.now();
    private static final String RESERVATION_FILE = "ReservationsFile.txt";



    public void startCustomerPanel() {
        while (true) {
            System.out.println("\n**********************");
            System.out.println("Presenting the Rooms info ");
            System.out.println("1. Standard room details");
            System.out.println("2. Delux room details");
            System.out.println("3. Suite room details");
            System.out.println("4. Make a reservation");
            System.out.println("5. Find a reservation");
            System.out.println("6. Delete a reservation");
            System.out.println("7. Exit");
            System.out.print("Enter Your Choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number (1-7).");
                sc.next(); // Clear invalid input
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> standaredRoomDetail();
                case 2 -> deluxeRoomDetail();
                case 3 -> suiteRoomDetail();
                case 4 -> info();
                case 5 -> infoforSearch();
                case 6 -> infoforDelete();
                case 7 -> {
                    System.out.println("Thanks for Visiting us!!!");

                    return;
                }
                default -> System.out.println("Invalid choice! Please enter a number between 1 and 7.");
            }
        }
    }

    public void standaredRoomDetail() {
        System.out.println("\n**********************");
        System.out.println("Room Type: Standard");
        System.out.println("Couch: " + 2);
        System.out.println("Beds: " + 1);
        System.out.println("Mattress: " + false);
        System.out.println("Facilities: Normal");
        System.out.println("Cost = " + 10000 + " per night");
    }

    public void deluxeRoomDetail() {
        System.out.println("\n**********************");
        System.out.println("Room Type: Deluxe");
        System.out.println("Couch: " + 4);
        System.out.println("Beds: " + 2);
        System.out.println("Mattress: " + true);
        System.out.println("Facilities: All");
        System.out.println("Cost = " + 20000 + " per night");
    }

    public void suiteRoomDetail() {
        System.out.println("\n**********************");
        System.out.println("Room Type: Suite");
        System.out.println("Couch: " + 8);
        System.out.println("Beds: " + 4);
        System.out.println("Mattress: " + true);
        System.out.println("Facilities: Premium");
        System.out.println("Cost = " + 30000 + " per night");
    }

    public void info() {
        System.out.println("\nMaking reservation");
        System.out.print("Enter your Email: ");
        String email = sc.nextLine().trim();

        System.out.print("Enter your Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter Room Type (Standard/Deluxe/Suite): ");
        String type = sc.nextLine().trim();

        makingReservation(email, name, type);
    }

    public void infoforSearch() {
        System.out.println("\nFind existing reservation");
        System.out.print("Enter your Email: ");
        String email = sc.nextLine().trim();
        searchingForReservation(email);
    }

    public void infoforDelete() {
        System.out.println("\nDelete reservation");
        System.out.print("Enter your Email: ");
        String email = sc.nextLine().trim();
        deleteReservation(email);
    }

    public void makingReservation(String email, String name, String type) {
        if (email.isEmpty() || name.isEmpty() || type.isEmpty()) {
            System.out.println("Error: All fields must be filled!");
            return;
        }

        try (FileWriter recordsHolderfile = new FileWriter(RESERVATION_FILE, true)) {
            String reservation = LocalDateTime.now() + " | Email: " + email +
                    " | Name: " + name + " | Room Type: " + type;
            recordsHolderfile.write(reservation + "\n");
            System.out.println("Reservation made successfully!");
            System.out.println("Reservation Details: " + reservation);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot make the reservation. File not found!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public boolean searchingForReservation(String email) {
        boolean found = false;
        File file = new File(RESERVATION_FILE);

        if (!file.exists()) {
            System.out.println("No reservations found. File does not exist.");
            return false;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;

            System.out.println("\nSearching for reservations for: " + email);

            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (line.toLowerCase().contains(email.toLowerCase())) {
                    System.out.println("Reservation found at line " + lineNumber + ":");
                    System.out.println(line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No reservation found for: " + email);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Reservation file not found!");
        } catch (IOException e) {
            System.out.println("Error reading reservation file: " + e.getMessage());
        }

        return found;
    }

    public void deleteReservation(String email) {
        File originalFile = new File(RESERVATION_FILE);
        File tempFile = new File("TempReservationsFile.txt");

        if (!originalFile.exists()) {
            System.out.println("No reservations found to delete.");
            return;
        }

        boolean deleted = false;

        try (BufferedReader br = new BufferedReader(new FileReader(originalFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (!line.toLowerCase().contains(email.toLowerCase())) {
                    bw.write(line);
                    bw.newLine();
                } else {
                    deleted = true;
                    System.out.println("Deleting reservation: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
            return;
        }

        if (deleted) {
            try {
                Files.move(tempFile.toPath(), originalFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Reservation(s) for " + email + " deleted successfully.");
            } catch (IOException e) {
                System.out.println("Error replacing original file: " + e.getMessage());
            }
        } else {
            tempFile.delete(); // Delete temp file if no deletions
            System.out.println("No reservation found for " + email);
        }
    }
}