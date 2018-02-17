package com.marsrover;

import com.marsrover.controller.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-16
 */
public final class Application {
    public static String run(String input) throws IllegalApplicationInstructionsException {
        List<RobotInstructions>robotsInstructions = RobotInstructionsInputParser.parseInstructions(input);

        List<String> robotsOutputs = new ArrayList<>();

        for (RobotInstructions robotInstructions : robotsInstructions) {
            RobotState robotState = RobotInstructionsController.execute(robotInstructions);

            robotsOutputs.add(String.format(
                "%d %d %s",
                robotState.coordinate().horizontalPoint(),
                robotState.coordinate().verticalPoint(),
                robotState.orientationInstructionAsString()
            ));
        }

        return String.join(" ", robotsOutputs);
    }
}
