package com.marsrover.robot;

import com.marsrover.coordinates.Coordinate;
import com.marsrover.robot.Mobility.SurfacePlan;
import com.marsrover.robot.Mobility.MobilityEngine;
import com.marsrover.robot.Mobility.Orientation;
import com.marsrover.robot.Mobility.MoveOutOfSurfacePlanRefusedException;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-13
 */
final public class Robot {
    private MobilityEngine mobilityEngine;

    public Robot(SurfacePlan surfacePlan, Coordinate coordinate, Orientation orientation) {
        mobilityEngine = new MobilityEngine(surfacePlan, coordinate, orientation);
    }

    public void moveForward() throws MoveOutOfSurfacePlanRefusedException {
        mobilityEngine.moveForward();
    }

    public void rotateLeft() {
        mobilityEngine.rotateLeft();
    }

    public void rotateRight() {
        mobilityEngine.rotateRight();
    }

    public Orientation currentOrientation() {
        return mobilityEngine.currentOrientation();
    }

    public Coordinate currentCoordinate() {
        return mobilityEngine.currentCoordinate();
    }
}
