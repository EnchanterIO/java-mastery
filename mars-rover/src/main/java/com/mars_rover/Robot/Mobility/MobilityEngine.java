package com.mars_rover.Robot.Mobility;

import com.mars_rover.Coordinates.Coordinate;

/**
 * Responsible for handling Robot movements such a rotation and its position.
 *
 * The Robot is booted up with externally given Map and Coordinates.
 * In the future, the Map could be updated on the fly as some more sophisticated
 * Robot vision could be introduced that would identify the surroundings.
 *
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-14
 */
public class MobilityEngine {
    private final Map map;
    private Coordinate currentCoordinate;
    private Orientation orientation;

    public MobilityEngine(Map map, Coordinate coordinate, Orientation orientation) {
        this.map = map;
        this.currentCoordinate = coordinate;
        this.orientation = orientation;
    }

    public Coordinate moveForward() throws OutOfMapException {
        int horizontalPoint = currentCoordinate.horizontalPoint();
        int verticalPoint = currentCoordinate.verticalPoint();

        switch (orientation) {
            case NORTH:
                verticalPoint++;
                break;

            case SOUTH:
                verticalPoint--;
                break;

            case EAST:
                horizontalPoint++;
                break;

            case WEST:
                horizontalPoint--;
                break;
        }

        Coordinate newCoordinate = new Coordinate(horizontalPoint, verticalPoint);

        if (map.hasCoordinate(newCoordinate)) {
            currentCoordinate = newCoordinate;

            return currentCoordinate;
        }

        throw new OutOfMapException(newCoordinate);
    }

    public void rotateLeft() {
        switch (orientation) {
            case NORTH:
                orientation = Orientation.WEST;
                break;

            case WEST:
                orientation = Orientation.SOUTH;
                break;

            case SOUTH:
                orientation = Orientation.EAST;
                break;

            case EAST:
                orientation = Orientation.NORTH;
                break;
        }
    }

    public void rotateRight() {
        switch (orientation) {
            case NORTH:
                orientation = Orientation.EAST;
                break;

            case EAST:
                orientation = Orientation.SOUTH;
                break;

            case SOUTH:
                orientation = Orientation.WEST;
                break;

            case WEST:
                orientation = Orientation.NORTH;
                break;
        }
    }

    public Orientation currentOrientation() {
        return orientation;
    }
}
