package Beans;

import java.util.List;

public class Chef extends Employee {

    private List<Employee> teamMembers;

    public void addTeamMember(Employee employee) {
        teamMembers.add(employee);
    }

    public void display() {
        System.out.println("{\n" +
                "   Id : " + this.getId() + ",\n"+
                "   Name : " + this.getName() + ",\n"+
                "   Team Members : {\n");
        if(this.teamMembers != null) {
            for (Employee e : teamMembers) {
                e.display();
            }
        }
        System.out.println("},");
    }
}
