package proj_3;
import java.io.Serializable;

public class SUV_45 extends Car_45 implements Serializable{
      private String wd;
    public SUV_45(int plateNumber, int numberOfTires, String color, int seatingCapacity, int numberOfDoors, double dailyFee,String wd) {
        super(plateNumber, numberOfTires, color, seatingCapacity, numberOfDoors, dailyFee);
         this.wd=wd;
    }
      
        public String getWd(){
        return this.wd;
    }
   
}
