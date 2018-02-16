package com.marsrover.robot.Mobility;

import com.marsrover.coordinates.Coordinate;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-15
 */
public interface SurfacePlan {
    boolean hasCoordinate(Coordinate coordinate);
}
