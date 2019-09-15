package ua.com.novykov.model;

import java.util.Objects;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Employee {
    private String name;
    private String nativeCity;
    private int age;
    private int workExperience;
    private Position position;

    public Employee() {
    }

    public Employee(String name, String nativeCity, int age, int workExperience, Position position) {
        this.name = name;
        this.nativeCity = nativeCity;
        this.age = age;
        this.workExperience = workExperience;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNativeCity() {
        return nativeCity;
    }

    public void setNativeCity(String nativeCity) {
        this.nativeCity = nativeCity;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("city", nativeCity)
                .append("age", age)
                .append("experience", workExperience)
                .append("position", position)
                .build();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nativeCity, age, workExperience, position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                workExperience == employee.workExperience &&
                Objects.equals(name, employee.name) &&
                Objects.equals(nativeCity, employee.nativeCity) &&
                position == employee.position;
    }
}
