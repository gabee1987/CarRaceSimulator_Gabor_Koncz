package hu.codecool.CarRaceSimulator_Gabor_Koncz;

import java.util.Random;

public class Truck extends  Vehicle{

    static int normalSpeed;
    int breakDownTurnLeft;

    public Truck() {
        name = createTruckName();
        type = "Truck";
        normalSpeed = 100;
    }

    public static String createTruckName() {
        Random random = new Random();

        Integer name = random.nextInt(1000);

        return Integer.toString(name);
    }

    @Override
    public void moveForAnHour(boolean isRaining) {

        Random random = new Random();

        if (breakDownTurnLeft == 0) {
            int breakDownChance = random.nextInt(101);
            if (breakDownChance <= 5) {
                breakDownTurnLeft =2;
            } else {
                distanceTraveled += normalSpeed;
            }
        } else {
            breakDownTurnLeft--;
        }
    }

}
