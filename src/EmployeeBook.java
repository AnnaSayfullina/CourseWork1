import java.util.Arrays;

/**
 * 1. Создать класс EmployeeBook.
 * 2. Перенести хранилище сотрудников в него (массив), закрыть к нему доступ извне (сделать приватным).
 */

public class EmployeeBook {
    private Employee[] employees;
    private int sizeArray;

    public EmployeeBook(){
//        this.employees = new Employee[sizeArray];
//        this.sizeArray = sizeArray;
        this.employees = new Employee[15];
    }
    public Employee[] getEmployees(){
        return this.employees;
    }
    public int getCurrentSizeArray(){
        return sizeArray;
    }
//    public int setSizeArray(int newSize){
//        return this.sizeArray= newSize;
//    }
    /**
     * Добавить нового сотрудника (создаем объект, заполняем поля, кладем в массив).
     * Нужно найти свободную ячейку в массиве и добавить нового сотрудника в нее.
     * Искать нужно всегда с начала, так как возможно добавление в ячейку удаленных ранее сотрудников.
     */

    public void addEmployeeToArray(Employee name) {
        if (sizeArray>= employees.length){
            System.out.println("Новый сотрудник не добавлен. В хранилище нет места.");
        }
        employees[sizeArray++] = name;
    }
    public void createNewEmployee(String fullName, int department, int salary){
        Employee name = new Employee(fullName, department, salary);
        addEmployeeToArray(name);
    }
    /**Получить список всех сотрудников со всеми имеющимися по ним данными
     * (вывести в консоль значения всех полей (toString)).
     */

