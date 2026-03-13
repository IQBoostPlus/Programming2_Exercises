public class Main {
    public static void main(String[] args) throws Exception {
        String str1="I was very satisfied with the service.";
        String str2="The e-Bike is quite comfortable to ride.";
        String str3="The battery life of the e-Bike is impressive.";
        String str4="The customer support was helpful and responsive.";
        String str5="I would recommend this e-Bike to my friends and family.";
        Feedback feedback1 = new Feedback("John", "Doe", "JohnDoe@gmail.com");
        feedback1.analysizeFeedback(true, str1, str2, str3, str4, str5);
        System.out.println(feedback1);
    }
}
