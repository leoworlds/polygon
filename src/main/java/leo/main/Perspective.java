package leo.main;

import java.util.List;
import java.util.stream.Collectors;

public class Perspective {

    private static final int FOCUS = 500;

    public static int convert(int p, int z) {
        return FOCUS * p / z;
    }

    public static Vertex convert(Vertex p) {
        return new Vertex(
                convert(p.getX(), p.getZ()),
                convert(p.getY(), p.getZ()),
                p.getZ());
    }

    public static Polygon convert(Polygon polygon) {
        List<Vertex> vertices = polygon.getVertices().stream()
                .map(Perspective::convert)
                .collect(Collectors.toList());

        return new Polygon(polygon.getColor(), vertices);
    }
}
