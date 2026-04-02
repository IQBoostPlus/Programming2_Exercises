
import java.time.LocalDateTime;

public class BikeRequest {
    String userEmail;
    String location;
    LocalDateTime requestTime;
    public BikeRequest(String userEmail, String location, LocalDateTime requestTime) {
        this.userEmail = userEmail;
        this.location = location;
        this.requestTime = requestTime;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public LocalDateTime getRequestTime() {
        return requestTime;
    }
    public void setRequestTime(LocalDateTime requestTime) {
        this.requestTime = requestTime;
    }
    @Override
    public String toString() {
        return "BikeRequest:" + "\n" + 
                "userEmail : " + userEmail + "\n" + 
                "location : " + location + "\n" + 
                "requestTime : " + requestTime;
    }
}
