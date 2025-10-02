package Level3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static List<Person> persons = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Welcome!");
        System.out.println();

        int option;
        do {
            option = menu();
            switch (option) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    persons.sort(Comparator.comparing(Person::getName));
                    showPersonsList();
                    break;
                case 3:
                    persons.sort(Comparator.comparing(Person::getName).reversed());
                    showPersonsList();
                    break;
                case 4:
                    persons.sort(Comparator.comparing(Person::getSurname));
                    showPersonsList();
                    break;
                case 5:
                    persons.sort(Comparator.comparing(Person::getSurname).reversed());
                    showPersonsList();
                    break;
                case 6:
                    persons.sort(Comparator.comparing(Person::getDni));
                    showPersonsList();
                    break;
                case 7:
                    persons.sort(Comparator.comparing(Person::getDni).reversed());
                    showPersonsList();
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
        System.out.println("2. Show all persons ordered by name (A-Z)");
        System.out.println("3. Show all persons ordered by name (Z-A)");
        System.out.println("4. Show all persons ordered by surname (A-Z)");
        System.out.println("5. Show all persons ordered by surname (Z-A)");
        System.out.println("6. Show all persons ordered by DNI (0-9)");
        System.out.println("7. Show all persons ordered by DNI (0-9)");
        System.out.println("0. Exit");
        return InputHandler.readInt("Choose what to do next (0-7)");
    }

    private static void addPerson() {
        try {
            String name = InputHandler.readString("Enter name");
            String surname = InputHandler.readString("Enter surname");
            String dni = InputHandler.readString("Enter DNI");
            persons.add(new Person(name, surname, dni));
            System.out.println("Person added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding person: " + e.getMessage());
        }
    }

    private static void showPersonsList() {
        System.out.println("__NAME__  __SURNAME__  __DNI__");
        for (Person p : persons) {
            System.out.println(p.getName() + "    " + p.getSurname() + "    " + p.getDni());
        }
    }
}
