/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_3;

/**
 *
 * @author mashe
 */
public interface vehicleBooking_45 {
    public void bookMe(Vehicle_45 c) throws SorryWeDontHaveThatOneException_45;
    public void cancelMe(Vehicle_45 c) throws NoCancellationYouMustPayException_45;
    public void rentMe(Vehicle_45 c)throws SorryWeDontHaveThatOneException_45 ;
    public void dropMe(Vehicle_45 c);    
}
