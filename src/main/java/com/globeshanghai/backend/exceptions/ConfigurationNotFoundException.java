package com.globeshanghai.backend.exceptions;

/**
 * Created by stijnergeerts on 17/04/17.
 */
public class ConfigurationNotFoundException extends RuntimeException {
    public ConfigurationNotFoundException(String id) {
        super(String.format("No configuration entry found with id: <%s>", id));
    }
}
