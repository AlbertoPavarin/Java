public class BankAccount{
    private double balance;

    public void deposit(double amount)
    {
        this.balance += amount;
    }

    public void withdraw(double amount)
    {
        this.balance -= amount;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public static void main(String[] args)
    {

    }
}