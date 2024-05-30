package AdditionalTask;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Square {
    private final double x1, y1, x2, y2;

    public Square(double x1, double y1, double x2, double y2) {
        if (x1 > x2 || y1 > y2) {
            throw new IllegalArgumentException("Coordinates are invalid");
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Square(Point p1, Point p2) {
        this(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public Point getBottomLeft() {
        return new Point(this.x1, this.y1);
    }

    public Point getTopRight() {
        return new Point(this.x2, this.y2);
    }

    public Point getBottomRight() {
        return new Point(this.x2, this.y1);
    }

    public Point getTopLeft() {
        return new Point(this.x1, this.y2);
    }

    public static List<Point> intersections(Square s1, Square s2) {
        List<Point> intersectionPoints = new ArrayList<>();

        Point A1 = s1.getBottomLeft();
        Point B1 = s1.getBottomRight();
        Point C1 = s1.getTopRight();
        Point D1 = s1.getTopLeft();

        Point A2 = s2.getBottomLeft();
        Point B2 = s2.getBottomRight();
        Point C2 = s2.getTopRight();
        Point D2 = s2.getTopLeft();

        Point[][] edges1 = {{A1, B1}, {B1, C1}, {C1, D1}, {D1, A1}};
        Point[][] edges2 = {{A2, B2}, {B2, C2}, {C2, D2}, {D2, A2}};

        for (Point[] edge1 : edges1) {
            for (Point[] edge2 : edges2) {
                Point intersection = lineLineIntersection(edge1[0], edge1[1], edge2[0], edge2[1]);
                if (intersection.getX() != Double.MAX_VALUE && intersection.getY() != Double.MAX_VALUE) {
                    if (!intersectionPoints.contains(intersection)) {
                        intersectionPoints.add(intersection);
                    }
                }
            }
        }

        return intersectionPoints;
    }

    private static Point lineLineIntersection(Point A, Point B, Point C, Point D) {
        double a1 = B.getY() - A.getY();
        double b1 = A.getX() - B.getX();
        double c1 = a1 * A.getX() + b1 * A.getY();

        double a2 = D.getY() - C.getY();
        double b2 = C.getX() - D.getX();
        double c2 = a2 * C.getX() + b2 * C.getY();

        double determinant = a1 * b2 - a2 * b1;

        if (determinant == 0) {
            return new Point(Double.MAX_VALUE, Double.MAX_VALUE);
        } else {
            double x = (b2 * c1 - b1 * c2) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;

            if (isBetween(A, B, new Point(x, y)) && isBetween(C, D, new Point(x, y))) {
                return new Point(x, y);
            } else {
                return new Point(Double.MAX_VALUE, Double.MAX_VALUE);
            }
        }
    }

    private static boolean isBetween(Point A, Point B, Point C) {
        return (C.getX() >= Math.min(A.getX(), B.getX()) && C.getX() <= Math.max(A.getX(), B.getX()) &&
                C.getY() >= Math.min(A.getY(), B.getY()) && C.getY() <= Math.max(A.getY(), B.getY()));
    }

    public static void main(String[] args) {
        Square a = new Square(0, 0, 1, 1);

        Square b = new Square(0.5, 0.5, 1.5, 1.5);
        System.out.printf("Intersection (Test 1): %s%n", intersections(a, b));

        b = new Square(0.75, 0.25, 1.25, 0.75);
        System.out.printf("Intersection (Test 2): %s%n", intersections(a, b));

        b = new Square(-0.25, -0.25, 0.25, 0.75);
        System.out.printf("Intersection (Test 3): %s%n", intersections(a, b));

        b = new Square(1, 1, 2, 2);
        System.out.printf("Intersection (Test 4): %s%n", intersections(a, b));

        b = new Square(1, -1, 2, 0);
        System.out.printf("Intersection (Test 5): %s%n", intersections(a, b));
    }
}
