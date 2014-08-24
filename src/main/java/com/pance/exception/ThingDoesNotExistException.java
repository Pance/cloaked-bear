package com.pance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Peter on 8/24/2014.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ThingDoesNotExistException extends Exception {
    public ThingDoesNotExistException(String message) {
        super(message);
    }
}
