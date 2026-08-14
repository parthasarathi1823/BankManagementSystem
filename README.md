\# 🏦 Bank Management System



A \*\*console-based Bank Management System built in Java\*\* to practice Object-Oriented Programming, collections, input handling, validation, and Git/GitHub development workflows.



\## 📌 Features



\* Create a new bank account

\* Automatically generate account numbers

\* Deposit money

\* Withdraw money

\* PAN-based authentication for withdrawals

\* Transfer money between accounts

\* Display account details

\* Account active/inactive status

\* Balance validation

\* Amount validation

\* Account existence validation

\* Insufficient-balance validation

\* PAN verification before secure transactions



\## 🛠️ Technologies Used



\* \*\*Java\*\*

\* \*\*Java Collections Framework\*\*



&#x20; \* `HashMap`

&#x20; \* `Map`

\* \*\*Scanner\*\* for console input

\* \*\*Git \& GitHub\*\* for version control



\## 📂 Project Structure



```text

BankManagementSystem/

│

├── Account.java

├── Bank.java

├── BankInterface.java

├── .gitignore

└── README.md

```



\### `Account.java`



Represents an individual bank account.



It stores:



\* Account holder name

\* PAN number

\* Phone number

\* Balance

\* Account type

\* Account activity status



It provides operations such as:



\* Deposit

\* Withdrawal

\* Display account details



\### `Bank.java`



Handles the overall banking operations and maintains accounts using a `HashMap`.



```text

Map<Integer, Account>

```



The account number is used as the key and the corresponding `Account` object is stored as the value.



\### `BankInterface.java`



Provides the console-based user interface and handles user input using `Scanner`.



\## 🔐 Security



The project includes a basic \*\*PAN-based security mechanism\*\*.



For example, before a withdrawal:



```text

Enter account number: 1001

Enter amount to withdraw: 500

Enter PAN for secure withdrawal: 123

```



The entered PAN is compared with the PAN stored in the corresponding account.



```java

if (usr\_pan.equals(acc.getPan())) {

&#x20;   // withdrawal

}

```



Only when the PAN matches can the withdrawal proceed.



\## 💰 Transaction Validation



The application validates several conditions before performing transactions.



\### Deposit



\* Amount must be greater than `0`

\* Account must exist

\* Account must be active



\### Withdrawal



\* Amount must be greater than `0`

\* Account must exist

\* Account must be active

\* PAN must match

\* Sufficient balance must be available



\### Transfer



\* Transfer amount must be greater than `0`

\* Sender account must exist

\* Receiver account must exist

\* Both accounts must be active

\* Sender authentication is required

\* Sender must have sufficient balance



\## ▶️ How to Run



Make sure Java is installed:



```powershell

java -version

javac -version

```



Compile the project:



```powershell

javac \*.java

```



Run the application:



```powershell

java BankInterface

```



\## 🖥️ Menu



The application provides the following menu:



```text

========== BANK MANAGEMENT SYSTEM ==========

1\. Create Account

2\. Deposit

3\. Withdraw

4\. Transfer

5\. Display Account

6\. Exit

============================================

```



\## 🧠 OOP Concepts Practiced



This project is primarily built as a Java OOP learning project.



\### Encapsulation



Account fields are kept private:



```java

private String name;

private String pan;

private double balance;

```



Access is provided through methods such as:



```java

getBalance()

getPan()

getIs\_active()

```



\### Classes and Objects



The project uses separate classes for:



```text

Account

Bank

BankInterface

```



\### Constructors



Accounts are initialized using a constructor:



```java

public Account(String name, String pan, String phone)

```



\### Composition



`Bank` maintains multiple `Account` objects using a `HashMap`.



\## 🌿 Git Branching



Git branches are used while developing new features.



Example:



```text

main

&#x20;│

&#x20;└── feature-safety

```



The `feature-safety` branch is used for developing security-related features without directly changing the stable `main` branch.



\## 🚧 Current Limitations



This is currently a \*\*learning project\*\*, so it has some limitations:



\* Data is stored only in memory

\* Accounts disappear when the application exits

\* No database is currently used

\* No graphical user interface

\* Basic PAN authentication only

\* No real banking authentication/encryption

\* Account numbers are generated locally

\* No multi-user or concurrent access



\## 🔮 Future Improvements



Possible future versions could include:



\* Persistent database storage

\* Login/authentication system

\* Better transaction validation

\* Transaction history

\* Account deactivation/reactivation

\* PIN/password authentication

\* Exception handling

\* JUnit automated testing

\* REST API

\* Spring Boot backend

\* Database integration using MySQL/PostgreSQL

\* Web-based frontend

\* Docker deployment



\## 🎯 Purpose



This project is being developed as a practical way to learn and apply:



\* Java fundamentals

\* Object-Oriented Programming

\* Collections

\* Input handling

\* Validation

\* Debugging

\* Software design

\* Git and GitHub

\* Branch-based development

\* Automated testing



> \*\*Note:\*\* This project is for educational purposes and is not intended for handling real financial transactions or sensitive banking information.

\---



\# Changelog



\## \[v1.0.1] — 2026-08-15



\### Added



\* Added \*\*PAN-based authentication\*\* for secure withdrawals.

\* Added PAN verification before processing withdrawal requests.

\* Added sender PAN verification for secure account transfers.

\* Added validation for positive deposit, withdrawal, and transfer amounts.

\* Added account existence checks before performing transactions.

\* Added account active-status checks for banking operations.

\* Added insufficient-balance validation for withdrawals and transfers.



\### Improved



\* Improved transaction validation and error messages.

\* Improved separation of responsibilities between `BankInterface`, `Bank`, and `Account`.

\* Improved console input handling by using a single `Scanner` instance.

\* Improved Git repository configuration by ignoring compiled `.class` files.



\### Fixed



\* Fixed PAN and phone number parameter ordering during account creation.

\* Fixed withdrawal PAN input handling after `nextDouble()`.

\* Fixed withdrawal balance comparison logic.

\* Fixed `Scanner` resource handling that caused `NoSuchElementException`.

\* Fixed successful-withdrawal messages being displayed when the balance was insufficient.



\### Development



\* Added/updated Git branching workflow for feature development.

\* Continued development on the `feature-safety` branch.

\* Prepared the project for automated testing with JUnit.



\## Previous Version



\### \[v1.0.0]



\* Initial Bank Management System implementation.

\* Account creation.

\* Deposit functionality.

\* Withdrawal functionality.

\* Account-to-account transfer.

\* Account details display.

\* Basic account validation.

\* Console-based interface.



