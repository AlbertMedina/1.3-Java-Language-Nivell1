package Level3;

public class Person {

    private String name;
    private String surname;
    private String dni;

    public Person(String name, String surname, String dni) {

        if (!isNameOrSurnameValid(name)) {
            throw new IllegalArgumentException("Invalid name");
        }

        if (!isNameOrSurnameValid(surname)) {
            throw new IllegalArgumentException("Invalid surname");
        }

        if (!isDniValid(dni)) {
            throw new IllegalArgumentException("Invalid DNI");
        }

        this.name = capitalizeNameSurname(name);
        this.surname = capitalizeNameSurname(surname);
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

    private boolean isNameOrSurnameValid(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }
        return !text.matches(".*\\d.*");
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

    public static String capitalizeNameSurname(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        String[] words = text.toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }
        }

        return sb.toString().trim();
    }
}
