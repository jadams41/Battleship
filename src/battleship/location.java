package battleship;

/**
 * Ethan Adams - Mr. Spiegel - AP Comp Sci
 * battleship project - Created on Apr 13, 2014
 */
class location {

    private int xCor;
    private int yCor;
    
    public location()
    {
        xCor = -1;
        yCor = -1;
    }

    public location(int x, int y)
    {
        xCor = x;
        yCor = y;
    }

    public int getXCor()
    {
        return xCor;
    }
    
    public int getYCor()
    {
        return yCor;
    }

    public boolean isValid()
    {
        return (xCor >= 0 && xCor <= 10) && (yCor >= 0 && yCor <= 10);
    }

    public String toString()
    {
        return xCor + " " + yCor;
    }
}
