package Student;

import java.util.Arrays;

public class Student {

    private final String studentName;
    private final int rollNumber;
    Calculations calculations;
    private char grade;
    public int studentClass;
    public int[] marks = new int[5];
    private int totalNumber;
    private double percentage;


    public Student(int rollNumber, String studentName) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        calculations = new Calculations();
    }

    private void calculateTotalNumbers(int[] array) {
        int sum = 0;
        for (int n : array) sum += n;
        this.totalNumber = sum;
        this.percentage = (double) sum * 100 / 500;
        this.grade = calculations.calculateGrade(sum);
    }


    protected void setStudentClass(int studentClass) {
        this.studentClass = studentClass;
    }

    public int getRollNumber() {
        return rollNumber;
    }

//    protected void setRollNumber(int rollNumber) {
//        this.rollNumber = rollNumber;
//    }


    public String getStudentName() {
        return studentName;
    }

    public char getGrade() {
        return grade;
    }


    public void marksEachSubject(int[] marks) {
        System.out.println("marks = " + Arrays.toString(marks));

    }

    protected void setMarks(int[] marks) {
        this.marks = marks;
        calculateTotalNumbers(marks);
    }

    public int getTotalNumber() {
        return totalNumber;
    }
    public void getMarkEachSubject() {
        System.out.println("Marks in each subject = " + Arrays.toString(this.marks));

    }
    public double getPercentage() {
        return percentage;
    }


    public void displayStudentinfo() {
        System.out.println("****************************");
        System.out.println("Student Info:");
        System.out.println("Name: " + studentName);
        System.out.println("rollNumber = " + rollNumber);
        System.out.println("Class = " + studentClass + " | Grade = " + grade);
        System.out.println();
        System.out.println("Result Info:");
        getMarkEachSubject();
        System.out.println(getTotalNumber());
        System.out.println(getPercentage());
        System.out.println(getGrade());
        System.out.println("thanks");
        System.out.println("============================");

    }

}
