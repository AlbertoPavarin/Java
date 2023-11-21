import java.util.Scanner;

public class StandardInputArrayPop{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int []arr = new int[1];
        int n, size = 0;

        System.out.print("Inserisci un numero intero: ");

        while(input.hasNextInt()) {
            System.out.print("Inserisci un numero intero: ");
            n = input.nextInt();
            if (arr.length == size)
                arr = ArrayUtil.resize(arr, 2*size);
            arr[size] = n;
            size++;
        }


        input.close();

        System.out.println();
        //System.out.println("\n" + size);
        for (int i = size - 1; i >= 0; i--)
            System.out.println(arr[i]);
    }
}