import java.util.Random;
import java.lang.Math;
import java.awt.*;
import javax.swing.JPanel;

/**
 * Write a description of class TreePanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TreePanel extends JPanel 
{
    /** description of instance variable x (add comment for each instance variable) */
    private int x;
    private int height = 600, width = 600;

    /** bottom x and bottom y first line */
    private int bx = 500;
    private int by = 800;;

    private int length = 200;

    private double angle = Math.PI/6.7;
    private double size = .75;
    private int amount = 14;
    private int count = 0;
    private int count2 = 0;
    /**
     * Default constructor for objects of class TreePanel
     */
    public TreePanel() 
    {
        setBackground(Color.black);
        setPreferredSize(new Dimension(1000,800));
    }

    public void paintComponent(Graphics face)
    {
        super.paintComponent(face);

        face.setColor(randomColor());
        face.drawLine(bx, by, bx, by-length);
        drawTreeRight(face,amount,bx,by,bx,by-length,angle);
        drawTreeLeft(face,amount,bx,by,bx,by-length,0-angle);

    }

    public void drawTreeRight(Graphics face, int current, int x1, int y1, int x2, int y2, double currAngle) 
    {
        if (current == 1)
        {
            face.drawLine(x1,y1,x2,y2);
        }
        else
        {
            double cos = Math.cos(currAngle);
            double sin = Math.sin(currAngle);

            double length = Math.sqrt((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2));
            double lenX = sin*length*size;
            double lenY = cos*length*size;

            int dx = x2-(int)(lenX);
            int dy = y2-(int)(lenY);

            face.setColor(randomColor());
            face.drawLine(x2,y2,dx,dy);
            drawTreeRight(face, current-1, x2, y2, dx,dy, currAngle+angle);
            drawTreeLeft(face, current-1, x2, y2, dx,dy, currAngle-angle);

        }
    }

    public void drawTreeLeft(Graphics face, int current, int x1, int y1, int x2, int y2, double currAngle)
    {
        if (current == 1)
        {
            face.drawLine(x1,y1,x2,y2);
        }
        else
        {
            double cos = Math.cos(currAngle);
            double sin = Math.sin(currAngle);

            double length = Math.sqrt((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2));
            double lenX = sin*length*size;
            double lenY = cos*length*size;

            int dx = x2-(int)(lenX);
            int dy = y2-(int)(lenY);

            face.setColor(randomColor());
            face.drawLine(x2,y2,dx,dy);
            drawTreeLeft(face, current-1, x2, y2, dx,dy, currAngle-angle);
            drawTreeRight(face, current-1, x2, y2, dx,dy, currAngle+angle);

        }
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int number)
    {
        length = number;
    }

    public int getBranch()
    {
        return amount;
    }

    public void setBranch(int number)
    {
        amount = number;
    }

    public double getAngle()
    {
        return angle;
    }

    public void setAngle(double number)
    {
        angle = number;
    }

    public Color randomColor()
    {
        Random gen = new Random();
        int r = gen.nextInt(200)+50, g = gen.nextInt(200)+50, b = gen.nextInt(200)+50;
        Color rand =  new Color(200,g,b);
        return rand;
    }

    /**
     * An example of a method - replace this comment with your own
     *    that describes the operation of the method
     *
     * @pre        preconditions for the method
     *            (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x+y;
    }

}
