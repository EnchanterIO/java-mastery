package com.mars_rover.Robot.Mobility;

import com.mars_rover.Coordinates.Coordinate;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since 2018-02-15
 */
public class OutOfMapException extends RuntimeException {
    public OutOfMapException(Coordinate coordinate) {
        super(
            String.format(
                "Robot got lost by entering unmapped coordinate %d,%d!",
                coordinate.horizontalPoint(),
                coordinate.verticalPoint()
            )
        );
    }
}
