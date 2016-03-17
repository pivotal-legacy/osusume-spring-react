package io.pivotal.beach.tokyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DatabaseRestaurantRepository implements RestaurantRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseRestaurantRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Restaurant> selectAll() {
        return jdbcTemplate.query("select * from restaurants", (rs, rowNum) -> {
            return new Restaurant(rs.getInt("id"), rs.getString("name"));
        });
    }
}
