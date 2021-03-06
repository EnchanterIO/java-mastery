package com.marsrover.robot.Mobility;

import com.marsrover.coordinates.Coordinate;

/**
 * Responsible for handling robot movements such a rotation and its position.
 *
 * The robot is booted up with externally given SurfacePlan and coordinates.
 * In the future, the SurfacePlan could be updated on the fly as some more sophisticated
 * robot vision could be introduced that would identify the surroundings.
 *
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-14
 */
final public class MobilityEngine {
    private final SurfacePlan surfacePlan;
    private Coordinate currentCoordinate;
    private Orientation orientation;

    public MobilityEngine(SurfacePlan surfacePlan, Coordinate coordinate, Orientation orientation) {
        this.surfacePlan = surfacePlan;
        this.currentCoordinate = coordinate;
        this.orientation = orientation;
    }

    public void moveForward() throws MoveOutOfSurfacePlanRefusedException {
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

        if (surfacePlan.hasCoordinate(newCoordinate)) {
            currentCoordinate = newCoordinate;

            return;
        }

        throw new MoveOutOfSurfacePlanRefusedException(newCoordinate);
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

    public Coordinate currentCoordinate() {
        return currentCoordinate;
    }
}
