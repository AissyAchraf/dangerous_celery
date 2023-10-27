import model.IEmployeeDAO;
import model.IEmployeeDAOImpl;
import model.LogEmployeeDAO;
import service.IEmployeeService;
import service.IEmployeeServiceImpl;
import vue.UserVue;

public class Main {
    public static void main(String[] args) {

        IEmployeeDAO employeeDAO = new LogEmployeeDAO(new IEmployeeDAOImpl());

        IEmployeeService employeeService = new IEmployeeServiceImpl(employeeDAO);

        UserVue userVue = new UserVue(employeeService);

        while(true) {
            userVue.printMenu();
            userVue.menuListner();
        }
    }
}