package hu.codecool.CarRaceSimulator_Gabor_Koncz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car extends Vehicle{

    private List<String> allFirstNames = FileReader.readFile("data/carFirstNames.txt");
    private List<String> allLastNames = FileReader.readFile("data/carLastNames.txt");

    public Car() {
        String name = createCarName();
        String type = "Car";
    }

    public String createCarName() {

        Collections.shuffle(allFirstNames);
        Collections.shuffle(allLastNames);
        name = allFirstNames.get(0) + " " + allLastNames.get(0);

        return name;

    }

    @Override
    public String toString() {
        return this.createCarName();
    }


}
