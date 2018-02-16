package com.marsrover;

import com.marsrover.controller.RobotInstructions;
import com.marsrover.controller.RobotInstructionsController;
import com.marsrover.controller.RobotInstructionsInputParser;
import com.marsrover.controller.RobotState;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-16
 */
public class Application {
    public static String runApplication(String input) {
        List<String> robotsOutputs = new ArrayList<>();
        List<RobotInstructions> robotsInstructions = new ArrayList<>();

        try {
            robotsInstructions = RobotInstructionsInputParser.parseInstructions(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            System.exit(1);
        }

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
