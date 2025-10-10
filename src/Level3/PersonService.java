package Level3;

import Utils.InputHandler;

import java.util.Comparator;

public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addPerson() {
        String name = InputHandler.readString("Enter name");
        String surname = InputHandler.readString("Enter surname");
        String dni = InputHandler.readString("Enter DNI");
        addPerson(name, surname, dni);
    }

    public void addPerson(String name, String surname, String dni) {
        try {
            personRepository.addPerson(new Person(name, surname, dni));
            System.out.println("Person added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding person: " + e.getMessage());
        }
    }

    public void showPersons() {
        for (Person p : personRepository.getPersons()) {
            System.out.println(p.getName());
        }
    }

    public void sortPersonsByName(boolean ascending) {
        if (ascending) {
            personRepository.sortPersons(Comparator.comparing(Person::getName));
        } else {
            personRepository.sortPersons(Comparator.comparing(Person::getName).reversed());
        }
    }

    public void sortPersonsBySurname(boolean ascending) {
        if (ascending) {
            personRepository.sortPersons(Comparator.comparing(Person::getSurname));
        } else {
            personRepository.sortPersons(Comparator.comparing(Person::getSurname).reversed());
        }
    }

    public void sortPersonsByDni(boolean ascending) {
        if (ascending) {
            personRepository.sortPersons(Comparator.comparing(Person::getDni));
        } else {
            personRepository.sortPersons(Comparator.comparing(Person::getDni).reversed());
        }
    }
}
