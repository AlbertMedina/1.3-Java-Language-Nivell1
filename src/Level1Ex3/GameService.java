package Level1Ex3;

import Utils.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private static final int NUMBER_OF_ROUNDS = 10;

    private final CountryRepository countryRepository;

    public GameService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public PlayerScore playGame() {
        String playerName = InputHandler.readString("Enter your name");
        System.out.println("OK " + playerName + ", let's try to guess the capital city for " + NUMBER_OF_ROUNDS + " countries.");
        System.out.println();

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
        }
        System.out.println("You guessed " + score + " out of " + NUMBER_OF_ROUNDS + " capital cities.");
        InputHandler.closeScanner();
        return new PlayerScore(playerName, score);
    }
}
