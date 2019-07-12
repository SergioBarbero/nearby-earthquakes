package earthquakes.nearby;

import java.util.List;

public class RendererFeatureDistance implements Renderer {

    List<Feature> earthquakes;
    Coordinates reference;

    public RendererFeatureDistance(List<Feature> earthquakes,Coordinates reference) {
        this.earthquakes = earthquakes;
        this.reference = reference;
    }

    @Override
    public void render() {
        earthquakes.stream().forEach(f -> System.out.println(f.getTitle() + " | " + f.getCoordinates().calculateDistanceTo(reference)));
    }
}
