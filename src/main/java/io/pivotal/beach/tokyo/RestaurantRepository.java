package io.pivotal.beach.tokyo;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> selectAll();
}
