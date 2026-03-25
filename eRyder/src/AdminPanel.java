
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminPanel {
    Scanner input=new Scanner(System.in);
    List<RegisteredUsers> registeredUsersList = new ArrayList<>();
    public void userManagementOptions(){
        while (true) { 
            System.out.println("Welcome to E-Ryder Admininstrator Panel.");
            System.out.println("Here are your options:");
            System.out.println("What do you want to do?");
            System.out.println("1. Add New Users");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. EXIT");
            int choice=Integer.parseInt(input.nextLine());
            switch(choice){
                case 1 -> addNewUsers();
                case 2 -> viewRegisteredUsers();
                case 3 -> removeRegisteredUsers();
                case 4 -> updateRegisteredUsers();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice. Please try again");
            }
        }
    }
    private void addNewUsers() {
        int userNumber;
        String fullName;
        String emailAddress;
        String dateOfBirth;
        long cardNumber;
        String cardProvider;
        String cardExpiryDate;
        int cvv;
        String userType;
        String[] lastThreeTrips=new String[3];
        Scanner input=new Scanner(System.in);
        System.out.println("How many users you want to add?");
        userNumber=Integer.parseInt(input.nextLine());
        for(int i=1;i<=userNumber;i++){
            System.out.println("Please enter the full name:");
            fullName=input.nextLine();
            System.out.println("Please enter the email address:");
            emailAddress=input.nextLine();
            System.out.println("Please enter the date of birth(YYYY-MM-DD):");
            dateOfBirth=input.nextLine();
            System.out.println("Please enter the card number(only Visa, MasterCard, and American Express cards are accepted):");
            cardNumber=input.nextLong();
            input.nextLine();
            System.out.println("Please enter the card provider:");
            cardProvider=input.nextLine();
            System.out.println("Please enter the card expiry date:(MM/YY)");
            cardExpiryDate=input.nextLine();
            System.out.println("Please enter the CVV:");
            cvv=input.nextInt();
            input.nextLine();
            System.out.println("Please enter the user type:");
            userType=input.nextLine();
            for(int j=0;j<3;j++){
                String dateOfTrip;
                String sourceAndDestination;
                String paidFare;
                String userFeedback;
                System.out.println("Please enter the date of the trip (YYYY-MM-DD):");
                dateOfTrip=input.nextLine();
                System.out.println("Please enter the source and destination of that trip:");
                sourceAndDestination=input.nextLine();
                System.out.println("Please enter the fare that was paid by the user on that trip:");
                paidFare=input.nextLine();
                System.out.println("Please enter the feedback the user might have entered:");
                userFeedback=input.nextLine();
                StringBuilder tripInformation=new StringBuilder();
                tripInformation.append("Date: ").append(dateOfTrip).append(", Source: ").append(sourceAndDestination).append(", Fare (€): ").append(paidFare).append(", Feedback: ").append(userFeedback);
                lastThreeTrips[j]=tripInformation.toString();
            }
            RegisteredUsers registeredUsers=new RegisteredUsers(fullName, emailAddress, dateOfBirth, cardNumber, cardProvider, cardExpiryDate, cvv, userType, lastThreeTrips);
            registeredUsersList.add(registeredUsers);
        }
    }
    private void viewRegisteredUsers(){
        if(registeredUsersList.isEmpty()){
            System.out.println("No registered users to display");
        }
        else{
            for(RegisteredUsers registeredUsers:registeredUsersList){
                System.out.println(registeredUsers);
            }
        }
    }
    private void removeRegisteredUsers(){
        if(registeredUsersList.isEmpty()){
            System.out.println("No registered users to display");
        }
        else{
            String removeEmailAddress;
            System.out.println("The email address of which user that must be removed?");
            Scanner input=new Scanner(System.in);
            removeEmailAddress=input.nextLine();
            Iterator<RegisteredUsers> iterator=registeredUsersList.iterator();
            while(iterator.hasNext()){
                RegisteredUsers registeredUsers=iterator.next();
                if(registeredUsers.getEmailAddress().equals(removeEmailAddress)){
                    iterator.remove();
                    return;
                }
                else{
                    System.out.println("No user found with this email address");
                }
            }
        }
    }
    private void updateRegisteredUsers(){
        if(registeredUsersList.isEmpty()){
            System.out.println("No registered users to display");
        }
        else{
            String updateEmailAddress;
            System.out.println("The email address of which user that must be removed?");
            Scanner input=new Scanner(System.in);
            updateEmailAddress=input.nextLine();
            for(RegisteredUsers registeredUsers:registeredUsersList){
                if(registeredUsers.getEmailAddress().equals(updateEmailAddress)){
                    String fullName;
                    String emailAddress;
                    String dateOfBirth;
                    long cardNumber;
                    String cardProvider;
                    String cardExpiryDate;
                    int cvv;
                    String userType;
                    System.out.println("Type new full name: (Press ENTER for no change)");
                    fullName=input.nextLine();
                    if(!fullName.isEmpty()){
                        registeredUsers.setFullName(fullName);
                    }
                    System.out.println("Type new email address: (Press ENTER for no change)");
                    emailAddress=input.nextLine();
                    if(!emailAddress.isEmpty()){
                        registeredUsers.setEmailAddress(emailAddress);
                    }
                    System.out.println("Type new date of birth(YYYY-MM-DD): (Press ENTER for no change)");
                    dateOfBirth=input.nextLine();
                    if(!dateOfBirth.isEmpty()){
                        registeredUsers.setDateOfBirth(dateOfBirth);
                    }
                    System.out.println("Type new card number: (Press '0' for no change)");
                    cardNumber=Long.parseLong(input.nextLine());
                    if(cardNumber!=0){
                        registeredUsers.setCardNumber(cardNumber);
                    }
                    System.out.println("Type new card provider: (Press ENTER for no change)");
                    cardProvider=input.nextLine();
                    if(!cardProvider.isEmpty()){
                        registeredUsers.setCardProvider(cardProvider);
                    }
                    System.out.println("Type new card expiry date:(MM/YY): (Press ENTER for no change)");
                    cardExpiryDate=input.nextLine();
                    if(!cardExpiryDate.isEmpty()){
                        registeredUsers.setCardExpiryDate(cardExpiryDate);
                    }
                    System.out.println("Type new CVV: (Press ENTER for no change)");
                    cvv=Integer.parseInt(input.nextLine());;
                    if(cvv!=0){
                        registeredUsers.setCvv(cvv);
                    }
                    System.out.println("Type new user type: (Press ENTER for no change)");
                    userType=input.nextLine();
                    if(!userType.isEmpty()){
                        registeredUsers.setUserType(userType);
                    }
                }
                else{
                    System.out.println("No user found with this email address");
                }
            }
        }
    }
}
