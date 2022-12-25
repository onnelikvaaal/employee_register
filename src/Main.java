import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Employee[] employeeBook = new Employee[10];
        employeeBook[0] = new Employee("Иванов Иван Иванович", 1, 45605.0);
        employeeBook[1] = new Employee("Петров Пётр Петрович", 1, 29874.0);
        employeeBook[2] = new Employee("Васильев Василий Васильевич", 5, 48762.0);
        employeeBook[3] = new Employee("Сидоров Сидор Сидорович", 1, 44989.0);
        employeeBook[4] = new Employee("Николаев Николай Николаевич", 1, 61298.0);
        employeeBook[5] = new Employee("Евгеньева Евгения Евгеньевна", 4, 29898.0);
        employeeBook[6] = new Employee("Александрова Александра Александровна", 4, 61800.0);
        employeeBook[7] = new Employee("Михайлов Михиал Михайлович", 2, 39898.0);
        employeeBook[8] = new Employee("Фёдоров Фёдор Фёдорович", 1, 42900.0);
        employeeBook[9] = new Employee("Сергеев Сергей Сергеевич", 2, 41800.0);

    }


    //метод для вывода всех сотрудников в консоль
    public static void printAllEmployees(Employee[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    //метод для получения суммы затрат на зп всех сотрудников
    public static double countSalarySum(Employee[] array) {
        double salarySum = 0;
        for (int i = 0; i < array.length; i++) {
            salarySum = salarySum + array[i].getSalary();
        }
        return salarySum;
    }

    //метод для поиска сотрудника с минимальной зп
    public static Employee findMinimalSalaryEmployee(Employee[] array) {
        double minNumber = 1_000_000.0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getSalary() < minNumber) {
                minNumber = array[i].getSalary();//нашла минимальную зп
            }
        }
        Employee employee = null;//завожу переменную, чтобы сложить туда найденного работника с минимальной зп
        for (int i = 0; i < array.length; i++) {
            if (minNumber == array[i].getSalary()) {
                employee = array[i];//нашла эту минимальную зп в ячейке массива
            }
        }
        return employee;
    }

    //метод для поиска сотрудника с максимальной зп
    public static Employee findMaximalSalaryEmployee(Employee[] array) {
        double maxNumber = 0.0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getSalary() > maxNumber) {
                maxNumber = array[i].getSalary();//нашла максимальную зп
            }
        }
        Employee employee = null;//завожу переменную, чтобы сложить туда найденного работника с максимальной зп
        for (int i = 0; i < array.length; i++) {
            if (maxNumber == array[i].getSalary()) {
                employee = array[i];//нашла ячейку массива с этой максимальной зп
            }
        }
        return employee;
    }

    //метод для получения средней зп
    public static double countAverageSalary(Employee[] array) {
        return countSalarySum(array) / array.length;
    }

    //метод для вывода в консоль всех ФИО
    public static void printAllEmployeeNames(Employee[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getName());
        }
    }

    //дальше повышенный уровень сложности:

    //метод для индексации зп
    public static void indexSalary(Employee[] array, int percent) {
        for (int i = 0; i < array.length; i++) {
            double newSalary = 0;
            newSalary = (array[i].getSalary() + ((array[i].getSalary() / 100) * percent));
            array[i].setSalary(newSalary);
        }
    }

    //метод для поиска по отделу сотрудника с минимальной зп
    public static Employee findMinimalSalaryEmployeeByDepartment(Employee[] array, int departmentNumber) {
        double minNumber = 1_000_000.0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getSalary() < minNumber && departmentNumber == array[i].getDepartment()) {
                minNumber = array[i].getSalary();
            }
        }
        Employee employee = null;
        for (int i = 0; i < array.length; i++) {
            if (minNumber == array[i].getSalary()) {
                employee = array[i];
            }
        }
        return employee;
    }

    //метод для поиска по отделу сотрудника с максимальной зп
    public static Employee findMaximalSalaryEmployeeByDepartment(Employee[] array, int departmentNumber) {
        double maxNumber = 0.0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getSalary() > maxNumber && departmentNumber == array[i].getDepartment()) {
                maxNumber = array[i].getSalary();
            }
        }
        Employee employee = null;
        for (int i = 0; i < array.length; i++) {
            if (maxNumber == array[i].getSalary()) {
                employee = array[i];
            }
        }
        return employee;
    }

    //метод для получения суммы зарплат по отделу
    public static double countSalarySumByDepartment(Employee[] array, int departmentNumber) {
        double salarySum = 0;
        for (int i = 0; i < array.length; i++) {
            if (departmentNumber == array[i].getDepartment()) {
                salarySum = salarySum + array[i].getSalary();
            }
        }
        return salarySum;
    }

    //метод для получения средней зп по отделу
    public static double countAverageSalaryByDepartment(Employee[] array, int departmentNumber) {
        double salarySum = 0;
        int employeesQuantity = 0;
        for (int i = 0; i < array.length; i++) {
            if (departmentNumber == array[i].getDepartment()) {
                salarySum = salarySum + array[i].getSalary();
                employeesQuantity = employeesQuantity + 1;
            }
        }
        return salarySum / employeesQuantity;
    }

    //метод для индексации зп по отделу
    public static void indexSalaryByDepartment(Employee[] array, int percent, int departmentNumber) {
        for (int i = 0; i < array.length; i++) {
            double newSalary = 0;
            if (departmentNumber == array[i].getDepartment()) {
                newSalary = (array[i].getSalary() + ((array[i].getSalary() / 100) * percent));
                array[i].setSalary(newSalary);
            }
        }
    }

    //метод для вывода в консоль всех сотрудников отдела
    public static void printAllEmployeesByDepartment(Employee[] array, int departmentNumber) {
        for (int i = 0; i < array.length; i++) {
            if (departmentNumber == array[i].getDepartment()) {
                System.out.println(array[i].getName() + " " + array[i].getSalary());
            }
        }
    }

    //метод для поиска сотрудников с зп меньше чем заданное число
    public static void findEmployeesWithSalaryLessThen(Employee[] array, int anyNumber) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getSalary() < anyNumber) {
                System.out.println(array[i]);
            }
        }
    }

    //метод для поиска сотрудников с зп больше/= заданному числу
    public static void findEmployeesWithSalaryMoreThen(Employee[] array, int anyNumber) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getSalary() >= anyNumber) {
                System.out.println(array[i]);
            }
        }
    }
}