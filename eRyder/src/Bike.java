
import java.time.LocalDateTime;

public class Bike {
    private String bikeId;
    private boolean isAvailable;
    private int batteryLevel;
    private LocalDateTime lastUsedTime;
    private String location;
    public String getBikeId() {
        return bikeId;
    }
    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }
    public boolean getIsAvailable() {
        return isAvailable;
    }
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public int getBatteryLevel() {
        return batteryLevel;
    }
    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    public LocalDateTime getLastUsedTime() {
        return lastUsedTime;
    }
    public void setLastUsedTime(LocalDateTime lastUsedTime) {
        this.lastUsedTime = lastUsedTime;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Bike(String bikeId, boolean isAvailable, int batteryLevel, LocalDateTime lastUsedTime, String location) {
        this.bikeId = bikeId;
        this.isAvailable = isAvailable;
        this.batteryLevel = batteryLevel;
        this.lastUsedTime = lastUsedTime;
        this.location = location;
    }
    @Override
    public String toString() {
        return "Bike:" + "\n" + 
                "bikeId : " + bikeId + "\n" + 
                "isAvailable : " + isAvailable + "\n" + 
                "batteryLevel : " + batteryLevel + "\n" + 
                "lastUsedTime : " + lastUsedTime + "\n" + 
                "location : " + location;
    }
}
