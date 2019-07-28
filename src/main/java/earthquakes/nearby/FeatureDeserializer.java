package earthquakes.nearby;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class FeatureDeserializer extends StdDeserializer<Feature> {

    public FeatureDeserializer() {
        this(null);
    }

    public FeatureDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Feature deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);

        String title = root.get("properties").get("title").asText();
        double lat = root.get("geometry").get("coordinates").get(1).asDouble();
        double lon = root.get("geometry").get("coordinates").get(0).asDouble();
        return new Feature(title, new Coordinates(lat, lon));
    }
}
