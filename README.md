# 🏦 Bank Management System

**Version:** `v1.0.1`

A **console-based Bank Management System built in Java** to practice Object-Oriented Programming, collections, input handling, validation, and Git/GitHub development workflows.

The app is split into an **Admin Panel** and a **Customer Panel**, with boxed menus and highlighted notices for important user-facing messages.

## 📌 Features

### Customer

* Create a new bank account (with input rules shown before entry)
* Automatically generate account numbers (starting from `1001`)
* Deposit money
* Withdraw money (PAN required)
* Transfer money between accounts (sender PAN required)
* Display account details
* Clear **Account creation cancelled** notice when creation fails for any reason

### Admin

* Display all accounts
* Update customer details (name / phone; enter `-` to keep existing value)
* Toggle account activity status (Active / Inactive)

### Shared

* Account active/inactive status checks on transactions
* Balance, amount, and account-existence validation
* Insufficient-balance validation
* PAN verification before secure transactions
* Name, phone, and PAN format validation on account creation / profile update
* Highlighted menus and alerts (`>>>` prefix for errors/notices)

## 🛠️ Technologies Used

* **Java**
* **Java Collections Framework**
  * `LinkedHashMap`
  * `Map`
* **Scanner** for console input
* **Git & GitHub** for version control

## 📂 Project Structure

```text
BankManagementSystem/
│
├── Account.java
├── Bank.java
├── BankInterface.java      # Main entry + panel selection
├── AdminInterface.java     # Admin panel
├── CustomerInterface.java  # Customer panel
├── .gitignore
└── README.md
```

### `Account.java`

Represents an individual bank account.

It stores:

* Account holder name
* PAN number (immutable after creation)
* Phone number
* Balance (default opening balance: `1000.00`)
* Account type (`savings`)
* Account activity status

It provides operations such as:

* Deposit
* Withdrawal
* Display account details
* Update name / phone / activity status

### `Bank.java`

Handles banking operations and stores accounts in insertion order:

```java
Map<Integer, Account> accounts = new LinkedHashMap<>();
```

The account number is the key; the `Account` object is the value.

Also provides:

* `createAccount`, `deposit`, `withdraw`, `transfer`, `display`
* `displayAllAccounts`
* `modifyAccountDetails`
* `changeActivity`
* Validators: `validateName`, `validatePhone`, `validatePan`

### `BankInterface.java`

Application entry point. Shows the main panel menu and routes to Admin or Customer.

### `AdminInterface.java`

Admin console: list accounts, update customer details, toggle activity status.

### `CustomerInterface.java`

Customer console: create account, deposit, withdraw, transfer, display account.

## 🔐 Security

The project includes a basic **PAN-based security mechanism**.

PAN format required:

```text
AAAAA9999A
```

(5 letters + 4 digits + 1 letter)

Example withdrawal flow:

```text
Enter account number: 1001
Enter amount to withdraw: 500
Enter PAN: ABCDE1234F
```

Comparison is case-insensitive:

```java
if (userPan.equalsIgnoreCase(acc.getPan())) {
    // withdrawal
}
```

Only when the PAN matches can the withdrawal or transfer proceed.

## 💰 Transaction & Input Validation

### Account creation

* Name: letters and spaces only (non-empty)
* Phone: 10 digits, starting with `6`–`9`
* PAN: `AAAAA9999A`
* Empty fields or failed validation → **Account creation cancelled**

### Deposit

* Amount must be greater than `0`
* Account must exist
* Account must be active

### Withdrawal

* Amount must be greater than `0`
* Account must exist
* Account must be active
* PAN must match
* Sufficient balance must be available

### Transfer

* Transfer amount must be greater than `0`
* Sender and receiver must be different accounts
* Sender and receiver accounts must exist
* Both accounts must be active
* Sender PAN authentication is required
* Sender must have sufficient balance

### Admin profile update

* Enter `-` for name or phone to keep the current value
* Invalid name/phone is rejected without applying that field

## ▶️ How to Run

Make sure Java is installed:

```powershell
java -version
javac -version
```

Compile the project:

```powershell
javac *.java
```

Run the application:

```powershell
java BankInterface
```

## 🖥️ Menus

### Main menu

