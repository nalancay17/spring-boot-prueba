package com.nico.springbootprueba.error;

public class DepartmentNameExistsException extends Exception {

    public DepartmentNameExistsException() {
        super();
    }

    public DepartmentNameExistsException(String message) {
        super(message);
    }

    public DepartmentNameExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNameExistsException(Throwable cause) {
        super(cause);
    }

    protected DepartmentNameExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
