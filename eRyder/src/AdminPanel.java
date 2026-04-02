
import java.util.Scanner;

public class AdminPanel {
    Scanner input = new Scanner(System.in);
    BikeService bikeService = new BikeService();
    RentalService rentalService = new RentalService();
    UserService userService = new UserService();
    public void userManagementOptions() {
        while (true) {
            System.out.println("Welcome to E-Ryder Admininstrator Panel.");
            System.out.println("Here are your options:");
            System.out.println("What do you want to do?");
            System.out.println("1. Add New Users");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. Demo the Bike Rental System");
            System.out.println("6. View System Logs");
            System.out.println("7. Manage Pending Bike Requests");
            System.out.println("8. EXIT");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> userService.addNewUsers();
                case 2 -> userService.viewRegisteredUsers();
                case 3 -> userService.removeRegisteredUsers();
                case 4 -> userService.updateRegisteredUsers();
                case 5 -> simulateRental();
                case 6 -> bikeService.getLogsStack().forEach(log -> log.viewSystemLogs());
                case 7 -> {
                    System.out.println("1. View Queue");
                    System.out.println("2. Update Queue");
                    System.out.println("3. Exit");
                    int queueChoice;
                    queueChoice = input.nextInt();
                    switch(queueChoice){
                        case 1 -> bikeService.getBikeRequest().forEach(request -> System.out.println(request));
                        case 2 -> bikeService.getBikeRequest().remove();
                        case 3 -> System.out.println("Exiting pending bike requests management...");
                        default -> System.out.println("Invalid choice. Please try again");
                    }
                }
                case 8 -> System.exit(0);
                default -> System.out.println("Invalid choice. Please try again");
            }
        }
    }
    private void simulateRental(){
        System.out.println("Simulating a bike rental...");
        System.out.println("Enter the location to find an available bike:");
        String location = input.nextLine();
        String bikeID = bikeService.findAvailableBikeAtLocation(location);
        if (bikeID != null) {
            System.out.println("Enter your email address to start the rental:");
            String emailAddress = input.nextLine();
            rentalService.startRental(bikeID, emailAddress);
            System.out.println("Rental started successfully!");
            System.out.println("Now ending the rental...");
            rentalService.endRental(bikeID);
            System.out.println("Rental ended successfully!");
        } else {
            System.out.println("No bikes available at the specified location. Please try again later.");
        }
    }
}
