package earthquakes.nearby;

import java.util.Objects;

public final class Coordinates {

    private static final int EARTH_RADIUS = 6371;

    private final double lat;
    private final double lon;

    public Coordinates(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    /**
     * Calculates distance to passed Coordinates by haversine formula
     * @param coordinates Coordinates to get distance with
     * @return distance between Coordinates
     */
    public double calculateDistanceTo(Coordinates coordinates) {
        double dLat  = Math.toRadians((this.lat - coordinates.lat));
        double dLong = Math.toRadians((this.lon - coordinates.lon));

        double startLat = Math.toRadians(this.lat);
        double endLat   = Math.toRadians(this.lon);

        double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Double.compare(that.lat, lat) == 0 && Double.compare(that.lon, lon) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lon);
    }

    private static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }
}
