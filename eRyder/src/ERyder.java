public class ERyder {
    private final String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;

    public void ride(){
        if (isAvailable && batteryLevel > 0){
            System.out.println("The bike is available.");
        } 
        else{
            System.out.println("The bike is not available.");
        }
    }
    public void printBikeDetails(){
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Is Available: " + isAvailable);
        System.out.println("Kilometers Driven: " + kmDriven);
    }
    public ERyder(){
        this.bikeID = "BK000001";
        this.batteryLevel = 100;
        this.isAvailable = true;
        this.kmDriven = 0;
    }
    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven){
        this.bikeID = bikeID;
        if (batteryLevel < 0 || batteryLevel > 100) {
            System.out.println("Invalid battery level. It should between 0 and 100.");
            this.batteryLevel=0;
        }
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
    }
}
