package battleship;

/**
 * Ethan Adams - Mr. Spiegel - AP Comp Sci
 * battleship project - Created on Apr 16, 2014
 */

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class battleshipClient  extends JFrame implements ActionListener {
    final JPanel frame = new JPanel();//creates panels for the calculator
    JButton[] button = new JButton[100]; //creates buttons
    Font font = new Font("Comic Sans", Font.PLAIN, 14);
    Battleship b;
    ArrayList<ship> game = new ArrayList<ship>();
    ArrayList<location> locs = new ArrayList<location>();
    
    
    battleshipClient(Battleship b, boolean mine) {
        super("Battleship");//titles the JFrame
        setSize(470,470);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(11,10);
        JPanel components = new JPanel();
        components.setLayout(grid);
        
        //sets icon for calculator - taken from somewhere online
        /*try{
            this.setIconImage(ImageIO.read(new File("src/numberconversions/icon.png")));//may need to be changed to find the icon, but it should be included with the project
           } catch(java.io.IOException e){
               e.toString();
           }*/
        if(mine)
        {
            for(int i = 0; i < 100; i++) {
                button[i] = new JButton();
                button[i].setSize(3, 3);
                button[i].setText("~");
                button[i].setFont(font);
           //     button[i].addActionListener(this);
                button[i].setBackground(Color.BLUE);
                button[i].setDefaultCapable(false);
            }

            for(int j = 0; j <100; j++)
            {
                components.add(button[j]);
            }
        
            this.add(components);
            components.add(new Label("Mine"));
            this.setLocation(600, 0);
        }
        else
        {
         for(int i = 0; i < 100; i++) {
                button[i] = new JButton();
                button[i].setSize(3, 3);
                button[i].setText("~");
                button[i].setFont(font);
                button[i].addActionListener(this);
                button[i].setBackground(Color.BLUE);             
            }

            for(int j = 0; j <100; j++)
            {
                components.add(button[j]);
            }
        
            this.add(components);
            components.add(new Label("Enemy"));   
        }
        this.b = b;
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        for(int i = 0; i < 100; i++)
        {
            if(ae.getSource() == button[i])
            {
                checkHit(i);
                b.makeEnemyMove();
                return;
            }
        }
    }
    
    public void checkHit(int i)
    {
        JButton jb = button[i];
        int r = 0;
        int c = 0;
        r = i%10;
        c = i/10;
        location loc = new location(c,r);
        for(location loc2 : locs)
            if(loc2.toString().matches(loc.toString()))
            {
                jb.setText("*");
                jb.setBackground(Color.RED);
                jb.removeActionListener(this);
                return;
            }
        jb.setText("X");
        jb.setBackground(Color.GREEN);        
        jb.removeActionListener(this);
        
    }

    public void addShip(ship s)
    {
        game.add(s);
        for(hull h : s.getBoat())
            locs.add(h.getLocation());
    }
    
    public void playGame()
    {
        
    }
    
    public boolean noOverlap(ArrayList<hull> hull)
    {
        location loc;
        for(hull g : hull)
        {
            loc = g.getLocation();
            for(ship s : game)
            {
                for(hull h : s.getBoat())
                {
                    if(h.getLocation().toString().matches(loc.toString()))
                    return false;
                }
            }
        }
        //System.out.println("I got hererwearw");
        return true;
    }
}