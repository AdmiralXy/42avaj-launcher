package com.admiralxy.avaj;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class Simulation {

    public static void main(String[] args) {
        if (args.length < 1)
            throw new ParserException("Please specify a scenario file");

        WeatherTower weatherTower = new WeatherTower();
        Scanner scanner;

        try {
            scanner = new Scanner(Paths.get(args[0]).toFile());
        } catch (FileNotFoundException e) {
            throw new ParserException("File not found");
        }

        if (!scanner.hasNextInt()) {
            throw new ParserException("First line must be an integer");
        }

        int numberOfSimulations = scanner.nextInt();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.isEmpty())
                continue;

            String[] split = line.split(" ");

            if (split.length != 5)
                throw new ParserException("Invalid line: " + line);

            try {
                String type = split[0];
                String name = split[1];
                int longitude = Integer.parseInt(split[2]);
                int latitude = Integer.parseInt(split[3]);
                int height = Integer.parseInt(split[4]);

                if (longitude < 0 || latitude < 0 || height < 0)
                    throw new ParserException("Coordinates must be positive: " + line);

                AircraftFactory.newAircraft(type, name, longitude, latitude, height)
                        .registerTower(weatherTower);
            } catch (NumberFormatException e) {
                throw new ParserException("Invalid number format: " + line);
            }
        }

        scanner.close();

        if (weatherTower.getObserversCount() == 0)
            throw new ParserException("No aircraft was registered");

        for (int i = 0; i < numberOfSimulations; i++)
            weatherTower.changeWeather();

        Logger.getInstance().close();
    }

}
