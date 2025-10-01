package Level2Ex1;

import java.util.HashSet;

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

        for (Restaurant r : restaurants) {
            System.out.println(r);
        }
    }
}
