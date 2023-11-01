package service;

import Beans.Employee;

import java.util.List;

public interface IEmployeeService {

    public Employee createNewEmployee(Employee employee);
    public Employee updateEmployee(Employee employee, Long id);
    public void deleteEmployee(Long id);
    public List<Employee> getEmployeesList();
    public Employee findById(Long id);
    public Employee restorePreviousState(int index , long idEmployee);
    Employee duplicateEmployee(Long employeeId);

}
