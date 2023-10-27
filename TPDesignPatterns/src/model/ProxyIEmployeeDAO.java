package model;

import Beans.Employee;
import Beans.User;

public class ProxyIEmployeeDAO {

    private IEmployeeDAOImpl iEmployeeDAO;

    public User getAuthenticatedUser() {
        return null;
    }

    public void update(Employee employee, Long id) {
        User authUser = this.getAuthenticatedUser();
        if(authUser.isGranted()) {
            iEmployeeDAO.update(employee, id);
            System.out.println("Employee mmodifié");
        } else {
            System.out.println("Accès refusé, vous n'avez pas les autorisations pour faire cette action");
        }
    }
}
