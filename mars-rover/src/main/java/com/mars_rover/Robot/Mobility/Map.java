package com.mars_rover.Robot.Mobility;

import com.mars_rover.Coordinates.Coordinate;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since 2018-02-15
 */
public interface Map {
    public boolean hasCoordinate(Coordinate coordinate);
}
