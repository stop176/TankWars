
/**
 * 
 *
 * Author: David
 * 
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.management.*;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.geom.Area;
//import javafx.geometry.Bounds;
import java.lang.Math.*;
import javax.swing.Timer;
import java.time.Instant;
import java.awt.geom.Rectangle2D;

public class GraphicsDay2Panel extends JPanel implements ActionListener, KeyListener
{
    //set kting my tank 1 and tank2 initial positions
    private  double xBox = 70;
   // private double gun1x =xqxq ;
    private double gun1y;
    private double gun2x;
    private double gun2y;
    private  double yBox = 300;
    private double xBox2 = 530, yBox2=300;
    //angles of my tanks (directions they're facing)
    private  double angle = 0;
    private double a2 = Math.PI;
    //arraylist for my bullets
    bullet[]bulletList = new bullet [12];

    //score tracker
    int score1= 0 ;
    int score2= 0;

    //array for walls, left makes the bullets bounce left, right makes them bounce back to the right, etc..
    Rectangle[]left = new Rectangle[10];
    Rectangle[]right = new Rectangle[10];

    Rectangle[]up = new Rectangle[10];

    Rectangle[]down = new Rectangle[10];

    //boolean for single input when pressing 
    private boolean downPressed=false;
    private boolean downPressed2=false;
    private boolean downPressed3=false;
    private boolean downPressed4=false;
    private boolean downPressed5=false;
    private boolean downPressed6=false;
    private boolean downPressed7=false;
    private boolean downPressed8=false;
    private boolean downPressed9=false;
    private boolean downPressed10=false;
    private boolean downPressed11=false;
    private boolean downPressed12=false;

    //for my timer, this makes sure the timer resets i think
    private boolean billy = false;
    private boolean billy2 = false;
    private boolean billy3 = false;
    private boolean billy4 = false;
    private boolean billy5 = false;
    private boolean billy6 = false;
    private boolean billy7 = false;
    private boolean billy8 = false;
    private boolean billy9 = false;
    private boolean billy10 = false;
    private boolean billy11 = false;
    private boolean billy12 = false;

    //the timer that starts after the bullet appears to count down the lifetime of each bullet
    long time1=0;
    long time2=0;
    long time3=0;
    long time4=0;
    long time5=0;
    long time6=0;
    long time7=0;
    long time8=0;
    long time9=0;
    long time10=0;
    long time11=0;
    long time12=0;

    //initial position of each bullet
    private bullet bullet1x = new bullet (-1000,-1000,0);
    private bullet bullet2x = new bullet(-1000,-1000,0);
    private bullet bullet3x = new bullet (-1000,-1000,0);
    private bullet bullet4x = new bullet(-1000,-1000,0);
    private bullet bullet5x = new bullet (-1000,-1000,0);
    private bullet bullet6x = new bullet(-1000,-1000,0);
    private bullet bullet7x = new bullet (-1000,-1000,0);
    private bullet bullet8x = new bullet(-1000,-1000,0);
    private bullet bullet9x = new bullet (-1000,-1000,0);
    private bullet bullet10x = new bullet(-1000,-1000,0);
    private bullet bullet11x = new bullet(-1000,-1000,0);
    private bullet bullet12x = new bullet(-1000,-1000,0);

    //first tank's bullets
    private boolean bullet1=false ;
    private boolean bullet2 = false;
    private boolean bullet3 = false;
    private boolean bullet4 = false;
    private boolean bullet5 = false;
    private boolean bullet6 = false;

    //second tank bullets

    private boolean bullet7=false ;
    private boolean bullet8 = false;
    private boolean bullet9 = false;
    private boolean bullet10 = false;
    private boolean bullet11 = false;
    private boolean bullet12 = false;

    //private  Rectangle rect1 = new Rectangle (400,400,40,25);
    //boolean for smooth movement
    private boolean moveForward, moveBackward, angleChangeLeft, angleChangeRight;
    private boolean moveForward2, moveBackward2, angleChangeLeft2, angleChangeRight2;

    //THE MAZE
    Rectangle left1= new Rectangle(110,105,10, 115);
    Rectangle right1= new Rectangle(112,105,10, 115);
    Rectangle up1= new Rectangle(110,101,115, 10);
    Rectangle down1= new Rectangle(111,104,115, 11);
    Rectangle left2= new Rectangle(297,0,10,60);
    Rectangle right2= new Rectangle(298,0,10, 60);

    Rectangle left11= new Rectangle(297,540,10,60);
    Rectangle right11= new Rectangle(298,540,10, 60);
    Rectangle up4= new Rectangle(540,290,60, 10);
    Rectangle down4= new Rectangle(540,295,60, 11);
    Rectangle up6= new Rectangle(0,290,60, 10);
    Rectangle down6 = new Rectangle(0,295,60, 11);

    Rectangle left9= new Rectangle(110,375,10,115);
    Rectangle right9= new Rectangle(112,375,10, 115);
    Rectangle up9= new Rectangle(110,479,115, 10);
    Rectangle down9 = new Rectangle(110,483,115, 11);
    Rectangle left3= new Rectangle(479,103,10,115);
    Rectangle right3= new Rectangle(480,103,10, 115);
    Rectangle up3= new Rectangle(370,102,115, 10);
    Rectangle down3= new Rectangle(371,106,115, 11);
    Rectangle left14= new Rectangle(476,377,10,115);
    Rectangle right14= new Rectangle(481,377,10, 115);
    Rectangle up14= new Rectangle(367,479,112, 10);
    Rectangle down14= new Rectangle(367,481,113, 11);
    Rectangle up15= new Rectangle(220,220,150,10);
    Rectangle left15= new Rectangle(221,220,10, 150);
    Rectangle right15= new Rectangle(361,220,10, 150);
    Rectangle down15= new Rectangle(222,362,150, 10);
    Rectangle capDown2= new Rectangle(297,59,10,1);
    Rectangle capUp11 = new Rectangle(296,540,10,1);
    Rectangle capUp9= new Rectangle(110,374,10,1);
    Rectangle capUp14= new Rectangle(478,376,14,4);
    Rectangle capRight6= new Rectangle(60,292,5,13);
    Rectangle capRight9= new Rectangle(225,479,7,12);
    Rectangle capRight1= new Rectangle(215,103,1,15);
    Rectangle capLeft3= new Rectangle(369,103,1,15);
    Rectangle capLeft14= new Rectangle(366,480,1,10);
    Rectangle capLeft4= new Rectangle(539,290,1,10);
    Rectangle capDown1= new Rectangle(109,219,14,5);
    Rectangle capDown3= new Rectangle(479,217,10,2);

    private Timer time = new Timer(1,this);
    public GraphicsDay2Panel()
    {
        time.start();

        setBackground(Color.black);

        addKeyListener(this);
        setFocusable(true);
        //in the beginning the tank doesn't move so movement's false
        moveForward = moveBackward = angleChangeLeft=angleChangeRight= false;

        //adding bullets to the array
        bulletList[0]=bullet1x;
        bulletList[1]=bullet2x;
        bulletList[2]=bullet3x;
        bulletList[3]=bullet4x;
        bulletList[4]=bullet5x;
        bulletList[5]=bullet6x;
        bulletList[6]=bullet7x;
        bulletList[7]=bullet8x;
        bulletList[8]=bullet9x;
        bulletList[9]=bullet10x;
        bulletList[10]=bullet11x;
        bulletList[11]=bullet12x;

        //adding bounce left rectangles to the array

        left[0]=left1;
        left[1]=left3;
        left[2]=left9;
        left[3]=left14;
        left[4]=left15;
        left[5]=left11;
        left[6]=capLeft4;
        left[7]=capLeft14;
        left[8]=capLeft3;
        left[9]=left2;
        //adding bounce right to the array
        right[0]=right1;
        right[1]=right3;
        right[2]=right9;
        right[3]=right14;
        right[4]=right15;
        right[5]=right11;
        right[6]=right2;
        right[7]=capRight6;
        right[8]=capRight9;
        right[9]=capRight1;
        //adding bounce up to array
        up[0]=up1;
        up[1]=up3;
        up[2]=up9;
        up[3]=up14;
        up[4]=up15;
        up[5]=up4;
        up[6]=up6;
        up[7]=capUp11;
        up[8]=capUp14;
        up[9]=capUp9;
        //adding down to array
        down[0]=down1;
        down[1]=down3;
        down[2]=down9;
        down[3]=down14;
        down[4]=down15;
        down[5]=down4;
        down[6]=down6;
        down[7]= capDown2;
        down[8]=capDown3;
        down[9]=capDown1;

    }

    public void paint(Graphics g )
    {
        super.paint(g);

        //affine transform has to be used on graphics2d
        Graphics2D g2 = (Graphics2D)g;

        //this makes the objects look smoother and "render" better
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //class for transformations
        AffineTransform T = new AffineTransform();

        //setting the parameters for the rotation, so that it's from the middle

        T.rotate(angle, xBox+ 20, yBox+12.5);

        g2.transform(T);
        //creating the two tanks
        Rectangle rect1 = new Rectangle ((int)xBox,(int)yBox,40,25);
        Rectangle rect2 = new Rectangle ((int)xBox2,(int)yBox2,40,25);
        //greeen tank
        g2.setColor(Color.green);
        g2.fill(rect1);
        
        //makes the tank an area object
        Area a = new Area(rect1);
        Area ra = new Area();
        ra = a.createTransformedArea(T);

        try{
            g2.transform(T.createInverse());
        }catch(NoninvertibleTransformException e){

        }

        //for the second tank
        AffineTransform F = new AffineTransform();
        F.rotate(a2, xBox2+ 20, yBox2+12.5);

        g2.transform(F); 
        //magenta tank
        g2.setColor(Color.magenta);
        g2.fill(rect2);

        //makes rect2 an area object
        Area aa = new Area(rect2);
        Area ra2 = new Area();
        ra2 = aa.createTransformedArea(F);
        try{
            g2.transform(F.createInverse());
        }catch(NoninvertibleTransformException e){

        }
        //setting the boundaries (the walls)
        Rectangle rectRight = new Rectangle(600,0,10,600 );
        Rectangle rectLeft = new Rectangle(0,0,1,600);
        Rectangle rectUp = new Rectangle(0,0,600,1);
        Rectangle rectDown = new Rectangle(0,600,600,10);

        //coloring the walls cyan
        g2.setColor(Color.CYAN);
        g2.draw(rectRight);
        g2.draw(rectLeft);
        g2.draw(rectUp);
        g2.draw(rectDown);

        //Tank hit walls
        for(int i =0; i<10;i++)
        {
            if(ra.intersects(left[i].getBounds()))
            {
                xBox-=3;
            }
        }
        for(int i =0; i<10;i++)
        {
            if(ra.intersects(right[i].getBounds()))
            {
                xBox+=3;
            }
        }
        for(int i =0; i<10;i++)
        {
            if(ra.intersects(up[i].getBounds()))
            {
                yBox-=3;
            }
        }
        for(int i =0; i<10;i++)

            if(ra.intersects(down[i].getBounds()))
            {
                yBox+=3;
            }
        for(int i =0; i<10;i++)
        {
            if(aa.intersects(left[i].getBounds()))
            {
                xBox2-=3;
            }
        }
        for(int i =0; i<10;i++)
        {
            if(aa.intersects(right[i].getBounds()))
            {
                xBox2+=3;
            }
        }
        for(int i =0; i<10;i++)
        {
            if(aa.intersects(up[i].getBounds()))
            {
                yBox2-=3;
            }
        }
        for(int i =0; i<10;i++)

            if(aa.intersects(down[i].getBounds()))
            {
                yBox2+=3;
            }

        //makes the walls impassable
        if(ra.intersects(rectLeft.getBounds()))
        {
            xBox+=3;

        }
        if(ra.intersects(rectRight.getBounds()))
        {
            xBox-=3;

        }
        if(ra.intersects(rectUp.getBounds()))
        {
            yBox+=3;

        }
        if(ra.intersects(rectDown.getBounds()))
        {
            yBox-=3;

        }
        if(ra2.intersects(rectLeft.getBounds()))
        {
            xBox2+=3;

        }
        if(ra2.intersects(rectRight.getBounds()))
        {
            xBox2-=3;

        }
        if(ra2.intersects(rectUp.getBounds()))
        {
            yBox2+=3;

        }
        if(ra2.intersects(rectDown.getBounds()))
        {
            yBox2-=3;

        }
        
        //painting in the bullets

        if(bullet1)
        {

            g.fillOval((int)bullet1x.getX(), (int)bullet1x.getY(), 10,10);
        }

        if(bullet2)
        {   g.fillOval((int)bullet2x.getX(), (int)bullet2x.getY(), 10,10);}
        if(bullet3)
        {   g.fillOval((int)bullet3x.getX(), (int)bullet3x.getY(), 10,10);}
        if(bullet4)
        {   g.fillOval((int)bullet4x.getX(), (int)bullet4x.getY(), 10,10);}
        if(bullet5)
        {   g.fillOval((int)bullet5x.getX(), (int)bullet5x.getY(), 10,10);}
        if(bullet6)
        {   g.fillOval((int)bullet6x.getX(), (int)bullet6x.getY(), 10,10);}
        if(bullet7)
        {   g.fillOval((int)bullet7x.getX(), (int)bullet7x.getY(), 10,10);}

        if(bullet8)
        {   g.fillOval((int)bullet8x.getX(), (int)bullet8x.getY(), 10,10);}

        if(bullet9)
        {   g.fillOval((int)bullet9x.getX(), (int)bullet9x.getY(), 10,10);}

        if(bullet10)
        {   g.fillOval((int)bullet10x.getX(), (int)bullet10x.getY(), 10,10);}
        if(bullet11)
        {   g.fillOval((int)bullet11x.getX(), (int)bullet11x.getY(), 10,10);}
        if(bullet12)
        {   g.fillOval((int)bullet12x.getX(), (int)bullet12x.getY(), 10,10);}

       // filling in the maze
        for(Rectangle x: left)
        {
            g2.fill(x);

        }
        for(Rectangle x: up)
        {
            g2.fill(x);

        }
        for(Rectangle x: down)
        {
            g2.fill(x);

        }
        for(Rectangle x: right)
        {
            g2.fill(x);

        }
        //scores
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Player One Score: "+score1, 20, 580);
        g.drawString("Player Two Score: "+score2, 380, 580);
        
        //collisions of bullets and tank
        for(int i = 0; i<12; i++)
        {

            if(rect2.contains(bulletList[i].getX()+5*Math.cos(bulletList[i].getA()), bulletList[i].getY()+5*Math.sin(bulletList[i].getA()))&&
            rect2.contains(bulletList[i].getX(), bulletList[i].getY())==false)

            {
                int x=(int)(Math.random()*4)+1;
                if(x==1)
                {
                    xBox= 20; yBox=20;
                    xBox2= 550; yBox= 550;
                }
                if(x==2)
                {
                    xBox= 20; yBox=20;
                    xBox2= 550; yBox2= 550;
                }
                if(x==3)
                {
                    xBox= 20; yBox=550;
                    xBox2= 550; yBox2= 20;
                }
                if(x==4)
                {
                    xBox2= 20; yBox2=550;
                    xBox= 550; yBox= 20;
                }

                bullet1=false ;
                bullet2 = false;
                bullet3 = false;
                bullet4 = false;
                bullet5 = false;
                bullet6 = false;

                //second tank bullets

                bullet7=false ;
                bullet8 = false;
                bullet9 = false;
                bullet10 = false;
                bullet11 = false;
                bullet12 = false;
                time1=0;
                time2=0;
                time3=0;
                time4=0;
                time5=0;
                time6=0;
                time7=0;
                time8=0;
                time9=0;
                time10=0;
                time11=0;
                time12=0;
                billy = false;
                billy2 = false;
                billy3 = false;
                billy4 = false;
                billy5 = false;
                billy6 = false;
                billy7 = false;
                billy8 = false;
                billy9 = false;
                billy10 = false;
                billy11 = false;
                billy12 = false;
                downPressed=false;
                downPressed2=false;
                downPressed3=false;
                downPressed4=false;
                downPressed5=false;
                downPressed6=false;
                downPressed7=false;
                downPressed8=false;
                downPressed9=false;
                downPressed10=false;
                downPressed11=false;
                downPressed12=false;

                score2++;

            }
            //collisions of tank 2
            if(rect1.contains(bulletList[i].getX()+5*Math.cos(bulletList[i].getA()), bulletList[i].getY()+5*Math.sin(bulletList[i].getA())) &&
            rect1.contains(bulletList[i].getX(), bulletList[i].getY())==false  )
            {
                int x=(int)(Math.random()*4)+1;

                if(x==1)
                {
                    xBox= 20; yBox=20;
                    xBox2= 550; yBox2= 550;
                }
                if(x==2)
                {
                    xBox2= 20; yBox2=20;
                    xBox= 550; yBox= 550;
                }
                if(x==3)
                {
                    xBox= 20; yBox=550;
                    xBox2= 550; yBox2= 20;
                }
                if(x==4)
                {
                    xBox2= 20; yBox2=550;
                    xBox= 550; yBox= 20;
                }
                bullet1=false ;
                bullet2 = false;
                bullet3 = false;
                bullet4 = false;
                bullet5 = false;
                bullet6 = false;

                bullet7=false ;
                bullet8 = false;
                bullet9 = false;
                bullet10 = false;
                bullet11 = false;
                bullet12 = false;
                time1=0;time2=0;time3=0;time4=0;time5=0;time6=0;time7=0;time8=0;time9=0;time10=0;time11=0;time12=0;
                billy = false;
                billy2 = false;
                billy3 = false;
                billy4 = false;
                billy5 = false;
                billy6 = false;
                billy7 = false;
                billy8 = false;
                billy9 = false;
                billy10 = false;
                billy11 = false;
                billy12 = false;
                downPressed=false;
                downPressed2=false;
                downPressed3=false;
                downPressed4=false;
                downPressed5=false;
                downPressed6=false;
                downPressed7=false;
                downPressed8=false;
                downPressed9=false;
                downPressed10=false;
                downPressed11=false;
                downPressed12=false;

                score1++;
            }
        }

    }

    public void actionPerformed(ActionEvent f )
    {
        //movement
        if (moveBackward) {
            xBox-= .15*Math.cos(angle);
            yBox-= .15* Math.sin(angle);

        }
        if (moveForward) {
            xBox+= .15*Math.cos(angle);
            yBox+=.15* Math.sin(angle);

        }
        if(angleChangeRight)
        {
            angle+=.006;

        }
        if(angleChangeLeft)
        {
            angle-=.006;

        }
        if (moveBackward2) {
            xBox2-= .15*Math.cos(a2);
            yBox2-=  .15*Math.sin(a2);
        }
        if (moveForward2) {
            xBox2+= .15*Math.cos(a2);
            yBox2+= .15*Math.sin(a2);
        }
        if(angleChangeRight2)
        {
            a2+=.006;
        }
        if(angleChangeLeft2)
        {
            a2-=.006;
        }

        //bullet reposition
        if(bullet1==false)
        {
            bullet1x.setA(angle);
            bullet1x.setX (xBox+20);
            bullet1x.setY(yBox+12.5);

        }

        if(bullet2==false)
        {
            bullet2x.setA(angle);
            bullet2x.setX(xBox+20);
            bullet2x.setY(yBox+12.5);;

        }
        if(bullet3==false)
        {
            bullet3x.setA(angle);
            bullet3x.setX(xBox+20);
            bullet3x.setY(yBox+12.5);;

        }
        if(bullet4==false)
        {
            bullet4x.setA(angle);
            bullet4x.setX(xBox+20);;
            bullet4x.setY(yBox+12.5);;

        }
        if(bullet5==false)
        {
            bullet5x.setA(angle);
            bullet5x.setX(xBox+20);
            bullet5x.setY(yBox+12.5);;

        }
        if(bullet6==false)
        {
            bullet6x.setA(angle);
            bullet6x.setX(xBox+20);
            bullet6x.setY(yBox+12.5);;

        }
        if(bullet7==false)
        {
            bullet7x.setA(a2);
            bullet7x.setX (xBox2);
            bullet7x.setY(yBox2+12.5);

        }

        if(bullet8==false)
        {
            bullet8x.setA(a2);
            bullet8x.setX (xBox2+20);
            bullet8x.setY(yBox2+12.5);

        }
        if(bullet9==false)
        {
            bullet9x.setA(a2);
            bullet9x.setX (xBox2+20);
            bullet9x.setY(yBox2+12.5);

        }
        if(bullet10==false)
        {
            bullet10x.setA(a2);
            bullet10x.setX (xBox2+20);
            bullet10x.setY(yBox2+12.5);

        }
        if(bullet11==false)
        {
            bullet11x.setA(a2);
            bullet11x.setX(xBox2+20);
            bullet11x.setY(yBox2+12.5);

        }
        if(bullet12==false)
        {
            bullet12x.setA(a2);
            bullet12x.setX (xBox2+20);
            bullet12x.setY(yBox2+12.5);

        }

        repaint();
        bulletPhysics();

        ricochet();
    }

//ricochet on walls of maze
    public void ricochet()
    {
        for(bullet x: bulletList)
        {

            if(x.getX()+16 >598)
            {
                x.setA(Math.PI -x.getA()) ;
            }
            if(x.getX()+1 < 2)
            {
                x.setA(Math.PI -x.getA());
            }
            if(x.getY()+21 >599)
            {
                x.setA( Math.PI*2-x.getA());
            }
            if(x.getY()-1 <1)
            {
                x.setA (Math.PI*2-x.getA());
            }

        }
        for(int x =0 ; x<12; x++)
        { 
            for(int y=0; y<10; y++)
            {
                if(down[y].contains((int)bulletList[x].getX(),(int)bulletList[x].getY()+5))
                    bulletList[x].setA (Math.PI*2-bulletList[x].getA());

                if(up[y].contains((int)bulletList[x].getX(),(int)bulletList[x].getY()))
                    bulletList[x].setA( Math.PI*2-bulletList[x].getA());

                if(left[y].contains((int)bulletList[x].getX()+5,(int)bulletList[x].getY()))
                    bulletList[x].setA(Math.PI -bulletList[x].getA()) ;
                if(right[y].contains((int)bulletList[x].getX(),(int)bulletList[x].getY()))
                    bulletList[x].setA(Math.PI -bulletList[x].getA());
            } 
        }

    }

   
    public void bulletPhysics()
    {
        
        if(bullet1)
        {

            if(billy==false)
            { 
                time1 = System.currentTimeMillis();
            }
            billy=true;
            
            //bullet movement
            bullet1x.setX(bullet1x.getX()+.3*Math.cos(bullet1x.getA()));
            bullet1x.setY(bullet1x.getY()+.3*Math.sin(bullet1x.getA()));

            //timer for the bullet
            if(time1!=0 )
            {
                if (System.currentTimeMillis()-time1>=12000)

                {
                    billy=false;
                    downPressed=false;
                    bullet1=false;

                    time1=0;

                }
            }
        }
        if(bullet2)
        {

            bullet2x.setX(bullet2x.getX()+.3*Math.cos(bullet2x.getA()));
            bullet2x.setY(bullet2x.getY()+.3*Math.sin(bullet2x.getA()));
            if(billy2==false)
            { 
                time2 = System.currentTimeMillis();
            }
            billy2=true;

            if(time2!=0 )
            {
                if (System.currentTimeMillis()-time2>=12000)

                {
                    downPressed2 = false;
                    bullet2=false;
                    billy2=false;
                    time2=0;
                }
            }
        }
        if(bullet3)
        {
            bullet3x.setX(bullet3x.getX()+.3*Math.cos(bullet3x.getA()));
            bullet3x.setY(bullet3x.getY()+.3*Math.sin(bullet3x.getA()));
            if(billy3==false)
            { 
                time3 = System.currentTimeMillis();
            }
            billy3=true;

            if(time3!=0 )
            {
                if (System.currentTimeMillis()-time3>=12000)

                {
                    downPressed3 = false;
                    bullet3=false;
                    billy3=false;
                    time3=0;
                }
            }
        }
        if(bullet4)
        {

            if(billy4==false)
            { 
                time4 = System.currentTimeMillis();
            }
            billy4=true;
            bullet4x.setX(bullet4x.getX()+.3*Math.cos(bullet4x.getA()));
            bullet4x.setY(bullet4x.getY()+.3*Math.sin(bullet4x.getA()));

            if(time4!=0 )
            {
                if (System.currentTimeMillis()-time4>=12000)

                {
                    downPressed4 = false;
                    bullet4=false;
                    billy4=false;
                    time4=0;
                }
            }
        }
        if(bullet5)
        {

            if(billy5==false)
            { 
                time5 = System.currentTimeMillis();
            }
            billy5=true;
            bullet5x.setX(bullet5x.getX()+.3*Math.cos(bullet5x.getA()));
            bullet5x.setY(bullet5x.getY()+.3*Math.sin(bullet5x.getA()));

            if(time5!=0 )
            {
                if (System.currentTimeMillis()-time5>=12000)

                {
                    downPressed5 = false;
                    bullet5=false;
                    billy5=false;
                    time5=0;
                }
            }
        }
        if(bullet6)
        {

            if(billy6==false)
            { 
                time6 = System.currentTimeMillis();
            }
            billy6=true;
            bullet6x.setX(bullet6x.getX()+.3*Math.cos(bullet6x.getA()));
            bullet6x.setY(bullet6x.getY()+.3*Math.sin(bullet6x.getA()));
            if(time6!=0 )
            {
                if (System.currentTimeMillis()-time6>12000)

                {
                    downPressed6= false;
                    bullet6=false;
                    billy6=false;
                    time6=0;
                }
            }
        }
        if(bullet7)
        {

            if(billy7==false)
            { 
                time7 = System.currentTimeMillis();
            }
            billy7=true;
            bullet7x.setX(bullet7x.getX()+.3*Math.cos(bullet7x.getA()));
            bullet7x.setY(bullet7x.getY()+.3*Math.sin(bullet7x.getA()));
            if(time7!=0 )
            {
                if (System.currentTimeMillis()-time7>=12000)

                {
                    billy7=false;
                    downPressed7=false;
                    bullet7=false;

                    time7=0;

                }
            }
        }
        if(bullet8)
        {

            bullet8x.setX(bullet8x.getX()+.3*Math.cos(bullet8x.getA()));
            bullet8x.setY(bullet8x.getY()+.3*Math.sin(bullet8x.getA()));
            if(billy8==false)
            { 
                time8 = System.currentTimeMillis();
            }
            billy8=true;

            if(time8!=0 )
            {
                if (System.currentTimeMillis()-time8>=12000)

                {
                    downPressed8 = false;
                    bullet8=false;
                    billy8=false;
                    time8=0;
                }
            }
        }
        if(bullet9)
        {
            bullet9x.setX(bullet9x.getX()+.3*Math.cos(bullet9x.getA()));
            bullet9x.setY(bullet9x.getY()+.3*Math.sin(bullet9x.getA()));
            if(billy9==false)
            { 
                time9 = System.currentTimeMillis();
            }
            billy9=true;

            if(time9!=0 )
            {
                if (System.currentTimeMillis()-time9>=12000)

                {
                    downPressed9 = false;
                    bullet9=false;
                    billy9=false;
                    time9=0;
                }
            }
        }
        if(bullet10)
        {

            if(billy10==false)
            { 
                time10 = System.currentTimeMillis();
            }
            billy10=true;
            bullet10x.setX(bullet10x.getX()+.3*Math.cos(bullet10x.getA()));
            bullet10x.setY(bullet10x.getY()+.3*Math.sin(bullet10x.getA()));

            if(time10!=0 )
            {
                if (System.currentTimeMillis()-time10>=12000)

                {
                    downPressed10 = false;
                    bullet10=false;
                    billy10=false;
                    time10=0;
                }
            }
        }
        if(bullet11)
        {

            if(billy11==false)
            { 
                time11 = System.currentTimeMillis();
            }
            billy11=true;
            bullet11x.setX(bullet11x.getX()+.3*Math.cos(bullet11x.getA()));
            bullet11x.setY(bullet11x.getY()+.3*Math.sin(bullet11x.getA()));

            if(time11!=0 )
            {
                if (System.currentTimeMillis()-time11>=12000)

                {
                    downPressed11 = false;
                    bullet11=false;
                    billy11=false;
                    time11=0;
                }
            }
        }
        if(bullet12)
        {

            if(billy12==false)
            { 
                time12 = System.currentTimeMillis();
            }
            billy12=true;
            bullet12x.setX(bullet12x.getX()+.3*Math.cos(bullet12x.getA()));
            bullet12x.setY(bullet12x.getY()+.3*Math.sin(bullet12x.getA()));
            if(time12!=0 )
            {
                if (System.currentTimeMillis()-time12>=12000)

                {
                    downPressed12= false;
                    bullet12=false;
                    billy12=false;
                    time12=0;
                }
            }
        }

    }

    public void keyPressed(KeyEvent k)
    {
        int c = k.getKeyCode();
        //senses key pressed
        if (k.getKeyCode() == k.VK_UP) {
            moveForward = true;
        }
        if (k.getKeyCode() == k.VK_DOWN) {
            moveBackward = true;
        }
        if (k.getKeyCode() == k.VK_LEFT) {
            angleChangeLeft=true;
        }
        if (k.getKeyCode() == k.VK_RIGHT) {
            angleChangeRight=true;
        }
        if (k.getKeyCode() == k.VK_W) {
            moveForward2 = true;
        }
        if (k.getKeyCode() == k.VK_S) {
            moveBackward2 = true;
        }
        if (k.getKeyCode() == k.VK_A) {
            angleChangeLeft2=true;
        }
        if (k.getKeyCode() == k.VK_D) {
            angleChangeRight2=true;
        }
        //whether or not bullet 6 shoots
        if (k.getKeyCode() == k.VK_M&&bullet1&&bullet2&&bullet3&&bullet4&&bullet5) {
            if (!downPressed6&&!bullet6)
            { 
                bullet6=true;
            }
            downPressed6=true;

        }
        //whether or not bullet 5 shoots... goes down to bullet 1
        if (k.getKeyCode() == k.VK_M&&bullet1&&bullet2&&bullet3&&bullet4) {
            if (!downPressed5&&!bullet5)
            { 
                bullet5=true;
            }
            downPressed5=true;

        }
        if (k.getKeyCode() == k.VK_M&&bullet1&&bullet2&&bullet3) {
            if (!downPressed4&&!bullet4)
            { 
                bullet4=true;
            }
            downPressed4=true;

        }
        if (k.getKeyCode() == k.VK_M&&bullet1&&bullet2) {
            if (!downPressed3&&!bullet3)
            { 
                bullet3=true;
            }
            downPressed3=true;

        }
        if (k.getKeyCode() == k.VK_M&&bullet1) {
            if (!downPressed2&&!bullet2)
            { 
                bullet2=true;
            }
            downPressed2=true;

        }
        if (k.getKeyCode() == k.VK_M) {
            if (!downPressed&&!bullet1)
            {   bullet1=true;

            }
            downPressed=true;

        }

        //from tnak 2 
        //whether or not bullet 12 shoots ... goes to bullet 7
        if (k.getKeyCode() == k.VK_Q&&bullet7&&bullet8&&bullet9&&bullet10&&bullet11) {
            if (!downPressed12&&!bullet12)
            { 
                bullet12=true;
            }
            downPressed12=true;

        }
        if (k.getKeyCode() == k.VK_Q&&bullet7&&bullet8&&bullet9&&bullet10) {
            if (!downPressed11&&!bullet11)
            { 
                bullet11=true;
            }
            downPressed11=true;

        }
        if (k.getKeyCode() == k.VK_Q&&bullet7&&bullet8&&bullet9) {
            if (!downPressed10&&!bullet10)
            { 
                bullet10=true;
            }
            downPressed10=true;

        }
        if (k.getKeyCode() == k.VK_Q&&bullet7&&bullet8) {
            if (!downPressed9&&!bullet9)
            { 
                bullet9=true;
            }
            downPressed9=true;

        }
        if (k.getKeyCode() == k.VK_Q&&bullet7) {
            if (!downPressed8&&!bullet8)
            { 
                bullet8=true;
            }
            downPressed8=true;

        }
        if (k.getKeyCode() == k.VK_Q) {
            if (!downPressed7&&!bullet7)
            {   bullet7=true;

            }
            downPressed7=true;

        }

    }

    public void keyReleased(KeyEvent k )
    {
        //booleans for movement
        if (k.getKeyCode() == k.VK_UP) {
            moveForward = false;
        }
        if (k.getKeyCode() == k.VK_DOWN) {
            moveBackward = false;
        }
        if (k.getKeyCode() == k.VK_LEFT) {
            angleChangeLeft = false;
        }
        if (k.getKeyCode() == k.VK_RIGHT) {
            angleChangeRight = false;
        }
        if (k.getKeyCode() == k.VK_W) {
            moveForward2 = false;
        }
        if (k.getKeyCode() == k.VK_S) {
            moveBackward2 = false;
        }
        if (k.getKeyCode() == k.VK_A) {
            angleChangeLeft2=false ;
        }
        if (k.getKeyCode() == k.VK_D) {

            angleChangeRight2=false;

        }

    }

    public void keyTyped(KeyEvent k)
    {}
}
