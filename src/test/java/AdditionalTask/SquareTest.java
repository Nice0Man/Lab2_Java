package AdditionalTask;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    @Test
    void test_intersections_equals() {
        Square square1 = new Square(new Point(0, 4), new Point(4, 0));
        Square square2 = new Square(new Point(0, 4),new Point(4, 0));

        List<Point> expectedIntersections = new ArrayList<>();
        expectedIntersections.add(new Point(0, 4));
        expectedIntersections.add(new Point(4, 0));

        List<Point> actualIntersections = Square.intersections(square1, square2);

        assertEquals(expectedIntersections.size(), actualIntersections.size());
        assertEquals(expectedIntersections.getFirst(), actualIntersections.getFirst());
    }

    @Test
    void test_intersections_in_1_point() {
        Square square1 = new Square(new Point(0, 4), new Point(4, 0));
        Square square2 = new Square(new Point(4, 0),new Point(10, -10));

        List<Point> expectedIntersections = new ArrayList<>();
        expectedIntersections.add(new Point(4, 0));

        List<Point> actualIntersections = Square.intersections(square1, square2);

        assertEquals(expectedIntersections.size(), actualIntersections.size());
        assertEquals(expectedIntersections.getFirst(), actualIntersections.getFirst());
    }

    @Test
    void test_intersections_in_2_points() {
        Square square1 = new Square(new Point(0, 4), new Point(4, 0));
        Square square2 = new Square(new Point(4, 2),new Point(6, -2));

        List<Point> expectedIntersections = new ArrayList<>();
        expectedIntersections.add(new Point(4, 2));
        expectedIntersections.add(new Point(4,0));

        List<Point> actualIntersections = Square.intersections(square1, square2);

        assertEquals(expectedIntersections.size(), actualIntersections.size());
        assertEquals(expectedIntersections.getFirst(), actualIntersections.getFirst());
    }
}