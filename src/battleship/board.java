package battleship;

import java.util.ArrayList;

/**
 * Ethan Adams - Mr. Spiegel - AP Comp Sci
 * battleship project - Created on Apr 13, 2014
 */

public class board {
    
    private final int width = 10;
    private final int height = 10;
    private int[][] gameBoard = new int[height][width];
    private ArrayList<hull> filledPos = new ArrayList<hull>();
    private ArrayList<location> guesses = new ArrayList<location>();
    
    public board()
    {
        fillBoard();
    }
    
    private void fillBoard()
    {
        for( int[] spaceArr : gameBoard)
        {
            for(int space : spaceArr)
            {
                space = 0;
            }
        }
    }

    public void displayBoard()
    {
        int count = 0;
        System.out.print("  ");
        for(int i = 0; i < 10; i++)
            System.out.print(i + " ");
        System.out.println();
        for(int[] spaceArr: gameBoard)
        {
            System.out.print(count++ + " ");
            for(int space : spaceArr)
                print(space);
            System.out.println();
        }
    }
    
    public void print(int i)
    {
        switch(i)
        {
            case 0 : System.out.print("~ ");
                break;
            case 1 : System.out.print("X ");
                break;    
            case 2 : System.out.print("* ");
                break;
            case 3 : System.out.print("# ");
        }

    }

    public void showShip(ship Ship)
    {
        for(hull h : Ship.getBoat())
            gameBoard[h.getLocation().getXCor()][h.getLocation().getYCor()] = 3;
        displayBoard();
    }

    public boolean canMove(location loc)
    {
        return(loc.isValid() && !guesses.contains(loc));
    }
    
    public boolean makeMove(location loc)
    {
        if(!canMove(loc))
            return false;
        checkForHit(loc);
        guesses.add(loc);
        return true;
    }
    
    public void checkForHit(location loc)
    {
        for(hull h : filledPos)
        {
            //System.out.println(loc + " " + h.getLocation());
            if(loc.toString().matches(h.getLocation().toString()))
            {
                gameBoard[h.getLocation().getXCor()][h.getLocation().getYCor()] = 2;
                h.hitMe();
                filledPos.remove(h);
                System.out.println("DIRECT HIT!");
                return;
            }
        }
        gameBoard[loc.getXCor()][loc.getYCor()] = 1;
    }

    public void addFilledPositions(ship Ship)
    {
        for(hull h : Ship.getBoat())
            filledPos.add(h);
    }

    public boolean noOverlap(ArrayList<hull> hull)
    {
        location loc;
        for(hull g : hull)
        {
            loc = g.getLocation();
            for(hull h : filledPos)
            {
                if(h.getLocation().toString().matches(loc.toString()))
                    return false;
            }
        }
        System.out.println("I got hererwearw");
        return true;
    }
}