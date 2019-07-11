package earthquakes.nearby;

import java.util.Comparator;

public class SortByProximity implements Comparator<Feature> {

    private Coordinates reference;

    public SortByProximity(Coordinates reference) {
        this.reference = reference;
    }

    @Override
    public int compare(Feature o1, Feature o2) {
        Double distance1 = reference.calculateDistanceTo(o1.getCoordinates());
        Double distance2 = reference.calculateDistanceTo(o2.getCoordinates());
        return Double.compare(distance1, distance2);
    }
}
