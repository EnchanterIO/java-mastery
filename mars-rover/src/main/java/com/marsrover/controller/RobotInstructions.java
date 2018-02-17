package com.marsrover.controller;

import com.marsrover.coordinates.Coordinate;
import com.marsrover.planet.Planet;
import com.marsrover.robot.Mobility.Orientation;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since 2018-02-15
 */
final public class RobotInstructions {
    private Planet planet;
    private Coordinate coordinate;
    private Orientation orientation;
    private MovementInstruction[] movementInstructions;

    RobotInstructions(Planet planet, Coordinate coordinate, Orientation orientation, MovementInstruction[] movementInstructions) {
        this.planet = planet;
        this.coordinate = coordinate;
        this.orientation = orientation;
        this.movementInstructions = movementInstructions;
    }

    public Planet planet() {
        return planet;
    }

    public Coordinate coordinate() {
        return coordinate;
    }

    public Orientation orientation() {
        return orientation;
    }

    public MovementInstruction[] movementInstructions() {
        return movementInstructions;
    }
}
