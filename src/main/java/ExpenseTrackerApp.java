import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;

public class ExpenseTrackerApp
{
    /*
        Features:
        - Add an expense with description and amount
        - Update an expense with a new description
        - Delete an expense
        - View all expenses
        - View summary of expenses (total amount)
        - View summary of expenses from a specific month (of current year)

        Order of Operations:
        - Create methods
            -- Add expense
            -- Update expense
            -- Delete expense
            -- Print all expenses
            -- Print summary of expenses (total amount)
            -- View summary of expenses from a specific month of current year)
        - Create file I/O in main method
        - Create switch statement for getting desired operation
        - Create try catches for ensuring input is good

        ArrayList of all expenses will be initialized in main method and passed into functions that require it
     */

    public static void main (String[] args) throws FileNotFoundException
    {
        File f = new File("expenses.csv");
        FileOutputStream fos = new FileOutputStream("expenses.csv", true);
        PrintWriter out = new PrintWriter(fos);
        LocalDate newDate = LocalDate.now();


    }

    //Done I think
    public static void addExpense(PrintWriter out, int id, String desc, double amount, LocalDate newDate)
    {
        Expense e = new Expense(id, desc, amount, newDate);
        out.println(e.toCSV());
        out.flush();
        out.close();
    }

}
