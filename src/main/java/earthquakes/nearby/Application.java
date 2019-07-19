package earthquakes.nearby;

import java.io.IOException;
import java.util.List;

public class Application {

    private static int size = 10;

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
        try {
            NearestEarthquakes ne = new NearestEarthquakes(USGSEarthquakes.initializeEarthQuakes());
            List<Feature> nearest10Features = ne.getNClosestFeatures(reference, size);
            nearest10Features.stream().forEach(f -> System.out.println(f.getTitle() + " || " + (int) reference.calculateDistanceTo(f.getCoordinates())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
