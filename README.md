# 📚 Library Management System – Java (OOP)

A simple yet feature-rich **console-based Library Management System** built with **Object-Oriented Programming (OOP)** principles in Java.  
This project manages books and users, supports multiple copies of each book, and prevents users from borrowing more than one copy of the same title.

---

## 🚀 Features
- **Book & User Management**
  - Auto-generated unique IDs for books (`B1`, `B2`, …) and users (`U1`, `U2`, …).
  - Tracks total and available copies of each book.
- **Borrow & Return**
  - Issue a book only if copies are available.
  - A user **cannot** borrow multiple copies of the same book.
  - Proper return process restores availability.
- **Search**
  - Search by **title**, **author**, or **book ID** (case-insensitive).
- **Inventory**
  - Supports multiple copies of each book and maintains accurate counts.


---

## 🛠️ Technologies Used
- **Java 17+** (works on Java 8+)
- Core Java OOP (classes, objects, collections, streams)

---

## ⚙️ Setup & Run
1. **Clone or Download**
   ```bash
   git clone https://github.com/<your-username>/library-management-java.git
   cd library-management-java
