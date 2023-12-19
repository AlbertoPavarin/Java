public class AccountTester{
    public static void main(String[] args)
    {
        BankAccount bAcc1 = new BankAccount(100);
        BankAccount bAcc2 = new BankAccount(100);
        BankAccount bAcc3 = new BankAccount(200);
        System.out.println(bAcc1);

        System.out.println(bAcc1.equals(bAcc2));
        System.out.println(bAcc1.equals(bAcc3));

        System.out.println();

        SavingsAccount sAcc1 = new SavingsAccount(100, 10);
        SavingsAccount sAcc2 = new SavingsAccount(100, 10);
        SavingsAccount sAcc3 = new SavingsAccount(100, 5);
        System.out.println(sAcc1);

        System.out.println(sAcc1.equals(sAcc2));
        System.out.println(sAcc1.equals(sAcc3));
        
        System.out.println();

        CheckingAccount cAcc1 = new CheckingAccount(100);
        CheckingAccount cAcc2 = new CheckingAccount(100, 0);
        CheckingAccount cAcc3 = new CheckingAccount(200, 2);
        System.out.println(cAcc1);

        System.out.println(cAcc1.equals(cAcc2));
        System.out.println(cAcc1.equals(cAcc3));
    }
}