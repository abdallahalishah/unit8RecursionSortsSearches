
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class TreeViewer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TreeViewerMouse implements MouseMotionListener,KeyListener
{
    /** description of instance variable x (add comment for each instance variable) */
    private int x;
    private int treeHeight = 1000, treeWidth = 1000;
    private int frameHeight = 1100, frameWidth = 1000;
    private TreePanelMouse tree;
    private JPanel panel;
    //     private JPanel buttons;
    private JFrame frame;
    //     private JButton increaseSize;
    //     private JButton decreaseSize;
    //     private JButton increaseBranch;
    //     private JButton decreaseBranch;
    //     private JButton increaseAngle;
    //     private JButton decreaseAngle;
    public static void main(String[] args) 
    {
        TreeViewerMouse view = new TreeViewerMouse();
    }

    public void init()
    {
        //this.addMouseMotionListener(this);
    }

    /**
     * Default constructor for objects of class TreeViewer
     */
    public TreeViewerMouse()
    {
        //         buttons = new JPanel();
        //         buttons.setPreferredSize(new Dimension(1000,50));
        //         buttons.setBackground(Color.cyan);
        // 
        //         increaseSize = new JButton("Increase Size");
        //         increaseSize.addActionListener(this);
        //         decreaseSize = new JButton("Decrease Size");
        //         decreaseSize.addActionListener(this);
        //         increaseBranch = new JButton("Increase Branches");
        //         increaseBranch.addActionListener(this);
        //         decreaseBranch = new JButton("Decrease Branches");
        //         decreaseBranch.addActionListener(this);
        //         increaseAngle = new JButton("Increase Angle");
        //         increaseAngle.addActionListener(this);
        //         decreaseAngle = new JButton("Decrease Angle");
        //         decreaseAngle.addActionListener(this);
        //         buttons.add(increaseSize);
        //         buttons.add(decreaseSize);
        //         buttons.add(increaseBranch);
        //         buttons.add(decreaseBranch);
        //         buttons.add(increaseAngle);
        //         buttons.add(decreaseAngle);
        tree = new TreePanelMouse(treeWidth, treeHeight);
        //tree.setFocusable(true);
        //tree.addFocusListener(KeyListener);
        panel = new JPanel();
        //panel.add(buttons);
        panel.add(tree);
        //panel.setKeyboardFocus(tree);
        frame = new JFrame();
        frame.setFocusable(true);
        //frame.addFocusListener(this);
        //frame.setKeyboardFocus(panel);
        frame.addMouseMotionListener(this);
        frame.addKeyListener(this);
        frame.setTitle("Colorful Tree");
        frame.add(panel);
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void mouseMoved(MouseEvent event) 
    {
        int length = tree.getLength();
        int branch = tree.getBranch();
        double angle = tree.getAngle();

        //         if (event.getSource() == increaseSize){length += 10;}
        //         else if (event.getSource() == decreaseSize){length -= 10;}
        //         else if (event.getSource() == increaseBranch){branch++;}
        //         else if (event.getSource() == decreaseBranch){branch--;}
        //if (event.getSource() == ){angle+=(2*Math.PI/180);}
        //else if (event.getSource() == decreaseAngle){angle-=(2*Math.PI/180);}
        int x = event.getX();
        int y = event.getY();
        int num = 1000;
        double scale = Math.PI/num;
        angle = scale*x;
        //tree.setRightLeft(x);
        //frame.repaint();
        double scaleBranch = 15/800;
        branch = (int)(scaleBranch*y);
        if (angle >= 0 && angle <= Math.PI)
        {
            tree.setAngle(angle);
            frame.repaint();
        }
        if (branch >= 1 && branch <= 14)
        {
            tree.setBranch(branch);
            frame.repaint();
        }
        if (length >= 10 && length <= 300)
        {
            tree.setLength(length);
            frame.repaint();
        }

    }

    public void keyPressed(KeyEvent event)
    {
        int length = tree.getLength();
        int branch = tree.getBranch();
        double angle = tree.getAngle();
        double size = tree.getRatio();
        System.out.println(event.getKeyCode());
        if (event.getKeyCode() == KeyEvent.VK_CONTROL){length+=10;}
        else if (event.getKeyCode() == KeyEvent.VK_ALT){length-=10;}
        else if (event.getKeyCode() == KeyEvent.VK_UP){branch++;}
        else if (event.getKeyCode() == KeyEvent.VK_DOWN){branch--;}
        else if (event.getKeyCode() == KeyEvent.VK_A){size-=.5;}
        else if (event.getKeyCode() == KeyEvent.VK_F){size+=.5;}
        
        if (size >= .4 && size <= .85)
        {
            tree.setRatio(size);
            frame.repaint();
        }
        if (angle >= 0 && angle <= Math.PI)
        {
            tree.setAngle(angle);
            frame.repaint();
        }
        if (branch >= 1 && branch <= 14)
        {
            tree.setBranch(branch);
            frame.repaint();
        }
        if (length >= 10 && length <= 300)
        {
            tree.setLength(length);
            frame.repaint();
        }
    }

    public void keyReleased(KeyEvent e){}

    public void keyTyped(KeyEvent e){}

    public void mouseDragged(MouseEvent e){}

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
