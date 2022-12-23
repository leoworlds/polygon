package leo.main;

import java.util.List;
import java.util.stream.Collectors;

public class Perspective {

    private static final int FOCUS = 500;

    public static int convert(int p, int z) {
        return FOCUS * p / z;
    }

    public static Point convert(Point p) {
        return new Point(
                convert(p.getX(), p.getZ()),
                convert(p.getY(), p.getZ()),
                p.getZ());
    }

    public static Polygon convert(Polygon polygon) {
        List<Point> points = polygon.getPoints().stream()
                .map(Perspective::convert)
                .collect(Collectors.toList());

        return new Polygon(polygon.getColor(), points);
    }
}
