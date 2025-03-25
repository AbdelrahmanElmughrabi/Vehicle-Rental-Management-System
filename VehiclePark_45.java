package proj_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

public class VehiclePark_45 implements Serializable {

    private static ArrayList<Vehicle_45> allVehicles_45;
    private static ArrayList<Vehicle_45> bookedVehicles;
    private static ArrayList<Vehicle_45> rentedVehicles;
    private static ArrayList<Vehicle_45> availableVehicles;
    private static ArrayList<String> registeredCustomer;
    private static ArrayList<Date> dateCarAdded = new ArrayList();
    private static ArrayList<Date> bookingDateList = new ArrayList();
    private static ArrayList<Date> rentingDateList = new ArrayList();
    private static ArrayList<Date> AvailableDateList = new ArrayList();

    static File f;
    static File fi;
    static VehiclePark_45 v = new VehiclePark_45();

    public VehiclePark_45() {
        allVehicles_45 = new ArrayList();
        bookedVehicles = new ArrayList();
        rentedVehicles = new ArrayList();
        registeredCustomer = new ArrayList();
        availableVehicles = new ArrayList();
        f = new File("AllVehicles.dat");
        fi = new File("DailyReport.dat");
    }

    static Scanner sc = new Scanner(System.in);

    public static void displayVehicles() throws FileNotFoundException, IOException {
        fillFile();
        fillAvailableArray();
        try {
            FileInputStream inputStream = new FileInputStream("AllVehicles.dat");
            ObjectInputStream oos = new ObjectInputStream(inputStream);
            System.out.println("ID     "+"Plate number        "+"Type");
            for (int i = 0; i < allVehicles_45.size(); i++) {
                System.out.println(allVehicles_45.get(i).getId() + "      " + allVehicles_45.get(i).getPlateNumber() + "          " + type(allVehicles_45.get(i)));
            }
            
            for (int i = 0; i < allVehicles_45.size(); i++) {
                while (inputStream.available() > 0) {
                    oos.read();
                  
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }

    public static void displayAvailableVehicles() {
        System.out.println("Enter for starting date: ");
        fillAvailableArray();
        Date startingDate = Vehicle_45.getStartingDate();
        System.out.println("Enter for ending date: ");
        Date endingDate = Vehicle_45.getEndingDate();
        int adder = 0;
        for (int i = adder; i < AvailableDateList.size(); i++) {
            if (i % 2 == 0) {//means it's a starting date from the date ArrayList
                Date starting = AvailableDateList.get(i);
                i += 1;
                adder = i;
                if (i % 2 != 0) {//means it's an ending date from same arrayList
                    Date ending = AvailableDateList.get(i);
                    if (starting == startingDate && ending == endingDate) {
                        System.out.println(availableVehicles.get(i - 1).getId() + " " + availableVehicles.get(i - 1).getPlateNumber() + " " + type(availableVehicles.get(i - 1)));
                    }
                }
            }
        }

    }

    public static void displayAvailableVehicles(String type) {
        System.out.println("Enter for starting date: ");
        Date startingDate = Vehicle_45.getStartingDate();
        System.out.println("Enter for ending date: ");
        Date endingDate = Vehicle_45.getEndingDate();
        switch (type) {

            case "sport":
                int adder = 0;
                for (int i = adder; i < AvailableDateList.size(); i++) {
                    if (i % 2 == 0) {//means it's a starting date from the date ArrayList
                        Date starting = AvailableDateList.get(i);
                        i += 1;
                        adder = i;
                        if (i % 2 != 0) {//means it's an ending date from same arrayList
                            Date ending = AvailableDateList.get(i);
                            if (starting == startingDate && ending == endingDate) {
                                if (availableVehicles.get(i - 1) instanceof Sports_45) {
                                    System.out.println(availableVehicles.get(i - 1).getId() + " " + availableVehicles.get(i - 1).getPlateNumber() + " " + type(availableVehicles.get(i - 1)));
                                }
                            }
                        }
                    }
                }
                break;

            case "SW":
                adder = 0;
                for (int i = adder; i < AvailableDateList.size(); i++) {
                    if (i % 2 == 0) {//means it's a starting date from the date ArrayList
                        Date starting = AvailableDateList.get(i);
                        i += 1;
                        adder = i;
                        if (i % 2 != 0) {//means it's an ending date from same arrayList
                            Date ending = AvailableDateList.get(i);
                            if (starting == startingDate && ending == endingDate) {
                                if (availableVehicles.get(i - 1) instanceof StationWagon_45) {
                                    System.out.println(availableVehicles.get(i - 1).getId() + " " + availableVehicles.get(i - 1).getPlateNumber() + " " + type(availableVehicles.get(i - 1)));
                                }
                            }
                        }
                    }
                }
                break;

            case "SUV":
                adder = 0;
                for (int i = adder; i < AvailableDateList.size(); i++) {
                    if (i % 2 == 0) {
                        Date starting = AvailableDateList.get(i);
                        i += 1;
                        adder = i;
                        if (i % 2 != 0) {
                            Date ending = AvailableDateList.get(i);
                            if (starting == startingDate && ending == endingDate) {
                                if (availableVehicles.get(i - 1) instanceof SUV_45) {
                                    System.out.println(availableVehicles.get(i - 1).getId() + " " + availableVehicles.get(i - 1).getPlateNumber() + " " + type(availableVehicles.get(i - 1)));
                                }
                            }
                        }
                    }
                }

                break;
            case "smallTruck":
                adder = 0;
                for (int i = adder; i < AvailableDateList.size(); i++) {
                    if (i % 2 == 0) {
                        Date starting = AvailableDateList.get(i);
                        i += 1;
                        adder = i;
                        if (i % 2 != 0) {
                            Date ending = AvailableDateList.get(i);
                            if (starting == startingDate && ending == endingDate) {
                                if (availableVehicles.get(i - 1) instanceof SmallTrucks_45) {
                                    System.out.println(availableVehicles.get(i - 1).getId() + " " + availableVehicles.get(i - 1).getPlateNumber() + " " + type(availableVehicles.get(i - 1)));
                                }
                            }
                        }
                    }
                }

                break;
            case "transportTruck":
                adder = 0;
                for (int i = adder; i < AvailableDateList.size(); i++) {
                    if (i % 2 == 0) {
                        Date starting = AvailableDateList.get(i);
                        i += 1;
                        adder = i;
                        if (i % 2 != 0) {
                            Date ending = AvailableDateList.get(i);
                            if (starting == startingDate && ending == endingDate) {
                                if (availableVehicles.get(i - 1) instanceof TransportTrucks_45) {
                                    System.out.println(availableVehicles.get(i - 1).getId() + " " + availableVehicles.get(i - 1).getPlateNumber() + " " + type(availableVehicles.get(i - 1)));
                                }
                            }
                        }
                    }
                }
                break;
            default:
                System.out.println("Invalid type");
                break;
        }

    }

    public static void addVehicle() throws IOException {

        System.out.println("Type car for add new car");
        System.out.println("Type truck for add new truck: ");
        String type = sc.next();

        if (type.equals("car")) {
            System.out.println("For sport cars type sport");
            System.out.println("For station wagon cars type stationWagon");
            System.out.println("For SUV cars type SUV: ");
            type = sc.next();
            if (type.equals("sport")) {
                System.out.println("Enter plate number: ");
                int plateNumbeR = sc.nextInt();
                System.out.println("Enter number of tires: ");
                int numOfTires = sc.nextInt();
                System.out.println("Enter daily fee: ");
                double fee = sc.nextDouble();
                System.out.println("Enter color: ");
                String Color = sc.next();
                System.out.println("Enter seating capacity: ");
                int capacity = sc.nextInt();
                System.out.println("Enter number of doors: ");
                int numDoors = sc.nextInt();
                System.out.println("Enter HP: ");
                int hp = sc.nextInt();
                Sports_45 newSport = new Sports_45(plateNumbeR, numOfTires, fee, Color, capacity, numDoors, hp);
                allVehicles_45.add(newSport);

                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                    oos.writeObject("Sport" + newSport.getId() + "   " + newSport.getPlateNumber() + "   " + newSport.getDailyFee());
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found.");
                } catch (IOException ex) {
                    System.out.println("Vehicle couldn't add to the file.");
                }

                System.out.println("Sport car successfully added.");

            } else if (type.equals("stationWagon")) {
                System.out.println("Enter plate number: ");
                int plateNumbeR = sc.nextInt();
                System.out.println("Enter number of tires: ");
                int numOfTires = sc.nextInt();
                System.out.println("Enter daily fee: ");
                double fee = sc.nextDouble();
                System.out.println("Enter color: ");
                String Color = sc.next();
                System.out.println("Enter seating capacity: ");
                int capacity = sc.nextInt();
                System.out.println("Enter number of doors: ");
                int numDoors = sc.nextInt();
                System.out.println("Enter loading capacity: ");
                int loadCapacity = sc.nextInt();
                StationWagon_45 newStationWagon = new StationWagon_45(plateNumbeR, numOfTires, fee, Color, capacity, numDoors, loadCapacity);
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                    oos.writeObject("Station Wagon" + newStationWagon.getId() + "   " + newStationWagon.getPlateNumber() + "   " + newStationWagon.getDailyFee());
                    oos.close();
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found.");
                } catch (IOException ex) {
                    System.out.println("Vehicle couldn't add to the file.");
                }

                allVehicles_45.add(newStationWagon);
                System.out.println("Station wagon successfully added.");

            } else if (type.equals("SUV")) {
                System.out.println("Enter plate number: ");
                int plateNumbeR = sc.nextInt();
                System.out.println("Enter number of tires: ");
                int numOfTires = sc.nextInt();
                System.out.println("Enter daily fee: ");
                double fee = sc.nextDouble();
                System.out.println("Enter color: ");
                String Color = sc.next();
                System.out.println("Enter seating capacity: ");
                int capacity = sc.nextInt();
                System.out.println("Enter number of doors: ");
                int numDoors = sc.nextInt();
                System.out.println("Type wheel drive: ");
                String wD = sc.next();
                SUV_45 newSUV = new SUV_45(plateNumbeR, numOfTires, Color, capacity, numDoors, fee, wD);
                allVehicles_45.add(newSUV);
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                    oos.writeObject("SUV " + newSUV.getId() + "   " + newSUV.getPlateNumber() + "   " + newSUV.getDailyFee());
                    oos.close();
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found.");
                } catch (IOException ex) {
                    System.out.println("Vehicle couldn't add to the file.");
                }
                System.out.println("SUV successfully added.");

            } else {
                System.out.println("Invalid input.");
            }
        } else if (type.equals("truck")) {
            System.out.println("For small truck type smallTruck");
            System.out.println("For Transport trucks type transportTruck");
            type = sc.next();
            if (type.equals("smallTruck")) {
                System.out.println("Enter plate number: ");
                int plateNumbeR = sc.nextInt();
                System.out.println("Enter number of tires: ");
                int numOfTires = sc.nextInt();
                System.out.println("Enter daily fee: ");
                double fee = sc.nextDouble();
                System.out.println("Enter vehicle loading capacity: ");
                int cap = sc.nextInt();
                SmallTrucks_45 newSmall = new SmallTrucks_45(plateNumbeR, numOfTires, fee, cap);
                allVehicles_45.add(newSmall);
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                    oos.writeObject("Small Truck " + newSmall.getId() + "   " + newSmall.getPlateNumber() + "   " + newSmall.getDailyFee() + " " + newSmall.getLoadingCapacity());
                    oos.close();
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found.");
                } catch (IOException ex) {
                    System.out.println("Vehicle couldn't add to the file.");
                }
                System.out.println("Small truck successfully added.");

            } else if (type.equals("transportTruck")) {
                System.out.println("Enter plate number: ");
                int plateNumbeR = sc.nextInt();
                System.out.println("Enter number of tires: ");
                int numOfTires = sc.nextInt();
                System.out.println("Enter daily fee: ");
                double fee = sc.nextDouble();
                TransportTrucks_45 newTransport = new TransportTrucks_45(plateNumbeR, numOfTires, fee);
                allVehicles_45.add(newTransport);
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                    oos.writeObject("Transport truck" + newTransport.getId() + "   " + newTransport.getPlateNumber() + "   " + newTransport.getDailyFee());
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found.");
                } catch (IOException ex) {
                    System.out.println("Vehicle couldn't add to the file.");
                }
                System.out.println("Transport truck successfully added.");

            } else {
                System.out.println("Invalid input");
            }
        }

    }

    public static void removeVehicle() {
        System.out.println("Enter plate number: ");
        int plate = sc.nextInt();

        for (int i = 0; i < allVehicles_45.size(); i++) {
            if (allVehicles_45.get(i).getPlateNumber() == plate) {
                allVehicles_45.remove(i);
                availableVehicles.remove(i);
                if (bookedVehicles.get(i).getPlateNumber() == plate) {
                    bookedVehicles.remove(bookedVehicles.get(i));
                    availableVehicles.remove(i);
                }
                if (rentedVehicles.get(i).getPlateNumber() == plate) {
                    rentedVehicles.remove(rentedVehicles.get(i));
                    availableVehicles.remove(i);
                }
                System.out.println("Vehicle removed successfully!");
            }
        }
    }

    public static void dailyReport() {
        if (TestClass_45.isAdmin) {
            while (true) {

                try {
                    FileInputStream n = new FileInputStream(fi);
                    n.read();

                } catch (FileNotFoundException ex) {
                    System.out.println("File not found");

                } catch (IOException ex) {
                    System.out.println("");
                }
            }
        }
    }

    public static void bookVehicle() throws SorryWeDontHaveThatOneException_45 {
        if (TestClass_45.isCustomer) {
            System.out.println("Enter plate number of vehicle: ");
            int plate = sc.nextInt();
            for (int i = 0; i < allVehicles_45.size(); i++) {
                if (allVehicles_45.get(i).getPlateNumber() == plate) {
                    allVehicles_45.get(i).bookMe(allVehicles_45.get(i));
                }
            }

        }
    }

    public static void cancelBooking() throws NoCancellationYouMustPayException_45 {
        if (TestClass_45.isCustomer) {
            System.out.println("Enter plate number: ");
            int plate = sc.nextInt();
            for (int i = 0; i < bookedVehicles.size(); i++) {
                if (bookedVehicles.get(i).getPlateNumber() == plate) {
                    bookedVehicles.get(i).cancelMe(bookedVehicles.get(i));
                }
            }
        }
    }

    public static void rentVehicle() throws SorryWeDontHaveThatOneException_45 {
        if (TestClass_45.isCustomer) {
            System.out.println("Enter plate number of the car: ");
            int plate = sc.nextInt();
            for (int i = 0; i < allVehicles_45.size(); i++) {
                if (plate == allVehicles_45.get(i).getPlateNumber()) {
                    allVehicles_45.get(i).rentMe(allVehicles_45.get(i));
                }
            }
        }
    }

    public static void dropVehicle() {
        if (TestClass_45.isCustomer) {
            System.out.println("Enter plate number of the car: ");
            int plate = sc.nextInt();
            for (int i = 0; i < allVehicles_45.size(); i++) {
                if (plate == allVehicles_45.get(i).getPlateNumber()) {
                    allVehicles_45.get(i).dropMe(allVehicles_45.get(i));
                }
            }
        }
    }

    public static void load() throws OverWeightException_45 {
        if (TestClass_45.isCustomer) {
            System.out.println("Enter plate number of the car: ");
            int plate = sc.nextInt();
            System.out.println("Enter type of your vehicle: ");
            System.out.println("If it is transport truck type transportTruck"
                    + "Else if it is station wagon type stationWagon"
                    + "Else if it is small truck type smallTruck");
            String type = sc.next();
            System.out.println("Enter ");
            for (int i = 0; i < allVehicles_45.size(); i++) {
                if (plate == allVehicles_45.get(i).getPlateNumber()) {
                    switch (type) {
                        case "transportTruck":
                            TransportTrucks_45 newTT = (TransportTrucks_45) allVehicles_45.get(i);
                            System.out.println("Enter the load you want to put in the vehicle");
                            int load = sc.nextInt();
                            newTT.loadMe(load);
                            break;
                        case "stationWagon":
                            StationWagon_45 newSW = (StationWagon_45) allVehicles_45.get(i);
                            break;
                        case "smallTruck":
                            SmallTrucks_45 newST = (SmallTrucks_45) allVehicles_45.get(i);
                            break;
                        default:
                            System.out.println("Invalid value.");
                    }
                }
            }
        }
    }

    public ArrayList<Vehicle_45> getAllVehicles_45() {
        return allVehicles_45;
    }

    public ArrayList<Vehicle_45> getBookedVehicles() {
        return bookedVehicles;
    }

    public ArrayList<Vehicle_45> getRentedVehicles() {
        return rentedVehicles;
    }

    public ArrayList<String> getRegisteredCustomer() {
        return registeredCustomer;
    }

    public ArrayList<Vehicle_45> getAvailableVehiclesList() {
        return availableVehicles;
    }

    public ArrayList<Date> getDateCarAdded() {
        return dateCarAdded;
    }

    public ArrayList<Date> getBookingDateList() {
        return bookingDateList;
    }

    public ArrayList<Date> getRentingDateList() {
        return rentingDateList;
    }

    public static String type(Object o) {
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

    public static void fillAvailableArray() {
        Sports_45 s = new Sports_45(898779, 4, 56.5, "red", 2, 2, 1400);
        availableVehicles.add(s);
        allVehicles_45.add(s);

        Calendar c = Calendar.getInstance();
        c.set(2023, 3, 2);
        Date start = c.getTime();
        AvailableDateList.add(start);
        Calendar d = Calendar.getInstance();
        d.set(2023, 4, 2);
        Date end = d.getTime();
        AvailableDateList.add(end);
    }

    public static void fillFile() throws FileNotFoundException, IOException {
        fillAvailableArray();
        String data;
        try {
            Sports_45 s = new Sports_45(898779, 4, 56.5, "red", 2, 2, 1400);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("AllVehicles.dat"));
            oos.writeObject(s);
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }

    }

}
