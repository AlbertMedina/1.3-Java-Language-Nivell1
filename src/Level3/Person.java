package Level3;

public class Person {

    private String name;
    private String surname;
    private String dni;

    public Person(String name, String surname, String dni) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }

        if (surname == null || surname.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid surname");
        }

        if (dni == null || dni.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid DNI");
        }

        this.name = name;
        this.surname = surname;
        this.dni = dni.toUpperCase();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDni() {
        return dni;
    }

    private boolean isDniValid(String dni) {
        if (dni == null || dni.trim().isEmpty()) {
            return false;
        }
        if (dni.length() != 9) {
            return false;
        }
        for (int i = 0; i < dni.length() - 1; ++i) {
            if (!Character.isDigit(dni.charAt(i))) {
                return false;
            }
        }
        return Character.isLetter(dni.charAt(dni.length() - 1));
    }
}
