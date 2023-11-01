package model;

import Beans.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IEmployeeDAOImpl implements IEmployeeDAO {

    private Connection connection;
    private List<Employee> employeeList = new ArrayList<>();
    private Long currentId = 0L;

    @Override
    public void connectToDB() {
        connection = DBConnection.getInstance();
        // traitement pour la connection à la base de données
    }

    @Override
    public Employee insert(Employee employee) {
        currentId++;
        employee.setId(this.currentId);
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee, Long id) {
        for (Employee e: employeeList) {
            if(e.getId() == id) {
                e.setName(employee.getName());
                return e;
            }
        }
        return null;
    }

    @Override
    public void delete(Employee employee) {
        employeeList.remove(employee);
    }

    @Override
    public List<Employee> searchEmployees(Predicate predicate) {
        return (List<Employee>) employeeList.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public void closeConnectionToDB() throws SQLException {
        connection.close();
    }

    @Override
    public Employee findById(Long id) {
        for (Employee e : employeeList) {
            if(e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {return employeeList;
    }

}
