
/**
 * Write a description of class bullet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class bullet
{
    private double xbo, ybo, anngle;
    public bullet(double x, double y, double a)
    {
        xbo=x;
        ybo=y;
        anngle=a;

    }
    public double getX()
    {
        return xbo;
    }
    public double getY()
    {
        return ybo;
    }
    public double getA()
    {
        return anngle;
    }
     public void setX(double x)
    {
         xbo=x;
    }
    public void setY(double x)
    {
         ybo=x;
    }
    public void setA(double x)
    {
         anngle=x;
    }
}
