package Level1Ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CountryRepository {

    private static final String COUNTRIES_FILE_PATH = "resources/countries.txt";

    private HashMap<String, String> countriesCapitals;

    public CountryRepository() {
        initialize();
    }

    public HashMap<String, String> getCountriesCapitals() {
        return countriesCapitals;
    }

    private void initialize() {
        countriesCapitals = new HashMap<>();
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
}
