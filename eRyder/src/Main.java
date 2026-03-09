public class Main {
    public static void main(String[] args) throws Exception {
        ERyder bikeDefault=new ERyder();
        bikeDefault.printBikeDetails();
        ERyder bikeCreated=new ERyder("BK000002", 66, true, 1.5);
        bikeCreated.ride();
        bikeCreated.printBikeDetails();
    }
}
