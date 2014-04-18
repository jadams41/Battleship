package battleship;

/**
 * Ethan Adams - Mr. Spiegel - AP Comp Sci
 * battleship project - Created on Apr 14, 2014
 */
class hull extends ship{

    location loc;
    boolean hasBeenHit;
    
    public hull(location loc)
    {
        this.loc = loc;
    }

    public location getLocation()
    {
        return loc;
    }

    public void hitMe()
    {
        hasBeenHit = true;
    }

    public boolean isHit()
    {
        return hasBeenHit;
    }
}