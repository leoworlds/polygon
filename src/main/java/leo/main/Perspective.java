package leo.main;

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
}
