package service;

import Beans.Employee;
import model.IEmployeeDAO;

import java.util.List;

public class IEmployeeServiceImpl implements IEmployeeService{

    private IEmployeeDAO employeeDAO;

    public IEmployeeServiceImpl(IEmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee createNewEmployee(Employee employee) {
        Employee savedEmployee =employeeDAO.insert(employee);
        return savedEmployee;
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee updatedEmployee = employeeDAO.update(employee, id);
        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeDAO.delete(employeeDAO.findById(id));
    }

    @Override
    public List<Employee> getEmployeesList() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeDAO.findById(id);
    }
}
