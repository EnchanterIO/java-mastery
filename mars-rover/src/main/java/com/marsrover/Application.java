package com.marsrover;

import com.marsrover.controller.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-16
 */
public final class Application {
    private final RobotInstructionsController controller;
    private final RobotInstructionsInputParser parser;

    public Application() {
        controller = new RobotInstructionsController();
        parser = new RobotInstructionsInputParser();
    }

    public String run(String input) throws IllegalApplicationInstructionsException {
        List<RobotInstructions>robotsInstructions = parser.parseInstructions(input);

        List<String> robotsOutputs = new ArrayList<>();

        for (RobotInstructions robotInstructions : robotsInstructions) {
            RobotState robotState = controller.execute(robotInstructions);

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
