# SIMPLE-TASK-MANAGMENT
# 🧩 Simple Task Management – Java Console Project

A simple, console-based Task Management system built using Java. This project is designed to demonstrate core Object-Oriented Programming (OOP) principles along with File Handling for persistent data storage — all without using databases or external frameworks.

---

## 🎯 Features

•⁠  ⁠📌 Add Task – Create new tasks with description, priority, due date, and status.
•⁠  ⁠📃 View Tasks – Display all tasks with structured formatting.
•⁠  ⁠✅ Mark Task as Completed – Update the task status to "Done".
•⁠  ⁠✏ Edit Task – Modify task details.
•⁠  ⁠🗑 Delete Task – Remove tasks from the list.
•⁠  ⁠💾 Persistent Storage – All tasks are saved to a .txt file for reuse.

---

## 🧠 Key Concepts Demonstrated

•⁠  ⁠🔒 Encapsulation
•⁠  ⁠📦 Abstraction
•⁠  ⁠🔁 Object Interaction
•⁠  ⁠🗃 File I/O using java.io
•⁠  ⁠🔧 Clean Console UI with Java's Scanner

---

## 🗂 Project Structure
TaskManagerProject/
│
├── model/
│ └── Task.java # Represents the Task entity
│
├── service/
│ └── TaskService.java # Core business logic
│
├── repository/
│ └── TaskRepository.java # File-based storage & retrieval
│
├── util/
│ └── FileUtil.java # File helper utilities
│
├── tasks.txt # Stores task data (acts like a DB)
└── Main.java # Entry point & Console UI
---

## 💡 How to Run

1.⁠ ⁠*Clone the Repository*
   ```bash
   git clone https://github.com/pratinjay28/SIMPLE-TASK-MANAGMENT.git
   cd SimpleTaskManager
Use your terminal or IDE to compile:
javac Main.java
use your terminal or IDE to run:
java Main
🖥️ Console Preview
Welcome to the Task Manager!

1.⁠ ⁠Add New Task
2.⁠ ⁠View Tasks
3.⁠ ⁠Mark Task as Completed
4.⁠ ⁠Edit Task
5.⁠ ⁠Delete Task
6.⁠ ⁠Exit

Enter your choice: 1
Enter task description: Study OOP
Enter priority (High/Medium/Low): High
Enter due date (YYYY-MM-DD): 2025-06-15
Task added successfully!

--- Tasks ---
[0] Description: Study OOP | Priority: High | Due: 2025-06-15 | Status: To Do
🗃 Sample Data File (tasks.txt)
Study OOP|High|2025-06-15|To Do
Clean room|Medium|2025-06-10|Done
✅ Use Cases
This console-based task manager is ideal for users who want to:

🗓️ Organize Daily Tasks
Add, view, update, and delete your daily to-dos in a simple interface.

📂 Keep Tasks Saved Securely
All your tasks are automatically saved to a file (tasks.txt), so you never lose them — even after closing the app.

📌 Track Progress Easily
View all your pending tasks at any time and update them as you complete them.

🧘 Stay Focused and Productive
Focus on one task at a time by managing your list through this distraction-free tool.

⚙️ Use Without Internet
Runs fully offline — perfect for students, developers, or anyone needing a lightweight task tracker.
