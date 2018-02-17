package com.marsrover;

import com.marsrover.controller.IllegalApplicationInstructionsException;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-13
 */
final public class CliApplication {
    public static void main(String[] args) {
        try {
            System.out.println(new Application().run(args[0]));
        } catch (IllegalApplicationInstructionsException exception) {
            System.out.println(exception.getMessage());
            System.exit(1);
        }
    }
}
