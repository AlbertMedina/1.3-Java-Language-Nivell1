package Level1Ex3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ScoreboardRepository {

    private static final String SCOREBOARD_FILE_PATH = "resources/scoreboard.txt";

    public ScoreboardRepository() {
    }

    public static void savePlayerScore(PlayerScore playerScore) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(SCOREBOARD_FILE_PATH, true)))) {
            pw.println(playerScore.getName().replace(" ", "_") + " " + playerScore.getScore());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
