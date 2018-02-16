package com.mars_rover.RobotInstructionsController;

import com.mars_rover.Coordinates.Coordinate;
import com.mars_rover.Robot.Mobility.Orientation;

import java.util.ArrayList;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-15
 */
public class RobotState {
    private Coordinate coordinate;
    private Orientation orientation;
    private ArrayList<String> errors;

    RobotState(Coordinate coordinate, Orientation orientation) {
        this.coordinate = coordinate;
        this.orientation = orientation;
        this.errors = new ArrayList<>();
    }

    public void addError(String error) {
        this.errors.add(error);
    }

    public Coordinate coordinate() {
        return coordinate;
    }

    public String orientationInstructionAsString() {
        return OrientationInstruction.fromOrientation(orientation).toString();
    }
}
