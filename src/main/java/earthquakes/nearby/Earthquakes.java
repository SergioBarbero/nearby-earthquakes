package earthquakes.nearby;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.MinMaxPriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Earthquakes {

    @JsonIgnore
    private Coordinates reference;
    private Set<Feature> features;

    public Set<Feature> getFeatures() {
        return features;
    }

    public Coordinates getReference() {
        return reference;
    }

    public void setReference(Coordinates reference) {
        this.reference = reference;
    }

    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }

    public List<Feature> getNClosestFeatures(int n) {
        List<Feature> sortedTop = new ArrayList<>(n);
        Queue<Feature> top = MinMaxPriorityQueue.orderedBy(new SortByProximity(reference)).maximumSize(n).create();
        top.addAll(this.features);

        Feature last;
        while((last = top.poll()) != null) {
            sortedTop.add(last);
        }
        return sortedTop;
    }
}
