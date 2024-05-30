package AdditionalTask;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class SquareTest {
    // Creating a square with valid coordinates
    @Test
    public void test_create_square_with_valid_coordinates() {
        Square square = new Square(0, 0, 1, 1);
        assertNotNull(square);
        assertEquals(0, square.getX1());
        assertEquals(0, square.getY1());
        assertEquals(1, square.getX2());
        assertEquals(1, square.getY2());
    }

    // Calculating intersections between overlapping squares
    @Test
    public void test_calculating_intersections_overlapping_squares() {
        Square a = new Square(0, 0, 1, 1);
        Square b = new Square(0.5, 0.5, 1.5, 1.5);
        List<Point> expectedIntersections = new ArrayList<>();

        expectedIntersections.add(new Point(1, 0.5));
        expectedIntersections.add(new Point(0.5,1));

        assertEquals(expectedIntersections, Square.intersections(a, b));
    }

    // Calculating intersections between non-overlapping squares
    @Test
    public void test_calculate_intersections_non_overlapping_squares() {
        Square a = new Square(0, 0, 1, 1);
        Square b = new Square(2, 2, 3, 3);
        List<Point> result = Square.intersections(a, b);
        assertTrue(result.isEmpty());
    }

    // Calculating intersections between adjacent squares
    @Test
    public void test_calculate_intersections_adjacent_squares() {
        Square a = new Square(0, 0, 1, 1);
        Square b = new Square(1, 0, 2, 1);

        List<Point> expectedIntersections = new ArrayList<>();
        expectedIntersections.add(new Point(1, 0));
        expectedIntersections.add(new Point(1, 1));

        List<Point> actualIntersections = Square.intersections(a, b);

        assertEquals(expectedIntersections, actualIntersections);
    }

    // Getting the top-right point of a square
    @Test
    public void test_get_top_right_point() {
        Square square = new Square(0, 0, 2, 2);
        Point topRight = square.getTopRight();
        assertEquals(2.0, topRight.getX(), 0.0001);
        assertEquals(2.0, topRight.getY(), 0.0001);
    }

    // Getting the bottom-left point of a square
    @Test
    public void test_get_bottom_left_point() {
        Square square = new Square(1, 2, 3, 4);
        Point bottomLeft = square.getBottomLeft();
        assertEquals(1.0, bottomLeft.getX(), 0.0001);
        assertEquals(2.0, bottomLeft.getY(), 0.0001);
    }

    // Getting the bottom-right point of a square
    @Test
    public void test_get_bottom_right_point() {
        Square square = new Square(0, 0, 2, 2);
        Point bottomRight = square.getBottomRight();
        assertEquals(2.0, bottomRight.getX(), 0.0001);
        assertEquals(0.0, bottomRight.getY(), 0.0001);
    }

    // Getting the top-left point of a square
    @Test
    public void test_get_top_left_point() {
        Square square = new Square(1, 2, 3, 4);
        Point expected = new Point(1, 4);
        Point actual = square.getTopLeft();
        assertEquals(expected, actual);
    }

    // Creating a square with invalid coordinates (x1 > x2 or y1 > y2)
    @Test
    public void test_invalid_coordinates_creation() {
        try {
            Square square = new Square(1, 1, 0, 0);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    // Calculating intersections when squares are touching at a single point
    @Test
    public void test_calculate_intersections_when_touching_at_single_point() {
        Square a = new Square(0, 0, 1, 1);
        Square b = new Square(1, 1, 2, 2);
        List<Point> expectedIntersections = new ArrayList<>();
        expectedIntersections.add(new Point(1, 1));
        List<Point> actualIntersections = Square.intersections(a, b);
        assertEquals(expectedIntersections, actualIntersections);
    }

    // Calculating intersections when squares are touching along an edge
    @Test
    public void test_calculating_intersections_touching_angle() {
        Square a = new Square(0, 0, 1, 1);
        Square b = new Square(0.5, 0, 1, 0.5);

        List<Point> expectedIntersections = new ArrayList<>();
        expectedIntersections.add(new Point(1, 0));
        expectedIntersections.add(new Point(0.5, 0));
        expectedIntersections.add(new Point(1, 0.5));
        List<Point> actualIntersections = Square.intersections(a, b);

        assertEquals(expectedIntersections, actualIntersections);
    }

    // Calculating intersections when one square is completely inside another
    @Test
    public void test_intersection_inside() {
        Square a = new Square(0, 0, 2, 2);
        Square b = new Square(1, 0.5, 2, 1.5);
        List<Point> expected = Arrays.asList(new Point(2, 0.5), new Point(2, 1.5));
        List<Point> actual = Square.intersections(a, b);
        assertEquals(expected, actual);
    }

    // Ensuring no duplicate intersection points are returned
    @Test
    public void test_no_duplicate_intersection_points() {
        Square a = new Square(0, 0, 1, 1);
        Square b = new Square(0.5, 0.5, 1.5, 1.5);
        List<Point> intersections = Square.intersections(a, b);
        assertEquals(2, intersections.size());
    }

    // Validating the line-line intersection logic
    @Test
    public void test_line_line_intersection_logic() {
        Square a = new Square(0, 0, 1, 1);
        Square b = new Square(0.5, 0.5, 1.5, 1.5);
        List<Point> intersectionPoints = Square.intersections(a, b);
        assertEquals(2, intersectionPoints.size());
        assertEquals(new Point(1, 0.5), intersectionPoints.get(0));
    }

    // Handling negative coordinates for squares
    @Test
    public void test_handling_negative_coordinates() {
        Square a = new Square(-1, -1, 1, 1);
        Square b = new Square(-2, -2, 0, 0);

        List<Point> expected = new ArrayList<>();
        expected.add(new Point(0, -1));
        expected.add(new Point(-1, 0));

        List<Point> actual = Square.intersections(a, b);
        assertEquals(expected, actual);
    }
}