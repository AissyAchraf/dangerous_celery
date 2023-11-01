import Beans.Employee;
import Utiles.Director;
import model.IEmployeeDAO;
import model.IEmployeeDAOImpl;
import model.LogEmployeeDAO;
import service.HistoriqueEmployeeStateImpl;
import service.IEmployeeService;
import service.IEmployeeServiceImpl;
import service.IHistoriqueEmployeeState;
import vue.UserVue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "TEFFAL", "OUSSAMA", "AISSY", "ACHRAF", "AYMAN",
                "MOUAD", "SAIDA", "YOUSSEF", "ANASS"
        );

        IEmployeeDAO employeeDAO = new LogEmployeeDAO(new IEmployeeDAOImpl());
        IHistoriqueEmployeeState historiqueEmployeeState = new HistoriqueEmployeeStateImpl();
        for (int i = 1; i <= 10; i++) {
            String randomName = names.get(ThreadLocalRandom.current().nextInt(names.size()));

            Employee employee = Director.accountBuilder()
                    .employeId((long) i)
                    .employeeName(randomName)
                    .build();

            employeeDAO.insert(employee);
        }
        IEmployeeService employeeService = new IEmployeeServiceImpl(employeeDAO, historiqueEmployeeState);

        UserVue userVue = new UserVue(employeeService);

        while(true) {
            userVue.printMenu();
            userVue.menuListner();
        }
    }
}