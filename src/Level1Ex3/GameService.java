package Level1Ex3;

import Utils.InputHandler;

import java.util.List;

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
            System.out.println();
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
        Question question = getRandomQuestion();
        String response = askForCapitalCity(question.getCountry());
        RoundResult result = checkResponse(question, response);
        return getRoundScore(result);
    }

    private Question getRandomQuestion() {
        List<String> countries = countryRepository.getCountries();
        String country = countries.get((int) (Math.random() * countries.size()));
        String capital = countryRepository.getCountriesCapitals().get(country);
        return new Question(country, capital);
    }

    private String askForCapitalCity(String country) {
        return InputHandler.readString("Enter the capital city of " + country);
    }

    private RoundResult checkResponse(Question question, String response) {
        RoundResult result = new RoundResult(question, response);
        if (result.isCorrect()) {
            System.out.println("Yes! Correct answer!");
        } else {
            System.out.println("No! The correct answer was " + question.getCapital());
        }
        return result;
    }

    private int getRoundScore(RoundResult result) {
        int score = 0;
        if (result.isCorrect()) {
            score = MAX_POINTS_PER_ROUND;
            System.out.println("You get " + MAX_POINTS_PER_ROUND + (MAX_POINTS_PER_ROUND == 1 ? " point." : " points."));
        }
        return score;
    }
}
