package com.jobHunt.exception;

import java.io.Serial;

public class JobHuntException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public JobHuntException(String message) {
        super(message);
    }

}
