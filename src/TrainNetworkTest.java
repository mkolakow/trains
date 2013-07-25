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
       assertEquals(1, network.distanceBetween("A", "B"));
    }
}
