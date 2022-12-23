package leo.main;

import java.util.List;
import java.util.stream.Collectors;

public class Screen {

    private static int width;
    private static int height;

    public static Polygon convert(Polygon polygon) {
        List<Point> points = polygon.getPoints().stream()
                .map(Screen::convert)
                .collect(Collectors.toList());
        return new Polygon(polygon.getColor(), points);
    }

    public static Point convert(Point p) {
        return new Point((p.getX() + width)/2, (p.getY() + height)/2, p.getZ());
    }

    public static void setSize(int width, int height) {
        Screen.width = width;
        Screen.height = height;
    }
}
