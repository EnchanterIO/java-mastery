package com.marsrover.planet;

import com.marsrover.robot.Mobility.SurfacePlan;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-13
 */
public class Planet {
    private final Surface surface;

    public Planet(int width, int height) {
        this.surface = new Surface(width, height);
    }

    public SurfacePlan map() {
        return this.surface;
    }
}
