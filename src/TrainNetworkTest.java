import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: mkolakow
 * Date: 7/24/13
 * Time: 8:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class TrainNetworkTest {

    TrainNetwork network;

    @BeforeMethod
    public void setup() {
       network = new TrainNetwork();
       network.addStationList( Arrays.asList( "AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"));
    }

    @Test
    public void distanceBetweenTwoStations() {
       network.addStation("AB1");
       assertEquals(network.distanceBetween("A", "B"), 1);
    }

    @Test
    public void differentDistanceBetweenTwoStations() {
        network.addStation("AB2");
        assertEquals(network.distanceBetween("A", "B"), 2);
    }

    @Test
    public void distanceWhenGivenMultipleStationPairs() {
       network.addStation("AB1");
       network.addStation("BC2");
       assertEquals(network.distanceBetween("A", "B"), 1);
    }

    @Test
    public void distanceBetweenThreeStations() {
        network.addStation("AB1");
        network.addStation("BC2");
        assertEquals(network.routeDistance(Arrays.asList("A", "B", "C")), 3);
    }

    @Test
    public void sanityCheck() {
        //let's just make sure we are right so far according to problem description
        assertEquals(network.routeDistance(Arrays.asList("A", "B", "C")), 9);
        assertEquals(network.routeDistance(Arrays.asList("A", "D")), 5);
        assertEquals(network.routeDistance(Arrays.asList("A", "D", "C")), 13);
        assertEquals(network.routeDistance(Arrays.asList("A", "E", "B", "C", "D")), 22);
    }

    @Test
    public void noSuchRoute() {
        try {
            assertEquals(network.routeDistance(Arrays.asList("A", "E", "D")), 22);
            fail("Should throw a no such route exception!");
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "NO SUCH ROUTE!");
        }
    }

    @Test
    public void numTrips() {
        assertEquals(network.numTrips( "C", 3 ), 2);
    }


    @Test
    public void recEmpty() {
        network.addStationList(Arrays.<String>asList());
        assertEquals(Arrays.asList(), network.rec(Arrays.asList()));
    }
}
