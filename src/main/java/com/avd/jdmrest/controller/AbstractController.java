package com.avd.jdmrest.controller;

abstract class AbstractController {
    String prefix = "[REQUEST] ";

    /**
     * Log the controller which is called
     * @param message
     */
    public void log(String message) {
        System.out.println(prefix + message);
    }

    /**
     * Log the controller which is called with id
     * @param message
     * @param id
     */
    public void log(String message, Long id) {
        System.out.println(prefix + message + " " + id);
    }
}
