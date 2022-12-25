public class Employee {

    private int id;//поле-идентификатор сотрудника
    private String name;//поле-ФИО сотрудника
    private int department;//поле-номер отдела
    private double salary;//поле-зарплата

    private static int idCounter = 1;//статическая переменная-счётчик


    public Employee(String name, int department, double salary) {//конструктор для класса Employee
        this.id = idCounter++;//проставление айди при создании объекта(id++ - постинкремент)
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {//геттер для айди
        return id;
    }

    public String getName() {//геттер для ФИО
        return name;
    }

    public int getDepartment() {//геттер для отдела
        return department;
    }

    public double getSalary() {//геттер для зарплаты
        return salary;
    }

    public void setName(String name) {//сеттер для ФИО
        this.name = name;
    }

    public void setDepartment(int department) {//сеттер для номера отдела
        this.department = department;
    }

    public void setSalary(double salary) {//сеттер для зарплаты
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " " + name + ", отдел " + department + ", заработная плата " + salary + " рублей";
    }
}
