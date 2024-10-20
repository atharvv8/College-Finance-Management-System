/**
 * Teacher Class: This class keeps track of the teacher's name, id, and salary.
 */

public class Teacher {
    private final String id;
    private final String name;
    private double salary;

    /**
     * Constructor for the Teacher class
     * @param id: The teacher's id
     * @param name: The teacher's name
     * @param salary: The teacher's salary
     */

    public Teacher(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    /**
     * Gets the teacher's id
     * @return: The teacher's id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the teacher's name
     * @return: The teacher's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the teacher's salary
     * @return: The teacher's salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the teacher's salary
     * @param salary: The teacher's salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Returns the teacher's information
     * @return: The teacher's information
     */
   @Override
    public String toString() {
        return "Teacher ID: " + id +
                ", Name: " + name +
                ", Salary: Rs. " + salary;
    }
}
