package proj_3;

import java.util.Date;
import java.util.ArrayList;
import java.io.Serializable;
public class Car_45 extends Vehicle_45 implements Serializable {

    private String color;
    private double dailyFee;
    private int seatingCapacity;
    private int numberOfDoors;
    private Date AddedCarDate;
    private ArrayList <Car_45> allCarsList=new ArrayList<>();
    
     Car_45(int plateNumber, int numberOfTires, String color, int seatingCapacity, int numberOfDoors, double dailyFee) {
        super(plateNumber, numberOfTires,dailyFee);
        this.color = color;
        this.seatingCapacity = seatingCapacity;
        this.numberOfDoors = numberOfDoors;
        this.AddedCarDate = new Date();
        this.dailyFee=dailyFee;
    }

   

    public void setColor(String color) {
        this.color = color;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
    
    public void addToCarList(Car_45 a){
        allCarsList.add(a);
    }

    public String getColor() {
        return this.color;
    }

    public int getSeatingCapacity() {
        return this.seatingCapacity;
    }

    public int getNumberOfDoors() {
        return this.numberOfDoors;
    }

    public Date AddedCarDate() {
        return this.AddedCarDate;
    }
    
   public ArrayList getCarsList(){
       return allCarsList;
   }

   
}