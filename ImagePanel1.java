import java.awt.*;
import javax.swing.*;
import java.util.*;
public class ImagePanel1 extends JPanel
{
    ArrayList<Image> imageList = new ArrayList<Image>();
    ArrayList<Integer> positionxList = new ArrayList<Integer>();
    ArrayList<Integer> positionyList = new ArrayList<Integer>();
    ArrayList<Color> colorList = new ArrayList<Color>();
    Color randomColor;
    
    public void addColor(int bluecolor, int greencolor, int redcolor){
        int blue = (int)(bluecolor);
        int green = (int)(greencolor);
        int red = (int)(redcolor);
        randomColor = new Color(red, green, blue);
        //colorList.add(randomColor);
    }
    
    @Override 
    public void paintComponent(Graphics g){
        //g.fillRect(0,0, 400, 400);
        g.setColor(randomColor);
        g.fillOval(100, 100, 200, 200);
        
    }
}