package lang.parking_lot;

/**
 * Created by kewang on 14/10/18.
 */
public class Car extends Vehicle {

    @Override
    public VehicleSize getSize(){
        return VehicleSize.Packet;
    }

}
