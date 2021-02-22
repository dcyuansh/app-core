package com.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author spring
 * @version 1.0
 */
public class ExceptionHelper {

    private Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

    private static ExceptionHelper c_instance;


    public static ExceptionHelper getInstance() {
        if (c_instance == null) {
            synchronized (ExceptionHelper.class) {
                if (c_instance == null) {
                    c_instance = new ExceptionHelper();
                }
            }
        }
        return c_instance;
    }

    public ValidationException handleValidationException(String debugMessage) {
        ValidationException ve = new ValidationException(debugMessage);
        return ve;
    }

    public Exception handleException(String errorMessage) {
        Exception exception = new Exception(errorMessage);
        return exception;
    }
}
