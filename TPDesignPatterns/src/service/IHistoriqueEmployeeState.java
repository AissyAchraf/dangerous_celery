package service;

import Utiles.EmployeePreviousState;

public interface IHistoriqueEmployeeState {

     void add(EmployeePreviousState employeePreviousState);
     EmployeePreviousState get(int index);
}
