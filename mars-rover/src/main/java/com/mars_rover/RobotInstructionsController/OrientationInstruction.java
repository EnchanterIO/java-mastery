package com.mars_rover.RobotInstructionsController;

import com.mars_rover.Robot.Mobility.Orientation;

enum OrientationInstruction {
    N(Orientation.NORTH),
    E(Orientation.EAST),
    S(Orientation.SOUTH),
    W(Orientation.WEST);

    private Orientation orientation;

    OrientationInstruction(Orientation orientation) {
        this.orientation = orientation;
    }

    public static OrientationInstruction fromOrientation(Orientation orientation) throws IllegalArgumentException {
        for (OrientationInstruction instruction : OrientationInstruction.values()) {
            if (instruction.orientation == orientation) {
                return instruction;
            }
        }

        throw new IllegalArgumentException(
            String.format(
                "Unable to reverse lookup Instruction from given Orientation: %s",
                orientation.toString()
            )
        );
    }

    public Orientation orientation() {
        return orientation;
    }
}
