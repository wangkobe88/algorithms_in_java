package lang.parking_lot;

/**
 * Created by kewang on 14/10/18.
 */
public class ParkingSpot {
    private final VehicleSize size;
    ParkingSpot(VehicleSize size){
        this.size = size;
    }

    private Vehicle vehicle;

    public void park(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void leave(){
        this.vehicle = null;
    }

    public boolean fit(Vehicle vehicle){
        if(this.vehicle == null && this.size == vehicle.getSize()){
            return true;
        } else {
            return false;
        }
    }
}
