package earthquakes.nearby;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.MinMaxPriorityQueue;

import java.io.IOException;
import java.net.URL;
import java.util.Set;

public class Application {

    private static int size = 10;
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String args[]) {
        try {
            double lat = Double.parseDouble(args[0]);
            double lon = Double.parseDouble(args[1]);
            checkClosestFeatures(lat, lon);
        } catch (NumberFormatException e) {
            System.out.println("Error, Please, provide numeric latitude and longitude");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error, Please, provide latitude and longitude");
        }
    }

    public static void checkClosestFeatures(double lat, double lon) {
        Coordinates reference = new Coordinates(lat, lon);
        String url = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson";
        try {
            Set<Feature> features = mapper.readValue(new URL(url), Earthquakes.class).getFeatures();
            MinMaxPriorityQueue<Feature> top = MinMaxPriorityQueue.orderedBy(new SortByProximity(reference)).maximumSize(size).create();
            top.addAll(features);

            Feature last;
            while((last = top.poll()) != null) {
                System.out.println(last.getTitle() + " || " + reference.calculateDistanceTo(last.getCoordinates()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
