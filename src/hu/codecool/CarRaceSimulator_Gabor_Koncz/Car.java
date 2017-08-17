package hu.codecool.CarRaceSimulator_Gabor_Koncz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car extends Vehicle{

    private List<String> allNames;
    private List<String> carNames;

    public Car() {
        allNames = FileReader.readFile("data/carNames.txt");
        carNames = new ArrayList<>(10);
    }

    public List<String> createCarNames() {

        Collections.shuffle(allNames);
        for (int i = 0; i < 10; i++) {
            //selectedFirstName = allNames.get(i);
            carNames.add(allNames.get(i));
        }

        return carNames;

    }


}
