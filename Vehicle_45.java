package proj_3;


import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;
import java.io.Serializable;

public abstract class Vehicle_45 implements vehicleBooking_45,Serializable {

    private int id;
    private int plateNumber;
    private int numberOfTires;
    private double dailyFee;
    private static int counter = 1000;
    private Date rentDate;
    private static Date startingBookingDate;
    private static Date endingBookingDate;
    
    
    VehiclePark_45 v = new VehiclePark_45();
    
    Vehicle_45(){
        
    }
    
    Vehicle_45(int plateNumber, int numberOfTires, double dailyFee) {

        this.id += counter++;
        this.plateNumber = plateNumber;
        this.numberOfTires = numberOfTires;
        this.dailyFee = dailyFee;
        v.getDateCarAdded().add(new Date());

    }

    public double getDailyFeeWhenBooked() {
        long differenceInDays = (this.startingBookingDate.getTime() - this.endingBookingDate.getTime()) / (1000 * 60 * 60 * 24);

        return dailyFee * differenceInDays;
    }
    
     public double getDailyFee(){
          return dailyFee;
     }

    public void addToVehicleList(Vehicle_45 a) {
        v.getAllVehicles_45().add(a);

    }

    public void printAllVehicles() {
        for (int i = 0; i < v.getAllVehicles_45().size(); i++) {
            System.out.println(v.getAllVehicles_45().get(i).id + " " + v.getAllVehicles_45().get(i).plateNumber + type(v.getAllVehicles_45().get(i)));
        }
    }

    public int getPlateNumber() {
        return plateNumber;
    }

    public int numberOfTires() {
        return numberOfTires;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public void bookMe(Vehicle_45 c) throws SorryWeDontHaveThatOneException_45 {
        this.startingBookingDate = getStartingDate();
        v.getBookingDateList().add( this.startingBookingDate);
        this.endingBookingDate = getEndingDate();
         v.getBookingDateList().add( this.endingBookingDate);
        try {
            System.out.println("Checking if the vehicle is there or not.....");
            checkIfInVehicleList(c);

        } catch (SorryWeDontHaveThatOneException_45 ex) {
            System.out.println("Sorry the selected car is booked.");
        }
        v.getBookedVehicles().add(c);
        v.getAvailableVehiclesList().remove(c);
        System.out.println("You have booke the car successfully.");
    }

    @Override
    public void cancelMe(Vehicle_45 c) throws NoCancellationYouMustPayException_45 {

        try {
            System.out.println("Checking if the vehicle is there or not.....");
            checkIfInVehicleList(c);
        } catch (SorryWeDontHaveThatOneException_45 ex) {
            System.out.println("Sorry the selected car is not on the list.");
        }

        Date currentdate = new Date();
        long differenceInDays = (this.startingBookingDate.getTime() - currentdate.getTime()) / (1000 * 60 * 60 * 24);
        if (differenceInDays <= 0) {
            throw new NoCancellationYouMustPayException_45("Sorry your booking period has started, you can't cancel after the starting date.");
        } else {
            v.getBookedVehicles().remove(c);
            v.getAvailableVehiclesList().add(c);
            System.out.println("Your cancellation has been done successfully.");
        }
    }

    @Override
    public void rentMe(Vehicle_45 c) throws SorryWeDontHaveThatOneException_45 {

        this.startingBookingDate = getStartingDate();
        v.getRentingDateList().add(this.startingBookingDate);
        this.endingBookingDate = getEndingDate();
         v.getRentingDateList().add(this.startingBookingDate);
        try {
            System.out.println("Checking if the vehicle is there or not.....");
            checkIfRented(c);
        } catch (SorryWeDontHaveThatOneException_45 ex) {
            System.out.println("Sorry the selected car is not on the list.");
        }
        this.rentDate = new Date();
        v.getRentedVehicles().add(c);
        v.getAvailableVehiclesList().remove(c);
        System.out.println("The selected vehicle has been rented successfully");

        if (c instanceof remoteOrDropableOff_45) {
            System.out.println("The selected Vehicle is supports remote delivery and dropping off locations!");
            System.out.println("Enter you Location you want to remote delivery.");
            Scanner scn = new Scanner(System.in);
            String remoteDel = scn.next();
            System.out.println("Enter your drop off location:");
            String dropOff = scn.next();
        } else {
            System.out.println("The selected vehicle doesn't support remote delivery and dropping off locations sadly.");
        }
    }

    public void dropMe(Vehicle_45 c) {
        v.getAllVehicles_45().add(c);
        v.getAvailableVehiclesList().add(c);
        System.out.println("The vehicle has been returned.");
        System.out.println("your payment is: " + getDailyFeeWhenBooked());
    }

    public String type(Object o) {
        if (o != null) {
            if (o instanceof Sports_45) {
                return "Sport car";
            } else if (o instanceof StationWagon_45) {
                return "Station Wagon car";
            } else if (o instanceof SUV_45) {
                return "SUV";
            } else if (o instanceof SmallTrucks_45) {
                return "Small Truck.";
            } else if (o instanceof TransportTrucks_45) {
                return "Transport Truck";
            }
        }
        return "Vehicle";
    }

    public boolean checkIfInVehicleList(Vehicle_45 chosen) throws SorryWeDontHaveThatOneException_45 {
        if (chosen != null) {
            for (int i = 0; i < v.getAllVehicles_45().size(); i++) {
                int s = v.getAllVehicles_45().get(i).plateNumber;
                if (chosen.plateNumber == s) {
                    return true;
                } else {
                    throw new SorryWeDontHaveThatOneException_45("Sorry couldn't find the selected car.");
                }
            }
        }
        throw new SorryWeDontHaveThatOneException_45("Sorry couldn't find the selected car.");
    }

    public boolean checkIfBooked(Vehicle_45 chosen) throws SorryWeDontHaveThatOneException_45 {
        if (chosen != null) {
            for (int i = 0; i < v.getBookedVehicles().size(); i++) {
                int s = v.getBookedVehicles().get(i).plateNumber;
                if (chosen.plateNumber == s) {
                    return true;
                } else {
                    throw new SorryWeDontHaveThatOneException_45();
                }
            }
        }
        throw new SorryWeDontHaveThatOneException_45("Sorry the selected car is booked.");
    }

    public boolean checkIfRented(Vehicle_45 chosen) throws SorryWeDontHaveThatOneException_45 {
        if (chosen != null) {
            for (int i = 0; i < v.getRentedVehicles().size(); i++) {
                int s = v.getRentedVehicles().get(i).plateNumber;
                if (chosen.plateNumber == s) {
                    return true;
                } else {
                    throw new SorryWeDontHaveThatOneException_45("Sorry the selected car is rented.");
                }
            }
        }
        throw new SorryWeDontHaveThatOneException_45("Sorry the selected car is rented.");
    }

    public static Date getStartingDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You're now selecting the Starting date.");
        System.out.print("Please enter the year: ");
        int year = scanner.nextInt();

        System.out.print("Please enter the month (1-12): ");
        int month = scanner.nextInt() - 1;

        System.out.print("Please enter the day: ");
        int day = scanner.nextInt();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    public static Date getEndingDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You're now selecting the ending date.");
        System.out.print("Please enter the year: ");
        int year = scanner.nextInt();

        System.out.print("Please enter the month (1-12): ");
        int month = scanner.nextInt() - 1;

        System.out.print("Please enter the day: ");
        int day = scanner.nextInt();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }
}
