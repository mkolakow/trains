import java.util.*;

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

    public void addStationList(List<String> stations) {
        for( String station : stations ) {
            addStation( station );
        }
    }

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

        if( distance == null ) {
            throw new RuntimeException("NO SUCH ROUTE!");
        }

        return distance;
    }

    //network.addStationList( Arrays.asList( "AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"));
    public int numTrips(String station, int maxStops) {
        int trips = 0;
        int stops = 0;
        Stack<String> stations = new Stack<String>();

        Iterator it = this.stationPairInfo.keySet().iterator();
        while( it.hasNext() ) {
            String name = (String) it.next();
            if( name.startsWith(station) ) {
                stops = 0;
                Iterator<String> start =  this.stationPairInfo.keySet().iterator();
                String nextStation = name.substring(1,2);
                while( stops < maxStops && start.hasNext() ) {
                    String check = start.next();
                    if( check.startsWith(nextStation)) {
                        stations.push(check);
                        if( check.endsWith(station)) {
                            trips++;
                            stops--;
                            stations.pop();
                            nextStation = stations.pop().substring(0,1);
                        } else {
                            stops++;
                            nextStation = check.substring(1,2);
                            start = this.stationPairInfo.keySet().iterator();
                        }
                    }
                    if( ! (start.hasNext()) && ! stations.empty() ) {
                        stations.pop();
                        start = this.stationPairInfo.keySet().iterator();
                    }
                }
            }
        }

        return trips;
    }

    private List<String> getAllStationsBeginningWith(String station) {
        List<String> stationPairs = new ArrayList<String>();

        for( String stationPair : this.stationPairInfo.keySet() ) {
            if( station.startsWith( station ) ) {
                stationPairs.add(stationPair);
            }
        }

        return stationPairs;
    }

}
