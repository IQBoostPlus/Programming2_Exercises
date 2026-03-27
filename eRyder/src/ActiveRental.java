
import java.time.LocalDateTime;

public class ActiveRental {
    private String bikeId;
    private String userEmail;
    private LocalDateTime tripStartTime;
    public String getBikeId() {
        return bikeId;
    }
    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public LocalDateTime getTripStartTime() {
        return tripStartTime;
    }
    public void setTripStartTime(LocalDateTime tripStartTime) {
        this.tripStartTime = tripStartTime;
    }
    public ActiveRental(String bikeId, String userEmail, LocalDateTime tripStartTime) {
        this.bikeId = bikeId;
        this.userEmail = userEmail;
        this.tripStartTime = tripStartTime;
    }
    @Override
    public String toString() {
        return "ActiveRental:" + "\n" + 
                "bikeId : " + bikeId + "\n" + 
                "userEmail : " + userEmail + "\n" + 
                "tripStartTime : " + tripStartTime;
    }
}
