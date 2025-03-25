package proj_3;

import java.io.IOException;
import java.util.Scanner;

public class TestClass_45 {
    
    static Scanner sc = new Scanner(System.in);
    static boolean isCustomer = false;
    static boolean isAdmin = false;
    VehiclePark_45 v = new VehiclePark_45();
  
    public static void main(String[] args) throws IOException, SorryWeDontHaveThatOneException_45, NoCancellationYouMustPayException_45 {

        Scanner input = new Scanner(System.in);
        String type;
        do {
            System.out.println("Enter your role customer/admin or to quit type quit:");
            type = input.nextLine();
            if (type.equals("customer")) {
                CustomerMenu();
            } else if (type.equals("admin")) {
                AdminMenu();
            } else if (type.equals("quit")) {
                System.out.println("Quit.");
            } else {
                System.out.println("Invalid type.");
            }
        } while (!type.equals("quit"));
    }

    public static void CustomerMenu() throws IOException, SorryWeDontHaveThatOneException_45, NoCancellationYouMustPayException_45 {
        isCustomer = true;
        int choice;
        do {
            System.out.println("((Press 1) Display all vehicles\n"
                    + "(Press 2) Display available vehicles\n"
                    + "(Press 3) Display available vehicles by type\n"
                    + "(Press 4) Book a vehicle\n"
                    + "(Press 5) Cancel my booking\n"
                    + "(Press 6) Rent a vehicle\n"
                    + "(Press 7) Drop a vehicle\n"
                    + "(Press 8) Quit\n");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    VehiclePark_45.displayVehicles();
                    break;
                case 2:
                    VehiclePark_45.displayAvailableVehicles();
                    break;
                case 3:
                    System.out.println("For sport cars, type sportCar"
                            + "\nFor station wagons, type SW"
                            + "\nFor SUV, type SUV"
                            + "\nFor small trucks, type smallTruck"
                            + "\nFor transport trucks, type transportTruck");
                    String type = sc.next();
                    VehiclePark_45.displayAvailableVehicles(type);
                    break;
                case 4:
                    VehiclePark_45.bookVehicle();
                    break;
                case 5:
                    VehiclePark_45.cancelBooking();
                    break;
                case 6:
                    VehiclePark_45.rentVehicle();
                    break;
                case 7:
                    VehiclePark_45.dropVehicle();
                    break;
                case 8:
                    System.out.println("Quit");
                    isCustomer = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        } while (choice != 8);
    }

    public static void AdminMenu() throws IOException {
        isAdmin = true;
        int choice;
        do {
            System.out.println("(Press 1) Display all vehicles\n"
                    + "(Press 2) Display available vehicles\n"
                    + "(Press 3) Add a new vehicle to the system\n"
                    + "(Press 4) Remove vehicle\n"
                    + "(Press 5) Reports\n"
                    + "(Press 6) Quit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    VehiclePark_45.displayVehicles();
                    break;
                case 2:
                    VehiclePark_45.displayAvailableVehicles();
                    break;
                case 3:
                    VehiclePark_45.addVehicle();
                    break;
                case 4:
                    VehiclePark_45.removeVehicle();
                    break;
                case 5:
                    VehiclePark_45.dailyReport();
                    break;
                case 6:
                    System.out.println("Quit");
                    isAdmin = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        } while (choice != 6);
    }
}
