package earthquakes.nearby;

import java.util.Comparator;

public class SortByProximity implements Comparator<Feature> {

    private Coordinates reference;

    public SortByProximity(Coordinates reference) {
        this.reference = reference;
    }

    /**
     * Compares 2 Feature objects by its proximity with the reference
     * @param feature1 Feature
     * @param feature2 Feature
     * @return 1 if feature1 is closer, -1 if feature2 is closer, 0 if they're equal
     */
    @Override
    public int compare(Feature feature1, Feature feature2) {
        double distance1 = reference.calculateDistanceTo(feature1.getCoordinates());
        double distance2 = reference.calculateDistanceTo(feature2.getCoordinates());
        return Double.compare(distance1, distance2);
    }
}
