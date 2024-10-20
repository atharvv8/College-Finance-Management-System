/**
 * Student Class: This class keeps track of the student's name, ID and status of tuition fees.
 */

class Student {
    private final String id;
    private final String name;
    private final String courseName;
    private final String courseCode;
    private final double tuitionFee;
    private double amount;
    private double tuitionPaid;
    private double totalTuitionPaid;


    /**
     * Constructor for Student class
     * @param id: Student's ID
     * @param name: Student's name
     * @param courseName: Student's course name
     * @param courseCode: Student's course code
     * @param tuitionFee: Student's tuition fees
     */

    public Student(String id, String name, String courseName, String courseCode, double tuitionFee) {
        this.id = id;
        this.name = name;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.tuitionFee = tuitionFee;
        if ((tuitionFee > 0) && (tuitionFee < 100000)) {
            amount = tuitionFee;
        }else {
            System.out.println("Tuition fees must be between £1.00 and £100000.00");
        }
        tuitionPaid = 0;
        totalTuitionPaid = 0;
    }

    /**
     * This method returns the student's ID
     * @return: Student's ID
     */
    public String getId() {
        return id;
    }

    /**
     * This method returns the student's name
     * @return: Student's name
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the student's course name
     * @return: Student's course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * This method returns the student's course code
     * @return: Student's course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * This method returns the student's tuition fees
     * It is final, used for holding the price of tuition fees
     * @return: Student's tuition fees price
     */
    public double getTuitionFee() {
        return tuitionFee;
    }

    /**
     * This method returns the student's tuition fee as an amount,
     * it is used for holding the price of tuition fees for calculating
     * the total tuition fees paid by the students.
     * @return: Student's amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * This method sets the student's tuition paid
     * @param tuitionPaid: Student's tuition paid
     */
    public void setTuitionPaid(double tuitionPaid) {
        this.tuitionPaid = tuitionPaid;
    }

    /**
     * This method gets the student's tuition paid
     * @return: Student's tuition paid
     */
    public double getTuitionPaid() {
        return tuitionPaid;
    }

    /**
     * This method calculates the student's outstanding fees
     * @return: Student's outstanding fees
     */
    public double payTuitionFee(){
        this.amount -= tuitionPaid;
        return amount;
    }

    /**
     * This method calculates the student's total tuition fees paid
     * @return: Student's total tuition fees paid
     */
    public double totalTuitionPaid() {
        this.totalTuitionPaid += this.tuitionPaid;
        return totalTuitionPaid;
    }

    /**
     * This method gets the student's total tuition fees paid
     * @return: Student's total tuition fees paid
     */
    public double getTotalTuitionPaid() {
        return totalTuitionPaid;
    }

    /**
     * This method returns all the student's details
     * @return: Student's details
     */
    @Override
    public String toString() {
        return "Student ID: " + id +
                ", Name: " + name +
                ", Course Name: " + courseName +
                ", Course Code: " + courseCode +
                ", Tuition Fees: £ " + tuitionFee;
    }

    /**
     * This method returns the student's details
     * Overrides the toString method
     * @return: Student's details
     */
    public String toString2() {
        return "Student ID: " + id +
                ", Name: " + name +
                ", Course Name: " + courseName +
                ", Course Code: " + courseCode +
                ", Tuition Fees Paid To-Date: £ " + totalTuitionPaid;
    }
}
