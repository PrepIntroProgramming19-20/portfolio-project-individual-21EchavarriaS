import java.awt.*;
import javax.swing.*;
import java.util.*;
public class ImagePanel1 extends JPanel
{
    ArrayList<Image> imageList = new ArrayList<Image>();
    ArrayList<Integer> positionxList = new ArrayList<Integer>();
    ArrayList<Integer> positionyList = new ArrayList<Integer>();
    Color randomColor;
    ImageIcon rings = new ImageIcon("rings1.png");
    boolean ring = false;
    int moons = 0;
    int mass = 230;
    
    public void addColor(int bluecolor, int greencolor, int redcolor){
        int blue = (int)(bluecolor);
        int green = (int)(greencolor);
        int red = (int)(redcolor);
        randomColor = new Color(red, green, blue);
        //colorList.add(randomColor);
    }
    
    public void addRings(boolean answer){
        if(answer == true){
            ring = true;
        }else{
            ring = false;
        }
    }
    
    public void addMoons(int amount){
        if(amount == 0){
            moons = 0;
        }else if(amount == 2){
            moons = 2;
        }else if(amount == 5){
            moons = 5;
        }
    }
    
    public Color chooseColor(){
        int blue = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int red = (int) (Math.random() * 255);
        Color randomColor1 = new Color(red, green, blue);
        return randomColor1;
    }
    
    @Override 
    public void paintComponent(Graphics g){
        //g.fillRect(0,0, 400, 400);
        
        g.setColor(randomColor);
        g.fillOval(300, 80, 230, 230);
        if(ring == true){
            Image image = rings.getImage();
            g.drawImage(image, 100, 140, this);
        }
        
        for(int i = 0; i < moons; i++){
            g.setColor(chooseColor());
            int positionx = (int)(Math.random() * 600);
            int positiony = (int)(Math.random() * 300);
            g.fillOval(positionx, positiony, 50, 50);
        }
        
    }
}