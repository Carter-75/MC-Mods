package com.drone_army.entity;

public enum CommandMode {
    FOLLOW,
    DEFEND,
    AGGRESSIVE,
    RETALIATE,
    HOLD_POSITION;

    public CommandMode next() {
        return values()[(this.ordinal() + 1) % values().length];
    }
}
