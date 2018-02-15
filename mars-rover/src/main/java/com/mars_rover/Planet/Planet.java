package com.mars_rover.Planet;

import com.mars_rover.Robot.Mobility.Map;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-13
 */
public class Planet {
    private final Surface surface;

    public Planet(int width, int height) {
        this.surface = new Surface(width, height);
    }

    public Map map() {
        return this.surface;
    }
}
