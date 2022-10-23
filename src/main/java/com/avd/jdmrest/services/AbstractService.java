package com.avd.jdmrest.services;

public interface AbstractService {

    void debug(String message);
    void debug(String message, Object... args);
}
