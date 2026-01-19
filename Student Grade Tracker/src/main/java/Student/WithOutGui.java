//package Student;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class WithOutGui {
//    static Scanner sc = new Scanner(System.in);
//    static ArrayList<Student> students = new ArrayList<>();
//
//    public static void main(String[] args) {
//
//        while (true) {
//            System.out.println("===============================");
//            System.out.println("***School Mangement***");
//            System.out.println("Form:");
//            System.out.println();
//            System.out.println("1.Add Student:");
//            System.out.println("2.Enter marks:");
//            System.out.println("3.Search Student Info:");
//            System.out.println("4.Display All students:");
//            System.out.println("5. See the Class Report:");
//            System.out.println("6.Exit");
//            System.out.println();
//            System.out.println("Enter your Choise Here:");
//            System.out.println();
//            if (!sc.hasNextInt()) {
//                System.out.println("Invalid input. Please enter a number.");
//                sc.next();
//                continue;
//            }
//            int choise = sc.nextInt();
//
//
//            switch (choise) {
//                case 1 -> addStudent();
//                case 2 -> enterMarks();
//                case 3 -> searchStudent();
//                case 4 -> displayAll();
//                case 5 -> reportClass();
//                case 6 -> {
//                    System.out.println("thanks for Joining us!!");
//                    return;
//                }
//
//            }
//        }
//    }
//
//    public static void addStudent() {
//        System.out.println("Admitting Student");
//        System.out.println("enter the RollNumber for New Student 6 digits:");
//        int rollNumber = sc.nextInt();
//        sc.nextLine();
//        if (rollNumber >= 100000 && rollNumber <= 999999) {
//            System.out.println("Enter New Student Name: ");
//            String name = sc.nextLine();
//            for (Student s : students) {
//                if (s.getRollNumber() == rollNumber) {
//                    System.out.println("Roll number already exists.");
//                    return;
//                }
//            }
//            students.add(new Student(rollNumber, name));
//            System.out.println("Process Completed!!!");
//            System.out.println("Student Added");
//        }else System.out.println("6 digits please");
//
//    }
//
//    public static void enterMarks() {
////        System.out.println("Entering Marks");
//        System.out.println("Roll Number:");
//        int rollNumber = sc.nextInt();
//        for (Student s : students) {
//            if (s.getRollNumber() == rollNumber) {
//                final int SUBJECT_COUNT = 5;
//                int[] marks = new int[SUBJECT_COUNT];
//                for (int i = 0; i < SUBJECT_COUNT; i++) {
//                    while (true) {
//                        System.out.println("Enter Marks of Subject " + (i + 1) + " = ");
//                        int input = sc.nextInt();
//                        if (input >= 0 && input <= 100) {
//                            marks[i] = input;
//                            break;
//                        } else {
//                            System.out.println("you cant exceed form the limit of 100");
//
//                        }
//                    }
//                }
//                s.setMarks(marks);
//                System.out.println("Marks Added");
//                return;
//            }
//
//        }
//        System.out.println("Student Roll Number not found!");
//    }
//
//    public static void displayAll() {
//        if (students.isEmpty()) {
//            System.out.println("Empty!!!");
//            return;
//        }
//        for (Student s : students) {
//            s.displayStudentinfo();
//        }
//    }
//
//    public static void searchStudent() {
//        System.out.println("enter the roll Number:");
//        int rollNumber = sc.nextInt();
//        for (Student s : students) {
//            if (s.getRollNumber() == rollNumber) {
//                System.out.println("Found!!!!");
//                s.displayStudentinfo();
//                return;
//            }
//
//        }
//        System.out.println("Can't find The Roll Number !!!!!!!");
//    }
//
//    public static void reportClass() {
//        if (students.isEmpty()) {
//            System.out.println("No student added!!!! ");
//            return;
//        }
//        double max = students.get(0).getTotalNumber();
//        double min = students.get(0).getTotalNumber();
//        double sum = 0;
//        for (Student s : students) {
//            {
//                double listNumber = s.getTotalNumber();
//                sum += listNumber;
//                if (listNumber > max) {
//                    max = listNumber;
//                }
//                if (listNumber < min) {
//                    min = listNumber;
//                }
//            }
//        }
//        double average = sum / students.size();
//        System.out.println("Max Number in the Class: " + max);
//        System.out.println("Min Number in the Class: " + min);
//        System.out.println("Average Marks in the Class:  " + average);
//    }
//}
