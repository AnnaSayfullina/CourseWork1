/**
 * 1. Создать класс Employee, который содержит информацию о Ф.И.О., отделе и зарплате сотрудника.
 * Отделы для простоты должны быть названы от 1 до 5.
 * 2. Добавить статическую переменную-счетчик, которая будет отвечать за id.
 * 3. Добавить в класс Employee поле id, которое проставляется из счетчика, а затем счетчик увеличивает свое значение.
 * 4. Добавить возможность получать значения полей из Employee (геттеры) для всех полей.
 * 5. Добавить возможность устанавливать значения полей отдела и зарплаты (сеттеры).
 * 6. По умолчанию все поля должны передавать через конструктор (кроме id) и заполняться в нем
 * (включая id, который нужно получить из счетчика).
 */
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

    /** Перегрузка метода compareTo, чтобы можно было сортировать массив по номеру отдела
     */
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

