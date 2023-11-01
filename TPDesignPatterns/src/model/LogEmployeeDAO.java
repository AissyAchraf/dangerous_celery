package model;

import Beans.Employee;
import Utiles.DBLogFacade;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class LogEmployeeDAO extends IEmployeeDAOImpl {

    private IEmployeeDAO employeeDAO;

    public LogEmployeeDAO(IEmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee insert(Employee employee) {
        DBLogFacade.writeLog("Insertion à la base de données : "+new Date().toString());
        return employeeDAO.insert(employee);
    }

    @Override
    public Employee update(Employee employee, Long id) {
        DBLogFacade.writeLog("Modification à la base de données : "+new Date().toString());
        return employeeDAO.update(employee, id);
    }

    @Override
    public void delete(Employee employee) {
        DBLogFacade.writeLog("Suppression de la base de données : "+new Date().toString());
        employeeDAO.delete(employee);
    }

    @Override
    public List<Employee> searchEmployees(Predicate predicate) {
        DBLogFacade.writeLog("Listing de la base de données : "+new Date().toString());
        return employeeDAO.searchEmployees(predicate);
    }

    @Override
    public Employee findById(Long id) {
        DBLogFacade.writeLog("Find by ID de la base de données : "+new Date().toString());
        return employeeDAO.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        DBLogFacade.writeLog("Find all de la base de données : "+new Date().toString());
        return employeeDAO.findAll();
    }
}
