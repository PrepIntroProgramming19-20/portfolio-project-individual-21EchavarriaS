import java.awt.*;
import javax.swing.*;
import java.util.*;
public class ImagePanel1 extends JPanel
{
    //instance variables that are used in the methods below
    //set at starting values to prevent crashing
    Color randomColor;
    //three of the same images but at different sizes 
    ImageIcon rings = new ImageIcon("rings1.png");
    ImageIcon rings2 = new ImageIcon("rings2.png");
    ImageIcon rings3 = new ImageIcon("rings3.png");
    boolean ring = false;
    int moons = 0;
    int mass = 230;
    int xposition = 300;
    int yposition = 80;
    
    //used to change the color when pressed in planet GUI class
    //parameters are the amount of blue, green and red to reach the desired color
    public void addColor(int bluecolor, int greencolor, int redcolor){
        int blue = (int)(bluecolor);
        int green = (int)(greencolor);
        int red = (int)(redcolor);
        randomColor = new Color(red, green, blue);
    }
    
    //used to add rings to the planet
    //parameter is a boolean since it is a true or false
    public void addRings(boolean answer){
        if(answer == true){
            ring = true;
        }else{
            ring = false;
        }
    }
    
    //used to set the mass of the planet which makes it larger or smaller
    public void chooseMass(double size){
        if(size == 0.33){
            //sets the mass which is used when painting the oval below
            //x and y position change because it needs to be centered and when you change the size this changes
            mass = 100;
            xposition = 350;
            yposition = 150;
        }else if(size == 5.97){
            mass = 230;
            xposition = 300;
            yposition = 80;
        }else if(size == 568){
            mass = 340;
            xposition = 250;
            yposition = 10;
        }
    }
    
    //used to set the amount of moons wanted by using a moons variable which is used in the paint component below
    public void addMoons(int amount){
        if(amount == 0){
            moons = 0;
        }else if(amount == 2){
            moons = 2;
        }else if(amount == 5){
            moons = 5;
        }
    }
    
    //creates a random color that can be used when making the moons below & returns a color
    public Color chooseColor(){
        int blue = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int red = (int) (Math.random() * 255);
        Color randomColor1 = new Color(red, green, blue);
        return randomColor1;
    }
    
    @Override 
    public void paintComponent(Graphics g){
        //random color variable from the addColor method
        //fill oval is the basic shape of the planet which references the xposition, yposition and mass from the choose mass method
        g.setColor(randomColor);
        g.fillOval(xposition,yposition, mass, mass);
        //if the rings are chosen then it checks what mass your planet is and references the correctly sized image 
        //has different positions because different center points
        if(ring == true){
            if(mass == 100){
                Image image = rings2.getImage();
                g.drawImage(image, 250, 180, this);
            }else if(mass == 230){
                Image image = rings.getImage();
                g.drawImage(image, 100, 140, this);
            }else if(mass == 340){
                Image image = rings3.getImage();
                g.drawImage(image, -15, 140, this);
            }
        }
        
        //for loop that goes through the number of moons selected from the add moons method
        //sets the color from the choose color method and sets a random position
        for(int i = 0; i < moons; i++){
            g.setColor(chooseColor());
            int positionx = (int)(Math.random() * 600);
            int positiony = (int)(Math.random() * 300);
            g.fillOval(positionx, positiony, 50, 50);
        }
        
    }
}