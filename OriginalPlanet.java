public class OriginalPlanet {
    private double mass; //in kg 
    private int radius; //in meters
       public void setMass(double newMass) {
           mass = newMass; // using this website for mass and radius of planets in our solar system: https://nssdc.gsfc.nasa.gov/planetary/factsheet/
    }
    public double getMass() {
            return mass; //so after you set the mass you can find it again
    }
    public void setRadius(int newRadius) { 
        if(newRadius <= 1000) { // 1185 is the radius for pluto so anything smaller than that would be too small
           System.out.println("You cannot have a negative, 0 or small radius");
        }else {
           radius = newRadius;
        }
    } 
    public int getRadius() {
          return radius;//helps get the radius once it is set 
    }
    public double getSurfGrav() {
          return (((6.67 * 1e-11)*(mass))/(radius * radius)); //used the surface gravity formula to get surface gravity based on the mass and radius already set
    }
    public double getWeight(double weightOnEarth) {
          return((weightOnEarth/9.8)*(getSurfGrav())); //in kg
    }
}
