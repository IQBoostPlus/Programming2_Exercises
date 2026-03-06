public class Main {
    public static void main(String[] args) throws Exception {
        ERyder bike0=new ERyder();
        bike0.printBikeDetails();
        ERyder bike1=new ERyder("BK001", 66, true, 1.5);
        bike1.ride();
        bike1.printBikeDetails();
    }
}
