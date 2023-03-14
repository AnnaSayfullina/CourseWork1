class Main {
    public static void main(String[] args) {
        EmployeeBook employees = new EmployeeBook();
        employees.createNewEmployee("Сидоров Павел Петрович", 1, 25000);
        employees.createNewEmployee("Иванов Иван Иванович", 1, 28000);
        employees.createNewEmployee("Федоров Федор Федорович", 1, 50000);
        employees.createNewEmployee("Петров Петр Петрович", 2, 35000);
        employees.createNewEmployee("Кириллов Кирилл Кириллович", 2, 32000);
        employees.createNewEmployee("Степанов Степан Степанович", 2, 36000);
        employees.createNewEmployee("Любимова Любовь Мирославовна", 3, 45000);
        employees.createNewEmployee("Пирогова Надежда Павловна", 3, 29000);
        employees.createNewEmployee("Лебедева Вера Николаевна", 3, 31000);
        employees.createNewEmployee("Смирнов Андрей Олегович", 4, 43000);
        employees.createNewEmployee("Денисов Денис Денисович", 4, 46000);
        employees.createNewEmployee("Михайлов Михаил Михайлович", 4, 51000);
        employees.createNewEmployee("Витальев Виталий Витальевич", 5, 44000);
        employees.createNewEmployee("Павлов Павел Павлович", 5, 21000);
        employees.createNewEmployee("Артемьев Артем Артемович", 5, 39000);

        employees.printEmployees();
        System.out.println();
        System.out.println(employees.getCurrentSizeArray());

        System.out.printf("Сумма затрат на зарплаты в месяц составляет %.2f рублей%n", employees.calculateAllSalaries());
        System.out.printf("Среднее значение зарплат %.2f рублей%n", employees.calculateMiddleSalary());
        System.out.println();

        employees.printFullNameAllEmployees();
        System.out.println();

        System.out.println("Сотрудник с максимальной зарплатой" + "\n" + employees.findEmployeeWithMaxSalary());
        System.out.println();

        System.out.println("Сотрудник с минимальной зарплатой" + "\n" + employees.findEmployeeWithMinSalary());
        System.out.println();

        System.out.println("Индексация зарплат сотрудников на 5%");
        employees.increaseSalaryByPercent(5);
        employees.printEmployees();
        System.out.println();

        employees.printEmployeeWithMaxSalaryInDepartment(3);
        employees.printEmployeeWithMinSalaryInDepartment(5);
        employees.printSalariesOfDepartment(4);
        employees.printMiddleSalariesOfDepartment(4);
        System.out.println();

        System.out.println("Индексация зарплат сотрудников отдела");
        employees.increaseSalaryByPercentInDepartment(5, 4);
        employees.printEmployeesDepartment(4);
        System.out.println();

        employees.printEmployeesSalaryIsLessThan(30000);
        System.out.println();

        employees.printEmployeesSalaryIsMoreThan(40000);
        System.out.println();

        System.out.println("Удаление сотрудника");
        employees.removeEmployee("Денисов Денис Денисович");
        employees.removeEmployee("Денисов Денис Денисович");
        System.out.println();

        System.out.println("Создание нового сотрудника и добавление его в массив");
        employees.createNewEmployee("Васильев Василий Васильевич", 1, 60000);
//        employees.createNewEmployee("Матросова Анна Геннадьевна", 5, 55500);
             employees.printEmployees();
        System.out.println();

        System.out.println("Изменение зарплаты сотрудника");
        employees.changeSalary("Иванов Иван Иванович", 35000);
        System.out.println(employees.findEmployee("Иванов Иван Иванович"));
        System.out.println();

        System.out.println("Изменение отдела сотрудника");
        employees.changeDepartment("Иванов Иван Иванович", 5);
        System.out.println(employees.findEmployee("Иванов Иван Иванович"));
        System.out.println();
        System.out.println(employees.getCurrentSizeArray());
        System.out.println("Список сотрудников по отделам");

        employees.printAllDepartments();







    }
}