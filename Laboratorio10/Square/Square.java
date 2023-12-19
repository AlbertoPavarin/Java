import java.awt.Rectangle;

public class Square extends Rectangle
{
   public Square(int x, int y, int lato)
   {
      super(x - (lato/2), y - lato/2, lato, lato);
   }
   
   public double getArea()
   {
      return this.getWidth() * this.getHeight();
   }
   
   public void setSize(int width, int height)
   {
      if (width == height)
         this.setSize(width, height);
      else
         throw new IllegalArgumentException();  
   }
   
   public void setSize(int dim)
   {
      super.setSize(dim, dim);
   }
}
