import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BikeService {
    Stack<ERyderLogs> logsStack = new Stack<>();
    Queue<BikeRequest> bikeRequest = new ArrayDeque<>();
    public Stack<ERyderLogs> getLogsStack() {
        return logsStack;
    }
    public Queue<BikeRequest> getBikeRequest() {
        return bikeRequest;
    }
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

    public boolean reserveBike(String bikeID, String userEmail) {
        if (bikeID == null) {
            System.out.println("Sorry, we're unable to reserve a bike at this time. Please try again later.");
            return false;
        }
        for (Bike bike : BikeDatabase.bikes) {
            if (bikeID.equals(bike.getBikeId()) && bike.getIsAvailable()) {
                LocalDateTime tripStartTime = LocalDateTime.now();
                bike.setIsAvailable(false);
                bike.setLastUsedTime(tripStartTime);
                logsStack.push(new ERyderLogs(bikeID+" - Bike with "+bikeID+" was rented by "+userEmail+" from "+bike.getLocation()+" at "+tripStartTime, "Bike Reserved", tripStartTime));
                logsStack.peek().viewSystemLogs();
                return true;
            }
            else{
                bikeRequest.add(new BikeRequest(userEmail, bike.getLocation(), LocalDateTime.now()));
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