package Utiles;

import Beans.Employee;

public class Director {

    public static Employee.EmployeeBuilder accountBuilder(){

        return new Employee.EmployeeBuilder();
    }

}
