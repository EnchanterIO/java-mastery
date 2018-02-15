package com.mars_rover.Robot;

import com.mars_rover.Coordinates.Coordinate;
import com.mars_rover.Robot.Mobility.Map;
import com.mars_rover.Robot.Mobility.MobilityEngine;
import com.mars_rover.Robot.Mobility.Orientation;
import com.mars_rover.Robot.Mobility.OutOfMapException;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-13
 */
public class Robot {
    private MobilityEngine mobilityEngine;

    public Robot(Map map, Coordinate coordinate, Orientation orientation) {
        mobilityEngine = new MobilityEngine(map, coordinate, orientation);
    }

    public Coordinate moveForward() throws OutOfMapException {
        return mobilityEngine.moveForward();
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
}
