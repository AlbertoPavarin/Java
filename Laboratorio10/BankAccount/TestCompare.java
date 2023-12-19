import java.util.*;

public class TestCompare
{
   public static void main(String[] args)
   {
      BankAccount[] bA = new BankAccount[10];
      BankAccount[] bB = new BankAccount[10];
      BankAccount[] bC = new BankAccount[10];
      
      Random rnd = new Random();
      
      for (int i = 0; i < bA.length; i++)
         bA[i] = new BankAccount(rnd.nextDouble(1000) + 1);
         
      for (int i = 0; i < bA.length; i++)
         System.out.println(bA[i].getBalance());
         
      System.arraycopy(bA, 0, bB, 0, bA.length);
      System.arraycopy(bA, 0, bC, 0, bA.length);
      
      System.out.println("\n\nMerge Sort: ");
      
      ArrayAlgs.mergeSort(bA);
      for (int i = 0; i < bA.length; i++)
         System.out.println(bA[i].getBalance());
         
      System.out.println("\nSelection Sort: ");
      
      ArrayAlgs.selectionSort(bB);
      for (int i = 0; i < bB.length; i++)
         System.out.println(bB[i].getBalance());
      
      System.out.println("\nInsertion Sort: ");
       
      ArrayAlgs.insertionSort(bC);
      for (int i = 0; i < bC.length; i++)
         System.out.println(bC[i].getBalance());
   }
}
