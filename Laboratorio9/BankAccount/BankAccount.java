public class BankAccount
{
    public BankAccount()
    {
        balance = 0;
    }

    public BankAccount(double initialBalance)
    {   
        deposit(initialBalance);
    }

    public void deposit(double amount)
    {
        if (amount <= 0)
            throw new IllegalArgumentException();
        balance = balance + amount;
    }

    public void withdraw(double amount)
    {
        if (amount > balance || amount <= 0)
            throw new IllegalArgumentException();
        balance = balance - amount;
    }

    public void transfer(double amount, BankAccount other)
    { 
        withdraw(amount);
        other.deposit(amount);
    }


    // ------- metodi di accesso --------

    public double getBalance()
    {   
        return balance;
    }

    // ------ metodi di Object sovrascritti ---------
    // ........... toString, equals .................

    public String toString()
    {
        return "BankAccount[balance=" + this.balance + "]" + super.toString();
    }

    public boolean equals(Object obj)
    {
        BankAccount other = (BankAccount)obj;
        if (other.balance == this.balance)
            return true;
        else
            return false;
    }

    // -------- campi di esemplare ---------

    private double balance;
}

