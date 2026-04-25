# 🏦 Java Bank System V2 (Console Application)

A simple banking system developed in Java using Object-Oriented Programming principles.

This project simulates basic banking operations such as account creation, deposits, withdrawals, transfers, and transaction history management through a console-based interface.

---

## 🚀 Features

* Create different types of accounts:

  * Current Account
  * Savings Account
  * Premium Account
* Account activation with password validation
* Deposit and withdrawal operations
* Money transfers between accounts
* Transaction history tracking
* Input validation (prevents crashes from invalid input)
* Console-based interactive menu

---

## 🧠 Concepts Applied

* Object-Oriented Programming (OOP)

  * Inheritance
  * Polymorphism
  * Encapsulation
  * Abstraction
* Data Structures

  * HashMap for account storage
* Input validation using Scanner
* Error handling (preventing NullPointerException)

---

## 🏗️ Project Structure

```
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

## 💡 How It Works

* The `Banco` class manages all accounts using a `HashMap`.
* Each account type extends `ContaBase` and customizes behavior:

  * `ContaCorrente`: allows overdraft
  * `ContaPoupanca`: applies interest
  * `ContaPremium`: reduced transaction tax
* The `MenuBanco` class provides a user interface via terminal.

---

## ▶️ Running the Project

1. Compile all `.java` files:

```bash
javac *.java
```

2. Run the program:

```bash
java Main
```

---

## 🧪 Example Usage

```
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

## ⚠️ Limitations

* Accounts are identified by name (not realistic for production systems)
* No data persistence (all data is lost when the program closes)
* Console-based only (no GUI)

---

## 🔮 Future Improvements

* Automatic account ID generation
* File or database persistence
* Graphical interface (GUI)
* Improved transaction system (using objects instead of Strings)
* Authentication system (login/logout)

---

## 👨‍💻 Author

Developed by [Your Name]

---

## 📌 Notes

This project was built as part of a Java learning journey focused on backend development and problem-solving through practical implementations.
