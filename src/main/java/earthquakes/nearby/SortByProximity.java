package earthquakes.nearby;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class SortByProximity implements Comparator<Feature> {

    private Coordinates reference;

    public SortByProximity(Coordinates reference) {
        this.reference = reference;
    }

    @Override
    public int compare(Feature o1, Feature o2) {
        double distance1 = Math.abs(reference.calculateDistanceTo(o1.getCoordinates()));
        double distance2 = Math.abs(reference.calculateDistanceTo(o2.getCoordinates()));
        return Double.compare(distance1, distance2);
    }

    @Override
    public Comparator<Feature> reversed() {
        return null;
    }
}
