
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BikeRental {
    private boolean isRegisteredUser;
    private String emailAddress;
    private String location;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private boolean locationValid;
    private UserRegistration userRegistration = new UserRegistration();
    private ActiveRental activeRental;
    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    private Scanner input= new Scanner(System.in);
    public void simulateApplicationInput(){
        System.out.println("This is the simulation of the e-bike rental process.");
        isRegisteredUser=Boolean.parseBoolean(input.nextLine());
        emailAddress=input.nextLine();
        location=input.nextLine();
        System.out.println("Simulating the analysis of the rental request.");
        bikeID=analyseRequest(isRegisteredUser, emailAddress, location);
        if(!locationValid){
            return;
        }
        System.out.println("Simulating e-bike reservation…");
        reserveBike(bikeID);
        System.out.println("Displaying the active rentals…");
        viewActiveRentals();
        System.out.println("Simulating the end of the trip…");
        removeTrip(bikeID);
        System.out.println(" Displaying the active rentals after trip end…");
        viewActiveRentals();
    }
    private String analyseRequest(boolean isRegisteredUser,String emailAddress,String location){
        if(isRegisteredUser){
            System.out.println("Welcome back, "+emailAddress+"!");
        }
        else{
            System.out.println("You’re not our registered user. Please consider registering.");
            userRegistration.registration();
        }
        return validateLocation(location);
    }
    private String validateLocation(String location){
        for(Bike bike:BikeDatabase.bikes){
            if(location.equals(bike.getLocation())&&bike.getIsAvailable()){
                System.out.println("A bike is available at the location you requested.");
                locationValid=true;
                return bikeID;
            }
        }
        System.out.println(": Sorry, no bikes are available at the location you requested. Please try again later");
        return null;
    }
    private void reserveBike(String bikeID){
        if(bikeID!=null){
            for(Bike bike:BikeDatabase.bikes){
                if(bikeID.equals(bike.getBikeId())){
                    tripStartTime=LocalDateTime.now();
                    bike.setIsAvailable(false);
                    bike.setLastUsedTime(tripStartTime);
                    System.out.println("Reserving the bike with the "+bikeID+". Please following the on-screen instructions to locate the bike and start your pleasant journey.");
                    activeRental=new ActiveRental(bikeID,emailAddress,tripStartTime);
                    activeRentalsList.add(activeRental);
                    break;
                }
            }
        }
        else{
            System.out.println("Sorry, we’re unable to reserve a bike at this time. Please try again later.");
        }
    }
    private void viewActiveRentals(){
        if(activeRentalsList.isEmpty()){
            System.out.println("No active rentals at the moment.");
        }
        else{
            System.out.println(activeRentalsList);
        }
    }
    private void removeTrip(String bikeID){
        Iterator<ActiveRental> iterator=activeRentalsList.iterator();
        while(iterator.hasNext()){
            if(bikeID.equals(iterator.next().getBikeId())){
                iterator.remove();
                break;
            }
            iterator.next();
        }
        for(Bike bike:BikeDatabase.bikes){
            if(bikeID.equals(bike.getBikeId())){
                tripStartTime=LocalDateTime.now();
                bike.setIsAvailable(true);
                bike.setLastUsedTime(tripStartTime);
            }
            else{
                System.out.println(" Your trip has ended. Thank you for riding with us.");
                break;
            }
        }
    }
}
