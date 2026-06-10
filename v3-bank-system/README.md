# Bank System V3

A simple banking system developed in Java using SQLite for data persistence.

This project was created as a learning exercise to practice object-oriented programming, database integration with JDBC, SQL operations, and software architecture concepts such as DAO (Data Access Object).

## Features

* Create bank accounts
* Login and logout system
* Deposit money
* Withdraw money
* Transfer money between accounts
* View account information
* Persistent data storage using SQLite
* Automatic account state reset on application startup

## Technologies Used

* Java
* SQLite
* JDBC
* IntelliJ IDEA

## Project Structure

```text
MenuBanco
    ↓
Banco
    ↓
ContaDAO
    ↓
SQLite Database
```

### Classes

#### Main

Application entry point.

#### MenuBanco

Handles user interaction through the console interface.

#### Banco

Contains the business logic for account operations.

#### ContaDAO

Manages database communication and SQL queries.

#### Conta

Represents a bank account and contains account-related validation logic.

## Database

The system uses an SQLite database stored locally.

Main table:

```sql
CREATE TABLE IF NOT EXISTS contas (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT,
    senha TEXT,
    saldo DOUBLE,
    limite DOUBLE,
    contaAtiva BOOLEAN
);
```

## Available Operations

### Account Creation

Users can create new accounts by providing:

* Name
* Password

### Login

Users can log in using:

* Account ID
* Password

### Deposit

Adds money to the current account balance.

### Withdraw

Removes money from the account if sufficient balance is available.

### Transfer

Transfers funds from one account to another.

### Account Information

Displays:

* Account ID
* Account Owner
* Current Balance

## Learning Goals

This project was developed to practice:

* Java fundamentals
* Object-Oriented Programming (OOP)
* JDBC database connectivity
* SQL CRUD operations
* Application architecture
* Exception handling
* Data persistence

## Future Improvements

* Transaction history
* Account statements
* Password encryption (hashing)
* Improved input validation
* Multiple user sessions
* Better console interface
* Unit testing

## Author

Developed by Bernardo S. Koehler as part of a personal Java learning journey.
