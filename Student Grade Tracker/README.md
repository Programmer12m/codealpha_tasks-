# 🎓 Student Grade Tracker (Core Java + Swing)

A simple **Student Grade Management System** built using **Core Java** and **Java Swing GUI**. This project allows managing student records, entering marks, calculating grades, and generating class-level reports through a graphical user interface.

---

## 📌 Features

* ➕ Add new students (Roll Number, Name, Class)
* 📝 Enter marks for 5 subjects with validation (0–100)
* 📊 Automatic calculation of:

  * Total marks
  * Percentage
  * Grade (A–F)
* 🔍 View all students in a table
* 📈 Generate class report:

  * Maximum marks
  * Minimum marks
  * Average marks
* 🖥️ User-friendly **Java Swing GUI** (no console input)

---

## 🧠 Concepts Used

* Core Java (OOP principles)

  * Encapsulation
  * Classes & Objects
* Collections (`ArrayList`)
* Java Swing (`JFrame`, `JTable`, `JButton`, `JOptionPane`)
* Event Handling
* MVC-style separation (Logic vs UI)

---

## 🗂️ Project Structure

```
Student-Grade-Tracker/
│
├── src/
│   └── Student/
│       ├── Main.java            # Console version (optional)
│       ├── StudentGUI.java      # Swing GUI entry point
│       ├── Student.java         # Student model & calculations
│       └── Calculations.java    # Grade calculation logic
│
└── README.md
```

---

## 🧮 Grade Calculation Logic

Grades are calculated **based on percentage**:

| Percentage | Grade |
| ---------- | ----- |
| 90–100     | A     |
| 80–89      | B     |
| 70–79      | C     |
| 60–69      | D     |
| < 60       | F     |

---

## ▶️ How to Run the Project

### Requirements

* Java JDK 17 or later (built in JDK 25)
* IntelliJ IDEA / Eclipse / VS Code

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/ Programmer12m/student-grade-tracker.git
   ```
2. Open the project in your IDE
3. Run:

   ```
   StudentGUI.java
   ```

---

## 🖼️ GUI Preview (Description)

* **Main Window**

  * Displays all students in a table
  * Buttons at the bottom:

    * Add Student
    * Enter Marks
    * Class Report

* **Add Student Dialog**

  * Input fields for roll number (6 digits), name, and class

* **Enter Marks Dialog**

  * Five input fields (one per subject)
  * Input validation prevents invalid marks

* **Class Report Dialog**

  * Shows max, min, and average marks of the class

---

## 🚀 Future Improvements

* Save data to file or database
* Edit / delete student records
* Subject-wise grading
* Export report as PDF
* JavaFX version

---

## 👨‍💻 Author

**Java Student | Core Java Project**  
Built as a learning project to strengthen Java fundamentals and GUI development.(INTERSHIP PROJECT)

**Name:** Muhammad Ali
**GitHub:** Programmer12m / JavaPerson1  
**Role:** College Student  
**Contact:** Discord – JavaPerson1

---

## ⭐ GitHub Tip

If you find this project helpful, consider giving it a ⭐ on GitHub!

Help me in improving it!
