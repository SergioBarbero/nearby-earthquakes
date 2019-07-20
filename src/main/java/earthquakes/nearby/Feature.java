package earthquakes.nearby;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

@JsonDeserialize(using = FeatureDeserializer.class)
public final class Feature {

    private final String title;
    private final Coordinates coordinates;

    public Feature(String title, Coordinates coordinates) {
        this.title = title;
        this.coordinates = coordinates;
    }

    public String getTitle() {
        return title;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feature feature = (Feature) o;
        return coordinates.equals(feature.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}
