import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mkolakow
 * Date: 7/24/13
 * Time: 8:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class TrainNetwork {

    public TrainNetwork() {
        stationPairInfo = new HashMap<String, Integer>();
    }

    private Map<String, Integer> stationPairInfo;

    public void addStation(String stationPair) {
        //this is kludgy, but could be factored out. Maybe use regex?
        String stations = stationPair.substring(0,2);
        Integer distance = Integer.parseInt(stationPair.substring(2, 3));

        stationPairInfo.put(stations, distance);
    }

    public int routeDistance(List<String> stations) {
        int totalDistance = 0;

        for( int x = 0; x < stations.size() - 1; x++) {
            totalDistance += distanceBetween(stations.get(x), stations.get(x+1));
        }

        return  totalDistance;
    }

    public int distanceBetween(String a, String b) {
        //get the station pair we want
        Integer distance = stationPairInfo.get(a + b);
        return distance;
    }
}
