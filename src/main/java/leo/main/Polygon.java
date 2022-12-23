package leo.main;

import lombok.Data;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

@Data
public class Polygon {
    private Color color;
    private List<Point> points;

    public Polygon(Color color, Point... points) {
        this.color = color;
        this.points = Arrays.asList(points);
    }

    public Polygon(Color color, List<Point> points) {
        this.color = color;
        this.points = points;
    }
}
