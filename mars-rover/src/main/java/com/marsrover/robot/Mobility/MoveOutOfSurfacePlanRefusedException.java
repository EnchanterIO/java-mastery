package com.marsrover.robot.Mobility;

import com.marsrover.coordinates.Coordinate;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-15
 */
public class MoveOutOfSurfacePlanRefusedException extends RuntimeException {
    MoveOutOfSurfacePlanRefusedException(Coordinate coordinate) {
        super(
            String.format(
                "Calculated coordinate %d,%d is not on the map! Robot won't move.",
                coordinate.horizontalPoint(),
                coordinate.verticalPoint()
            )
        );
    }
}
