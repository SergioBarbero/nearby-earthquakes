package earthquakes.nearby;

import com.google.common.collect.MinMaxPriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NearestEarthquakes {

    private Earthquakes earthquakes;

    public NearestEarthquakes(Earthquakes earthquakes) {
        this.earthquakes = earthquakes;
    }

    public List<Feature> getNClosestFeatures(Coordinates reference, int n) {
        List<Feature> sortedTop = new ArrayList<>(n);
        Queue<Feature> top = MinMaxPriorityQueue.orderedBy(new SortByProximity(reference)).maximumSize(n).create();
        top.addAll(this.earthquakes.getFeatures());

        Feature last;
        while((last = top.poll()) != null) {
            sortedTop.add(last);
        }
        return sortedTop;
    }

}
