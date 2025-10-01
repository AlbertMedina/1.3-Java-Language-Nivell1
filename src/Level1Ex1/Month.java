package Level1Ex1;

public class Month {

    private String name;

    public Month(String name) {
        if (name == null || name.trim().isEmpty()) {
            name = "Unnamed";
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
