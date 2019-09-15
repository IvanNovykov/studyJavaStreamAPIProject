package ua.com.novykov.utils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import ua.com.novykov.model.Employee;
import ua.com.novykov.model.Position;
import java.util.*;

public class TestUtils {
    private TestUtils() {
        throw new IllegalArgumentException("Not support");
    }

    public static ImmutableMap<Object, Object> buildExpectedEmployeesGroupedByCity() {
        return ImmutableMap.builder()
                .put("Poltava", Collections.singletonList(new Employee("Marta", "Poltava", 33, 10, Position.DIRECTOR)))
                .put("Liverpool", Collections.singletonList(new Employee("John", "Liverpool", 22, 1, Position.WORKER)))
                .put("Ternopil", Collections.singletonList(new Employee("Andriy", "Ternopil", 23, 4, Position.WORKER)))
                .put("Lviv", Collections.singletonList(new Employee("Ivan", "Lviv", 55, 27, Position.MANAGER)))
                .put("Chicago", Collections.singletonList(new Employee("Emma", "Chicago", 22, 3, Position.WORKER)))
                .put("Krakow", Collections.singletonList(new Employee("Eva", "Krakow", 29, 6, Position.WORKER)))
                .put("Marseille", Collections.singletonList(new Employee("Mikel", "Marseille", 36, 13, Position.MANAGER)))
                .put("Manchester", Arrays.asList(
                        new Employee("Robert", "Manchester", 35, 18, Position.MANAGER),
                        new Employee("Jared", "Manchester", 38, 14, Position.WORKER),
                        new Employee("Jared", "Manchester", 38, 14, Position.WORKER)
                ))
                .put("London", Arrays.asList(
                        new Employee("Matt", "London", 36, 15, Position.MANAGER),
                        new Employee("Merry", "London", 25, 6, Position.WORKER),
                        new Employee("Merry", "London", 25, 6, Position.WORKER),
                        new Employee("Tom", "London", 37, 19, Position.DIRECTOR),
                        new Employee("Emilia", "London", 24, 7, Position.WORKER),
                        new Employee("Emilia", "London", 24, 7, Position.WORKER)
                ))
                .put("Kharkiv", Collections.singletonList(new Employee(null, "Kharkiv", 31, 9, Position.WORKER)))
                .build();
    }

    public static List<Employee> buildExpectedEmployeesSortedByAge() {
        return ImmutableList.of(
                new Employee("John", "Liverpool", 22, 1, Position.WORKER),
                new Employee("Emma", "Chicago", 22, 3, Position.WORKER),
                new Employee("Andriy", "Ternopil", 23, 4, Position.WORKER),
                new Employee("Emilia", "London", 24, 7, Position.WORKER),
                new Employee("Emilia", "London", 24, 7, Position.WORKER),
                new Employee("Merry", "London", 25, 6, Position.WORKER),
                new Employee("Merry", "London", 25, 6, Position.WORKER),
                new Employee("Eva", "Krakow", 29, 6, Position.WORKER),
                new Employee(null, "Kharkiv", 31, 9, Position.WORKER),
                new Employee("Marta", "Poltava", 33, 10, Position.DIRECTOR),
                new Employee("Robert", "Manchester", 35, 18, Position.MANAGER),
                new Employee("Matt", "London", 36, 15, Position.MANAGER),
                new Employee("Mikel", "Marseille", 36, 13, Position.MANAGER),
                new Employee("Tom", "London", 37, 19, Position.DIRECTOR),
                new Employee("Jared", "Manchester", 38, 14, Position.WORKER),
                new Employee("Jared", "Manchester", 38, 14, Position.WORKER),
                new Employee("Ivan", "Lviv", 55, 27, Position.MANAGER));
    }

    public static List<Employee> buildExpectedEmployeesNotFromManchesterBetweenTwentyFiveAndThirtyFive() {
        return ImmutableList.of(
                new Employee("Merry", "London", 25, 6, Position.WORKER),
                new Employee("Merry", "London", 25, 6, Position.WORKER),
                new Employee("Eva", "Krakow", 29, 6, Position.WORKER),
                new Employee("Marta", "Poltava", 33, 10, Position.DIRECTOR),
                new Employee(null, "Kharkiv", 31, 9, Position.WORKER));
    }

