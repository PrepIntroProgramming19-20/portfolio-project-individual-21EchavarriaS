//old test drive class 
public class PlanetTestDrive {
    public static void main(String args[]) {
        OriginalPlanet Neptune = new OriginalPlanet(); //creates the planet object
        Neptune.setMass(500 * 1e+5); //declaring what the mass is for the planet (incorrect value)
        Neptune.setRadius(12);// declaring what the radius is for the planet(incorrect value)
        Neptune.setMass(102 * 1e+24); //correct mass
        Neptune.setRadius(24764);// correct radius
        System.out.println("Your mass is " + Neptune.getMass() + "! And your radius is " + Neptune.getRadius() + "!");//uses methods to print what the mass and radius is
        System.out.println("Your surface gravity is " + Neptune.getSurfGrav() + "!");
        System.out.println("Your weight on your planet is " + Neptune.getWeight(60) + "!"); //The weight is 60 kg and it will print your weight on your planet
    }
}
