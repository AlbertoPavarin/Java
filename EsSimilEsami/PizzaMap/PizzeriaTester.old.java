// Cinzia Pizzi

import java.io.*;
import java.util.*;

//Questa soluzione gestisce file con il nome della pizza composta da una sola parola
//cosi' come in pizze.txt fornito

public class PizzeriaTester{

	public static void main(String[] args){
	
		PizzaMap spm = new PizzaMap();
		
		try(FileReader reader = new FileReader("pizze.txt"); Scanner filescanner = new Scanner(reader)){		
			while(filescanner.hasNextLine()){
				String line = filescanner.nextLine();
				Scanner linescanner = new Scanner(line);
				String pizza = linescanner.next();
				Double prezzo = linescanner.nextDouble();
				spm.put(pizza,prezzo);
			}			
			
			System.out.println("Contenuto della mappa");
			System.out.println(spm);
			
			System.out.println("Menu' ordinato per prezzo");
			System.out.println(spm.printMenu());
			
			double tot = 0;
			tot += (Double)spm.get("Margherita");
			tot += (Double)spm.get("Bufala");
			tot += (2*(Double)spm.get("Prosciutto"));
			
			System.out.printf("Prezzo per una margherita, una bufala e due pizze al prosciutto: %.2f \n",tot);
		}
		catch(IOException e){
			System.out.println("Problema con il file pizze "+e);
		}
		catch(NoSuchElementException e){//importante! se il file non e' formattato bene i .next() lanciano questa eccezione
			System.out.println("Problema con la formattazione del file pizze "+e);
		}
		catch(NumberFormatException e){
			System.out.println("Problema con la formattazione del file pizze "+e);
		}
		catch(Exception e){
			System.out.println("Problema: "+e);
		}	
	}
}