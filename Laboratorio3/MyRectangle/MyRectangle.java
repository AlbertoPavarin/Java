public class MyRectangle{
    private int posX, posY, width, heigth;

    public MyRectangle(int posX, int posY, int w, int h)
    {
        this.posX = posX;
        this.posY = posY;
        this.width = w;
        this.heigth = h;
    }

    public int getX()
    {
        return this.posX;
    }

    public int getY()
    {
        return this.posY;
    }

    public int getWidth()
    {
        return this.width;
    }

    public int getHeigth()
    {
        return this.heigth;
    }

    public void resize(double mult)
    {
        this.width *= mult;
        this.heigth *= mult;
    }

    public void translate(int dx, int dy)
    {
        this.posX += dx;
        this.posY += dy;
    }

    public String toString()
    {
        return "Rettangolo: x=" + this.posX + ", y=" + this.posY + ", w=" + this.width + ", h=" + this.heigth;
    }

    public static void main(String[] args)
    {
        MyRectangle rect = new MyRectangle(1, 1, 10, 30);

        System.out.println(rect);
        System.out.println("Altezza: " + rect.getHeigth());
        System.out.println("Larghezza: " + rect.getWidth());
        System.out.println("Posizione X: " + rect.getX());
        System.out.println("Posizione Y: " + rect.getY());

        rect.resize(2.0);
        System.out.println(rect);
        rect.resize(0.25);
        System.out.println(rect);

        rect.translate(2, 1);
        System.out.println(rect);
    }
}