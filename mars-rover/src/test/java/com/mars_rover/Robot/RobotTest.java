package com.mars_rover.Robot;

import com.mars_rover.Coordinates.Coordinate;
import com.mars_rover.Planet.Planet;
import com.mars_rover.Robot.Mobility.Orientation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * No need to mock the dependencies of the Robot as in this case
 * no infrastructure is involved and we can test everything by passing
 * real dependencies which will automatically test these as well.
 */
public class RobotTest {
    private final int horizontalPoint = 1;
    private final int verticalPoint = 2;
    private Robot robot;

    @Before
    public void setUp() {
        Planet planet = new Planet(5, 5);

        robot = new Robot(
            planet.map(),
            new Coordinate(horizontalPoint, verticalPoint),
            Orientation.NORTH
        );
    }

    @Test
    public void movingNorthShouldChangeVerticalCoordinate() {
        robot.moveForward();

        assertTrue(
            "Robot vertical coordinate should have been increased.",
            robot.currentCoordinate().verticalPoint() == verticalPoint + 1
        );
        assertTrue(
            "Robot horizontal coordinate should not be changed.",
            robot.currentCoordinate().horizontalPoint() == horizontalPoint
        );
    }

    @Test
    public void movingEastShouldChangeHorizontalCoordinate() {
        robot.rotateRight();
        robot.moveForward();

        assertTrue(
            "Robot horizontal coordinate should have been increased.",
            robot.currentCoordinate().horizontalPoint() == horizontalPoint + 1
        );
        assertTrue(
            "Robot vertical coordinate should not be changed.",
            robot.currentCoordinate().verticalPoint() == verticalPoint
        );
    }

    @Test
    public void movingWestShouldChangeHorizontalCoordinate() {
        robot.rotateLeft();
        robot.moveForward();

        assertTrue(
            "Robot horizontal coordinate should have been increased.",
            robot.currentCoordinate().horizontalPoint() == horizontalPoint - 1
        );
        assertTrue(
            "Robot vertical coordinate should not be changed.",
            robot.currentCoordinate().verticalPoint() == verticalPoint
        );
    }

    @Test
    public void movingSouthShouldChangeVerticalCoordinate() {
        robot.rotateLeft();
        robot.rotateLeft();
        robot.moveForward();

        assertTrue(
            "Robot vertical coordinate should have been decreased.",
            robot.currentCoordinate().verticalPoint() == verticalPoint - 1
        );
        assertTrue(
            "Robot horizontal coordinate should not be changed.",
            robot.currentCoordinate().horizontalPoint() == horizontalPoint
        );
    }
}