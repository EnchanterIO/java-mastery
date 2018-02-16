package com.marsrover.controller;

import com.marsrover.robot.Mobility.MoveOutOfSurfacePlanRefusedException;
import com.marsrover.robot.Robot;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since 2018-02-15
 */
public class RobotInstructionsController {
    public static RobotState execute(RobotInstructions robotInstructions) {
        Robot robot = new Robot(
            robotInstructions.planet().map(),
            robotInstructions.coordinate(),
            robotInstructions.orientation()
        );

        try {
            for (MovementInstruction movementInstruction : robotInstructions.movementInstructions()) {
                switch (movementInstruction) {
                    case M:
                        robot.moveForward();
                        break;
                    case L:
                        robot.rotateLeft();
                        break;
                    case R:
                        robot.rotateRight();
                        break;
                }
            }
        } catch (MoveOutOfSurfacePlanRefusedException exception) {
            RobotState robotState = new RobotState(robot.currentCoordinate(), robot.currentOrientation());
            robotState.addError(exception.getMessage());

            return robotState;
        }

        return new RobotState(robot.currentCoordinate(), robot.currentOrientation());
    }
}
