package Level1Ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    private static final String COUNTRIES_FILE_PATH = "resources/countries.txt";
    private static final int NUMBER_OF_ROUNDS = 10;

    private static HashMap<String, String> countriesCapitals = new HashMap<>();

    public static void main(String[] args) {

        initialize();

        if (!countriesCapitals.isEmpty()) {
            String playerName = InputHandler.readString("Enter your name");
            System.out.println("OK " + playerName + ", let's try to guess the capital city for " + NUMBER_OF_ROUNDS + " countries.");
            System.out.println();
            int finalScore = playGame();

            savePlayerFinalScore(playerName, finalScore);
        } else {
            System.out.println("Something went wrong. No capital cities to guess...");
        }
    }

    private static void initialize() {
        try (BufferedReader br = new BufferedReader(new FileReader(COUNTRIES_FILE_PATH))) {
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String country = parts[0].trim().replace("_", " ");
                    String capital = parts[1].trim().replace("_", " ");
                    countriesCapitals.put(country, capital);
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int playGame() {
        ArrayList<String> keys = new ArrayList<>(countriesCapitals.keySet());
        int score = 0;
        for (int i = 1; i <= NUMBER_OF_ROUNDS; ++i) {
            String country = keys.get((int) (Math.random() * countriesCapitals.size()));
            String input = InputHandler.readString(i + ". Enter the capital city of " + country);
            if (input.equalsIgnoreCase(countriesCapitals.get(country))) {
                System.out.println("Yes! You get 1 point.");
                score++;
            } else {
                System.out.println("No! The correct answer was " + countriesCapitals.get(country));
            }
            System.out.println();
        }

        System.out.println("You guessed " + score + " out of " + NUMBER_OF_ROUNDS + " capital cities.");

        return score;
    }

    private static void savePlayerFinalScore(String playerName, int finalScore) {

    }
}
