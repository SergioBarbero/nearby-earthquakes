import earthquakes.nearby.Coordinates;
import earthquakes.nearby.Earthquakes;
import earthquakes.nearby.Feature;
import earthquakes.nearby.NearestEarthquakes;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NearestEarthquakesTest {

    @Test
    public void getNClosestFeaturesTest() {
        Feature a = new Feature("a", new Coordinates(2.000, 4.000));
        Feature b = new Feature("b", new Coordinates(3.000, 4.000));
        Feature c = new Feature("c", new Coordinates(10.000, 53.000));
        Feature d = new Feature("d", new Coordinates(15.000, 0.000));
        Feature e = new Feature("e", new Coordinates(27.000, 12.000));
        Set<Feature> features = Set.of(a, b, c, d, e);
        Earthquakes earthquakes = mock(Earthquakes.class);
        when(earthquakes.getFeatures()).thenReturn(features);
        NearestEarthquakes nearestEarthquakes = new NearestEarthquakes(earthquakes);
        List<Feature> expected3NearestFeatures = List.of(a, b, d);
        List<Feature> nearest3Features = nearestEarthquakes.getNClosestFeatures(new Coordinates(0.000, 0.000), 3);
        assertEquals(expected3NearestFeatures, nearest3Features);
    }
}
