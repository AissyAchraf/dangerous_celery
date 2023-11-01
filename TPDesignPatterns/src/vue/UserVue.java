package vue;

import Beans.Employee;
import service.IEmployeeService;

import java.util.List;
import java.util.Scanner;

public class UserVue {

    private int choix;
    private IEmployeeService iEmployeeService;

    public UserVue(IEmployeeService iEmployeeService) {
        this.iEmployeeService = iEmployeeService;
    }

    public void printMenu() {
        System.out.println("===================================");
        System.out.println("1) Ajouter un employee");
        System.out.println("2) Modifier un employee");
        System.out.println("3) Supprimer un employee");
        System.out.println("4) Afficher la liste des employee");
        System.out.println("5) Afficher un employee");
        System.out.println("0) Quitter");
        System.out.println("===================================");
    }

    public void menuListner() {
        Scanner sc = new Scanner(System.in);
        choix = sc.nextInt();
        switch (choix) {
            case 1 : addEmployee();break;
            case 2 : updateEmployee();break;
            case 3 : deleteEmployee();break;
            case 4 : showEmployees();break;
            case 5 : showEmployee();break;
            case 0 : exit();
        }
    }

    private void exit() {
        System.exit(1);
    }

    private void showEmployee() {
        System.out.println("Entrez l'Id de l'employé à afficher :");
        Scanner sc = new Scanner(System.in);
        Long id = sc.nextLong();
        Employee employee = iEmployeeService.findById(id);
        if(employee != null) {
            employee.display();
        } else {
            System.out.println("Aucun employé n'est trouvé avec l'Id : "+id);
        }
    }

    private void showEmployees() {
        List<Employee> employees = iEmployeeService.getEmployeesList();
        for (Employee e:employees) {
            e.display();
        }
    }

    private void deleteEmployee() {
        System.out.println("Entrez l'Id de l'employé à supprimer :");
        Scanner sc = new Scanner(System.in);
        Long id = sc.nextLong();
        iEmployeeService.deleteEmployee(id);
        System.out.println("Employé avec Id : "+ id +" est supprimé");
    }

    private void updateEmployee() {
        System.out.println("Entrez l'Id de l'employé à modifier :");
        Scanner sc = new Scanner(System.in);
        Long id = sc.nextLong();
        Employee oldEmployee = iEmployeeService.findById(id);
        if(oldEmployee == null) {
            System.out.println("Aucun employé n'est trouvé avec l'Id : "+id);
        }
        Employee employee = new Employee();
        System.out.println("Entrez le nom de l'employee :");
        Scanner sc2 = new Scanner(System.in);
        employee.setName(sc2.nextLine());
        iEmployeeService.updateEmployee(employee, id);
        System.out.println("Employé avec Id : "+ id +" est modifié");
    }

    private void addEmployee() {
        Employee newEmpl = new Employee();
        System.out.println("Entrez le nom de l'employee :");
        Scanner sc = new Scanner(System.in);
        newEmpl.setName(sc.nextLine());
        iEmployeeService.createNewEmployee(newEmpl);
    }

}
