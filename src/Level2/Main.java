package Level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        HashSet<Restaurant> restaurants = new HashSet<>();

        restaurants.add(new Restaurant("El Celler de Can Roca", 5));
        restaurants.add(new Restaurant("El Celler de Can Roca", 4));
        restaurants.add(new Restaurant("Cinc Sentits", 5));
        restaurants.add(new Restaurant("CINC SENTITS", 5));
        restaurants.add(new Restaurant("cinc sentits", 4));
        restaurants.add(new Restaurant("Disfrutar", 3));
        restaurants.add(new Restaurant("Disfrutar", 3));
        restaurants.add(new Restaurant("Abac", 4));
        restaurants.add(new Restaurant("Abac", 3));

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
}
