package Level3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonRepository {

    private static final String PERSONS_FILE_PATH = "resources/persons.csv";

    private List<Person> persons;

    public PersonRepository() {
        initialize();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void addPerson(Person person) throws Exception {
        if (persons.stream().anyMatch(p -> p.getDni().equalsIgnoreCase(person.getDni()))) {
            throw new Exception("We already have a person with this DNI in the list");
        }
        persons.add(person);
    }

    public void sortPersons(Comparator<Person> comparator) {
        persons.sort(comparator);
    }

    private void initialize() {
        persons = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PERSONS_FILE_PATH))) {
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String surname = parts[1].trim();
                    String dni = parts[2].trim();
                    persons.add(new Person(name, surname, dni));
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
