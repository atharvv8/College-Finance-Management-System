import java.util.ArrayList;

/**
 * College Class: This class is used to keep track of all the students, teachers and
 * college funds
 */

public class College {
    private final String collegeName;
    private final ArrayList<Student> students;
    private final ArrayList<Teacher> teachers;
    private double totalMoneyEarned;
    private double totalMoneySpent;
    private double totalMoneyLeft;

    /**
     * Constructor for College Class
     * @param collegeName : The name of the college
     * students : The list of students
     * teacher : The list of teachers
     * totalMoneyEarned : The total money earned
     * totalMoneySpent : The total money spent
     * totalMoneyLeft : The total money left
     */

    public College(String collegeName) {
        this.collegeName = collegeName;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.totalMoneyEarned = 0;
        this.totalMoneySpent = 0;
        this.totalMoneyLeft = 0;
    }

    /**
     * Gets the college name
     * @return: collegeName: The name of the college
     */

    public String getCollegeName() {
        return collegeName;
    }

    /**
     * Gets list of students
     * @return: students: The list of students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Gets list of teachers
     * @return: teachers: The list of teachers
     */
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Gets total money earned
     * @return: totalMoneyEarned: The total money earned
     */
    public double getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    /**
     * Gets total money spent
     * @return: totalMoneySpent: The total money spent
     */
    public double getTotalMoneySpent() {
        return totalMoneySpent;
    }

    /**
     * Gets total money left
     * @return: totalMoneyLeft: The total money left
     */
    public double getTotalMoneyLeft() {
        return totalMoneyLeft;
    }

    /**
     * Adds a student to the list of students
     * @param student: The student to be added
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Adds a teacher to the list of teachers
     * @param teacher: The teacher to be added
     */

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    /**
     * Finds a teacher by ID
     * @param teacherID: The teacher ID
     * @return: teacher: The teacher
     */
    public boolean findTeacher(String teacherID) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(teacherID)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes a teacher from the list of teachers
     * @param teacherID: The teacher ID
     */
    ArrayList<Teacher> deletedTeacherList = new ArrayList<>();

    public boolean removeTeacher(String teacherID) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(teacherID)) {
                deletedTeacherList.add(teacher);
                teachers.removeAll(deletedTeacherList);
                return true;
            }
        }
        return false;
    }

    /**
     * Increases teacher salary
     * @param teacherID : The teacher ID
     * @param salaryIncrease : The salary to be added
     * @return: newSalary: The new salary
     */
    public double increaseTeacherSalary(String teacherID, double salaryIncrease) {
        double newSalary = 0;
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(teacherID)) {
                if ((salaryIncrease > 0) && (salaryIncrease < 100000)) {
                    teacher.setSalary(teacher.getSalary() + salaryIncrease);
                    newSalary = teacher.getSalary();
                    System.out.println("Salary Increased Successfully!");
                } else {
                    System.out.println("Salary Increase must be between Re. 1.00 and Rs. 100000.00");
                }
            }
        }
        return newSalary;
    }

    /**
     * Adds money to the total money earned
     * @return totalMoneyEarned: the total money earned
     */
    public double calculateTotalMoneyEarned() {
        for (Student student : students) {
            this.totalMoneyEarned += student.getTotalTuitionPaid();
            System.out.println(student.toString2());
        }
        return totalMoneyEarned;
    }

    /**
     * Adds money to the total money spent
     * @return: totalMoneySpent: Total money spent
     */
    public double calculateTotalMoneySpent() {
            for (Teacher teacher : teachers) {
                this.totalMoneySpent += teacher.getSalary();
                System.out.println(teacher.toString());
            }
        return totalMoneySpent;
    }

    /**
     * Calculates the total money left
     * @return: totalMoneyLeft: Total money left
     */
    public double calculateTotalMoneyLeft() {
        totalMoneyLeft = totalMoneyEarned - totalMoneySpent;
        return totalMoneyLeft;
    }

    /**
     * Print the list of teachers
     */
    public void printListOfTeachers() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher.toString());
        }
    }

    /**
     * Print the list of students
     */
    public void printListOfStudents() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    /**
     * Finds a student by ID
     * @param studentID: The student ID
     *        courseID: The course ID
     * @return: student: The student
     */
    public boolean findStudent(String studentID, String courseCode) {
        for (Student student : students) {
            if ((student.getId().equals(studentID)) &&
                    (student.getCourseCode().equals(courseCode))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes a student from the list of students
     */
    ArrayList<Student> deletedStudentList = new ArrayList<>();

    public boolean removeStudent(String studentID) {
        for (Student student : students) {
            if (student.getId().equals(studentID)) {
                deletedStudentList.add(student);
                students.removeAll(deletedStudentList);
                return true;
            }
        }
        return false;
    }

    /**
     * Pay student's tuition fees
     * @param studentID: The student ID
     *        courseCode: The course code
     *        tuitionPayment : The tuition fees payment
     * @return: The new tuition
     */

    public boolean payStudentTuitionFees(String studentID, String courseCode, double tuitionPayment){
        double tuitionFees;
        double tuitionFeesPaid;
        double amountOutstanding;
        double feesPaidToDate;
        for (Student student : students) {
            if ((student.getId().equals(studentID)) && (student.getCourseCode().equals(courseCode))) {
                tuitionFees = student.getAmount();
                student.setTuitionPaid(student.getTuitionPaid() + tuitionPayment);
                tuitionFeesPaid = student.getTuitionPaid();
                amountOutstanding = student.payTuitionFee();
                feesPaidToDate = student.totalTuitionPaid();
                if(student.getAmount() < student.getTuitionPaid()){
                    System.out.println("=== ERROR ===\nYou have paid more than the required tuition fees!");
                    System.out.println("Full Tuition Fees: Rs. " + student.getTuitionFee());
                    System.out.println("You Paid: £ " + student.getTuitionPaid());
                }else{
                    System.out.println("=== SUCCESS ===\nYou have successfully paid the tuition fees!");
                    System.out.println("Tuition Fees: Rs. " + tuitionFees);
                    System.out.println("Tuition Fees Paid: Rs. " + tuitionFeesPaid);
                    System.out.println("Amount Outstanding: Rs. " + amountOutstanding);
                    System.out.println();
                    System.out.println("Fees Paid To-date: Rs. " + feesPaidToDate);
                    System.out.println();
                    return true;
                }
            }else{
                System.out.println("Student not found");
            }
        }
        return false;
    }

}

