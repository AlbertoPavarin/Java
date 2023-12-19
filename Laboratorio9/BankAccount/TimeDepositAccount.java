public class TimeDepositAccount extends SavingsAccount
{
    int monthsCount;

    public TimeDepositAccount(double initialRate)
    {
        super(initialRate);
        monthsCount = 0;
    }

    public TimeDepositAccount(double initialRate, int initialMonthCount)
    {
        super(initialRate);
        monthsCount = initialMonthCount;
    }

    public TimeDepositAccount(double initialBalance, double initialRate, int initialMonthCount)
    {
        super(initialBalance ,initialRate);
        monthsCount = initialMonthCount;
    }


    public void withdraw(double amount)
    {
        if (monthsCount > 0)
            amount += 20;
        super.withdraw(amount);
        
    }

    public void addInterest()
    {
        super.addInterest();
        monthsCount--;
    }

    public int getMonthsLeft()
    {
        return monthsCount;
    }

    public String toString()
    {
        return "TimeDepositAccount[monthsCount=" + monthsCount + "]" + super.toString();
    }
}