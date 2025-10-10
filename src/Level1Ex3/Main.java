package Level1Ex3;

import Utils.InputHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String SCOREBOARD_FILE_PATH = "resources/scoreboard.txt";
    
    public static void main(String[] args) {

        CountryRepository countryRepository = new CountryRepository();
        GameService gameService = new GameService(countryRepository);

        PlayerScore playerScore = gameService.playGame();
        savePlayerFinalScore(playerScore.getName(), playerScore.getScore());
    }

    private static void savePlayerFinalScore(String playerName, int finalScore) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(SCOREBOARD_FILE_PATH, true)))) {
            pw.println(playerName.replace(" ", "_") + " " + finalScore);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
