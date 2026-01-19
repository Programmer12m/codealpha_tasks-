package ServiceProvider;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Admin {

    private static final String RESERVATION_FILE =
            "D:\\Java Project\\Testing projects\\Hotal_Reservation_System\\ReservationsFile.txt";

    Scanner sc = new Scanner(System.in);
    RoomDetails roomDetails = new RoomDetails();

    public void startAdminPanel() {
        while (true) {
            System.out.println("\n===== ADMIN PANEL =====");
            System.out.println("1. View All Reservations");
            System.out.println("2. Search Reservation");
            System.out.println("3. Delete Reservation");
            System.out.println("4. Exit Admin Panel");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> viewAllReservations();
                case 2 -> searchReservation();
                case 3 -> deleteReservation();
                case 4 -> {
                    System.out.println("Exiting Admin Panel...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void viewAllReservations() {
        System.out.println("\n---- ALL RESERVATIONS ----");
        try (BufferedReader br = new BufferedReader(new FileReader(RESERVATION_FILE))) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                count++;
                System.out.println(count + ". " + line);
            }

            if (count == 0) {
                System.out.println("No reservations found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading reservation file: " + e.getMessage());
        }
    }

    private void searchReservation() {
        System.out.print("Enter Email / Name / Keyword to search: ");
        String keyword = sc.nextLine();
        roomDetails.searchingForReservation(keyword);
    }

    private void deleteReservation() {
        System.out.print("Enter Email / Name / Keyword to delete: ");
        String keyword = sc.nextLine();
        roomDetails.deleteReservation(keyword);
    }
}
