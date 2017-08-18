package hu.codecool.CarRaceSimulator_Gabor_Koncz;

import java.util.Random;

public class Motorcycle extends Vehicle {

    static Random random = new Random();

    static int normalSpeed;
    static int nameNumber = 1;

    public Motorcycle() {
        name = createMotorcycleName();
        type = "MotorCycle";
        normalSpeed = 100;
    }


    public static String createMotorcycleName() {

        String name = "Motorcycle " + nameNumber++;
        return  name;


    }

    @Override
    public void moveForAnHour(boolean isRaining) {
        if (isRaining) {
            normalSpeed = random.nextInt(45) + 5;
        } else {
            normalSpeed = 100;
        }
        distanceTraveled += normalSpeed;
    }
}
