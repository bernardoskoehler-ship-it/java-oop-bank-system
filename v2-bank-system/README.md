# 🏦 Java Bank System v2

An improved version of a console-based banking system built in Java, focusing on better architecture, validation, and user interaction.

This version enhances the original project (v1) by introducing stronger object-oriented design, safer input handling, and a fully interactive system.

---

## 🚀 What’s New in v2

This version is a major upgrade over **v1**, focusing on code quality and real-world behavior.

### 🔥 Key Improvements

* ✅ Interactive console menu system
* ✅ Safe input handling (no crashes on invalid input)
* ✅ Centralized control with `Banco` class
* ✅ Better validation across all operations
* ✅ Consistent use of `boolean` returns for operation success/failure
* ✅ Improved method naming (`valorPosTaxa`)
* ✅ Account activation system with password attempts
* ✅ Transaction history with access control (only active accounts)
* ✅ Polymorphism for account behavior

---

## 🧠 Concepts Applied

* Object-Oriented Programming (OOP)

  * Inheritance (`ContaBase` → account types)
  * Polymorphism (method overriding)
  * Encapsulation (private attributes + controlled access)
  * Abstraction (shared behavior in base class)
* Data Structures

  * `HashMap` for account management
* Input validation and error prevention
* Console-based system design

---

## 🏗️ Project Structure

```id="struct-v2"
.
├── ContaBase.java
├── ContaCorrente.java
├── ContaPoupanca.java
├── ContaPremium.java
├── Banco.java
├── MenuBanco.java
└── Main.java
```

---

## ⚙️ How the System Works

* `Banco` manages all accounts and operations
* Each account type defines its own rules:

  * `ContaCorrente`: allows overdraft
  * `ContaPoupanca`: generates interest
  * `ContaPremium`: reduced transaction tax
* `MenuBanco` handles user interaction via terminal
* All operations are validated before execution

---

## ▶️ Running the Project

```bash id="compile-v2"
javac *.java
java Main
```

---

## 🧪 Example Menu

```id="menu-v2"
1 - Create account
2 - Activate account
3 - Deposit
4 - Withdraw
5 - Transfer
6 - Show account
7 - Show history
0 - Exit
```

---

## 📊 v1 vs v2 Comparison

| Feature                      | v1 | v2 |
| ---------------------------- | -- | -- |
| Basic OOP structure          | ✅  | ✅  |
| Multiple account types       | ✅  | ✅  |
| Transaction logic            | ✅  | ✅  |
| Input validation             | ❌  | ✅  |
| Interactive menu             | ❌  | ✅  |
| Centralized system (`Banco`) | ❌  | ✅  |
| Safe null handling           | ❌  | ✅  |
| Boolean-based operations     | ❌  | ✅  |
| Account activation system    | ❌  | ✅  |
| Improved method naming       | ❌  | ✅  |

---

## ⚠️ Current Limitations

* Accounts are identified by name
* No persistent storage (data is lost after execution)
* Console-only interface

---

## 🔮 Future Improvements

* Automatic account ID generation
* Database or file persistence
* Login system (session-based access)
* GUI version (JavaFX or web)
* Better transaction modeling (using objects instead of strings)

---

## 👨‍💻 Author

Developed by Bernardo Koehler

---

## 📌 About This Project

This project was built as part of a Java learning journey, focusing on improving code structure, applying OOP concepts, and evolving from a simple system (v1) into a more complete and robust application (v2).