```text
╔══════════════════════════════════════════╗
║         BANK MANAGEMENT SYSTEM           ║
╠══════════════════════════════════════════╣
║  Select the User Panel:                  ║
║  1. Admin Panel                          ║
║  2. Customer Panel                       ║
║  3. Exit Platform                        ║
╚══════════════════════════════════════════╝
```

### Customer panel

```text
╔══════════════════════════════════════════╗
║             CUSTOMER PANEL               ║
╠══════════════════════════════════════════╣
║  1. Create Account                       ║
║  2. Deposit                              ║
║  3. Withdraw                             ║
║  4. Transfer                             ║
║  5. Display Account                      ║
║  6. Exit                                 ║
╚══════════════════════════════════════════╝
```

### Admin panel

```text
╔══════════════════════════════════════════╗
║              ADMIN PANEL                 ║
╠══════════════════════════════════════════╣
║  1. Display all accounts                 ║
║  2. Update Customer Details              ║
║  3. Update Activity Status               ║
║  4. Exit                                 ║
╚══════════════════════════════════════════╝
```

## 🧠 OOP Concepts Practiced

### Encapsulation

Account fields are kept private, with access through getters/setters such as:

```java
getBalance()
getPan()
isActive()
setName()
setPhone()
setActive()
```

### Classes and Objects

```text
Account
Bank
BankInterface
AdminInterface
CustomerInterface
```

### Constructors

```java
public Account(String name, String pan, String phone)
```

### Composition

`Bank` maintains multiple `Account` objects using a `LinkedHashMap`.

## 🌿 Git Branching

Git branches are used while developing new features.

Example:

```text
main
 │
 ├── feature-safety
 ├── AdminPannel-feature
 └── updateDetails-feature
```

Feature branches are used so work can be developed without changing stable `main` directly.

## 🚧 Current Limitations

This is currently a **learning project**, so it has some limitations:

* Data is stored only in memory
* Accounts disappear when the application exits
* No database is currently used
* No graphical user interface
* Basic PAN authentication only
* No real banking authentication/encryption
* Account numbers are generated locally
* No multi-user or concurrent access

## 🔮 Future Improvements

Possible future versions could include:

* Persistent database storage
* Login/authentication system
* Transaction history
* PIN/password authentication
* Exception handling
* JUnit automated testing
* REST API / Spring Boot backend
* Database integration using MySQL/PostgreSQL
* Web-based frontend
* Docker deployment

## 🎯 Purpose

This project is being developed as a practical way to learn and apply:

* Java fundamentals
* Object-Oriented Programming
* Collections
* Input handling
* Validation
* Debugging
* Software design
* Git and GitHub
* Branch-based development
* Automated testing

> **Note:** This project is for educational purposes and is not intended for handling real financial transactions or sensitive banking information.

---

## 📜 Changelog

### [v1.0.1] — 2026-08-21

UI polish, admin/customer split documentation, stronger validation messaging, and account-creation cancel notices.

#### Added

* Separate **Admin** and **Customer** panels (`AdminInterface`, `CustomerInterface`)
* Main panel selector in `BankInterface`
* Admin: display all accounts, update customer name/phone, toggle activity status
* Boxed console menus and important instruction boxes
* `>>>` highlighted alerts for invalid input and key notices
* Create-account rules box (name / PAN / phone formats)
* Explicit **Account creation cancelled** message when creation fails for any reason
* Boxed success message with generated account number on successful creation
* Name, phone, and PAN validators (`validateName`, `validatePhone`, `validatePan`)
* Profile update support with `-` to keep an existing field

#### Changed

* Account storage from `HashMap` to `LinkedHashMap` (stable insertion order when listing)
* PAN checks to case-insensitive comparison
* Method naming cleanup (`deposit`, `withdraw`, `isActive`, etc.)
* Scanner buffer handling after numeric input (`nextLine()` where needed)
* Project structure and menus documented to match the current UI

#### Fixed

* Invalid/empty account-creation inputs no longer fail silently — user is told creation was cancelled
* Incomplete admin update flow and activity-status option wired into the admin menu
* Menu option numbering aligned with available actions

### [v1.0.0] — Initial

* Console banking core: create account, deposit, withdraw, transfer, display
* PAN-based withdrawal/transfer checks
* In-memory `Map`-backed account store
* Basic amount / balance / existence validation
