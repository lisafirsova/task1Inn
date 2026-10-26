package org.example.firsova.exception;

import java.io.Serial;

public class ArrayException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public ArrayException() {
        super();
    }

    public ArrayException(String message) {
        super(message);
    }

    public ArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayException(Throwable cause) {
        super(cause);
    }
}
