package proj_3;
import java.io.Serializable;

public class Truck_45 extends Vehicle_45 implements Serializable {

    private int loadingCapacity;
    private double dailyFee;

    public Truck_45(int plateNumber, int numberOfTires, double dailyFee) {
        super(plateNumber, numberOfTires, dailyFee);
    }

    public void setLoadingCapacity(int loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }
    
    
     public int getLoadingCapacity() {
       return loadingCapacity;
    } 
}