package Student;

public class Calculations {

    public char calculateGrade(int totalMarks) {
        double percentage = (double) totalMarks / 500 * 100;

        if (percentage >= 90) return 'A';
        else if (percentage >= 80) return 'B';
        else if (percentage >= 70) return 'C';
        else if (percentage >= 60) return 'D';
        else return 'F';
    }

    // public  void classReport(int ) { }
}


