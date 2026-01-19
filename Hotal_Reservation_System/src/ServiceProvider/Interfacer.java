package ServiceProvider;

import java.util.Scanner;

public class Interfacer {
    public static void interfaceInstallation(){
        Scanner scanner= new Scanner(System.in);
        while (true){
            System.out.println("\n**********************");
            System.out.println("1.Admin ");
            System.out.println("2.Customer ");
            System.out.println("3.Exit ");
            System.out.println("Enter your choise");
            int choise=scanner.nextInt();
            switch (choise){
                case 1->{
                    Admin admin= new Admin();
                    admin.startAdminPanel();
                }
                case 2->{
                   RoomDetails roomDetails=new RoomDetails();
                   roomDetails.startCustomerPanel();
                }case 3 -> {
                    System.out.println("Thanks for Visiting us!!!");
                    scanner.close(); // Close scanner
                    return;
                }
                default -> System.out.println("Invalid choice! Please enter a number between 1 and 7.");
            }
        }

    }
}
