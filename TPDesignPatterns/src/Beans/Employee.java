package Beans;

import Utiles.EmployeePreviousState;

public class Employee implements Cloneable {

    private Long id;
    private String name;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("{\n" +
                "   Id : " + this.getId() + ",\n"+
                "   Name : " + this.getName() + "\n"+
                "\n},");
    }
    public EmployeePreviousState save(){
       return new EmployeePreviousState(this.id,this.name);
    }
    public void restore(EmployeePreviousState employeePreviousState) {
        id = employeePreviousState.getId();
        name=employeePreviousState.getName();
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }

    public static class EmployeeBuilder{
        private Employee employee=new Employee();
        public EmployeeBuilder employeId(Long id){
            employee.id=id;
            return this;
        }
        public EmployeeBuilder employeeName(String name){
            employee.name=name;
            return this;
        }

        public Employee build(){
            return this.employee;
        }




    }
}
