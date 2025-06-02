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

        test
     */

    public static void main (String[] args)
    {
        try
        {
            ArrayList<Expense> allExpenses = new ArrayList<>();
            File f = new File("expenses.csv");
            FileOutputStream fos = new FileOutputStream("expenses.csv", true);
            Scanner in = new Scanner(f);
            PrintWriter out = new PrintWriter(fos);
            LocalDate newDate = LocalDate.now();
            int idCounter = 1;

            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] tokens = line.split(",");
                Expense temp = new Expense(Integer.parseInt(tokens[0]), tokens[1], Double.parseDouble(tokens[2]), LocalDate.parse(tokens[3]));
                allExpenses.add(temp);
                idCounter++;
            }

            for (Expense e : allExpenses) {
                if (e.getId() - idCounter > 0) {
                    idCounter++;
                }
            }

            switch(args[0])
            {
                case "add":
                    addExpense(out, idCounter, args[1], Double.parseDouble(args[2]), newDate);
                    System.out.println("Expense added successfully (ID: " + idCounter + ")");
                    break;
                case "update":
                    updateExpense(out, Integer.parseInt(args[1]), allExpenses, args[2], idCounter);
                    break;
                case "delete":
                    deleteExpense(out, Integer.parseInt(args[1]), allExpenses, idCounter);
                    break;
                case "list":
                    printExpenses(allExpenses);
                    break;
                case "summary":
                    printTotals(allExpenses);
                    break;
                default:
                    System.out.println("Unknown command");

            }

            System.out.println(idCounter);

            out.close();

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error editing or creating file");
        }
        catch(Exception e)
        {
            System.out.println("Error. Please ensure all parameters are valid and correct.");
        }

    }

    //Done I think
    public static void addExpense(PrintWriter out, int id, String desc, double amount, LocalDate newDate)
    {
        Expense e = new Expense(id, desc, amount, newDate);
        out.println(e.toCSV());
        out.flush();
    }

    public static void updateExpense(PrintWriter out, int id, ArrayList<Expense> allExpenses, String desc, int idCount) throws FileNotFoundException
    {
        // TODO: double confirm new logic works
        if(!allExpenses.isEmpty() && id < idCount)
        {
            FileOutputStream fos = new FileOutputStream("expenses.csv", false);
            for (Expense e : allExpenses)
            {
                if (e.getId() == id)
                {
                    e.setDescription(desc);
                    break;
                }
            }
            for (Expense e : allExpenses)
            {
                out.println(e.toCSV());
            }
            System.out.println("Expense updated successfully.");
        }
        else
        {
            System.out.println("No expenses found");
        }
        out.flush();
    }

    public static void deleteExpense(PrintWriter out, int id, ArrayList<Expense> allExpenses, int idCount) throws FileNotFoundException
    {
        // TODO: double confirm new logic works
        if(!allExpenses.isEmpty() && id < idCount) {
            FileOutputStream fos = new FileOutputStream("expenses.csv", false);
            Expense toDelete = null;
            for (Expense e : allExpenses) {
                if (e.getId() == id) {
                    toDelete = e;
                    break;
                }
            }
            allExpenses.remove(toDelete);
            for (Expense e : allExpenses) {
                out.println(e.toCSV());
            }
            System.out.println("Expense deleted successfully.");
        }
        else
        {
            System.out.println("No expenses found");
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
