package com.nhlstenden.windturbines.exception;

public class OverloadException extends Exception {
    /**
     * Exception for when the wind-turbines overload.
     *
     * @param message shows what went wrong in the wind turbine.
     */
    public OverloadException(String message) {
        super(message);
    }
}
