import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;

public class RentalService {
    private final double BASE_FARE = 3.0;
    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    private BikeService bikeService;
    public void startRental(String bikeID, String emailAddress, RegisteredUsers user) {
        boolean bikeReserved = bikeService.reserveBike(bikeID, emailAddress);
        if (bikeReserved) {
            LocalDateTime tripStartTime = LocalDateTime.now();
            ActiveRental activeRental = new ActiveRental(bikeID, emailAddress, tripStartTime);
            activeRentalsList.add(activeRental);
            System.out.println("Rental started for bike " + bikeID + " (user: " + emailAddress + ")");
        } else {
            System.out.println("Failed to start rental: Bike could not be reserved.");
        }
    }

    public void endRental(String bikeID, RegisteredUsers user) {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        boolean rentalFound = false;
        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (bikeID.equals(rental.getBikeId())) {
                iterator.remove();
                rentalFound = true;
                break;
            }
        }
        if (rentalFound) {
            bikeService.releaseBike(bikeID);
            double finalFare = user.calculateFare(BASE_FARE);
            System.out.println("Your trip has ended. Fare: €" + finalFare);
            System.out.println("Thank you for riding with us.");
        } else {
            System.out.println("No active rental found for bike " + bikeID);
        }
    }

    public void cancelRental(String bikeID) {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (bikeID.equals(rental.getBikeId())) {
                iterator.remove();
                bikeService.releaseBike(bikeID);
                System.out.println("Rental for bike " + bikeID + " has been cancelled.");
                return;
            }
        }
        System.out.println("No active rental found to cancel for bike " + bikeID);
    }

    public void viewActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals at the moment.");
        } else {
            System.out.println("Active Rentals: " + activeRentalsList);
        }
    }
}