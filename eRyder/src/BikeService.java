import java.time.LocalDateTime;

public class BikeService {
    public String findAvailableBikeAtLocation(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (location.equals(bike.getLocation()) && bike.getIsAvailable()) {
                System.out.println("A bike is available at the location you requested.");
                return bike.getBikeId();
            }
        }
        System.out.println("Sorry, no bikes are available at the location you requested. Please try again later");
        return null;
    }

    public boolean reserveBike(String bikeID) {
        if (bikeID == null) {
            System.out.println("Sorry, we're unable to reserve a bike at this time. Please try again later.");
            return false;
        }

        for (Bike bike : BikeDatabase.bikes) {
            if (bikeID.equals(bike.getBikeId()) && bike.getIsAvailable()) {
                LocalDateTime tripStartTime = LocalDateTime.now();
                bike.setIsAvailable(false);
                bike.setLastUsedTime(tripStartTime);
                System.out.println("Reserving the bike with ID: " + bikeID + ". Please follow the on-screen instructions to locate the bike and start your pleasant journey.");
                return true;
            }
        }
        return false;
    }

    public void releaseBike(String bikeID) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bikeID.equals(bike.getBikeId())) {
                LocalDateTime endTime = LocalDateTime.now();
                bike.setIsAvailable(true);
                bike.setLastUsedTime(endTime);
                System.out.println("Bike " + bikeID + " has been released and is now available.");
                return;
            }
        }
        System.out.println("Bike with ID " + bikeID + " not found.");
    }

    public boolean validateLocation(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (location.equals(bike.getLocation())) {
                return true;
            }
        }
        System.out.println("Location " + location + " is not valid (no bikes serve this location).");
        return false;
    }
}