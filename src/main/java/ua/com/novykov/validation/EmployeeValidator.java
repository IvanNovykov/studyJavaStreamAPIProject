package ua.com.novykov.validation;

import ua.com.novykov.exception.EmployeeNotCorrectException;
import ua.com.novykov.model.Employee;

public class EmployeeValidator {
    public Employee validate(Employee employee) {
        if (employee.getName() == null) {
            throw new EmployeeNotCorrectException("Employee's name is not correct!");
        }
        return employee;
    }
}