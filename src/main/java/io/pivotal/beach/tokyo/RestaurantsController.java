package io.pivotal.beach.tokyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantsController {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantsController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @RequestMapping(value = "", method = GET)
    public List<Restaurant> index() {
        return restaurantRepository.selectAll();
    }
}
