package ua.com.novykov.exception;

public class EmployeeNotCorrectException extends RuntimeException {

    public EmployeeNotCorrectException(String message) {
        super(message);
    }
}