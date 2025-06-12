# Expense Tracker CLI Application
This is a simple Command Line Interface Application for keeping track of expenses. You can add, update, and delete expenses directly from the termianl. You can also view all expenses and the total cost of all expenses.

## Installation
1. Ensure you have the latest JDK installed.
2. Clone the repository
   ```
   git clone https://github.com/zachprogramming1684/ExpenseTrackerCLI.git
   ```
3. Navigate to the correct directory
   ```
   cd ExpenseTrackerCLI/src/main/java
   ```
4. Compile the project
   ```
   javac ExpenseTrackerApp.java
   ```
5. Run the project
   ```
   java ExpenseTrackerApp <your argument(s)>
   ```
## Usage
1. Add an expense
   ```
      java ExpenseTrackerApp add "milk from the store" 4.99
      Output: Expense added successfully (ID: 1)
   ```
2. Delete an expense
   ```
      java ExpenseTrackerApp delete 1
      Output: Expense deleted successfully
   ```
3. Update an expense
   ```
      java ExpenseTrackerApp update 1 "bananas from the store" 2.99
      Output: Expense updated successfully
   ```
4. List all expenses
   ```
      java ExpenseTrackerApp list
   ```
5. List total cost of all expenses
   ```
      java ExpenseTrackerApp summary
   ```  
      

   Submitted for roadmap.sh with some minor changes
   https://roadmap.sh/projects/expense-tracker
