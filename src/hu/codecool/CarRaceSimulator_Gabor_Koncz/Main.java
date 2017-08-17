package hu.codecool.CarRaceSimulator_Gabor_Koncz;

import java.util.List;
import java.util.Random;
import java.util.Scanner;


/**
 * <h1> CarRaceSimulator </h1>
 * <p>
 * 2nd OOP module SI assignment. Simulate a race with 10 cars, trucks and motorcycles
 * in varying circumstances.
 * </p>
 * <b> Note: </b> The user have to type in the numbers to navigate in the menu.
 *
 * @author  Gabor Koncz
 * @version 1.0
 * @since   2017-08-15
 */

public class Main {

    static Random random = new Random();
    static Car car = new Car();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            clearScreen();
            printMenu();
            int selection = getSelection();
            switch (selection) {
                case 0:
                    //simulateRace(car);
                    //createVehicles();
                    //simulateRace();
                    //printRaceResults();
                    break;
                case 1:
                    printDocumentation();
                    break;
                case 2:
                    running = false;
                    break;
            }
        }
    }

    private static Vehicle[] createVehicles() {

        Vehicle[] vehicles = new Vehicle[10];
        String[] carNames = Car.createNames();
        for (int i = 0; i < 10; i++) {
            car.name = carNames[i];


                    System.out.println(testNames);
                System.out.println(testValue);
        }

    }

    /** <h2> Handles the selection in the menu </h2> */
    private static int getSelection() {
        System.out.print("Please select an option:");
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("Please select an option:");
        }
        return input.nextInt();
    }

    /** <h2> Prints out the menu options in the command line </h2> */
    private static void printMenu() {
        List<String> logo = FileReader.readFile("data/logo.txt");
        String[] options = {
                "Play",
                "Documentation",
                "Exit"
        };
        for (String line: logo) {
            System.out.println(line);
        }
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + ". " + options[i]);
        }
    }

    /** <h2> Prints the documentation to the console. </h2> */
    private static void printDocumentation() {
        List<String> help = FileReader.readFile("data/documentation.txt");
        clearScreen();
        System.out.println("Documentation\n");
        for (String line: help) {
            System.out.println(line);
        }

    }

    /**
     * <h2> Clears the screen in the command line </h2>
     * <b> Note: </b> Not working in the IntelliJ terminal.
     */
    private static void clearScreen() {
        System.out.print(String.format("%c[2J", 0x1B));  // clear screen
        System.out.print(String.format("%c[3J", 0x1B));  // clear scrollback buffer
        System.out.print(String.format("%c[%d;%df", 0x1B, 1, 1));  // position cursor to 1,1
    }

    /** <h2> Calculates if its raining or not. </h2> */
    private static boolean isRaining() {
        int rain = random.nextInt(100) + 1;
        if (rain <= 30) {
            return true;
        }
        return false;
    }
}
