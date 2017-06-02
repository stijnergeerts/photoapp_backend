package com.globeshanghai.backend.exceptions;

public class ConfigurationNotFoundException extends RuntimeException {

    /**
     * This exception is thrown when no content is found.
     * @param id The configId that is not linked to a {@link com.globeshanghai.backend.dom.configuration.Config}
     */
    public ConfigurationNotFoundException(String id) {
        super(String.format("No configuration entry found with id: <%s>", id));
    }
}
