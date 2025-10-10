package Level1Ex3;

import Utils.InputHandler;

public class GameService {

    private static final int NUMBER_OF_ROUNDS = 10;
    private static final int MAX_POINTS_PER_ROUND = 1;

    private final CountryRepository countryRepository;

    public GameService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public PlayerScore playGame() {
        String playerName = askPlayerName();
        System.out.println();

        int score = 0;
        for (int i = 1; i <= NUMBER_OF_ROUNDS; ++i) {
            score += playRound(i);
        }
        InputHandler.closeScanner();

        System.out.println("You guessed " + score + " out of " + NUMBER_OF_ROUNDS + " capital cities.");

        return new PlayerScore(playerName, score);
    }

    private String askPlayerName() {
        String name = InputHandler.readString("Enter your name");
        System.out.println("OK " + name + ", let's try to guess the capital city for " + NUMBER_OF_ROUNDS + " countries.");
        return name;
    }

    private int playRound(int roundNum) {
        System.out.println("Round " + roundNum);
        String country = getRandomCountry();
        String response = askForCapitalCity(country);
        return checkResponse(country, response);
    }

    private String getRandomCountry() {
        return countryRepository.getCountries().get((int) (Math.random() * countryRepository.getCountriesCapitals().size()));
    }

    private String askForCapitalCity(String country) {
        return InputHandler.readString("Enter the capital city of " + country);
    }

    private int checkResponse(String country, String response) {
        int score = 0;
        if (response.equalsIgnoreCase(countryRepository.getCountriesCapitals().get(country))) {
            System.out.println("Yes! You get " + MAX_POINTS_PER_ROUND + (MAX_POINTS_PER_ROUND == 1 ? " point." : " points."));
            score = MAX_POINTS_PER_ROUND;
        } else {
            System.out.println("No! The correct answer was " + countryRepository.getCountriesCapitals().get(country));
        }
        return score;
    }
}
