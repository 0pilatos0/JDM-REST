package com.avd.jdmrest.controller;

abstract class AbstractController {
    String prefix = "[REQUEST] ";

    public void log(String message) {
        System.out.println(prefix + message);
    }

    public void log(String message, Long id) {
        System.out.println(prefix + message + " " + id);
    }
}
