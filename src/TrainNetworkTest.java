import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

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
}
