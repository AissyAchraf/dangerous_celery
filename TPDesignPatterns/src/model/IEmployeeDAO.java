package model;

import Beans.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Predicate;

public interface IEmployeeDAO {

    public void connectToDB();
    public Employee insert(Employee employee);
    public Employee update(Employee employee, Long id);
    public void delete(Employee employee);
    public List<Employee> searchEmployees(Predicate predicate);
    public void closeConnectionToDB() throws SQLException;
    public Employee findById(Long id);
    public List<Employee> findAll();
}
