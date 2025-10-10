package Level2;

public class Main {
    public static void main(String[] args) {

        RestaurantRepository restaurantRepository = new RestaurantRepository();
        RestaurantService restaurantService = new RestaurantService(restaurantRepository);

        restaurantService.addRestaurant("El Celler de Can Roca", 5);
        restaurantService.addRestaurant("El Celler de Can Roca", 4);
        restaurantService.addRestaurant("Cinc Sentits", 5);
        restaurantService.addRestaurant("CINC SENTITS", 5);
        restaurantService.addRestaurant("cinc sentits", 4);
        restaurantService.addRestaurant("Disfrutar", 3);
        restaurantService.addRestaurant("Disfrutar", 3);
        restaurantService.addRestaurant("Abac", 4);
        restaurantService.addRestaurant("abac", 3);

        System.out.println("Restaurants:");
        restaurantService.showRestaurants();

        System.out.println();

        System.out.println("Restaurants sorted:");
        restaurantService.showRestaurantsSorted();
    }
}
