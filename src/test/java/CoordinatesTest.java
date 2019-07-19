import earthquakes.nearby.Coordinates;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CoordinatesTest {
    @Test
    public void testCalculateDistanceTo() {
        Coordinates c1 = new Coordinates(40.73061, -73.935242);
        Coordinates c2 = new Coordinates(40.7516667, -73.9486667);
        double distance = c1.calculateDistanceTo(c2);
        assertEquals(2.439143265143821, distance);
    }
}
