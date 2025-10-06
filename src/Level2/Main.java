package Level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        HashSet<Restaurant> restaurants = new HashSet<>();

        addRestaurant(restaurants, "El Celler de Can Roca", 5);
        addRestaurant(restaurants, "El Celler de Can Roca", 4);
        addRestaurant(restaurants, "Cinc Sentits", 5);
        addRestaurant(restaurants, "CINC SENTITS", 5);
        addRestaurant(restaurants, "cinc sentits", 4);
        addRestaurant(restaurants, "Disfrutar", 3);
        addRestaurant(restaurants, "Disfrutar", 3);
        addRestaurant(restaurants, "Abac", 4);
        addRestaurant(restaurants, "abac", 3);

        System.out.println("HashSet restaurants:");
        for (Restaurant r : restaurants) {
            System.out.println(r);
        }

        System.out.println();

        List<Restaurant> restaurantsList = new ArrayList<>(restaurants);
        Collections.sort(restaurantsList);

        System.out.println("Ordered list:");
        for (Restaurant r : restaurantsList) {
            System.out.println(r);
        }
    }

    private static void addRestaurant(HashSet<Restaurant> restaurants, String name, int rating) {
        try {
            restaurants.add(new Restaurant(name, rating));
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding restaurant: " + e.getMessage());
        }
    }
}
