public class BankAccountTester{
    public static void main(String[] args)
    {
        BankAccount account = new BankAccount();
        System.out.println("Saldo Iniziale:" + account.getBalance());
        account.deposit(100);
        System.out.println("Saldo dopo il deposito: " + account.getBalance());
        account.withdraw(20);
        System.out.println("Saldo dopo la prelevazione: " + account.getBalance());
    }
}