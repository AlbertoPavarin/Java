import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/* Usare costruttore e metodi della classe SimpleImage
   (fate riferimento alla classe per la descrizione):

public SimpleImage(String filename)
public int height() 
public int width() 
public Color get(int i, int j) 
public void set(int i, int j, Color c)

e i metodi della classe color
public int getRed()
public int getGreen()
public int getBlue()
e il costruttore Color(int r, int g, int b)

*/

public class DecodeImageWest {
   public static void main(String args[])throws IOException {
      
      if (args.length != 2){
         System.out.println("Usage: java DecodeImage inputFileName outputFileName");
         System.exit(0);
      }
      
      //Creo oggetto SimpleImage con l'immagine di input
      SimpleImage img = new SimpleImage(args[0]);
      
     
      
      // ricordarsi che le immagini sono griglie di pixel
      // l'asse x e' la larghezza
      // l'asse y l'altezza
      // (0,0) e' l'angolo in alto a sinistra
      
      
      //per ogni pixel in posizione x,y
      //per ogni pixel in posizione x,y
      for (int x = 0; x < img.width(); x++)
      {
         for (int y = 0; y < img.height(); y++)
         {
         
            // Acquisisco il colore del pixel e lo salvo
            // in una var. riferimento a un oggetto Color           
            Color c = img.get(x,y);
            
            //Acquisisco i singoli colori e li salvo in varibili int
            int red = c.getRed();
            int green = c.getGreen();
            int blue = c.getBlue();

            //Modifico i colori
            green = 0;
            red = 0;

            if (blue >= 16)
               blue = 0;
            else  
               blue *= 16; 

            
            int grey = MakeGreyImage.setGreyScale(red, green, blue);

            //Creo un nuovo colore con questi valori RGB
            c = new Color(grey, grey, grey);
            
            //Metto il nuovo colore nell'immagine in pos (x,y)
            img.set(x, y, c);
         }
      }   
      
      //Saving the modified image
      img.save(args[1]);
      System.out.println("Done...");  
   }
}