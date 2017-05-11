package com.globeshanghai.frontend.util;

/**
 * Created by stijnergeerts on 17/04/17.
 */
public final class PreCondition {
    public static void isTrue(boolean expression, String errorMessageTemplate, Object... errorMessageArguments) {
        isTrue(expression, String.format(errorMessageTemplate, errorMessageArguments));
    }
    /**
     * Ensures that the expression given as a method parameter is true.
     * @param expression The inspected expression.
     * @param errorMessage The error message that is passed forward to the exception that is thrown
     * if the expression is false.
     * @throws IllegalArgumentException if the inspected expression is false.
     */
    public static void isTrue(boolean expression, String errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
    /**
     * Ensures that the string given as a method parameter is not empty.
     * @param string The inspected string.
     * @param errorMessage The error message that is passed forward to the exception that is thrown if
     * the string is empty.
     * @throws IllegalArgumentException if the inspected string is empty.
     */
    public static void notEmpty(String string, String errorMessage) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
    /**
     * Ensures that the object given as a method parameter is not null.
     * @param reference A reference to the inspected object.
     * @param errorMessage The error message that is passed forward to the exception that is thrown if
     * the object given as a method parameter is null.
     * @throws NullPointerException If the object given as a method parameter is null.
     */
    public static void notNull(Object reference, String errorMessage) {
        if (reference == null) {
            throw new NullPointerException(errorMessage);
        }
    }

    /**
     * Ensures that the object given as a method parameter is a valid date notation.
     * @param string A string to the given date.
     * @param errorMessage The error message that is passed forward to the exception that is thrown if
     * the object given as a method parameter is null.
     * @throws IllegalArgumentException If the object given as a method parameter is not the right date format.
     */
    public static void isDate(String string, String errorMessage){
        if (!string.matches("\\d{4}/\\d{2}/\\d{2}")){
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
