package service;

import Beans.Employee;
import Utiles.EmployeePreviousState;
import model.IEmployeeDAO;

import java.util.List;

public class IEmployeeServiceImpl implements IEmployeeService{

    private IEmployeeDAO employeeDAO;
    private IHistoriqueEmployeeState historiqueEmployeeState;


    public IEmployeeServiceImpl(IEmployeeDAO employeeDAO, IHistoriqueEmployeeState historiqueEmployeeState) {
        this.employeeDAO = employeeDAO;
        this.historiqueEmployeeState = historiqueEmployeeState;
    }

    @Override
    public Employee createNewEmployee(Employee employee) {
        Employee savedEmployee =employeeDAO.insert(employee);
        return savedEmployee;
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee updatedEmployee = employeeDAO.update(employee, id);
        historiqueEmployeeState.add(employee.save());
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

    @Override
    public Employee restorePreviousState(int index , long idEmployee){
        EmployeePreviousState state = historiqueEmployeeState.get(index);
        if(idEmployee == state.getId()) {
            Employee employee = employeeDAO.findById(idEmployee);
            employee.restore(state);
            return employee;
        } else {
            return null;
        }
    }

    @Override
    public Employee duplicateEmployee(Long employeeId) {
        Employee employeeoriginal = employeeDAO.findById(employeeId);
        try {
            Employee employeeduplicata = employeeoriginal.clone();
            return employeeDAO.insert(employeeduplicata);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }


    }
}
