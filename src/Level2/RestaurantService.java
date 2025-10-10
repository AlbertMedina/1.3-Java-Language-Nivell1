package Level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestaurantService {

    public RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public void addRestaurant(String name, int rating) {
        try {
            restaurantRepository.addRestaurant(new Restaurant(name, rating));
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding restaurant: " + e.getMessage());
        }
    }

    public void showRestaurants() {
        for (Restaurant r : restaurantRepository.getRestaurants()) {
            System.out.println(r);
        }
    }

    public void showRestaurantsSorted() {
        List<Restaurant> restaurantsSorted = new ArrayList<>(restaurantRepository.getRestaurants());
        Collections.sort(restaurantsSorted);
        for (Restaurant r : restaurantsSorted) {
            System.out.println(r);
        }
    }
}
