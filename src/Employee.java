class Employee implements Comparable<Employee> {
    private String name;
    private int department;
    private double salary;
    private int id;
    public static int count = 0;

    public Employee(String name, int department, int salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
        count++;
        this.id = count;
    }
    public String getName(){
        return this.name;
    }
    public int getDepartment(){
        return this.department;
    }
    public double getSalary(){
        return this.salary;
    }
    public int getId(){
        return this.id;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public void setDepartment(int department){
        this.department = department;
    }
    public String toString(){
        return "Ф.И.О: " + this.name + ", Отдел " + this.department + ", Зарплата " + this.salary + ", id " + this.id;
    }
    @Override
    public int compareTo(Employee o) {
        Employee tmp = o;
        if(this.department < tmp.department) {
            return -1;
        } else if (this.department > tmp.department) {
            return 1;
        }
        return 0;
    }
}

