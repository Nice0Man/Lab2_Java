package AdditionalTask;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public final class Point {

    private final double x;

    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }
}