    public static List<Employee> buildExpectedEmployeesAfterAddedOneYearOfExperience() {
        return ImmutableList.of(
                new Employee("Matt", "London", 36, 16, Position.MANAGER),
                new Employee("Ivan", "Lviv", 55, 28, Position.MANAGER),
                new Employee("Mikel", "Marseille", 36, 14, Position.MANAGER),
                new Employee("Merry", "London", 25, 7, Position.WORKER),
                new Employee("Merry", "London", 25, 7, Position.WORKER),
                new Employee("John", "Liverpool", 22, 2, Position.WORKER),
                new Employee("Robert", "Manchester", 35, 19, Position.MANAGER),
                new Employee("Tom", "London", 37, 20, Position.DIRECTOR),
                new Employee("Eva", "Krakow", 29, 7, Position.WORKER),
                new Employee("Jared", "Manchester", 38, 15, Position.WORKER),
                new Employee("Jared", "Manchester", 38, 15, Position.WORKER),
                new Employee("Andriy", "Ternopil", 23, 5, Position.WORKER),
                new Employee("Marta", "Poltava", 33, 11, Position.DIRECTOR),
                new Employee("Emma", "Chicago", 22, 4, Position.WORKER),
                new Employee("Emilia", "London", 24, 8, Position.WORKER),
                new Employee("Emilia", "London", 24, 8, Position.WORKER),
                new Employee(null, "Kharkiv", 31, 10, Position.WORKER));
    }

    public static List<Employee> buildExpectedListOfFirstFiveEmployeeWhoIsFromLondon() {
        return ImmutableList.of(
                new Employee("Matt", "London", 36, 15, Position.MANAGER),
                new Employee("Merry", "London", 25, 6, Position.WORKER),
                new Employee("Merry", "London", 25, 6, Position.WORKER),
                new Employee("Tom", "London", 37, 19, Position.DIRECTOR),
                new Employee("Emilia", "London", 24, 7, Position.WORKER));
    }

    public static List<Employee> buildExpectedListOfEmployeesWhoseNameStartsWithMAndWhoIsAManagerOrDirector() {
        return ImmutableList.of(
                new Employee("Matt", "London", 36, 15, Position.MANAGER),
                new Employee("Mikel", "Marseille", 36, 13, Position.MANAGER),
                new Employee("Marta", "Poltava", 33, 10, Position.DIRECTOR));
    }

    public static List<Employee> buildExpectedListOfUniqueEmployeesWithFiveYearsOfExperience() {
        return ImmutableList.of(
                new Employee("Matt", "London", 36, 15, Position.MANAGER),
                new Employee("Ivan", "Lviv", 55, 27, Position.MANAGER),
                new Employee("Mikel", "Marseille", 36, 13, Position.MANAGER),
                new Employee("Merry", "London", 25, 6, Position.WORKER),
                new Employee("Robert", "Manchester", 35, 18, Position.MANAGER),
                new Employee("Tom", "London", 37, 19, Position.DIRECTOR),
                new Employee("Eva", "Krakow", 29, 6, Position.WORKER),
                new Employee("Jared", "Manchester", 38, 14, Position.WORKER),
                new Employee("Marta", "Poltava", 33, 10, Position.DIRECTOR),
                new Employee("Emilia", "London", 24, 7, Position.WORKER),
                new Employee(null, "Kharkiv", 31, 9, Position.WORKER));
    }

    public static List<String> buildExpectedListOfNamesOfAllEmployees() {
        return ImmutableList.of(
                "Matt", "Ivan", "Mikel", "Merry", "Merry", "John", "Robert", "Tom", "Eva", "Jared", "Jared",
                "Andriy", "Marta", "Emma", "Emilia", "Emilia", null);
    }

    public static List<Employee> buildExpectedListOfLastFourEmployees() {
        return ImmutableList.of(
                new Employee("Emma", "Chicago", 22, 3, Position.WORKER),
                new Employee("Emilia", "London", 24, 7, Position.WORKER),
                new Employee("Emilia", "London", 24, 7, Position.WORKER),
                new Employee(null, "Kharkiv", 31, 9, Position.WORKER));
    }
}
