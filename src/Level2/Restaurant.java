package Level2;

import java.util.Objects;

public class Restaurant implements Comparable<Restaurant> {

    private String name;
    private int rating;

    public Restaurant(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Restaurant otherRestaurant = (Restaurant) other;
        return rating == otherRestaurant.getRating() && name.equalsIgnoreCase(otherRestaurant.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), rating);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Rating: " + rating;
    }

    @Override
    public int compareTo(Restaurant other) {
        int comparison = name.compareToIgnoreCase(other.getName());
        if (comparison == 0) {
            if (rating < other.getRating()) {
                return 1;
            } else if (rating > other.getRating()) {
                return -1;
            }
        }
        return comparison;
    }
}
