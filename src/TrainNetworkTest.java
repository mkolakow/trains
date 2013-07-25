import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: mkolakow
 * Date: 7/24/13
 * Time: 8:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class TrainNetworkTest {

    @Test
    public void distanceBetweenTwoStations() {
       TrainNetwork network = new TrainNetwork();
       network.addStation("AB1");
       assertEquals(network.distanceBetween("A", "B"), 1);
    }

    @Test
    public void differentDistanceBetweenTwoStations() {
        TrainNetwork network = new TrainNetwork();
        network.addStation("AB2");
        assertEquals(network.distanceBetween("A", "B"), 2);
    }

    @Test
    public void distanceWhenGivenMultipleStationPairs() {
       TrainNetwork network  = new TrainNetwork();
       network.addStation("AB1");
       network.addStation("BC2");
       assertEquals(network.distanceBetween("A", "B"), 1);
    }
}
