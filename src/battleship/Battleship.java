/*
 * TODO:
 * make ships sink when completely hit - can take this from initial game
 * make game end when all ships are sunk - JFrame popping up saying who won
 * fix adding ships for both human input(hasn't been started) and for computer
    **for computer change where it checks isValid() from 0  to size-1
 * make intelligent guessing algorithm
 */

package battleship;

import java.util.ArrayList;
import java.util.Scanner;

public class Battleship {
    static ArrayList<ship> game = new ArrayList<ship>();
    static ArrayList<location> locs = new ArrayList<location>();
    static ArrayList<ship> game2 = new ArrayList<ship>();
    static ArrayList<Integer> guessedLocs = new ArrayList<Integer>();
    ship destroyer;
    ship cruiser;
    ship sub;
    ship bship;
    ship carrier;
    static board Board;
    static board Board2;
    static Scanner scanner = new Scanner(System.in);
    static battleshipClient bC;
    static battleshipClient bC2;

    /*
    public Battleship()
    {
        Board = new board();
        Board2 = new board();
        fillEnemyBoard();

        System.out.println("Place a destroyer");
        destroyer = new destroyer(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        while(!Board.noOverlap(destroyer.getBoat()) && destroyer.getBoat().get(0).getLocation().isValid())
        {
            System.out.println("Try that again");
            destroyer = new destroyer(scanner.nextInt(), 
                    scanner.nextInt(), scanner.nextInt());
        }
        Board.showShip(destroyer);
        Board.addFilledPositions(destroyer);
        game.add(destroyer);
        
        System.out.println("Place a cruiser");
        cruiser = new cruiser(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());        
        while(!Board.noOverlap(cruiser.getBoat()) && cruiser.getBoat().get(0).getLocation().isValid())
        {
            System.out.println("Try that again");
            cruiser = new cruiser(scanner.nextInt(), 
                    scanner.nextInt(), scanner.nextInt());
        }
        Board.showShip(cruiser);
        Board.addFilledPositions(cruiser);
        game.add(cruiser);
        
        System.out.println("Place a submarine");
        sub = new sub(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        while(!Board.noOverlap(sub.getBoat()) && sub.getBoat().get(0).getLocation().isValid())
        {
            System.out.println("Try that again");
            sub = new sub(scanner.nextInt(), 
                    scanner.nextInt(), scanner.nextInt());
        }
        Board.showShip(sub);
        Board.addFilledPositions(sub);
        game.add(sub);
        
        System.out.println("Place a battleship");
        bship = new bship(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        while(!Board.noOverlap(bship.getBoat()) && bship.getBoat().get(0).getLocation().isValid())
        {
            System.out.println("Try that again");
            bship = new bship(scanner.nextInt(), 
                    scanner.nextInt(), scanner.nextInt());
        }
        Board.showShip(bship);
        Board.addFilledPositions(bship);
        game.add(bship);
        
        System.out.println("Place a carrier");
        carrier = new carrier(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        while(!Board.noOverlap(carrier.getBoat()) && carrier.getBoat().get(0).getLocation().isValid())
        {
            System.out.println("Try that again");
            carrier = new carrier(scanner.nextInt(), 
                    scanner.nextInt(), scanner.nextInt());
        }
        Board.showShip(carrier);
        Board.addFilledPositions(carrier);
        game.add(carrier); 

    }*/
    
