package leo.main;

import lombok.Data;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

@Data
public class Polygon {
    private Color color;
    private List<Vertex> vertices;

    public Polygon(Color color, Vertex... vertices) {
        this.color = color;
        this.vertices = Arrays.asList(vertices);
    }

    public Polygon(Color color, List<Vertex> vertices) {
        this.color = color;
        this.vertices = vertices;
    }
}
