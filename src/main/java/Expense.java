import java.time.LocalDate;
import java.util.Date;

public class Expense
{
    private int id;
    private String description;
    private double amount;
    private LocalDate date;

    public Expense(int id, String description, double amount, LocalDate date)
    {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String toCSV()
    {
        return id + "," + description + "," + amount + "," + date.toString();
    }

}
