package com.desktop.tasks.service.enums;

public enum EPriority{
    NOT_IMPORTANT(0), USUAL(1), IMPORTANT(2), ESSENTIAL(3);

    private final int i;

    EPriority(int i) {
        this.i = i;
    }

    public int getI() {
        return this.i;
    }
}
