import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import java.util.*;
import java.io.*;
    
public class PlanetGUI
    {
    //one jframe with two major panels within it and an instance of the imagepanel class
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel planetPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    ImagePanel1 planet = new ImagePanel1();
    
    //panel,radio buttons and button for each question
    //color question
    JPanel colorPanel = new JPanel();
    JButton colorButton = new JButton("Press this button once you have chosen a color");
    ButtonGroup colorGroup = new ButtonGroup();
    JRadioButton color1 = new JRadioButton("Blue");
    JRadioButton color2 = new JRadioButton("Red");
    JRadioButton color3 = new JRadioButton("Green");
    
    //rings question
    JPanel ringsPanel = new JPanel();
    JButton ringsButton = new JButton("Would you like rings on your planet? Press this button");
    ButtonGroup ringsGroup = new ButtonGroup();
    JRadioButton rings1 = new JRadioButton("Yes");
    JRadioButton rings2 = new JRadioButton("No");
    
    //mass question
    JPanel massPanel = new JPanel();
    JButton massButton = new JButton("Choose a mass (all masses are multiplied by 10^24 kg)");
    ButtonGroup massGroup = new ButtonGroup();
    JRadioButton mass1 = new JRadioButton("0.33");
    JRadioButton mass2 = new JRadioButton("5.97");
    JRadioButton mass3 = new JRadioButton("568");
    
    //moons question
    JPanel moonPanel = new JPanel();
    JButton moonButton = new JButton("Choose how many moons you want!");
    ButtonGroup moonGroup = new ButtonGroup();
    JRadioButton moon1 = new JRadioButton("none");
    JRadioButton moon2 = new JRadioButton("two");
    JRadioButton moon3 = new JRadioButton("five");
    
    //label with the surface gravity that changes if mass or radius are changed
    OriginalPlanet gravity = new OriginalPlanet();
    JLabel gravityLabel = new JLabel("");
    public PlanetGUI(){
        //frame and panels added to the frame using boxlayout
        frame.setSize(800,800);
        frame.add(panel);
        panel.setPreferredSize(new Dimension(800,800));
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);
        panel.add(planetPanel);
        panel.add(buttonPanel);
        planetPanel.setPreferredSize(new Dimension(400,400));
        buttonPanel.setPreferredSize(new Dimension(400,400));
        
        //adds imagepanel instance to the planet panel
        planetPanel.add(planet);
        planet.setPreferredSize(new Dimension(800,800));
        
        //adds each color panel to the button panel half
        BoxLayout buttonLayout = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        buttonPanel.setLayout(buttonLayout);
        buttonPanel.add(colorPanel);
        buttonPanel.add(ringsPanel);
        buttonPanel.add(massPanel);
        buttonPanel.add(moonPanel);
        buttonPanel.add(gravityLabel);
        
        //layout of each question with a box layout with radio buttons (one group of buttons per question) and one button 
        //color layout
        BoxLayout colorLayout = new BoxLayout(colorPanel, BoxLayout.X_AXIS);
        colorPanel.setLayout(colorLayout);
        colorPanel.add(color1);
        color1.setActionCommand("blue");
        colorPanel.add(color2);
        color2.setActionCommand("red");
        colorPanel.add(color3);
        color3.setActionCommand("green");
        colorPanel.add(colorButton);
        colorButton.setPreferredSize(new Dimension(100, 160));
        colorGroup.add(color1);
        colorGroup.add(color2);
        colorGroup.add(color3);
        
        //rings layout
        BoxLayout ringsLayout = new BoxLayout(ringsPanel, BoxLayout.X_AXIS);
        ringsPanel.setLayout(ringsLayout);
        ringsPanel.add(rings1);
        rings1.setActionCommand("yes");
        ringsPanel.add(rings2);
        rings2.setActionCommand("no");
        ringsPanel.add(ringsButton);
        ringsButton.setPreferredSize(new Dimension(100, 160));
        ringsGroup.add(rings1);
        ringsGroup.add(rings2);

        //mass layout
        BoxLayout massLayout = new BoxLayout(massPanel, BoxLayout.X_AXIS);
        massPanel.setLayout(massLayout);
        massPanel.add(mass1);
        mass1.setActionCommand("0.33");
        massPanel.add(mass2);
        mass2.setActionCommand("5.97");
        massPanel.add(mass3);
        mass3.setActionCommand("568");
        massPanel.add(massButton);
        massButton.setPreferredSize(new Dimension(100, 160));
        massGroup.add(mass1);
        massGroup.add(mass2);
        massGroup.add(mass3);
        
        //moon layout
        BoxLayout moonLayout = new BoxLayout(moonPanel, BoxLayout.X_AXIS);
        moonPanel.setLayout(moonLayout);
        moonPanel.add(moon1);
        moon1.setActionCommand("none");
        moonPanel.add(moon2);
        moon2.setActionCommand("two");
        moonPanel.add(moon3);
        moon3.setActionCommand("five");
        moonPanel.add(moonButton);
        moonButton.setPreferredSize(new Dimension(100, 160));
        moonGroup.add(moon1);
        moonGroup.add(moon2);
        moonGroup.add(moon3);
        
        //action listeners for each question using the button to change the GUI accordingly
        colorButton.addActionListener(new ButtonListen1());
        ringsButton.addActionListener(new ButtonListen2());
        massButton.addActionListener(new ButtonListen3());
        moonButton.addActionListener(new ButtonListen4());
        
        //sets the gravity to the starting size of the planet and the surface gravity label
        gravity.setMass(5.97);
        gravity.setRadius(6378);
        gravityLabel.setText("Surface Gravity: " + gravity.getSurfGrav() + "kg/km²");
        
        //sets panel and frame visible
        panel.setVisible(true);
        frame.setVisible(true);
    }
    //main method
    public static void main(String[] args){
        PlanetGUI test = new PlanetGUI();
    }
    
    //color button action listener
    class ButtonListen1 implements ActionListener{
        public void actionPerformed(ActionEvent event) throws NullPointerException{
            //try and catch statement so if you press button without clicking radio button it doesn't crash
            try{
                //uses imagepanel add color method to set the planet's color
                //math random option makes it so the shade of the color is random and can be changed
                if(colorGroup.getSelection().getActionCommand()== "blue"){
                    int blue = (int)(Math.random() * 255);
                    int green = (int)(Math.random() * 20);
                    planet.addColor(blue, green, 2);
                }else if(colorGroup.getSelection().getActionCommand() == "red"){
                    int red = (int)(Math.random() * 255);
                    int blue = (int)(Math.random() * 20);
                    planet.addColor(blue, 2, red);
                }else if(colorGroup.getSelection().getActionCommand() == "green"){
                    int green = (int)(Math.random() * 255);
                    int blue = (int)(Math.random() * 20);
                    planet.addColor(blue, green, 2);
                }
                //repaints the image panel, panel and the frame
                planet.repaint();
                panel.repaint();
                panel.setVisible(true);
                frame.repaint();
            }catch(NullPointerException e){
        
            }
        }
    }
    
    //rings button listener
    class ButtonListen2 implements ActionListener{
        public void actionPerformed(ActionEvent event) throws NullPointerException{
            try{
                //since this is a yes or no question the add rings method is a boolean
                if(ringsGroup.getSelection().getActionCommand()== "yes"){
                    planet.addRings(true);
                }else if(ringsGroup.getSelection().getActionCommand() == "no"){
                    planet.addRings(false);
                }
                planet.repaint();
                panel.setVisible(true);
                frame.repaint(); 
            }catch(NullPointerException e){
        
            }
        }
    }

    //mass button listener
    class ButtonListen3 implements ActionListener{
        public void actionPerformed(ActionEvent event){
            try{
                //references to the choose mass method in the imagepanel to change the position and size of the planet
                //also uses the original planet class to set the mass and radio to calculate the surface gravity
                if(massGroup.getSelection().getActionCommand()== "0.33"){
                    planet.chooseMass(0.33);
                    gravity.setMass(0.33);
                    gravity.setRadius(2440);
                    gravityLabel.setText("Surface Gravity:" + gravity.getSurfGrav() + "kg/km²");
                }else if(massGroup.getSelection().getActionCommand() == "5.97"){
                    planet.chooseMass(5.97);
                    gravity.setMass(5.97);
                    gravity.setRadius(6378);
                    gravityLabel.setText("Surface Gravity: " + gravity.getSurfGrav() + "kg/km²");
                }else if(massGroup.getSelection().getActionCommand() == "568"){
                    planet.chooseMass(568);
                    gravity.setMass(568);
                    gravity.setRadius(60268);
                    gravityLabel.setText("Surface Gravity:" + gravity.getSurfGrav() + "kg/km²");
                }
                planet.repaint();
                panel.setVisible(true);
                frame.repaint(); 
            }catch(NullPointerException e){
        
            }
        }
    }
    
    //moon button listener
    class ButtonListen4 implements ActionListener{
        public void actionPerformed(ActionEvent event){
            try{
                //references the add moons method in the image panel 
                if(moonGroup.getSelection().getActionCommand()== "none"){
                    planet.addMoons(0);
                }else if(moonGroup.getSelection().getActionCommand() == "two"){
                    planet.addMoons(2);
                }else if(moonGroup.getSelection().getActionCommand() == "five"){
                    planet.addMoons(5);
                }
                planet.repaint();
                panel.setVisible(true);
                frame.repaint(); 
            }catch(NullPointerException e){
        
            }
        }
    }
}
