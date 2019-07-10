package earthquakes.nearby;

import com.fasterxml.jackson.core.JsonFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class Application {

    static ObjectMapper mapper = new ObjectMapper();

    public static void main(String args[]) {
        String url = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson";
        JsonFactory jsonFactory = new JsonFactory();
        Earthquakes information = null;
        try {
            Earthquakes earthquakes = new ObjectMapper().readValue(new URL(url), Earthquakes.class);
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
