package com.mars_rover;

import com.mars_rover.RobotInstructionsController.RobotInstructions;
import com.mars_rover.RobotInstructionsController.RobotInstructionsController;
import com.mars_rover.RobotInstructionsController.RobotInstructionsInputParser;
import com.mars_rover.RobotInstructionsController.RobotState;

import java.util.ArrayList;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-16
 */
public class Application {
    public static String runApplication(String input) {
        ArrayList<String> robotsOutputs = new ArrayList<>();
        ArrayList<RobotInstructions> robotsInstructions = new ArrayList<>();

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
