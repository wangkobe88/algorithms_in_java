package lang.parking_lot;

/**
 * Created by kewang on 14/10/18.
 */
public class ParkingLot {
    private Level[] levels;

    public ParkingLot(){
        /* init the data of levels*/
    }
    public boolean stop(Vehicle vehicle) {
        for(Level level : this.levels){
            if(level.hasSpot(vehicle)){
                return true;
            }
        }
        return false;
    }

}
