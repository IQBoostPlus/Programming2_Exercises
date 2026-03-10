public class Main {
    public static void main(String[] args) throws Exception {
        ERyder bikeDefault=new ERyder("BK000001", 80, true, 0.0);
        bikeDefault.printRideDetails(5);
        ERyder bikeCreated=new ERyder("York" , "123-456-7890" , "BK000002", 66, true, 1.5);
        bikeCreated.printRideDetails(15);
    }
}
