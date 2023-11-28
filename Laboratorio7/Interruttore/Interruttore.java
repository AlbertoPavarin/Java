public class Interruttore{
    private static boolean bulbOn = false;
    private boolean intState; 

    public Interruttore()
    {
        intState = false;
    }

    public boolean isBulbOn()
    {
        return bulbOn;
    }

    public void changeStatus()
    {
        if (this.intState)
        {
            this.intState = false;
            changeBulbStatus();
        }
        else
        {
            this.intState = true;
            changeBulbStatus();
        }
    }

    public String printStatus()
    {
        if (this.intState)
            return "up";
        else
            return "down";
    }

    public static String printBulbStatus()
    {
        if (bulbOn)
            return "accesa";
        else
            return "spenta";
    }

    private void changeBulbStatus()
    {
        if (bulbOn)
            bulbOn = false;
        else
            bulbOn = true;
    }
}