import earthquakes.nearby.USGSEarthquakes;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class USGSEarthquakesTest {

    @Test
    public void externalServiceWorks() throws IOException {
        URL service = new URL(USGSEarthquakes.getUrl());
        HttpURLConnection connection = (HttpURLConnection) service.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int code = connection.getResponseCode();
        assertEquals(200, code);
    }
}
