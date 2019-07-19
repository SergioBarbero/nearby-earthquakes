package earthquakes.nearby;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class USGSEarthquakes implements Earthquakes {

    private static final String url = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson";
    private Set<Feature> features;

    public static Earthquakes initializeEarthQuakes() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new URL(url), USGSEarthquakes.class);
    }

    public Set<Feature> getFeatures() {
        return features;
    }

    public static String getUrl() {
        return url;
    }

    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }
}
