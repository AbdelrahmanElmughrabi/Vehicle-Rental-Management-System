package proj_3;
import java.io.Serializable;

public class Sports_45 extends Car_45 implements remoteOrDropableOff_45, Serializable{
    private int Hp;
    
    public Sports_45(int plateNumber, int numberOfTires, double dailyFee, String color, int seatingCapacity, int numberOfDoors, int Hp) {
        super(plateNumber, numberOfTires, color, seatingCapacity, numberOfDoors,dailyFee);
        this.Hp=Hp;
    }
      
    public int getHp(){
        return this.Hp;
    }
}
 