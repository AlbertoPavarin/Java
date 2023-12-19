public class BankAccount implements Comparable
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

   public int compareTo(Object obj)
   {
      BankAccount acc = (BankAccount)obj;
      if (this.balance > acc.balance) return 1;
      if (this.balance < acc.balance) return -1;
      return 0;
   }

    // -------- campi di esemplare ---------

    private double balance;
}

