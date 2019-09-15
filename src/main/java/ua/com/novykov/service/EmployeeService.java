package ua.com.novykov.service;

import ua.com.novykov.model.Employee;
import ua.com.novykov.model.Position;
import ua.com.novykov.validation.EmployeeValidator;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService extends Employee {
    private static final  int DOWNLIMIT = 25;
    private final static int UPLIMIT = 35;
    private final static int AGEPOINT = 30;
    private final static int LIMIT_EMPLOYEES_FROM_LONDON = 5;
    private final static int LIMIT_OF_EXPERIENCE = 5;
    private final static int NUMBER_OF_LAST_EMPLOYEES_IN_LIST = 4;
    private final static String CITY = "Manchester";

    public Map<String, List<Employee>> groupEmployeesByCity(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getNativeCity));
    }

    public List<Employee> sortEmployeesByAge(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.toList());
    }

    public  List<Employee> filterEmployeesByCityAndAge(List<Employee> employees) {
        return employees.stream()
                .filter(this::checkIfEmployeeNotFromManchesterAndBetweenDOWNLIMITAndUPLIMITAge)
                .collect(Collectors.toList());
    }

    public List<Employee> addToEveryEmployeeOneYearOfExperience(List<Employee> employees) {
        return employees.stream()
                .peek(employee -> employee.setWorkExperience(employee.getWorkExperience() + 1))
                .collect(Collectors.toList());
    }

    public double countAverageAgeOfEmployees(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.averagingInt(Employee::getAge));
    }

    public long countNumberOfEmployeesOlderThanThirty(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> (employee.getAge()) > AGEPOINT)
                .count();
    }

    public List<Employee> findFiveEmployeesFromLondon(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> "London".equals(employee.getNativeCity()))
                .limit(LIMIT_EMPLOYEES_FROM_LONDON)
                .collect(Collectors.toList());
    }

    public List<Employee> findUniqueEmployeesWithFiveYearsOfExperience(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getWorkExperience() > LIMIT_OF_EXPERIENCE)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> findListOfNamesOfEmployees(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public List<Employee> findEmployeesWhoseNameStartWithMAndTheyAreManagersOrDirectors(List<Employee> employees) {
        return employees.stream()
                .filter(this::checkIfNameOfEmployeeStartsWithM)
                .collect(Collectors.toList());
    }

    public List<Employee> findLastFourEmployees(List<Employee> employees) {
        return employees.stream()
                .skip(employees.size() - NUMBER_OF_LAST_EMPLOYEES_IN_LIST)
                .collect(Collectors.toList());
    }

    private boolean checkIfNameOfEmployeeStartsWithM(Employee employee) {
        return employee.getName().startsWith("M")
                && (employee.getPosition() == Position.MANAGER || employee.getPosition() == Position.DIRECTOR);
    }

    private boolean checkIfEmployeeNotFromManchesterAndBetweenDOWNLIMITAndUPLIMITAge(Employee employee) {
        return !CITY.equals(employee.getNativeCity()) && ((employee.getAge() >= DOWNLIMIT && employee.getAge() <= UPLIMIT));
    }

    public List<Employee> validateEmployeesByName(List<Employee> employees){
        EmployeeValidator employeeValidator = new EmployeeValidator();
        return employees.stream()
                .peek(employee -> employeeValidator.validate(employee))
                .collect(Collectors.toList());
    }
}