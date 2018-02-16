package com.mars_rover.RobotInstructionsController;

import com.mars_rover.Coordinates.Coordinate;
import com.mars_rover.Planet.Planet;
import com.mars_rover.Robot.Mobility.Orientation;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since 2018-02-15
 */
public class RobotInstructions {
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
