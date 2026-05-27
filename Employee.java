public class Employee {
    private int id;
    private String name;
    private String department;
    private int salary;
    private boolean activeStatus;

    public Employee(int id, String name, String department, int salary, boolean activeStatus) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.activeStatus = activeStatus;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public int getSalary() { return salary; }
    public boolean isActiveStatus() { return activeStatus; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", activeStatus=" + activeStatus +
                '}';
    }
}
