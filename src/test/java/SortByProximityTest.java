import earthquakes.nearby.Coordinates;

import earthquakes.nearby.Feature;
import earthquakes.nearby.SortByProximity;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class SortByProximityTest {

    @Test
    public void compareTest() {
        Coordinates center = new Coordinates(40.73061, -73.935242);
        Comparator<Feature> comparator = new SortByProximity(center);

        Feature feature1 = new Feature("A feature", new Coordinates(40.73061, -73.935242));
        Feature feature2 = new Feature("Another feature", new Coordinates(50.73061, -60.935242));
        Assert.assertEquals(-1, comparator.compare(feature1, feature2));
    }
}
