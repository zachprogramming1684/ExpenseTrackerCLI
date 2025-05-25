import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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
            -- Add expense (done I think)
            -- Update expense (done I think)
            -- Delete expense (done I think)
            -- Print all expenses (done I think)
            -- Print summary of expenses (total amount) (done I think)
            -- View summary of expenses from a specific month of current year (do this later)
        - Create file I/O in main method
        - Create switch statement for getting desired operation
        - Create try catches for ensuring input is good

        ArrayList of all expenses will be initialized in main method and passed into functions that require it
     */

    public static void main (String[] args) throws FileNotFoundException
    {
        ArrayList<Expense> allExpenses = new ArrayList<>();
        File f = new File("expenses.csv");
        FileOutputStream fos = new FileOutputStream("expenses.csv", true);
        Scanner in = new Scanner(f);
        PrintWriter out = new PrintWriter(fos);
        LocalDate newDate = LocalDate.now();

        while (in.hasNextLine())
        {
            String line = in.nextLine();
            String[] tokens = line.split(",");
            Expense temp = new Expense(Integer.parseInt(tokens[0]), tokens[1], Double.parseDouble(tokens[2]), LocalDate.parse(tokens[3]));
            allExpenses.add(temp);
        }


        out.close();
    }

    //Done I think
    public static void addExpense(PrintWriter out, int id, String desc, double amount, LocalDate newDate)
    {
        Expense e = new Expense(id, desc, amount, newDate);
        out.println(e.toCSV());
        out.flush();
    }

    public static void updateExpense(PrintWriter out, int id, ArrayList<Expense> allExpenses, String desc) throws FileNotFoundException
    {
        FileOutputStream fos = new FileOutputStream("expenses.csv", false);
        for(Expense e : allExpenses)
        {
            if(e.getId() == id)
            {
                e.setDescription(desc);
                break;
            }
        }
        for(Expense e : allExpenses)
        {
            out.println(e.toCSV());
        }
        out.flush();
    }

    public static void deleteExpense(PrintWriter out, int id, ArrayList<Expense> allExpenses) throws FileNotFoundException
    {
        FileOutputStream fos = new FileOutputStream("expenses.csv", false);
        Expense toDelete = null;
        for(Expense e : allExpenses)
        {
            if(e.getId() == id)
            {
                toDelete = e;
                break;
            }
        }
        allExpenses.remove(toDelete);
        for(Expense e : allExpenses)
        {
            out.println(e.toCSV());
        }
        out.flush();
    }
    public static void printExpenses(ArrayList<Expense> allExpenses)
    {
        for(Expense e : allExpenses)
        {
            System.out.println(e);
        }
    }

    public static void printTotals(ArrayList<Expense> allExpenses)
    {
        double total = 0;
        for(Expense e : allExpenses)
        {
            total += e.getAmount();
        }
        System.out.println("Total: $" + total);
    }


}
