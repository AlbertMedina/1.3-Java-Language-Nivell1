package Level3;

public class Main {
    public static void main(String[] args) {

        PersonRepository personRepository = new PersonRepository();
        PersonService personService = new PersonService(personRepository);
        MenuHandler menuHandler = new MenuHandler(personService);

        menuHandler.start();
    }
}