    public Battleship(int i)
    {
        bC= new battleshipClient(this, true);
        bC2 = new battleshipClient(this,false);
        fillEnemyBoard();
        
        utilFrame uF1 = new utilFrame(2, "destroyer", bC);
        uF1.setTextInstructions("Please place a destroyer");
        uF1.setVisible(true);
        //while(uF1.isVisible())
        //{
            
        //}
        
        utilFrame uF2 = new utilFrame(3, "submarine", bC);
        uF2.setTextInstructions("Please place a submarine");
        uF2.setVisible(true);
        while(uF2.isVisible())
        {
            
        }
        
        utilFrame uF3 = new utilFrame(3, "cruiser", bC);
        uF3.setTextInstructions("Please place a cruiser");
        uF3.setVisible(true);
        while(uF3.isVisible())
        {
            
        }

        utilFrame uF4 = new utilFrame(4, "battleship", bC);
        uF4.setTextInstructions("Please place a battleship");
        uF4.setVisible(true);
        while(uF4.isVisible())
        {
            
        }
        
        utilFrame uF5 = new utilFrame(5, "carrier", bC);
        uF5.setTextInstructions("Please place a cruiser");
        uF5.setVisible(true);
        while(uF5.isVisible())
        {
            
        }
    }
    
    public static void fillEnemyBoard()
    {
        ship eDestroyer = new destroyer((int)(Math.random()*10),
                (int) (Math.random()*10), (int) (Math.random()*360));
        while(!bC2.noOverlap(eDestroyer.getBoat()) && eDestroyer.getBoat().get(0).getLocation().isValid())
                eDestroyer = new destroyer((int)(Math.random()*10),
                        (int) (Math.random()*10), (int) (Math.random()*360));
        bC2.addShip(eDestroyer);
        
        ship eCruiser = new cruiser((int)(Math.random()*10),
                (int) (Math.random()*10), (int) (Math.random()*360));
        while(!bC2.noOverlap(eCruiser.getBoat()) && eCruiser.getBoat().get(0).getLocation().isValid())
        {
            eCruiser = new cruiser((int)(Math.random()*10),
                        (int) (Math.random()*10), (int) (Math.random()*360));
        //    System.out.println("I am running forever");
        }
        bC2.addShip(eCruiser);
        
        ship eSub = new sub((int)(Math.random()*10),
                (int) (Math.random()*10), (int) (Math.random()*360));
        while(!bC2.noOverlap(eSub.getBoat()) && eSub.getBoat().get(0).getLocation().isValid())
                eSub = new sub((int)(Math.random()*10),
                        (int) (Math.random()*10), (int) (Math.random()*360));
        bC2.addShip(eSub);
        
        ship eBShip = new bship((int)(Math.random()*10),
                (int) (Math.random()*10), (int) (Math.random()*360));
        while(!bC2.noOverlap(eBShip.getBoat()) && eBShip.getBoat().get(0).getLocation().isValid())
                eBShip = new bship((int)(Math.random()*10),
                        (int) (Math.random()*10), (int) (Math.random()*360));
        bC2.addShip(eBShip);
                
        ship eCarrier = new carrier((int)(Math.random()*10),
                (int) (Math.random()*10), (int) (Math.random()*360));
        while(!bC2.noOverlap(eCarrier.getBoat()) && eCarrier.getBoat().get(0).getLocation().isValid())
                eCarrier = new carrier((int)(Math.random()*10),(int) (Math.random()*10), (int) (Math.random()*360));
        bC2.addShip(eCarrier);

    }
    
    public static boolean playGame()
    {
        for(ship s : game)
        {
            if(s.isFloating())
                return true;
        }
        return false;
    }
    
    public ArrayList<location> getLocs()
    {
        return locs;
    }
    
    public void makeEnemyMove()
    {
        int i = (int)(Math.random()*100);
        while(guessedLocs.contains(i))
        {
            System.out.println("LOOPING");
            i = (int)(Math.random()*100);    
        }
        guessedLocs.add(i);
        bC.checkHit(i);
    }
    
    //public static void makeMove()
    //{
      //  System.out.println("input x and then y coordinate of planned strike");
      //  Board.makeMove(new location((int)(Math.random()*10),(int)(Math.random()*10)));
      //  Board2.makeMove(new location(scanner.nextInt(), scanner.nextInt()));
    //}
    
    public static void main(String[] args) 
    {
        Battleship game = new Battleship(1);
        System.out.println(game);
        
    }
}