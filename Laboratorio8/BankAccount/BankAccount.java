public class BankAccount{
    private double balance;

    public boolean deposit(double amount)
    {
        if (amount <= 0)
            return false;

        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount)
    {
        if (amount <= 0 || amount > this.balance)
            return false;

        this.balance -= amount;
        return true;
    }

    public double getBalance()
    {
        return this.balance;
    }

}