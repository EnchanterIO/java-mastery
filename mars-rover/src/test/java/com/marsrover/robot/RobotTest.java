package com.marsrover.robot;

import com.marsrover.coordinates.Coordinate;
import com.marsrover.planet.Planet;
import com.marsrover.robot.Mobility.Orientation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * No need to mock the dependencies of the robot as in this case
 * no infrastructure is involved and we can test everything by passing
 * real dependencies which will automatically test these as well.
 *
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-13
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

        assertEquals(
            "robot vertical coordinate should have been increased.",
            robot.currentCoordinate().verticalPoint(),
            verticalPoint + 1
        );

        assertEquals(
            "robot horizontal coordinate should not be changed.",
            robot.currentCoordinate().horizontalPoint(),
            horizontalPoint
        );
    }

    @Test
    public void movingEastShouldChangeHorizontalCoordinate() {
        robot.rotateRight();
        robot.moveForward();

        assertEquals(
            "robot horizontal coordinate should have been increased.",
            robot.currentCoordinate().horizontalPoint(),
            horizontalPoint + 1
        );

        assertEquals(
            "robot vertical coordinate should not be changed.",
            robot.currentCoordinate().verticalPoint(),
            verticalPoint
        );
    }

    @Test
    public void movingWestShouldChangeHorizontalCoordinate() {
        robot.rotateLeft();
        robot.moveForward();

        assertEquals(
            "robot horizontal coordinate should have been increased.",
            robot.currentCoordinate().horizontalPoint(),
            horizontalPoint - 1
        );

        assertEquals(
            "robot vertical coordinate should not be changed.",
            robot.currentCoordinate().verticalPoint(),
            verticalPoint
        );
    }

    @Test
    public void movingSouthShouldChangeVerticalCoordinate() {
        robot.rotateLeft();
        robot.rotateLeft();
        robot.moveForward();

        assertEquals(
            "robot vertical coordinate should have been decreased.",
            robot.currentCoordinate().verticalPoint(),
            verticalPoint - 1
        );

        assertEquals(
            "robot horizontal coordinate should not be changed.",
            robot.currentCoordinate().horizontalPoint(),
            horizontalPoint
        );
    }
}