package earthquakes.nearby;

import com.fasterxml.jackson.core.JsonFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.source.tree.Tree;

import java.io.IOException;
import java.net.URL;
import java.util.Set;
import java.util.TreeSet;

public class Application {

    static ObjectMapper mapper = new ObjectMapper();

    public static void main(String args[]) {
        Coordinates reference = new Coordinates(40.730610, -73.935242);
        String url = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson";
        JsonFactory jsonFactory = new JsonFactory();
        Earthquakes information = null;
        try {
            Set<Feature> features = new ObjectMapper().readValue(new URL(url), Earthquakes.class).getFeatures();
            TreeSet<Feature> top = new TreeSet<Feature>(new SortByProximity(reference));
            top.addAll(features);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
