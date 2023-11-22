public class Player{
    public final static int DICES_NUMBER = 3;
    private String name;
    private int score;
    private int[] diceScores;

    public Player(String name)
    {
        this.score = 0;
        this.diceScores = new int[]{0, 0, 0};
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public int getScore()
    {
        return this.score;
    }

    public void turno()
    {
        for (int i = 0; i < DICES_NUMBER; i++)
        {
            this.diceScores[i] =  (int)(1 + 6*Math.random());
        }
    }

    public int[] sortDice()
    {
        int[] sorted = new int[DICES_NUMBER];
        for (int i = 0; i < DICES_NUMBER; i++)
            sorted[i] = this.diceScores[i];

        for (int i = 0; i < DICES_NUMBER - 1; i++)
        {
            for (int j = 0; j < DICES_NUMBER - 1; j++)
            {
                if (sorted[j] > sorted[j+1])
                {
                    int tmp = sorted[j];
                    sorted[j] = sorted[j+1];
                    sorted[j+1] = tmp;
                }
            }
        }
    
        return sorted;
    }

    public void addPoint()
    {
        this.score++;
    }

    public void resetScore()
    {
        this.score = 0;
    }

    public String toString()
    {
        String str = this.name;
        for (int i = 0; i < DICES_NUMBER; i++)
        {
            str += " " + this.diceScores[i];
        }

        return str;
    }
}