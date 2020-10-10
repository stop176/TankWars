
/**
 * Write a description of class GraphicsDay4Panel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuButton extends JPanel implements ActionListener

{
    private JButton button1;
    private JButton button2;
    private RunnerFrame frame;
private boolean ifPressed;
    public MenuButton()
    {
        setFocusable(true);
       frame = new RunnerFrame();
        button1 = new JButton("Press To Start Game");
        //detects if the button is clicked
        button1.addActionListener(this);
        add(button1);

        
    
    }
  

    public void actionPerformed(ActionEvent e)
    {
        
        //displays the main game if the button is clicked
       frame.display();
        
      

    }
    

    public void paint(Graphics g)
    {
        super.paint(g);
        //instructions
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Welcome to Tanks! In this game, you'll be", 100, 100);
         g.drawString(" trying to beat your opponent in a 1v1 with tanks!", 100, 150);
         g.setFont(new Font("Arial", Font.BOLD, 15));
          g.drawString("Player 1: ", 80, 250);
            g.drawString("Use the arrow keys to move, and M to shoot", 100, 300);
             g.drawString("Left and right arrow keys for rotation and up and down arrow keys ", 100, 330);
            g.drawString("for forward and backward movement", 100, 360);
             g.drawString("Player 2: ", 80, 400);
            g.drawString("Use WASD to move, and Q to shoot", 100, 450);
             g.drawString("A and D for rotation and W and S for forward and backward movement", 100, 480);
             
    }

}
