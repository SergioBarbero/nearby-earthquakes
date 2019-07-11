import earthquakes.nearby.Coordinates;

import earthquakes.nearby.Feature;
import earthquakes.nearby.SortByProximity;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

import static junit.framework.TestCase.assertEquals;


public class EarthQuakesTests {

    @Test
    public void testCalculateDistanceTo() {
        Coordinates c1 = new Coordinates(40.73061, -73.935242);
        Coordinates c2 = new Coordinates(40.7516667, -73.9486667);
        double distance = c1.calculateDistanceTo(c2);
        assertEquals(2.439143265143821, distance);
    }

    @Test
    public void compareTest() {
        Coordinates center = new Coordinates(40.73061, -73.935242);
        Comparator<Feature> comparator = new SortByProximity(center);

        Feature feature1 = new Feature("A feature", new Coordinates(40.73061, -73.935242));
        Feature feature2 = new Feature("Another feature", new Coordinates(50.73061, -60.935242));
        Assert.assertEquals(-1, comparator.compare(feature1, feature2));
    }
}
