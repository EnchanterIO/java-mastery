package com.marsrover.controller;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since 2018-02-17
 */
public class IllegalApplicationInstructionsException extends IllegalArgumentException {
    IllegalApplicationInstructionsException(String message) {
        super(message);
    }
}
