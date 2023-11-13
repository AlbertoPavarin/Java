import java.util.Scanner;

public class Apprx2{
	
	public static void main (String[] args){
        Scanner input = new Scanner(System.in);
		double r, x;
        
        System.out.print("Inserisci il primo numero: ");
        r = input.nextDouble();

        System.out.print("Inserisci il secondo numero: ");
        x = input.nextDouble();
		
		if (Numeric.approxEqual(r,x))
			System.out.println("I due numeri " + r + " e " + x + " sono approsimativamente uguli");
		else 
			System.out.println("I due numeri " + r + " e " + x + " non sono approsimativamente uguli");

		
	}
}	