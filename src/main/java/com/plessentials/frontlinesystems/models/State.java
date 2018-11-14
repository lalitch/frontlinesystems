package com.plessentials.frontlinesystems.models;

public enum State {
    Washington("WA"), California("CA"), Oregon("OR"), Nevada("NV"), NewYork("NY");

    private final String value;

    State(String value) {
        this.value = value;
    }

    public static State fromValue(String value) {
        if (value != null) {
            for (State state : values()) {
                if (state.value.equals(value)) {
                    return state;
                }
            }
        }

        throw new IllegalArgumentException("Invalid state: " + value);
    }

    public String toValue() {
        return value;
    }
}
