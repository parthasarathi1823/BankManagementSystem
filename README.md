# 🏦 Bank Management System

**Version:** `v1.1.0`

A **console-based Bank Management System built in Java** to practice Object-Oriented Programming, inheritance, polymorphism, collections, input handling, validation, and Git/GitHub development workflows.

The app is split into an **Admin Panel** and a **Customer Panel**, with boxed menus and highlighted notices for important user-facing messages.

## 📌 Features

### Customer

* Create a **Savings** or **Current** account (with input rules shown before entry)
* Automatically generate account numbers (starting from `1001`)
* Deposit money
* Withdraw money (PAN required; account-type rules enforced)
* Transfer money between accounts (sender PAN required; account-type rules enforced)
* Display account details (including calculated interest)
* Clear **Account creation cancelled** notice when creation fails for any reason

### Admin

* Display all accounts (with account type)
* Update customer details (name / phone; enter `-` to keep existing value)
* Toggle account activity status (Active / Inactive)

### Shared

* Account active/inactive status checks on transactions
* Balance, amount, and account-existence validation
* PAN verification before secure transactions
* Name, phone, and PAN format validation on account creation / profile update
* Highlighted menus and alerts (`>>>` prefix for errors/notices)

## 🏛️ Account Types

### Savings Account

* Opening balance: **₹1000.00** (minimum balance)
* Minimum balance must be maintained after every withdrawal
* Interest rate: **4%** per annum (calculated on current balance)
* No overdraft

### Current Account

* Opening balance: **₹0.00**
* Overdraft limit: **₹5000.00**
* No interest earned

Withdrawal and transfer limits are enforced by each account subclass via polymorphic `withdraw()` — the `Bank` class delegates to the account object rather than applying a generic balance check.

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
├── Account.java            # Abstract base account
├── SavingsAccount.java     # Savings account (min balance + interest)
├── CurrentAccount.java     # Current account (overdraft, no interest)
├── Bank.java
├── BankInterface.java      # Main entry + panel selection
├── AdminInterface.java     # Admin panel
├── CustomerInterface.java  # Customer panel
├── .gitignore
└── README.md
```

### `Account.java`

Abstract base class for all account types. Stores:

* Account holder name
* PAN number (immutable after creation)
* Phone number
* Balance
* Account activity status

Provides shared operations (`deposit`, `display`, getters/setters) and declares abstract methods for account-type-specific behavior:

* `withdraw(double amount)` — enforced per subclass
* `getAccountType()` — returns the account type label
* `calculateIntrest()` — returns calculated interest on current balance

### `SavingsAccount.java`

Extends `Account`. Enforces a **₹1000 minimum balance** on withdrawals and calculates **4% interest** on the current balance.

### `CurrentAccount.java`

Extends `Account`. Starts at **₹0** and allows withdrawals up to a **₹5000 overdraft limit**. Earns no interest.

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
* Account type: `1` (Savings) or `2` (Current) only
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
* Account-type rules enforced by subclass:
  * **Savings:** balance after withdrawal must stay ≥ ₹1000
  * **Current:** balance may go negative up to ₹5000 overdraft limit

### Transfer

* Transfer amount must be greater than `0`
* Sender and receiver must be different accounts
* Sender and receiver accounts must exist
* Both accounts must be active
* Sender PAN authentication is required
* Sender account-type withdrawal rules apply (same as withdrawal)

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

### Inheritance & Polymorphism

```text
Account (abstract)
 ├── SavingsAccount
 └── CurrentAccount
```

`Bank` stores and operates on `Account` references. Withdrawal rules differ per subclass — the correct `withdraw()` implementation is called at runtime.

### Encapsulation

Account fields are kept private/protected, with access through getters/setters such as:

```java
getBalance()
getPan()
isActive()
setName()
setPhone()
setActive()
```

### Abstraction

`Account` declares abstract methods (`withdraw`, `getAccountType`, `calculateIntrest`) that each subclass must implement.

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
* Inheritance and polymorphism
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

### [v1.1.0] — 2026-09-01

Account-type inheritance, polymorphic withdrawal rules, and validation fixes.

#### Added

* `SavingsAccount` and `CurrentAccount` subclasses extending abstract `Account`
* Account type selection during account creation (`1` = Savings, `2` = Current)
* Savings minimum-balance enforcement (₹1000) on withdrawals
* Current account overdraft support (up to ₹5000)
* `calculateIntrest()` implemented per account type and shown in account display
* Account type shown in creation success message and admin account listing
* Input validation for account type (numeric check + allowed values)

#### Changed

* `Account` refactored to abstract class with abstract `withdraw()`, `getAccountType()`, `calculateIntrest()`
* `Bank.createAccount()` now accepts account type code and creates the correct subclass
* `Bank.withdraw()` and `Bank.transfer()` delegate balance/overdraft checks to subclass `withdraw()` (polymorphism)
* Withdrawal/transfer failure messages now come from the account subclass (no duplicate generic message)
* README updated to document account types, inheritance architecture, and new validation rules

#### Fixed

* Invalid account type (e.g. `0`, `99`) no longer silently creates a Current Account
* Non-integer account type input no longer crashes with `InputMismatchException`
* Current account overdraft was blocked by a generic balance check in `Bank` — now works correctly
* Scanner buffer handling after account type input (`nextLine()` added)
* Account number no longer consumed when account type validation fails

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
