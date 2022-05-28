package com.techelevator;


import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static List<Department> department = new ArrayList<>();
    public static List<Employee> employees = new ArrayList<>();
    public static List<Employee> deptMarketing = new ArrayList<>();
    public static List<Employee> deptSales = new ArrayList<>();
    public static List<Employee> deptEngineering = new ArrayList<>();
    public static Map<String,Project> projects = new HashMap<>();

    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();


        // print each department by name
        printDepartments();


        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
        Department marketing = new Department(001, "Marketing");
        Department sales = new Department(002, "Sales");
        Department engineering = new Department(003, "Engineering");

        department.add(marketing);
        department.add(sales);
        department.add(engineering);


    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");

        for (int i = 0; i < department.size(); i++){
            System.out.println(department.get(i).getName());
        }

    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        Employee dean = new Employee(001, "Dean", "Johnson", "djohnson@teams.com", department.get(2),"08/21/2020");
        Employee angie = new Employee(002, "Angie", "Smith", "asmith@teams.com", department.get(2),"08/21/2020");
        {
            angie.setSalary(angie.getSalary()/10 + angie.getSalary());
        }

        Employee margaret = new Employee(001, "Margaret", "Thompson", "mthompson@teams.com", department.get(0),"08/21/2020");

        employees.add(dean);
        employees.add(angie);
        employees.add(margaret);



    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");

        for (int i =0; i < employees.size(); i++){
            System.out.println(employees.get(i).getFullName()+ " (" + employees.get(i).getSalary()+ ") " + employees.get(i).getDepartment().getName());

        }


    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
        Project TEams = new Project("TEams", "Project Management Software" , "10/10/2020", "11/10/2020");
        for (Employee employee : employees){
            if(employee.getDepartment().getName().equals("Engineering")){
                deptEngineering.add(employee);
            }
        }
        TEams.setTeamMembers(deptEngineering);
        projects.put(TEams.getName(),TEams);


    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        Project Marketing = new Project("Marketing Landing Project", "Lead Capture Landing Page For Marketing", "10/10/2020", "10/17/2020");
        for (Employee employee : employees) {
            if (employee.getDepartment().getName().equals("Marketing")) {
                deptMarketing.add(employee);
            }
        }
        Marketing.setTeamMembers(deptMarketing);
        projects.put(Marketing.getName(), Marketing);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
            System.out.println("TEams: " + deptEngineering.size());
        System.out.println( "Marketing Landing Page: " + deptMarketing.size());

    }

}
