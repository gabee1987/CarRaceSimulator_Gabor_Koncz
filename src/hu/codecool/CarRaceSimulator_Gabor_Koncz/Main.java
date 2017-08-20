package hu.codecool.CarRaceSimulator_Gabor_Koncz;

import java.util.*;


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

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            clearScreen();
            printMenu();
            int selection = getSelection();
            switch (selection) {
                case 0:
                    Vehicle[] vehicles = createVehicles();
                    Vehicle[] racedVehicles = simulateRace(vehicles);
                    printRaceResults(racedVehicles);
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


    /** <h2> Creates the 30 vehicles, return a list. </h2> */
    public static Vehicle[] createVehicles() {

        Vehicle[] vehicles = new Vehicle[30];


        for (int c = 0; c < 10; c++) {
            Vehicle car = new Car();
            vehicles[c] = car;

        }

        for (int m = 10; m < 20; m++) {
            Vehicle motorCycle = new Motorcycle();
            vehicles[m] = motorCycle;
        }

        for (int t = 20; t < 30; t++) {
            Vehicle truck = new Truck();
            vehicles[t] = truck;
        }

        return vehicles;
    }


    /** <h2> Simulates the race of the vehicles for 50 hour, returns a list with names and traveled distance </h2> */
    public static Vehicle[] simulateRace(Vehicle[] vehicles) {
        for (int hour = 1; hour <= 50; hour++) {
            for (int vehicle = 0; vehicle < 30; vehicle++) {
                vehicles[vehicle].moveForAnHour(isRaining());
            }
        }

        return vehicles;
    }


    /** <h2> Prints out the simulation result in the terminal </h2> */
    public static void printRaceResults(Vehicle[] vehicles) {

        int temp = 0;
        int winner = 0;

        for (int i = 0; i < 30; i++) {
            System.out.println(vehicles[i].name + " traveled:  " + vehicles[i].getDistanceTraveled());
            if (temp < vehicles[i].getDistanceTraveled()) {
                temp = vehicles[i].getDistanceTraveled();
                winner = i;
            }
        }

        System.out.println("\nThe winner is " + vehicles[winner].name + " with a " + vehicles[winner].getType() +
                            ", " + " traveled " + vehicles[winner].getDistanceTraveled() + " km");

    }





    /** <h2> Handles the selection in the menu, return an integer. </h2> */
    private static int getSelection() {
        System.out.print("Please select an option:");
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("Please select an option:");
        }
        return input.nextInt();
    }

    /** <h2> Prints out the menu options in the terminal </h2> */
    private static void printMenu() {
        String[] logo = FileReader.readFile("data/logo.txt");
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
        String[] help = FileReader.readFile("data/documentation.txt");
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

    /** <h2> Calculates if its raining or not, return a boolean. </h2> */
    private static boolean isRaining() {
        int rain = random.nextInt(100);
        if (rain <= 30) {
            return true;
        }
        return false;
    }
}
