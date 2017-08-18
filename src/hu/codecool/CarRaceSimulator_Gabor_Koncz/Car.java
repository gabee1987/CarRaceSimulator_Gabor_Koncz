package hu.codecool.CarRaceSimulator_Gabor_Koncz;

import java.util.*;

public class Car extends Vehicle{

    static int normalSpeed;

    private static List<String> allFirstNames = new ArrayList(Arrays.asList(FileReader.readFile("data/carFirstNames.txt")));
    private static List<String> allLastNames = new ArrayList(Arrays.asList(FileReader.readFile("data/carLastNames.txt")));

    static Random random = new Random();

    public Car() {
        name = createCarName();
        type = "Car";
        normalSpeed = random.nextInt(31) + 80;
    }

    public static String createCarName() {

        //Collections.shuffle(allFirstNames);
        //Collections.shuffle(allLastNames);
        String name = allFirstNames.get(random.nextInt(170)) + " " + allLastNames.get(random.nextInt(170));
        //System.out.println("In Car class, in function -->" + name);

        return name;
    }

    @Override
    public void moveForAnHour(boolean isRaining) {
        if (isRaining) {
            normalSpeed = 70;
        } else {
            normalSpeed = random.nextInt(31) + 80;
        }
        distanceTraveled += normalSpeed;

    }

    @Override
    public String toString() {
        return this.createCarName();
    }


}
