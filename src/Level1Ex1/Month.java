package Level1Ex1;

import java.util.Objects;

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

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Month otherMonth = (Month) other;
        return name.equalsIgnoreCase(otherMonth.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }


}
