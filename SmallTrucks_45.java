package proj_3;
import java.io.Serializable;
import java.util.Scanner;

public class SmallTrucks_45 extends Truck_45 implements remoteOrDropableOff_45,loadable_45,Serializable{
    private int vehicleLoadingCapacity;
    
    SmallTrucks_45(int plateNumber, int numberOfTires, double dailyFee, int vehicleLoadingCapacity) {
        super(plateNumber, numberOfTires, dailyFee);
        this.vehicleLoadingCapacity=vehicleLoadingCapacity;
    }
    
     @Override
    public void loadMe(int loadingCapacity) throws OverWeightException_45 {
     try{
        checkLoad();
     }catch(OverWeightException_45 ex){
         System.out.println("Sorry the amount of load is higher than required for this vehicle.");
     }
    }

    public void checkLoad()throws OverWeightException_45{
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter the amount of load you want to hold in the vehicle.");
        int load=scn.nextInt();
         if(load>this.vehicleLoadingCapacity){
            throw new OverWeightException_45("");
        }
    }

    
    @Override
    public int getLoadingCap(){
        return vehicleLoadingCapacity;
    }
    
    
    @Override
    public void setLoadingCap( int vehicleLoadingCapacity){
        this.vehicleLoadingCapacity=vehicleLoadingCapacity;
    }
}
