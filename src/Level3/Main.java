package Level3;

import Utils.InputHandler;

public class Main {
    public static void main(String[] args) {

        PersonRepository personRepository = new PersonRepository();
        PersonService personService = new PersonService(personRepository);

        System.out.println("Welcome!");
        System.out.println();

        int option;
        do {
            option = menu();
            switch (option) {
                case 1:
                    personService.addPerson();
                    break;
                case 2:
                    personService.sortPersonsByName(true);
                    personService.showPersons();
                    break;
                case 3:
                    personService.sortPersonsByName(false);
                    personService.showPersons();
                    break;
                case 4:
                    personService.sortPersonsBySurname(true);
                    personService.showPersons();
                    break;
                case 5:
                    personService.sortPersonsBySurname(false);
                    personService.showPersons();
                    break;
                case 6:
                    personService.sortPersonsByDni(true);
                    personService.showPersons();
                    break;
                case 7:
                    personService.sortPersonsByDni(false);
                    personService.showPersons();
                    break;
                case 0:
                    System.out.println("See you soon!");
                    break;
                default:
                    System.out.println("Invalid option (" + option + ").");
                    break;
            }

            System.out.println();
        } while (option != 0);

        InputHandler.closeScanner();
    }

    private static int menu() {
        System.out.println("We can do the following:");
        System.out.println("1. Add person");
        System.out.println("2. Order and show persons by name (A-Z)");
        System.out.println("3. Order and show persons by name (Z-A)");
        System.out.println("4. Order and show persons by surname (A-Z)");
        System.out.println("5. Order and show persons by surname (Z-A)");
        System.out.println("6. Order and show persons by DNI (0-9)");
        System.out.println("7. Order and show persons by DNI (9-0)");
        System.out.println("0. Exit");
        return InputHandler.readInt("Choose what to do next (0-7)");
    }
}
