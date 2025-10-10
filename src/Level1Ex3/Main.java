package Level1Ex3;

public class Main {

    public static void main(String[] args) {

        CountryRepository countryRepository = new CountryRepository();
        GameService gameService = new GameService(countryRepository);
        
        PlayerScore playerScore = gameService.playGame();
        ScoreboardRepository.savePlayerScore(playerScore);
    }
}
