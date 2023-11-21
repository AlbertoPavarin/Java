import java.util.Scanner;

public class IsMagicSquare{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[2];
        int n = 0, size=0, matchColSum = 0, matchRowSum = 0, leftDiagonal = 0, rigthDiagonal = 0;
        boolean found = false;

        System.out.println("Inserisci dei numeri: ");
        while(input.hasNextInt())
        {
            n = input.nextInt();
            if (numbers.length == size)
                numbers = ArrayUtil.resize(numbers, numbers.length * 2);
            
            numbers[size] = n;
            size++;
        }

        input.close();
    
        if (Math.sqrt(size) != (int)Math.sqrt(size))
        {
            System.out.println("Errore, inserisci un numero di elementi che è un quadrato perfetto");
            System.exit(-1);
        }

        int squareSize = (int)Math.sqrt(size);

        for (int i = 0; i < size; i++)
        {
            if (numbers[i] > squareSize*squareSize || numbers[i] <= 0)
            {
                System.out.println("Un numero è superiore al quadrato dei numeri inseriti o minore o uguale a 0");
                System.exit(-1);
            }

            for (int j = 0; j < size; j ++)
            {
                if (i != j && numbers[i] == numbers[j])
                {
                    if (found)
                    {
                        System.out.println("Errore, un numero è duplicato");
                        System.exit(-1);
                    }
                    else
                        found = true;
                }
            }
        }

        int[][] square = new int[squareSize][squareSize];
        int numbersIndex = 0;
        int sum = 0;
        
        for (int i = 0; i < squareSize; i++)
        {
            for (int j = 0; j < squareSize; j++)
            {
                square[i][j] = numbers[numbersIndex++];
            }
        }

        System.out.println();

        for (int i = 0; i < squareSize; i++)
        {
            System.out.println(ArrayUtil.printArray(square[i], squareSize));
        }

        for (int i = 0; i < squareSize; i++)
        {
            sum += square[0][i]; 
        }

        // righe e colonne
        for (int i = 0; i < squareSize; i++)
        {
            matchColSum = 0;
            matchRowSum = 0;
            for (int j = 0; j < squareSize; j++)
            {
                matchColSum += square[i][j];
                matchRowSum += square[j][i];
            }

            if (matchRowSum != sum || matchColSum != sum)
            {
                System.out.println("Non è un quadrato magico");
                System.exit(-1);
            }
        }
        
        // diagonale
        for (int i = 0; i < squareSize - 1; i++)
        {
            leftDiagonal += square[i+1][i+1];
            rigthDiagonal += square[squareSize-1-i][i];
        }

        if (matchRowSum != sum || matchColSum != sum)
        {
            System.out.println("Non è un quadrato magico");
            System.exit(-1);
        }

        System.out.println("Il quadrato inserito è magico");
    }
}