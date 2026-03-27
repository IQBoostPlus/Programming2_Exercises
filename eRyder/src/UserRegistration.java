import java.time.LocalDate;
import java.util.Scanner;

public class UserRegistration {
    private final static double VIP_DISCOUNT_UNDER_18_BIRTHDAY=25.0;
    private final static double VIP_DISCOUNT_UNDER_18 =20.0;
    private final static double VIP_BASE_FEE=100.0;
    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private long cardNumber;
    private String cardProvider;
    private String cardExpiryDate;
    private double feeToCharge;
    private int cvv;
    private String userType;
    private boolean emailValid=false;
    private boolean minorAndBirthday=false;
    private boolean minor=false;
    private boolean ageValid=false;
    private boolean cardNumberValid=false;
    private boolean cardStillValid=false;
    private boolean validCVV=false;

    public void registration(){
        System.out.println("Welcome to the ERyder Registration.");
        System.out.println("Here are your two options:");
        System.out.println("1. Register as a Regular User");
        System.out.println("2. Register as a VIP User");
        System.out.println("Please enter your choice (1 or 2):");
        Scanner input=new Scanner(System.in);
        int choice=input.nextInt();
        input.nextLine(); 
        switch(choice){
            case 1:
                userType="Regular User";
                break;
            case 2:
                userType="VIP User";
                break;
            default:
                System.out.println("Invalid choice. Please enter 1 or 2.");
                return;
        }
        System.out.println("Please enter your full name:");
        fullName=input.nextLine();
        System.out.println("Please enter your email address:");
        emailAddress=input.nextLine();
        emailValid=analyseEmail(emailAddress);
        System.out.println("Please enter your date of birth(YYYY-MM-DD):");
        dateOfBirth=input.nextLine();
        LocalDate dob=LocalDate.parse(dateOfBirth);
        ageValid=analyseAge(dob);
        System.out.println("Please enter your card number(only Visa, MasterCard, and American Express cards are accepted):");
        cardNumber=input.nextLong();
        input.nextLine();
        cardNumberValid=analyseCardNumber(cardNumber);
        System.out.println("Please enter your card expiry date:(MM/YY)");
        cardExpiryDate=input.nextLine();
        cardStillValid=analyseCardStillValid(cardExpiryDate);
        System.out.println("Please enter your CVV:");
        cvv=input.nextInt();
        validCVV=analyseCVV(cvv);
        finalCheckpoint();
    }
    private boolean analyseEmail(String email){
        if(email.contains("@") && email.contains(".")){
            System.out.println("Email is valid.");
        }
        else{
            System.out.println("Invalid email address. Going back to the start of the registration.");
            registration();
        }
        return true;
    }
    private boolean analyseAge(LocalDate dob){
        LocalDate currentDate=LocalDate.now();
        int age=currentDate.getYear()-dob.getYear();
        boolean isBirthday=currentDate.getMonthValue()==dob.getMonthValue() && currentDate.getDayOfMonth()==dob.getDayOfMonth();
        if(userType.equals("VIP User")){
            if(age>12&&age<=18){
                if(isBirthday){
                    System.out.println("Happy Birthday!");
                    System.out.println("You get 25% discount on the VIP subscription fee for being born today and being under 18!");
                    minorAndBirthday=true;
                }
                else{
                    System.out.println("You get 20% discount on the VIP subscription fee for being under 18!");
                    minor=true;
                }
            }
            else{
                if(age<=12||age>120){
                    System.out.println("Looks like you are either too young or already dead. Sorry, you can’t be our user. Have a nice day");
                    System.exit(0);
                }
            }
        }
        return true;
    }
    private boolean analyseCardNumber(long cardNumber){
        String cardNumberStr=String.valueOf(cardNumber);
        int firstTwoDigits=Integer.parseInt(cardNumberStr.substring(0,2));
        int firstFourDigits=Integer.parseInt(cardNumberStr.substring(0,4));
        if((cardNumberStr.length()==13||cardNumberStr.length()==15)&&cardNumberStr.startsWith("4")){
            cardProvider="Visa";
        }
        else{
            if(cardNumberStr.length()==16&&((firstTwoDigits>=51&&firstTwoDigits<=55)||(firstFourDigits>=2221&&firstFourDigits<=2720))){
                cardProvider="MasterCard";
            }
            else{
                if(cardNumberStr.length()==15&&(firstTwoDigits==34||firstTwoDigits==37)){
                    cardProvider="American Express";
                }
                else{
                    System.out.println("Sorry, but we accept only VISA, MasterCard, or American Express cards. Please try again with a valid card.");
                    System.out.println("Going back to the start of the registration.");
                    registration();
                }
            }
        }
        return true;
    }
    private boolean analyseCardStillValid(String cardExpiryDate){
        int month=Integer.parseInt(cardExpiryDate.substring(0,2));
        int year=Integer.parseInt(cardExpiryDate.substring(3,5))+2000;
        LocalDate currentDate=LocalDate.now();
        int currentYear=currentDate.getYear();
        int currentMonth=currentDate.getMonthValue();
        if(year>currentYear||(year==currentYear&&month>=currentMonth)){
            System.out.println("The card is still valid");
        }
        else{
            System.out.println("Sorry, your card has expired. Please use a different card.");
            System.out.println("Going back to the start fo the registration process…");
            registration();
        }
        return true;
    }
    private boolean analyseCVV(int cvv){
        String cvvStr=String.valueOf(cvv);
        if((cardProvider.equals("American Express")&&cvvStr.length()==4)||(cardProvider.equals("Visa")&&cvvStr.length()==3)||(cardProvider.equals("MasterCard")&&cvvStr.length()==3)){
            System.out.println("CVV is valid.");
        }
        else{
            System.out.println("Invalid CVV for the given card.");
            System.out.println("Going back to the start of the registration process.");
            registration();
        }
        return true;
    }
    private void finalCheckpoint(){
        if(emailValid&&ageValid&&cardNumberValid&&cardStillValid&&validCVV){
            chargeFees();
        }
        else{
            System.out.println("Sorry, your registration was unsuccessful due to the following reason(s)");
            if(!emailValid){
                System.out.println("Invalid email address");
            }
            if(!ageValid){
                System.out.println("Invalid age");
            }
            if(!cardNumberValid){
                System.out.println("Invalid card number");
            }
            if(!cardStillValid){
                System.out.println("Card has expired");
            }
            if(!validCVV){
                System.out.println("Invalid CVV");
            }
            System.out.println("Going back to the start of the registration process.");
            registration();
        }
    }
    private void chargeFees(){
        if(minorAndBirthday){
            feeToCharge=VIP_BASE_FEE*(1-VIP_DISCOUNT_UNDER_18_BIRTHDAY/100);
        }
        else{
            if(minor){
                feeToCharge=VIP_BASE_FEE*(1-VIP_DISCOUNT_UNDER_18/100);
            }
            else{
                feeToCharge=VIP_BASE_FEE;
            }
        }
        System.out.println("Thank you for your payment.");
        System.out.println("A fee of " + feeToCharge + " has been charged to your card ending with " + String.valueOf(cardNumber).substring(String.valueOf(cardNumber).length()-4));
    }
    @Override
    public String toString(){
        String cardNumberStr=String.valueOf(cardNumber);
        String censoredPart=cardNumberStr.substring(4).replaceAll(".", "*");
        String lastFourDigits=cardNumberStr.substring(cardNumberStr.length()-4);
        String censoredNumber=censoredPart+lastFourDigits;
        return "Registration successful! Here are your details:\nUser Type: " + userType + "\nFull Name: " + fullName + "\nEmail Address: " + emailAddress + "\nDate of Birth: " + dateOfBirth + "\nCard Number: " + censoredNumber + "\nCard Provider: " + cardProvider + "\nCard Expiry Date: " + cardExpiryDate;
    }
}