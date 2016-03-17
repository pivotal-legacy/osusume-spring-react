package io.pivotal.beach.tokyo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static io.pivotal.beach.tokyo.utils.SqlTestingUtils.prepareTestingDataSource;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DatabaseRestaurantRepositoryTest {

    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {
        jdbcTemplate = new JdbcTemplate(prepareTestingDataSource());
    }

    @Test
    public void testSelectAll() {
        DatabaseRestaurantRepository repo = new DatabaseRestaurantRepository(jdbcTemplate);

        try {
            jdbcTemplate.update("INSERT INTO restaurants (name) VALUES ('Afuri')");
            List<Restaurant> restaurants = repo.selectAll();
            assertThat(restaurants.size(), equalTo(1));
            assertThat(restaurants.get(0).getName(), equalTo("Afuri"));
        } finally {
            jdbcTemplate.update("DELETE FROM restaurants");
        }
    }
}
