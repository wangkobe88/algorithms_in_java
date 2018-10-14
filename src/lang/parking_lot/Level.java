package lang.parking_lot;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kewang on 14/10/18.
 */
public class Level {
    private final List<ParkingSpot> spots;
    Level(int numOfSpots){
        spots = new ArrayList<ParkingSpot>(numOfSpots);
        /* init the sports*/
    }

    boolean hasSpot(Vehicle v){
        for(ParkingSpot parkingSpot : spots){
            if (parkingSpot.fit(v)){
                return true;
            }
        }
        return false;
    }
}
