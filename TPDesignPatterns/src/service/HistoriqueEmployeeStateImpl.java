package service;

import Utiles.EmployeePreviousState;

import java.util.ArrayList;
import java.util.List;

public class HistoriqueEmployeeStateImpl implements  IHistoriqueEmployeeState{

    private List<EmployeePreviousState> employeePreviousStates = new ArrayList<>();

    @Override
    public void add(EmployeePreviousState employeePreviousState) {
        employeePreviousStates.add(employeePreviousState);

    }

    @Override
    public EmployeePreviousState get(int index) {
        return employeePreviousStates.get(index);
    }
}