    public void printEmployees(){
        System.out.println("Все сотрудники:");
        for (int i = 0; i < sizeArray; i++) {
            System.out.println(employees[i]);
        }
    }
    /**Посчитать сумму затрат на зарплаты в месяц.
     */
    public double calculateAllSalaries(){
        double sum = 0;
        for (int i = 0; i < sizeArray; i++){
            sum += employees[i].getSalary();
        }
        return sum;
    }
    /**Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).
     */
    public double calculateMiddleSalary(){
        return calculateAllSalaries()/sizeArray;
    }
    /**Получить Ф. И. О. всех сотрудников (вывести в консоль)
     */
    public void printFullNameAllEmployees(){
        System.out.println("Ф.И.О. всех сотрудников:");
        for (int i = 0; i < sizeArray; i++) {
            System.out.println(getEmployees()[i].getName());
        }
    }
    /**Найти сотрудника с максимальной зарплатой.
     */
    public Employee findEmployeeWithMaxSalary(){
        double maxSalary = employees[0].getSalary();
        Employee maxEmployee = employees[0];
        for (int i = 1; i < sizeArray; i++){
            if (employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                maxEmployee = employees[i];
            }
        }
        return maxEmployee;
    }
    /**Найти сотрудника с минимальной зарплатой.
     */
    public Employee findEmployeeWithMinSalary(){
        double minSalary = employees[0].getSalary();
        Employee minEmployee = employees[0];
        for (int i = 1; i < sizeArray; i++){
            if (employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                minEmployee = employees[i];
            }
        }
        return minEmployee;
    }
    /**Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
     */
    public void increaseSalaryByPercent(double percent){
        percent = 0.01 * percent;
        for (int i = 0; i < sizeArray; i++){
            employees[i].setSalary(employees[i].getSalary() * (1 + percent));
        }
    }
    /** Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
     Сотрудника с максимальной зарплатой.
     */
    public Employee findEmployeeWithMaxSalaryInDepartment(int department){
        double maxSalary = 0;
        Employee maxEmployeeDepartment = employees[0];
        for (int i = 0; i < sizeArray; i++) {
            if (employees[i].getDepartment() == department) {
                if (employees[i].getSalary() > maxSalary) {
                    maxEmployeeDepartment = employees[i];
                    maxSalary = employees[i].getSalary();
                }
            }
        }
        return maxEmployeeDepartment;
    }
    public void printEmployeeWithMaxSalaryInDepartment(int department){
        Employee name = findEmployeeWithMaxSalaryInDepartment(department);
        System.out.printf("В отделе %d сотрудник %s с максимальной зарплатой %.2f рублей%n", name.getDepartment(), name.getName(), name.getSalary());
    }
    /** Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
     Сотрудника с минимальной зарплатой.
     */
    public Employee findEmployeeWithMinSalaryInDepartment(int department){
        double minSalary = Integer.MAX_VALUE;
        Employee minEmployeeDepartment = employees[0];
        for (int i = 0; i < sizeArray; i++) {
            if (employees[i].getDepartment() == department) {
                if (employees[i].getSalary() < minSalary) {
                    minEmployeeDepartment = employees[i];
                    minSalary = employees[i].getSalary();
                }
            }
        }
        return minEmployeeDepartment;
    }
    public void printEmployeeWithMinSalaryInDepartment(int department){
        Employee name = findEmployeeWithMinSalaryInDepartment(department);
        System.out.printf("В отделе %d сотрудник %s с минимальной зарплатой %.2f рублей%n", name.getDepartment(), name.getName(), name.getSalary());
    }
    /** Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
     Сумму затрат на зарплату по отделу.
     */
    public double calculateSalariesOfDepartment(int department){
        double sum = 0;
        for (int i = 0; i < sizeArray; i++){
            if (employees[i].getDepartment() == department) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }
    public void printSalariesOfDepartment(int department){
        System.out.printf("Сумма затрат на зарплату по отделу %d составила %.02f рублей%n", department, calculateSalariesOfDepartment(department));
    }
    /** Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
     Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
     */
    public double calculateMiddleSalariesOfDepartment(int department) {
        double sum = calculateSalariesOfDepartment(department);
        int numbers = 0;
        for (int i = 0; i < sizeArray; i++){
            if (employees[i].getDepartment() == department) {
                numbers++;
            }
        }
        return sum/numbers;
    }
    public void printMiddleSalariesOfDepartment(int department){
        System.out.printf("Средняя зарплата по отделу %d составила %.02f рублей%n", department, calculateMiddleSalariesOfDepartment(department));
    }
    /** Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
     Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
     */
    public void increaseSalaryByPercentInDepartment(double percent, int department){
        percent = 1+ 0.01 * percent;
        for (int i = 0; i < sizeArray; i++){
            if (employees[i].getDepartment() == department) {
                employees[i].setSalary(employees[i].getSalary() * percent);
            }
        }
    }
    /** Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
     Напечатать всех сотрудников отдела (все данные, кроме отдела).
     */
    public void printEmployeesDepartment(int department){
        System.out.println("Сотрудники отдела " + department);
        for (int i = 0; i < sizeArray; i++) {
            if (employees[i].getDepartment() == department) {
                System.out.println(employees[i].getName() +", зарплата "+ employees[i].getSalary()+" рублей, id " + employees[i].getId());
            }
        }
    }
    /** Получить в качестве параметра число и найти:
     1. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
     2. Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
     */
    public void printEmployeesSalaryIsLessThan (int salary){
        System.out.println("Сотрудники с зарплатой меньше " + salary + " рублей:");
        for (int i = 0; i < sizeArray; i++) {
            if(employees[i].getSalary() < salary){
                System.out.println(employees[i].getName() +", зарплата "+ employees[i].getSalary()+" рублей, id " + employees[i].getId());
            }
        }
    }
    public void printEmployeesSalaryIsMoreThan (int salary){
        System.out.println("Сотрудники с зарплатой больше (или равной) " + salary + " рублей:");
        for (int i = 0; i < sizeArray; i++) {
            if(employees[i].getSalary() >= salary){
                System.out.println(employees[i].getName() +", зарплата "+ employees[i].getSalary()+" рублей, id " + employees[i].getId());
            }
        }
    }
    /**Удалить сотрудника (находим сотрудника по Ф. И. О. и/или id, обнуляем его ячейку в массиве).
     */
    public void removeEmployee(String fullName) {
        for (int i = 0; i < sizeArray; i++) {
            if (employees[i].getName().equals(fullName)) {
                employees[i] = null;
                if (i != employees.length-1) {
                    System.arraycopy(employees, i+1, employees, i, sizeArray - i -1 );
                }
                sizeArray--;
                System.out.println("Сотрудник " + fullName + " удален");
                return;
            }
        }
        System.out.println("Сотрудник " + fullName + " не найден");
    }
    /** Изменить сотрудника (получить сотрудника по Ф. И. О., модернизировать его запись):
     1. Изменить зарплату.
     2. Изменить отдел.
     Придумать архитектуру. Сделать или два метода, или один, но продумать его.
     */
    public Employee findEmployee(String fullName) {
        Employee name = employees[0];
        for (int i = 0; i < sizeArray; i++) {
            if (employees[i].getName().equals(fullName)) {
                name = employees[i];
            }
        }
        return name;
    }
    public void changeSalary(String fullName, int salary) {
        findEmployee(fullName).setSalary(salary);
    }
    public void changeDepartment(String fullName, int department) {
        findEmployee(fullName).setDepartment(department);
    }

    /** Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников).
     */
    public void sortArrayByDepartment(){
        Employee[] newArray = Arrays.copyOf(employees, sizeArray);
        employees = newArray;
        Arrays.sort(employees);
    }
    public void printAllDepartments(){
        sortArrayByDepartment();
        for (int i = 0; i < sizeArray; i++){
            System.out.println("Отдел " + employees[i].getDepartment());
            if (i == sizeArray - 1) {
                System.out.println(employees[i].getName());
                return;
            }
            if(employees[i].getDepartment() != employees[i+1].getDepartment()) {
                System.out.println(employees[i].getName());
            }
            while (employees[i].getDepartment() == employees[i+1].getDepartment() ){
                System.out.println(employees[i].getName());
                i++;
                if(i == sizeArray -1) {
                    System.out.println(employees[i].getName());
                    return;
                }
                if(employees[i].getDepartment() < employees[i+1].getDepartment()){
                    System.out.println(employees[i].getName());
                }
            }
        }
    }
}