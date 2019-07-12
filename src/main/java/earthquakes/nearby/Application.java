package earthquakes.nearby;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Application {

    private static int size = 10;
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String args[]) {
        try {
            double lat =  Math.floor(Double.parseDouble(args[0]) * 100d) / 100d;
            double lon =  Math.floor(Double.parseDouble(args[1]) * 100d) / 100d;
            printClosestFeaturesTo(lat, lon);
        } catch (NumberFormatException e) {
            System.out.println("Error, Please, provide numeric latitude and longitude");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error, Please, provide latitude and longitude");
        }
    }

    public static void printClosestFeaturesTo(double lat, double lon) {
        Coordinates reference = new Coordinates(lat, lon);
        String url = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson";
        try {
            Earthquakes earthquakes = mapper.readValue(new URL(url), Earthquakes.class);
            earthquakes.setReference(reference);

            List<Feature> closestEarthquakes = earthquakes.getNClosestFeatures(size);
            new RendererFeatureDistance(closestEarthquakes, reference).render();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
