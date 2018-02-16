package com.mars_rover.RobotInstructionsController;

import com.mars_rover.Coordinates.Coordinate;
import com.mars_rover.Planet.Planet;
import com.mars_rover.Robot.Mobility.Orientation;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since 2018-02-15
 */
public class RobotInstructionsInputParser {
    private static Planet parsePlanet(String instructions) throws IllegalArgumentException {
        try {
            int planetWidth = Character.getNumericValue(instructions.charAt(0));
            int planetHeight = Character.getNumericValue(instructions.charAt(2));

            return new Planet(planetWidth, planetHeight);
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception.getMessage(), exception);
        }
    }

    public static ArrayList<RobotInstructions> parseInstructions(String instructions) throws IllegalArgumentException {
        Planet planet = parsePlanet(instructions);
        String instructionsWithoutPlanet = removePlanet(instructions);
        Matcher matcher = createParser(instructionsWithoutPlanet);

        validateInput(matcher, instructionsWithoutPlanet);

        ArrayList<RobotInstructions> robotInstructions = new ArrayList<>();

        while (matcher.find()) {
            robotInstructions.add(
                new RobotInstructions(
                    planet,
                    parseCoordinate(matcher.group("coordinate")),
                    parseOrientation(matcher.group("orientation")),
                    parseMovements(matcher.group("movements"))
                )
            );
        }

        return robotInstructions;
    }

    private static void validateInput(Matcher matcher, String input) throws IllegalArgumentException {
        if (matcher.groupCount() != 3) {
            throw new IllegalArgumentException(
                String.format(
                    "Unable to parse RobotInstructions from input: '%s'!",
                    input
                )
            );
        }
    }

    private static Matcher createParser(String instructionsWithoutPlanet) {
        String regex = "(?<coordinate>\\d\\s\\d\\s)(?<orientation>\\w)\\s(?<movements>\\w*)";
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(instructionsWithoutPlanet);
    }

    private static String removePlanet(String instructions) {
        return instructions.substring(4);
    }

    private static Coordinate parseCoordinate(String rawCoordinate) {
        return new Coordinate(
            Character.getNumericValue(rawCoordinate.charAt(0)),
            Character.getNumericValue(rawCoordinate.charAt(2))
        );
    }

    private static Orientation parseOrientation(String rawOrientation) {
        return OrientationInstruction.valueOf(rawOrientation).orientation();
    }

    private static MovementInstruction[] parseMovements(String rawConcatenatedMovements) {
        char[] rawMovements = rawConcatenatedMovements.toCharArray();

        MovementInstruction[] movements = new MovementInstruction[rawMovements.length];

        for (int i = 0; i < rawMovements.length; i++) {
            movements[i] = MovementInstruction.valueOf(Character.toString(rawMovements[i]));
        }

        return movements;
    }
}
