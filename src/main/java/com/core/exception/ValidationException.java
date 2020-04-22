package com.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidationException extends RuntimeException {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ValidationException(String msg) {
        super(msg);
    }
}
