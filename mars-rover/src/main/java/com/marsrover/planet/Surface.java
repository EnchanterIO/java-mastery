package com.marsrover.planet;

import com.marsrover.coordinates.Coordinate;
import com.marsrover.robot.Mobility.SurfacePlan;

/**
 * Every planet has a flat rectangular surface.
 *
 * The size of the planet is defined with Width and Height which is
 * behind the scenes translated into the Coordinate system of points.
 *
 * The minimum Coordinate is un-configurable 0,0 by default.
 *
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-13
 */
class Surface implements SurfacePlan {
    private final Coordinate highestCoordinate;
    private final Coordinate lowestCoordinate;

    public Surface(int width, int height) {
        this.highestCoordinate = new Coordinate(width, height);
        this.lowestCoordinate = new Coordinate(0, 0);
    }

    public boolean hasCoordinate(Coordinate coordinate) {
         return
             coordinate.horizontalPoint() <= highestCoordinate.horizontalPoint()
             && coordinate.verticalPoint() <= highestCoordinate.verticalPoint()
             && coordinate.horizontalPoint() >= lowestCoordinate.horizontalPoint()
             && coordinate.horizontalPoint() >= lowestCoordinate.verticalPoint();
    }
}
