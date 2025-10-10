package Level1Ex3;

import Utils.InputHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {


    private static final String SCOREBOARD_FILE_PATH = "resources/scoreboard.txt";
    private static final int NUMBER_OF_ROUNDS = 10;

    private static CountryRepository countryRepository;

    public static void main(String[] args) {

        countryRepository = new CountryRepository();

        if (!countryRepository.getCountriesCapitals().isEmpty()) {
            String playerName = InputHandler.readString("Enter your name");
            System.out.println("OK " + playerName + ", let's try to guess the capital city for " + NUMBER_OF_ROUNDS + " countries.");
            System.out.println();
            int finalScore = playGame();

            savePlayerFinalScore(playerName, finalScore);
        } else {
            System.out.println("Something went wrong. No capital cities to guess...");
        }

        InputHandler.closeScanner();
    }


    private static int playGame() {
        List<String> keys = new ArrayList<>(countryRepository.getCountriesCapitals().keySet());
        int score = 0;
        for (int i = 1; i <= NUMBER_OF_ROUNDS; ++i) {
            String country = keys.get((int) (Math.random() * countryRepository.getCountriesCapitals().size()));
            String input = InputHandler.readString(i + ". Enter the capital city of " + country);
            if (input.equalsIgnoreCase(countryRepository.getCountriesCapitals().get(country))) {
                System.out.println("Yes! You get 1 point.");
                score++;
            } else {
                System.out.println("No! The correct answer was " + countryRepository.getCountriesCapitals().get(country));
            }
            System.out.println();
        }

        System.out.println("You guessed " + score + " out of " + NUMBER_OF_ROUNDS + " capital cities.");

        return score;
    }

    private static void savePlayerFinalScore(String playerName, int finalScore) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(SCOREBOARD_FILE_PATH, true)))) {
            pw.println(playerName.replace(" ", "_") + " " + finalScore);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
