public class Main {
    public static void main(String[] args) throws Exception {
        String commit1="I was very satisfied with the service.";
        String commit2="The e-Bike is quite comfortable to ride.";
        String commit3="The battery life of the e-Bike is impressive.";
        String commit4="The customer support was helpful and responsive.";
        String commit5="I would recommend this e-Bike to my friends and family.";
        Feedback feedback = new Feedback("John", "Doe", "JohnDoe@gmail.com");
        feedback.analysizeFeedback(true, commit1, commit2, commit3, commit4, commit5);
        System.out.println(feedback);
    }
}
