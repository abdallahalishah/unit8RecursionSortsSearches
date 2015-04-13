import java.util.Random;
import java.lang.Math;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.BasicStroke;

/**
 * Write a description of class TreePanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TreePanelMouse extends JPanel 
{
    /** description of instance variable x (add comment for each instance variable) */
    private int line;

    private int x1 = 500;
    private int y1 = 800;
    private int x2 = 500;
    private int y2 = 600;

    private int initialX1 = 500;
    private int initialY1 = 800;
    private int initialX2 = 500;
    private int initialY2 = 600;
    private int length = 200;

    private double angle = Math.PI/6.7;
    private double size = .75;
    private int amount = 14;
    /**
     * Default constructor for objects of class TreePanel
     */
    public TreePanelMouse(int width, int height) 
    {
        setBackground(Color.black);
        setPreferredSize(new Dimension(width,height));
        line = 15;
    }

    public void paintComponent(Graphics face)
    {
        super.paintComponent(face);

        face.setColor(randomColor());
        face.drawLine(initialX1,initialY1,initialX2,initialY2);
        drawTreeRight(face,amount,x1,y1,x2,y2,angle);
        drawTreeLeft(face,amount,x1,y1,x2,y2,0-angle);

    }

    public void setLineThickness(int number)
    {
        line = number;
    }

    public void setRightLeft(int topX)
    {
        x2 = topX;
    }

    public void drawTreeRight(Graphics face, int current, int x1, int y1, int x2, int y2, double currAngle) 
    {
        Graphics2D face2 = (Graphics2D) face;
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

            face2.setColor(randomColor());
            //face2.setStroke(new BasicStroke(line));
            face2.drawLine(x2,y2,dx,dy);
            //line--;
            //if(line<1){line=1;}
            drawTreeRight(face, current-1, x2, y2, dx,dy, currAngle+angle);
            drawTreeLeft(face, current-1, x2, y2, dx,dy, currAngle-angle);

        }
    }

    public void drawTreeLeft(Graphics face, int current, int x1, int y1, int x2, int y2, double currAngle)
    {
        Graphics2D face2 = (Graphics2D) face;
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

            face2.setColor(randomColor());
            //face2.setStroke(new BasicStroke(line));
            face2.drawLine(x2,y2,dx,dy);
            //line--;
            //if(line<1){line=1;}
            drawTreeLeft(face, current-1, x2, y2, dx,dy, currAngle-angle);
            drawTreeRight(face, current-1, x2, y2, dx,dy, currAngle+angle);

        }
    }

    public double getRatio()
    {
        return size;
    }

    public void setRatio(double number)
    {
        size = number;
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
        int r = gen.nextInt(255), g = gen.nextInt(255), b = gen.nextInt(255);
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
    {return 8;
    }

}
