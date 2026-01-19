package Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MainMenu {

    private final ArrayList<Student> students = new ArrayList<>();
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;

    public static void mainMenu() {
        SwingUtilities.invokeLater(() -> new MainMenu().createGUI());
    }

    private void createGUI() {
        frame = new JFrame("Student Grade Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(new BorderLayout());

        // Table for displaying students
        String[] columns = {"Roll Number", "Name", "Class", "Marks", "Total", "Percentage", "Grade"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        JButton addBtn = new JButton("Add Student");
        JButton marksBtn = new JButton("Enter Marks");
        JButton reportBtn = new JButton("Class Report");
        buttonPanel.add(addBtn);
        buttonPanel.add(marksBtn);
        buttonPanel.add(reportBtn);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        addBtn.addActionListener(e -> addStudentDialog());
        marksBtn.addActionListener(e -> enterMarksDialog());
        reportBtn.addActionListener(e -> showClassReport());

        frame.setVisible(true);
    }

    private void addStudentDialog() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JTextField rollField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField classField = new JTextField();

        panel.add(new JLabel("Roll Number (6 digits):"));
        panel.add(rollField);
        panel.add(new JLabel("Student Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Class:"));
        panel.add(classField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Add Student", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int roll = Integer.parseInt(rollField.getText());
                int studentClass = Integer.parseInt(classField.getText());
                String name = nameField.getText().trim();

                if (roll < 100000 || roll > 999999) {
                    JOptionPane.showMessageDialog(frame, "Roll number must be 6 digits!");
                    return;
                }

                for (Student s : students) {
                    if (s.getRollNumber() == roll) {
                        JOptionPane.showMessageDialog(frame, "Roll number already exists!");
                        return;
                    }
                }

                Student newStudent = new Student(roll, name);
                newStudent.setStudentClass(studentClass);
                students.add(newStudent);
                refreshTable();
                JOptionPane.showMessageDialog(frame, "Student added!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input!");
            }
        }
    }

    private void enterMarksDialog() {
        String rollStr = JOptionPane.showInputDialog(frame, "Enter Roll Number:");
        if (rollStr == null) return;

        try {
            int roll = Integer.parseInt(rollStr);
            Student student = null;
            for (Student s : students) {
                if (s.getRollNumber() == roll) {
                    student = s;
                    break;
                }
            }

            if (student == null) {
                JOptionPane.showMessageDialog(frame, "Student not found!");
                return;
            }

            JPanel panel = new JPanel(new GridLayout(5, 2));
            JTextField[] markFields = new JTextField[5];

            for (int i = 0; i < 5; i++) {
                panel.add(new JLabel("Marks for Subject " + (i + 1) + ":"));
                markFields[i] = new JTextField();
                panel.add(markFields[i]);
            }

            int result = JOptionPane.showConfirmDialog(frame, panel, "Enter Marks", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                int[] marks = new int[5];
                for (int i = 0; i < 5; i++) {
                    int mark = Integer.parseInt(markFields[i].getText());
                    if (mark < 0 || mark > 100) {
                        JOptionPane.showMessageDialog(frame, "Marks must be between 0 and 100!");
                        return;
                    }
                    marks[i] = mark;
                }
                student.setMarks(marks);
                refreshTable();
                JOptionPane.showMessageDialog(frame, "Marks added!");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid roll number!");
        }
    }

    private void showClassReport() {
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No students added!");
            return;
        }

        double max = students.get(0).getTotalNumber();
        double min = students.get(0).getTotalNumber();
        double sum = 0;

        for (Student s : students) {
            double total = s.getTotalNumber();
            sum += total;
            if (total > max) max = total;
            if (total < min) min = total;
        }

        double average = sum / students.size();

        JOptionPane.showMessageDialog(frame,
                "Max Marks: " + max +
                        "\nMin Marks: " + min +
                        "\nAverage Marks: " + average,
                "Class Report",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Student s : students) {
            String marksStr = Arrays.toString(s.marks);
            tableModel.addRow(new Object[]{
                    s.getRollNumber(),
                    s.getStudentName(),
                    s.studentClass,
                    marksStr,
                    s.getTotalNumber(),
                    s.getPercentage(),
                    s.getGrade()
            });
        }
    }
}
