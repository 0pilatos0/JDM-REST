package com.avd.jdmrest.services;

abstract class AbstractServiceImpl implements AbstractService{
    @Override
    public void debug(String message) {

        System.out.println("[DEBUG] " + message);
    }

    @Override
    public void debug(String message, Object... args) {
        System.out.println("[DEBUG] " + String.format(message, args));
    }
}
