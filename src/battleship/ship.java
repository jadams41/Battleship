package battleship;

import java.util.ArrayList;

/**
 * Ethan Adams - Mr. Spiegel - AP Comp Sci
 * battleship project - Created on Apr 13, 2014
 */
public class ship {
    private int size;
    private location loc;
    private int direction;
    private String name;
    private ArrayList<hull> boat;
    
    public ship() 
    {
        
    }

    public ship(int size, int x, int y, int direction, String name)
    {
        this.size = size;
        loc = new location(x,y);
        this.direction = (direction/90*90)%360;
        this.name = name;
        boat = new ArrayList<hull>();
        buildShip();
    }

    public void buildShip()
    {
        boolean keepRun = true;

        ArrayList<hull> blueprint = new ArrayList<hull>();
        while(true)
            {
                for(int i = 0; i < size; i++)
                {
                    location temp;
                    switch(direction)
                    {
                        case 0 : temp = new location(loc.getXCor()-i,loc.getYCor());
                            break;
                        case 90 : temp = new location(loc.getXCor(),loc.getYCor()+i);
                            break;
                        case 180 : temp = new location(loc.getXCor()+i,loc.getYCor());
                            break;
                        case 270 : temp = new location(loc.getXCor(),loc.getYCor()-i);
                            break;
                        default : temp = new location();
                            break;
                    }
                    blueprint.add(new hull(temp));
            
                }
                for(hull h : blueprint)
                {
                    if(!h.getLocation().isValid())
                    {
                        keepRun = false;
                        loc = new location((int)(Math.random()*10),(int)(Math.random()*10));
                    }
                }
                if(keepRun = true)
                {
                    boat.addAll(blueprint);
                    return;
                }
        }
    }

    public ArrayList<hull> getBoat()
    {
        return boat;
    }

    public int getDirection()
    {
        return direction;
    }

    public boolean isFloating() 
    {
        for(hull h : boat)
            if(!h.isHit())
                return true;
        return false;
    }
}