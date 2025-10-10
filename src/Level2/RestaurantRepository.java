package Level2;

import java.util.HashSet;

public class RestaurantRepository {

    private HashSet<Restaurant> restaurants;

    public RestaurantRepository() {
        restaurants = new HashSet<>();
    }

    public HashSet<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }
}
