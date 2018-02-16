package com.mars_rover.Robot.Mobility;

import com.mars_rover.Coordinates.Coordinate;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-15
 */
public class MoveOutOfMapRefusedException extends RuntimeException {
    MoveOutOfMapRefusedException(Coordinate coordinate) {
        super(
            String.format(
                "Calculated coordinate %d,%d is not on the map! Robot won't move.",
                coordinate.horizontalPoint(),
                coordinate.verticalPoint()
            )
        );
    }
}
