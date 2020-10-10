
/**
 * Write a description of class GraphicsDay4Frame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.*;

public class MenuRunner extends JFrame
{
    private JFrame frame;
    private MenuButton panel;
    
    public MenuRunner()
    {
    //the menu screen for starting the game
        frame = new JFrame("menu screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new MenuButton();
        panel.setPreferredSize(new Dimension(600,600));
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(panel);
        
      
    
    
    }
    public void display()
    {
        frame.pack();
        frame.setVisible(true);
    
    }
}
