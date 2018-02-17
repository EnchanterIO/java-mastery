package com.marsrover;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * A functional test validating NewRelic challenge Input and Output.
 *
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-13
 */
@RunWith(Parameterized.class)
public class ApplicationTest {
    private String input;
    private String expectedOutput;
    private Application application;

    public ApplicationTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.application = new Application();
    }

    @Parameterized.Parameters
    public static Collection configureFixtures() {
        return Arrays.asList(new Object[][] {
            { "5 5 1 2 N LMLMLMLMM", "1 3 N" },
            { "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM", "1 3 N 5 1 E" },
            { "5 5 1 2 N LMMMMMMMM", "0 2 W" },
        });
    }

    @Test
    public void validateApplication() {
        assertEquals(
            "robot should finish in expected coordinate.",
            application.run(input),
            expectedOutput
        );
    }
}