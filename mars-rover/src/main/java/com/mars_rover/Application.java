package com.mars_rover;

import com.mars_rover.Coordinates.Coordinate;
import com.mars_rover.Planet.Planet;
import com.mars_rover.Robot.Mobility.Orientation;
import com.mars_rover.Robot.Robot;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-13
 */
public class Application {
    public static void main(String[] args) {
        int planetWidth = 5;
        int planetHeight = 5;
        Planet planetMars = new Planet(planetWidth, planetHeight);
        Coordinate robotCoordinate = new Coordinate(1, 2);
        Orientation robotDirection = Orientation.NORTH;

        Robot robot = new Robot(planetMars.map(), robotCoordinate, robotDirection);
        robot.rotateLeft();
        robot.moveForward();
        robot.rotateLeft();
        robot.moveForward();
        robot.rotateLeft();
        robot.moveForward();
        robot.rotateLeft();
        robot.moveForward();

        Coordinate lastRobotCoordinate = robot.moveForward();

        System.out.println(
            "Robot position is: "
            +lastRobotCoordinate.horizontalPoint()
            +"/"+lastRobotCoordinate.verticalPoint()
            +" facing "
            +robot.currentOrientation()
        );
    }
}
