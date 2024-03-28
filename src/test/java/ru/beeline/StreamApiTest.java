package ru.beeline;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StreamApiTest {

    @Data
    @Accessors(chain = true)
    public class Department {

        String name;
        List<Employee> employees;

    }


    @Data
    @Accessors(chain = true)
    public class Employee {

        String fullName;
        BigDecimal salary;

    }


    ///
    @Test
    public void findAllEmployeesWithSecondHighestSalaryUsingStreams() {
        var dep1 = new Department().setName("HR")
                .setEmployees(
                        List.of(
                                new Employee().setFullName("Employee 11").setSalary(new BigDecimal("1000.30")),
                                new Employee().setFullName("Employee 12").setSalary(new BigDecimal("1500.30")),
                                new Employee().setFullName("Employee 13").setSalary(new BigDecimal("1800.30")),
                                new Employee().setFullName("Employee 14").setSalary(new BigDecimal("1700.30")),
                                new Employee().setFullName("Employee 15").setSalary(new BigDecimal("1900.30"))
                        ));
        var dep2 = new Department().setName("Payroll")
                .setEmployees(
                        List.of(
                                new Employee().setFullName("Employee 21").setSalary(new BigDecimal("1000.30")),
                                new Employee().setFullName("Employee 22").setSalary(new BigDecimal("1500.30")),
                                new Employee().setFullName("Employee 23").setSalary(new BigDecimal("1500.30"))
                        ));
        var dep3 = new Department().setName("IT")
                .setEmployees(
                        List.of(
                                new Employee().setFullName("Employee 31").setSalary(new BigDecimal("1800")),
                                new Employee().setFullName("Employee 33").setSalary(new BigDecimal("1800")),
                                new Employee().setFullName("Employee 34").setSalary(new BigDecimal("1800"))
                        ));

        var departments = List.of(dep1, dep2, dep3);

        // Получить список всех сотрудников со второй самой высокой зарплатой каждом отделе
        // Необходимо продолжить используя Stream API
        List<Employee> res = departments.;

        Assertions.assertEquals(2, res.size());
        Assertions.assertEquals(new BigDecimal("1800.30"), res.get(0).getSalary());
        Assertions.assertEquals(new BigDecimal("1000.30"), res.get(1).getSalary());

    }

}
