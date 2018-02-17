package com.marsrover.controller;

import com.marsrover.coordinates.Coordinate;
import com.marsrover.robot.Mobility.Orientation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-15
 */
final public class RobotState {
    private Coordinate coordinate;
    private Orientation orientation;
    private List<String> errors;

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
