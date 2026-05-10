# Lab 1 - Software Project Registration Form

**Student:** Bekir Kaan ÇALIŞKAN
**Student ID:** 202328018
**Course:** SENG 272 - Software Project II

---

## About

A simple Java Swing form application that collects information about a
software project (name, team leader, team size, project type, start date)
and saves it to a local text file (`projects.txt`).

The lab covers:
- Java Swing components (JFrame, JPanel, JLabel, JTextField, JComboBox, JButton)
- Event handling with ActionListener
- File I/O using FileWriter
- Basic Git/GitHub usage

---

## How to compile

From the project root:

\`\`\`bash
javac -d bin src/ProjectFormApp.java src/ProjectFormPanel.java
\`\`\`

## How to run

\`\`\`bash
java -cp bin ProjectFormApp
\`\`\`

---

## Form fields

| Field | Component | Notes |
|---|---|---|
| Project Name | JTextField | free text |
| Team Leader | JTextField | free text |
| Team Size | JComboBox | 1-3, 4-6, 7-10, 10+ |
| Project Type | JComboBox | Web, Mobile, Desktop, API |
| Start Date | JTextField | DD/MM/YYYY |

## Buttons

- **Save** - checks that all fields are filled, then appends a new entry
  to projects.txt. A success message is shown via JOptionPane.
- **Clear** - resets all text fields and combo boxes.

---

## File format

Each entry is appended to projects.txt with the structure:

\`\`\`
=== Project Entry ===
Project Name : ...
Team Leader  : ...
Team Size    : ...
Project Type : ...
Start Date   : ...
Record Time  : 2026-04-...
====================
\`\`\`

The record time is captured automatically using LocalDateTime.now().

---

## Project structure

\`\`\`
lab1-swing-fileio/
├── src/
│   ├── ProjectFormApp.java     (main, frame setup)
│   └── ProjectFormPanel.java   (form UI + event logic)
├── .gitignore
└── README.md
\`\`\`
