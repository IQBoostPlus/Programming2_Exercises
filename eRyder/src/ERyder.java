public class ERyder {
    private final static String COMPANY_NAME= "eRyder";
    private final static double BASE_FARE=1.0;
    private final static double PER_MINUTE_FARE=0.5;
    private final String LINKED_ACCOUNT;
    private final String LINKED_PHONE_NUMBER;
    private final String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;
    private int totalUsageInMinutes;
    private double totalFare;

    private double calculateFare(int usageInMinutes){
        totalFare = BASE_FARE + (PER_MINUTE_FARE * usageInMinutes);
        return totalFare;
    }
    public void printRideDetails(int usageInMinutes){
        this.totalUsageInMinutes = usageInMinutes;
        this.totalFare = calculateFare(usageInMinutes);
        System.out.println("Linked Account: " + LINKED_ACCOUNT);
        System.out.println("Linked Phone Number: " + LINKED_PHONE_NUMBER);
        System.out.println("Usage Duration: " + usageInMinutes + " minutes");
        System.out.println("Total Fare: " + totalFare);
    }
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
    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven){
        LINKED_ACCOUNT = "Default Account";
        LINKED_PHONE_NUMBER = "000-000-0000";
        this.bikeID = bikeID;
        if (batteryLevel < 0 || batteryLevel > 100) {
            System.out.println("Invalid battery level. It should between 0 and 100.");
            this.batteryLevel=0;
        }
        else{
            this.batteryLevel = batteryLevel;
        }
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
    }
    public ERyder(String linkedAccount, String linkedPhoneNumber, String bikeID, int batteryLevel, boolean isAvailable, double kmDriven){
        LINKED_ACCOUNT = linkedAccount;
        LINKED_PHONE_NUMBER = linkedPhoneNumber;
        this.bikeID = bikeID;
        if (batteryLevel < 0 || batteryLevel > 100) {
            System.out.println("Invalid battery level. It should between 0 and 100.");
            this.batteryLevel=0;
        }
        else{
            this.batteryLevel = batteryLevel;
        }
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
    }
}
