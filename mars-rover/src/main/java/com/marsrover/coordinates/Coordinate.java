package com.marsrover.coordinates;

/**
 * Coordinate is responsible for uniquely identifying a specific Point
 * on a planet.
 *
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-13
 */
public class Coordinate {
    private int horizontalPoint;
    private int verticalPoint;

    public Coordinate(int horizontalPoint, int verticalPoint) {
        this.horizontalPoint = horizontalPoint;
        this.verticalPoint = verticalPoint;
    }

    public int horizontalPoint() {
        return horizontalPoint;
    }

    public int verticalPoint() {
        return verticalPoint;
    }
}
