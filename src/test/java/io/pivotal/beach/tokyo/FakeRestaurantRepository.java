package io.pivotal.beach.tokyo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeRestaurantRepository implements RestaurantRepository {
    List<Restaurant> selectAll_returnValue = new ArrayList<>();
    @Override
    public List<Restaurant> selectAll() {
        return selectAll_returnValue;
    }
}
