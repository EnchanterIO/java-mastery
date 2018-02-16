package com.mars_rover.RobotInstructionsController;

import com.mars_rover.Robot.Mobility.MoveOutOfMapRefusedException;
import com.mars_rover.Robot.Robot;

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
        } catch (MoveOutOfMapRefusedException exception) {
            RobotState robotState = new RobotState(robot.currentCoordinate(), robot.currentOrientation());
            robotState.addError(exception.getMessage());

            return robotState;
        }

        return new RobotState(robot.currentCoordinate(), robot.currentOrientation());
    }
}
