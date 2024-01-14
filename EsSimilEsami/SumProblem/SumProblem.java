import java.util.Scanner;
import java.io.*;

public class SumProblem{
    public static void main(String[] args)
    {
        int[] nums = new int[10];
        int k = 0, s = 0;

        if (args.length != 2)
        {
            System.out.println("Errore. Uso: SumProblem in.txt out.txt");
            System.exit(-1);
        }

        try (FileReader f = new FileReader(args[0]); Scanner console = new Scanner(f))
        {
            while(console.hasNextLine())
            {
                if (k == nums.length)
                    nums = resize(nums, nums.length, nums.length*2);
                
                try
                {
                    nums[k++] = Integer.parseInt(console.next());
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Errore nel formato di un dato");
                }
            }
            console.close();
        }
        catch (IOException e)
        {
            System.out.println("Errore in lettura del file");
        }

        int[][] zeroSumNumbers = new int[k][2];

        System.out.println("I numeri tale che la somma fa 0 sono i seguenti: ");
        for (int i = 0; i < k; i++)
        {
            for (int j = i; j < k; j++)
            {
                if (nums[i] + nums[j] == 0)
                {
                    System.out.println(nums[i] + " "  + nums[j]);
                    zeroSumNumbers[s][0] = nums[i];
                    zeroSumNumbers[s++][1] = nums[j];
                }
            }
        }

        try (PrintWriter w = new PrintWriter(args[1]))
        {
            for (int i = 0; i < s; i++)
                w.println(zeroSumNumbers[i][0] + " " + zeroSumNumbers[i][1]);
        }
        catch (IOException e)
        {
            System.out.println("Errore in lettura del file");
        }
    }

    public static int[] resize(int[] a, int oldL, int newL)
    {
        int[] newArray = new int[newL];
        System.arraycopy(a, 0, newArray, 0, oldL);
        return newArray;
    } 
}