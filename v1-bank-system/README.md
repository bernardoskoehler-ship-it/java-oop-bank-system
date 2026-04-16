# 💳 Bank System — v1

This is the first version of the Bank System project.

It focuses on implementing the core banking features using basic Object-Oriented Programming concepts in Java.

---

## ⚙️ Features

- Create accounts
- Deposit money
- Withdraw money
- Transfer between accounts
- Basic transaction history

---

## 🧱 Structure

The system is based on a base account class and derived account types:

- `ContaBase` → Contains shared logic
- `ContaPadrao` → Standard account (lower limits)
- `ContaDeluxe` → Deluxe account (higher limits)

---

## 📌 Rules Implemented

- Validation for input values
- Balance checks before withdrawal
- Transfer logic between accounts
- Different limits depending on account type

---

## 📉 Limitations

This version is simple and has some limitations:

- No advanced error handling
- Basic validation only
- No persistence (data is not saved)
- Console-based interaction

---

## 🎯 Purpose

This version was created to practice:

- Encapsulation
- Inheritance
- Basic business rules

---

## 🚀 Next Steps (v2 Ideas)

- Improve validation logic
- Add better transaction history structure
- Introduce interfaces
- Refactor duplicated code
- Improve code organization

---

## 👨‍💻 Author

Developed by [Bernardo](https://github.com/bernardoskoehler-ship-it)
