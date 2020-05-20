package pl.lickerish.soapdemo.employee;

import org.springframework.stereotype.Service;
import pl.lickerish.soapdemo.employee.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employees;

    public EmployeeService() {

        employees = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Michał");
        employee1.setSurname("Pilot");

        Employee employee2 = new Employee();
        employee2.setId(1);
        employee2.setName("Andrzej");
        employee2.setSurname("Dyrdymała");

        Employee employee3 = new Employee();
        employee3.setId(1);
        employee3.setName("Andrzej");
        employee3.setSurname("Dyrdymała");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }

    public Employee getEmployeeById(Long id) {
        return employees
                .stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .get();
    }
}
