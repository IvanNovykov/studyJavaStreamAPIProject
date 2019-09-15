package ua.com.novykov.service;

import org.junit.Before;
import org.junit.Test;
import ua.com.novykov.exception.EmployeeNotCorrectException;
import ua.com.novykov.model.Employee;
import ua.com.novykov.model.Position;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static ua.com.novykov.utils.TestUtils.*;

public class EmployeeServiceTest {

    private EmployeeService employeeService = new EmployeeService();
    private List<Employee> inputEmployees;

    @Before
    public void setUp() {
        inputEmployees = new ArrayList<>();
        inputEmployees.add(new Employee("Matt", "London", 36, 15, Position.MANAGER));
        inputEmployees.add(new Employee("Ivan", "Lviv", 55, 27, Position.MANAGER));
        inputEmployees.add(new Employee("Mikel", "Marseille", 36, 13, Position.MANAGER));
        inputEmployees.add(new Employee("Merry", "London", 25, 6, Position.WORKER));
        inputEmployees.add(new Employee("Merry", "London", 25, 6, Position.WORKER));
        inputEmployees.add(new Employee("John", "Liverpool", 22, 1, Position.WORKER));
        inputEmployees.add(new Employee("Robert", "Manchester", 35, 18, Position.MANAGER));
        inputEmployees.add(new Employee("Tom", "London", 37, 19, Position.DIRECTOR));
        inputEmployees.add(new Employee("Eva", "Krakow", 29, 6, Position.WORKER));
        inputEmployees.add(new Employee("Jared", "Manchester", 38, 14, Position.WORKER));
        inputEmployees.add(new Employee("Jared", "Manchester", 38, 14, Position.WORKER));
        inputEmployees.add(new Employee("Andriy", "Ternopil", 23, 4, Position.WORKER));
        inputEmployees.add(new Employee("Marta", "Poltava", 33, 10, Position.DIRECTOR));
        inputEmployees.add(new Employee("Emma", "Chicago", 22, 3, Position.WORKER));
        inputEmployees.add(new Employee("Emilia", "London", 24, 7, Position.WORKER));
        inputEmployees.add(new Employee("Emilia", "London", 24, 7, Position.WORKER));
        inputEmployees.add(new Employee(null, "Kharkiv", 31, 9, Position.WORKER));
    }

    @Test
    public void groupEmployeesByCity() {
        assertEquals(buildExpectedEmployeesGroupedByCity(), employeeService.groupEmployeesByCity(inputEmployees));
    }

    @Test
    public void sortEmployeesByAge() {
        assertEquals(buildExpectedEmployeesSortedByAge(), employeeService.sortEmployeesByAge(inputEmployees));
    }

    @Test
    public void filterEmployeesByCityAndAge() {
        List<Employee> actual = employeeService.filterEmployeesByCityAndAge(inputEmployees);

        assertFalse(actual.isEmpty());

        assertEquals(buildExpectedEmployeesNotFromManchesterBetweenTwentyFiveAndThirtyFive(), actual);
    }

    @Test
    public void addToEveryEmployeeOneYearOfExperience() {
        assertEquals(buildExpectedEmployeesAfterAddedOneYearOfExperience(), employeeService.addToEveryEmployeeOneYearOfExperience(inputEmployees));
    }

    @Test
    public void countAverageAgeOfEmployees() {
        assertEquals(31.352941175470587, employeeService.countAverageAgeOfEmployees(inputEmployees), 0.0002);
    }

    @Test
    public void countNumberOfEmployeesOlderThanThirty() {
        assertEquals(9, employeeService.countNumberOfEmployeesOlderThanThirty(inputEmployees));
    }

    @Test
    public void fiveEmployeesFromLondon() {
        assertEquals(buildExpectedListOfFirstFiveEmployeeWhoIsFromLondon(), employeeService.findFiveEmployeesFromLondon(inputEmployees));
    }
    @Test
    public void findFiveYearsExperienceUniqueEmployee() {
        assertEquals(buildExpectedListOfUniqueEmployeesWithFiveYearsOfExperience(), employeeService.findUniqueEmployeesWithFiveYearsOfExperience(inputEmployees));
    }

    @Test(expected = NullPointerException.class)
    public void findListOfNamesOfEmployees() {
        assertEquals(buildExpectedListOfNamesOfAllEmployees(), employeeService.findListOfNamesOfEmployees(inputEmployees));
    }

    @Test(expected = NullPointerException.class)
    public void findEmployeesWhoseNameStartWithMAndTheyAreManagersOrDirectors(){
        assertEquals(buildExpectedListOfEmployeesWhoseNameStartsWithMAndWhoIsAManagerOrDirector(), employeeService.findEmployeesWhoseNameStartWithMAndTheyAreManagersOrDirectors(inputEmployees)
        );
    }

    @Test
    public void findLastFourEmployees() {
        assertEquals(buildExpectedListOfLastFourEmployees(), employeeService.findLastFourEmployees(inputEmployees));
    }

    @Test(expected = EmployeeNotCorrectException.class)
    public void validateEmployeesByName(){
        EmployeeNotCorrectException expectedException = new EmployeeNotCorrectException("Employee's name is not correct!");

        assertEquals(expectedException, employeeService.validateEmployeesByName(inputEmployees) );
    }
}